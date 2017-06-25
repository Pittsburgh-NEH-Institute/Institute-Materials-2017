#!/usr/bin/env python
"""Tag words and add POS and lemma information in XML document."""

from xml.dom.minidom import Document, Element
from xml.dom import pulldom
import nltk


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


def create_word_element(d: Document, text:str, pos:str) -> Element:
    word = d.createElement("word")
    word.setAttribute("pos", pos)
    word.setAttribute("lemma", lemmatize(text, pos))
    t = d.createTextNode(text)
    word.appendChild(t)
    return word


def get_wordnet_pos(treebank_tag: str) -> str:
    """Replace treebank POS tags with wordnet ones; default is noun"""
    pos_tags = {'J': nltk.corpus.reader.wordnet.ADJ, 'V': nltk.corpus.reader.wordnet.VERB,
                'R': nltk.corpus.reader.wordnet.ADV}
    return pos_tags.get(treebank_tag[0], nltk.corpus.reader.wordnet.NOUN)


def lemmatize(text: str, pos: str) -> str:
    return nltk.stem.WordNetLemmatizer().lemmatize(text.lower(), get_wordnet_pos(pos))


def extract(input_xml) -> Document:
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
            words = nltk.word_tokenize(node.toxml())
            tagged_words = nltk.pos_tag(words)
            for (text, pos) in tagged_words:
                word = create_word_element(d, text, pos)
                open_elements.peek().appendChild(word)
        else:
            continue
    return d


with open('test.xml', 'r') as test_in:
    results = extract(test_in)
    print(results.toprettyxml())
