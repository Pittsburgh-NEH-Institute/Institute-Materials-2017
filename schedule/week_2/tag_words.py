#!/usr/bin/env python
"""Tag words and add POS and lemma information in XML document."""

from xml.dom.minidom import Document, Element
from xml.dom import pulldom
import nltk


def create_word_element(d: Document, text: str, pos: str) -> Element:
    """Create <word> element with POS and lemma attributes."""
    word = d.createElement("word")
    word.setAttribute("pos", pos)
    word.setAttribute("lemma", lemmatize(text, pos))
    t = d.createTextNode(text)
    word.appendChild(t)
    return word


def get_wordnet_pos(treebank_tag: str) -> str:
    """Replace treebank POS tags with wordnet ones; default POS is noun."""
    pos_tags = {'J': nltk.corpus.reader.wordnet.ADJ, 'V': nltk.corpus.reader.wordnet.VERB,
                'R': nltk.corpus.reader.wordnet.ADV}
    return pos_tags.get(treebank_tag[0], nltk.corpus.reader.wordnet.NOUN)


def lemmatize(text: str, pos: str) -> str:
    """Identify lemma for current word."""
    return nltk.stem.WordNetLemmatizer().lemmatize(text.lower(), get_wordnet_pos(pos))


def extract(input_xml) -> Document:
    """Process entire input XML document, firing on events."""
    # Initialize output as XML document, point to most recent open node
    d = Document()
    current = d
    # Start pulling; it continues automatically
    doc = pulldom.parse(input_xml)
    for event, node in doc:
        if event == pulldom.START_ELEMENT:
            current.appendChild(node)
            current = node
        elif event == pulldom.END_ELEMENT:
            current = node.parentNode
        elif event == pulldom.CHARACTERS:
            # tokenize, pos-tag, create <word> as child of parent
            words = nltk.word_tokenize(node.toxml())
            tagged_words = nltk.pos_tag(words)
            for (text, pos) in tagged_words:
                word = create_word_element(d, text, pos)
                current.appendChild(word)
    return d


with open('test.xml', 'r') as test_in:
    results = extract(test_in)
    print(results.toprettyxml())
