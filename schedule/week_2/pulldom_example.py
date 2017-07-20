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
    inText = False # are we in the <text> or the <teiHeader>? 
    # Start pulling; it continues automatically
    doc = pulldom.parseString(input_xml) # change parseString to parse if it's a file, and not a string
    for event, node in doc:
        if event == pulldom.START_ELEMENT:
            if node.nodeName == 'text':
                inText = True
            current.appendChild(node)
            current = node
        elif event == pulldom.END_ELEMENT:
            if node.nodeName == 'text':
                inText = False
            current = node.parentNode
        elif event == pulldom.CHARACTERS:
            if inText:
                # tokenize, pos-tag, create <word> as child of parent
                words = nltk.word_tokenize(node.toxml())
                tagged_words = nltk.pos_tag(words)
                for (text, pos) in tagged_words:
                    word = create_word_element(d, text, pos)
                    current.appendChild(word)
            else:
                t = d.createTextNode(node.toxml())
                current.appendChild(t)
    return d

test_in = '''<?xml version="1.0" encoding="UTF-8"?>
<?xml-model href="http://www.tei-c.org/release/xml/tei/custom/schema/relaxng/tei_all.rng" type="application/xml" schematypens="http://relaxng.org/ns/structure/1.0"?>
<?xml-model href="http://www.tei-c.org/release/xml/tei/custom/schema/relaxng/tei_all.rng" type="application/xml"
	schematypens="http://purl.oclc.org/dsdl/schematron"?>
<TEI xmlns="http://www.tei-c.org/ns/1.0">
  <teiHeader>
      <fileDesc>
         <titleStmt>
            <title>Title</title>
         </titleStmt>
         <publicationStmt>
            <p>Publication Information</p>
         </publicationStmt>
         <sourceDesc>
            <p>Information about the source</p>
         </sourceDesc>
      </fileDesc>
  </teiHeader>
  <text>
      <body>
         <p>Some text here.</p>
      </body>
  </text>
</TEI>
'''
results = extract(test_in)
print(results.toprettyxml())
