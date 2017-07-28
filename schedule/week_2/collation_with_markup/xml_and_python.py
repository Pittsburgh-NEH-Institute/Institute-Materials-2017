#!/usr/bin/env python
# Filename: xml_and_python.py
# Developer: David J. Birnbaum (djbpitt@gmail.com)
# First version: 2017-07-23
# Last revised: 2017-07-27
#
# Syntax: python xml_and_python.py
# Input: Representative input is embedded in the Python script
# Output: stdout
#
# Synopsis: Collate XML around embedded markup
#
# Original TEI documents are processed with XSLT to tag words as <w> elements. Markup
# intermingled with text is flattened into <milestone> elements. The python script
# retains the flattened markup in the "t" values and strips it from the "n" value.


import os
from xml.dom import pulldom
from xml.dom.minidom import parseString
import re
from collatex import *

RE_MARKUP = re.compile(r'<.+?>')
RE_MILESTONE = re.compile(r'&lt;milestone(.*?)&gt;')


def tokenize(input_xml):
    """Return list of word tokens, with internal milestone markup, as strings

    We did our tokenization with XSLT, and the input into CollateX has word
    tokens tagged as <w> elements. Tokenization at this next stage involves
    selecting the <w> elements and ignoring the rest."""
    in_p = False  # the only elements inside <body> are <p>, and, inside <p>, <milestone> and <w>
    words = []
    doc = pulldom.parseString(input_xml)
    for event, node in doc:
        # <p>
        if event == pulldom.START_ELEMENT and node.localName == 'p':
            in_p = True
        elif event == pulldom.END_ELEMENT and node.localName == 'p':
            in_p = False
        # descendants of <p>
        elif event == pulldom.START_ELEMENT and in_p:
            if node.localName == 'w':
                doc.expandNode(node)
                words.append(re.sub(r'\n|<w>|</w>', r' ', node.toxml()).strip() + " ")
    return words


def create_token(word):
    return {"t": word, "n": normalize(word)}


def normalize(word_token):
    return RE_MARKUP.sub('', word_token)


collatex_witness_input = []
witnesses = os.scandir('word_tagged')
for witness_file in witnesses:
    witness_siglum = witness_file.name.split('.xml')[0]
    with open(witness_file, 'r', encoding='utf-8') as f:
        witness_xml = f.read()
    word_tokens = tokenize(witness_xml)
    token_list = [create_token(token) for token in word_tokens]
    witness_data = {"id": witness_siglum, "tokens": token_list}
    collatex_witness_input.append(witness_data)
collatex_json_input = {"witnesses": collatex_witness_input}
table = collate(collatex_json_input, layout="vertical", segmentation=False)
json_output = collate(collatex_json_input, output="json")
print(table)
print(json_output)
collate(collatex_json_input, output="svg")
collate(collatex_json_input, segmentation=False, output="svg")
xml_output = parseString(collate(collatex_json_input, output="xml"))
print(xml_output.toprettyxml())
