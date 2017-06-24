# Unicode

## Introduction

Information within a computer is stored as zeroes and ones, and the relationships between specific combinations of zeroes and ones and the units of human writing are defined in a _character set_. [Unicode](http://www.unicode.org/) is a character set designed to be able to represent text in all human writing systems. Unicode is built into all major modern operating systems and applications, and should be used for all new digital edition projects, but you may encounter non-Unicode data in legacy documents.

## Code points and UTF-8

Unicode characters have official names and official numerical values, called _code points_, which are conventionally written in four-digit (or more, for longer numbers) [hexadecimal](http://www.electronics-tutorials.ws/binary/bin_3.html) notation with a “U+” prefix. For example, “LATIN SMALL LETTER A” has the value 97 decimal, which is spelled “U+0061”. You can look up the name and number of a character at <http://www.unicode.org/charts/>.

Unicode alphabetic characters are defined as members of a _script_, so although LATIN SMALL LETTER A and CYRILLIC SMALL LETTER A may look identical, they have different code points (U+0061 and U+0430, respectively), and they should be encoded according to their meaning, and not their appearance. Although this might seem not to matter with respect to appearance, it matters for searching, sorting, and similar operations. Markup and programming languages typically make it possible to express characters either literally or with their numerical values. For example, writing “&amp;#x0061;” in a web page will render “a” in a browser. In Python, executing `print('\u0061')` will print “a”.

For historical reasons, some symbols used in human writing may be represented in more than one way in Unicode. For example, Latin “á” may be written either as a single Unicode character (LATIN SMALL LETTER A WITH ACUTE, U+00E1) or as a sequence of two characters, the first of which is the base, LATIN SMALL LETTER A, U+0061, and the second of which is COMBINING ACUTE ACCENT, U+0301. This variability means that it is not always possible to identify a Unicode character by looking at how it is rendered, and it also means that legacy documents or collections of documents may encode the same information in different ways, that is, inconsistently. Unicode provides a [normalization mechanism](http://unicode.org/reports/tr15/) to deal with such inconsistencies during processing, which we’ll practice using later in our Institute.

Unicode code points are normally managed within a computer in a Unicode Transformation Format (UTF), the most common of which is UTF-8. There’s a concise explanation of UTF-8 and other Unicode encodings in the Python documentation at <https://docs.python.org/3.3/howto/unicode.html>, but for the most part you don’t need to worry about it, as operating systems and applications will handle the relationship between code points and UTF-8 behind the scenes.

## Legacy character sets

If you’re using someone else’s data, and especially if the files are old, they may not be in Unicode. ASCII is compatible with UTF-8, so if you’re files are in ASCII, they are also automatically in UTF-8. If you have to work with legacy non-Unicode data, you can convert it to UTF-8 in Python with:

```python
import codecs
with codecs.open('russian-cp1251.txt','r','cp1251') as f:
	contents = f.read()	# contents now contains a Unicode string
```

In this sample, “russian-cp1251.txt” contains data in [CP 1251](https://en.wikipedia.org/wiki/Windows-1251), a legacy character set for representing English and Russian data. You can find a list of legacy character sets that Python knows how to read at <https://docs.python.org/3/library/codecs.html#standard-encodings>.

## The Unicode private use area (PUA)

Unicode sets aside a large number of code points for users to create characters that are not otherwise supported. In some cases, support may arrive eventually,  once the need for it has been documented adequately. In other cases users may require support for “characters” that do not satisfy the Unicode understanding of what a character is, which means that Unicode will never incorporate those “characters”. The PUA is designed to allow users to work around limitations in the character inventory supported officially by Unicode.

### Why you don’t want to use the PUA

Regular Unicode characters have established names and meanings, which means that where they are supported by operating systems, applications, or other resources, they always have the same meaning. This is not true of the PUA. If you define your own characters in the PUA, other users are free to define the same space in ways that conflict with yours. That means that files that use the PUA can be exchanged safely only in a controlled environment, in which all parties have the same understanding of the meaning of PUA characters.

PUA characters do not have the inherent semantics of regular Unicode characters. For example, Unicode alphabetic characters belong to a script, they have upper and lower case properties (if case is relevant to the writing system), etc. Programming languages can use these properties; for example, you can write [regular expressions](http://www.regular-expressions.info/) that match text in a particular script, you can use a function to convert upper to lower case and vice versa, etc. Because PUA characters do not have the same properties build into the operating system or applications or programming languages, if you use them, you’ll be responsibile for handling them specially yourself.

### If you nonetheless have to use the PUA

The Medieval Unicode Font Initiative (MUFI) attempts to coordinate the use of parts of the PUA by medieval scholars, and the MUFI proposal is followed in the [Junicode](http://junicode.sourceforge.net/) font. This community “microstandard” is not real Unicode standardization; programming languages know nothing about the semantics (script, case, etc.) of MUFI characters, and there is no guarantee that some other developer whose materials you need will not inadvertently use the same code points in the PUA as MUFI.

Projects that use the PUA to create readable text needs to provide font support that renders the PUA characters in a culturally acceptable way. Until recently, publication of such documents on the web required that end users install special fonts into their computers; not only was this inconvenient, but not all users know how to do it, some platforms (e.g., iOS) do not support end-user font installation at all, and some environments that otherwise support public web access (e.g., public libraries, university labs) do not permit users to install resources. The emergence of [web fonts](http://dh.obdurodon.org/usingWebfonts.xhtml) means that developers can now make custom fonts available automatically whenever a user loads a page that needs them, freeing the user from having to download and install the font explicitly.

## Characters and glyphs

Characters are units of information and glyphs are units of presentation. Unicode is an inventory of characters; a font is an inventory of glyphs. The mappings between characters in Unicode and glyphs in a font are not necessarily one to one. For example, you may key in an accented letter as a base character followed by a combining diacritic, and your application may render a single glyph; this can support more elegant typography, since it makes it possible to set the diacritic at a different height over upper- and lowercase letters, to remove the dot over the letter “i” before adding an accent mark, etc. In a Well-Ordered Universe, you should enter the informational units and let the application worry about adjusting the rendering to the environment. In Real Life, if fine typography is a high priority in your project, you may need to compromise.

## If Python can’t read your Unicode file

Python 3 normally reads Unicode files without a problem (this is not true of Python 2). If you get an error, try:

```python
import codecs
with codecs.open("filename.txt", "r", "utf-8") as tmpfile:
    data = tmpfile.read()
```

If you’re parsing XML in Python using [pulldom](https://docs.python.org/3/library/xml.dom.pulldom.html), you need to read XML files (which are normally UTF-8) as bytes, rather than strings, which you can do by adding a “b” to the second argument of the `open()` function:

```python
open('1818_Ch1.xml', 'rb')
```

## Useful Unicode tools

Richard Ishida, the International­ization Activity Lead at the W3C and a contributor to the Unicode Editorial Committee, provides several useful online Unicode utilities at <https://r12a.github.io/applist>.

Mac users may wish to install [UnicodeChecker](http://earthlingsoft.net/UnicodeChecker/index.html).

If you know what your character looks like but don’t know the name or code point, or perhaps even the script, try drawing it at [shapecatcher](http://shapecatcher.com/).
