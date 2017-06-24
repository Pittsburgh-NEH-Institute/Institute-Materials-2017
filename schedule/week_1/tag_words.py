#!/usr/bin/env python
"""Tag words and add POS and lemma information in XML document."""

from xml.dom.minidom import Document
from xml.dom import pulldom
import nltk


# https://github.com/rhdekker/python_xml_pull_parser_example/blob/master/pull_parser_test.py
class Stack(list):
    def push(self, item):
        self.append(item)

    def peek(self):
        return self[-1]


# https://stackoverflow.com/questions/15586721/wordnet-lemmatization-and-pos-tagging-in-python
def get_wordnet_pos(treebank_tag: str) -> str:
    """Replace treebank POS tags with wordnet ones."""
    if treebank_tag.startswith('J'):
        return nltk.corpus.reader.wordnet.ADJ
    elif treebank_tag.startswith('V'):
        return nltk.corpus.reader.wordnet.VERB
    elif treebank_tag.startswith('N'):
        return nltk.corpus.reader.wordnet.NOUN
    elif treebank_tag.startswith('R'):
        return nltk.corpus.reader.wordnet.ADV
    else:
        return 'n'


def lemmatize(text: str, pos: str) -> str:
    return nltk.stem.WordNetLemmatizer().lemmatize(text.lower(), get_wordnet_pos(pos))


def extract(input_xml):
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
            value = node.toxml()
            words = nltk.word_tokenize(value)
            pos_tagged = nltk.pos_tag(words)
            for (text, pos) in pos_tagged:
                word = d.createElement("word")
                word.setAttribute("pos", pos)
                word.setAttribute("lemma", lemmatize(text, pos))
                t = d.createTextNode(text)
                word.appendChild(t)
                open_elements.peek().appendChild(word)
        else:
            continue
    return d


with open('test.xml', 'rb') as test_in:
    results = extract(test_in)
    print(results.toprettyxml())

