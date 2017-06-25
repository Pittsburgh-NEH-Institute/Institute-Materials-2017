#!/usr/bin/env python
"""Tag words and add POS and lemma information in XML document."""

from xml.dom.minidom import Document
from xml.dom import pulldom
import nltk
from typing import BinaryIO


# https://github.com/rhdekker/python_xml_pull_parser_example/blob/master/pull_parser_test.py
class Stack(list):
    def push(self, item):
        self.append(item)

    def peek(self):
        return self[-1]


class Word:
    @staticmethod
    def create(d: Document, text: str, pos: str):
        word = d.createElement("word")
        word.setAttribute("pos", pos)
        word.setAttribute("lemma", lemmatize(text, pos))
        t = d.createTextNode(text)
        word.appendChild(t)
        return word


# https://stackoverflow.com/questions/15586721/wordnet-lemmatization-and-pos-tagging-in-python
def get_wordnet_pos(treebank_tag: str) -> str:
    """Replace treebank POS tags with wordnet ones; default is noun"""
    if treebank_tag.startswith('J'):
        return nltk.corpus.reader.wordnet.ADJ
    elif treebank_tag.startswith('V'):
        return nltk.corpus.reader.wordnet.VERB
    elif treebank_tag.startswith('R'):
        return nltk.corpus.reader.wordnet.ADV
    else:
        return nltk.corpus.reader.wordnet.NOUN


def lemmatize(text: str, pos: str) -> str:
    return nltk.stem.WordNetLemmatizer().lemmatize(text.lower(), get_wordnet_pos(pos))


def extract(input_xml: BinaryIO) -> Document:
    """Process entire input XML document, firing on events"""
    # Initialize output as XML tree, stack of open elements
    d = Document()
    open_elements = Stack()
    open_elements.push(d)
    # Start pulling; it continues automatically
    doc = pulldom.parse(input_xml)
    for event, node in doc:
        if event == pulldom.START_ELEMENT:
            open_elements.peek().appendChild(node)
            open_elements.push(node)
        elif event == pulldom.END_ELEMENT:
            open_elements.pop()
        elif event == pulldom.CHARACTERS:
            # tokenize, pos-tag, create <word> as child of parent
            for (text, pos) in nltk.pos_tag(nltk.word_tokenize(node.toxml())):
                open_elements.peek().appendChild(Word().create(d, text, pos))
        else:
            continue
    return d


with open('test.xml', 'rb') as test_in:
    results = extract(test_in)
    print(results.toprettyxml())

