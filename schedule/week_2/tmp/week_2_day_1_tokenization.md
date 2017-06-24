# Tokenization

## Introduction

Tokenization (the first of the five parts of the [Gothenburg model](http://wiki.tei-c.org/index.php/Textual_Variance#The_.E2.80.9CGothenburg_model.E2.80.9D:_A_modular_architecture_for_computer-aided_collation)) divides the texts to be collated into tokens, which are most commonly (but not obligatorily) words. Dividing continuous text into words feel intuitive as long as the text contains nothing but words, but text (at least, English-language text) also typically contains punctuation. By default, the [CollateX](https://pypi.python.org/pypi/collatex) collation toolkit considers punctuation to be its own token, which means that the witness readings “Hi!” and “Hi” will both contain a token that reads “Hi” (and the first witness will contain an additional token, which reads “!”). In this situation, that may be the behavior the user wants, since both witnesses contain what a human would recognize as the same word, and the difference involves only the presence vs absence of the exclamation mark.

## What’s easy and what’s hard

Tokenization may split on a separator that is not itself considered a token, such as the white space between words in English. Or it may split without an overt separator, such as the division of “Hi!” into two tokens described above, or the division into words of Chinese text, which does not use white-space separation, but where there are some words that are spelled with more than one character. Tokenization that divides a string into contiguous and tesselated substrings is common, but consider also tokenization into morphemes. Agglutinative structures like the normal English plural in “–s” or “–es” are relatively simple, but English strong plurals like “men” don’t present a lexical stem followed by a pluralizing ending, and in writing systems like Arabic and Hebrew, the vowels that represent grammatical information are typically interwoven with the consonants that represent a lexical root. (For more about these writing systems, and a tool for their segmentation, see <https://nlp.stanford.edu/software/segmenter.shtml>.)

We’ll explore tokenization in more detail [tomorrow](week_2_day_2_plan.md), but here’s a brief introduction, concentrating for the moment on English-language examples.

## Issues with tokenization on white space

### English possessive constructions

At what level is “Peter’s” the same word as “Peter”? The linguistic answer depends on what you mean by “word”. Because CollateX (for example) will regard the apostrophe as a separate token, “Peter’s” will be tokenized as three tokens: the name, the apostrophe, and the possessive. Here’s the default behavior for “Peter’s cat.” and “Peter has a cat.”:

Siglum | 1 | 2 | 3 | 4 | 5 
---- | ---- | ---- | ---- | ---- | ---- 
A | Peter | ' | s | cat | .
B | Peter | has | a | cat | .


For possessives, the preceding tokenization may or may not be acceptable behavior, but how about contractions like “didn’t” (how many tokens, and what are they?) or “A’dam” (short for “Amsterdam”, and logically one token)?

### English hyphenation

Assuming you can reliably distinguish hard and soft hyphens and ignore the soft ones:

1. How many words is “ne’er-do-well”?
1. If we tokenize “first-rate” as `first | - | rate`, how does that differ from “first rate”? At a character level, a white-space character has been replaced by a hyphen character, and the variation is between two different characters. At a word level, since white space is generally ignored during word tokenization (it separates word tokens, but is not itself a token), a hyphen token has been added between two word tokens, and the variation is between the presence and absence of a hyphen token. At a phrase level, the difference might be understood as between a two-word phrase and a hyphenated phrase. How about “first- and second-rate”?

### Tokenizing numbers

Numerical values of the sort used for currency often contain commas and periods, e.g., US English “$1,234.56”. How many tokens? It seems natural that the currency symbol might be one token, and perhaps the dollars, cents, and period separator are separate tokens, but is the rest three tokens: `1 | , | 234`? “Forty”, “forty-five”, and “forty thousand” are all single numbers, but the first is a single word, the second is two words separated by a hyphen, and the third is two words separated by a space. How about “one hundred” (two word tokens) vs “100”?

### Tokenization below the word level

Characters (at least in English) are sequential, but that’s only partially true of morphemes (e.g., “bring” ~ “brought”, “code” ~ “coding”) and syllables. Is there a practical use for tokenization into characters? Morphemes? Syllables? Poetic feet?

### Tokenization above the word level

Tokenizing some phrasal constructions into words might misrepresent the lexical makeup of a text. For example, although the “White House” is white and it’s a house, the meaning of the phrase has little to do with the meaning of the constituent words, and a “bad actor” may or may not be a talentless thespian. “Not important” and “unimportant” are largely synonymous, but the first is two word tokens and the second is one. If tokenization is to be used for lexico-semantic purposes, splitting uniformly on white space (and, in some cases, on punctuation) may misrepresent the meaning (and perhaps also the lexicon) of the text.

### Tokenization outside the study of variation

As the first of the five stages of GM, tokenization defines, at least initially, the level of granularity for the comparison of textual variants.   But outside the study of variation, tokenization may be important for:

* lexical analysis (e.g., word frequencies)
* other lexical statistics (e.g., [TF/IDF](https://en.wikipedia.org/wiki/Tf%E2%80%93idf))
* phrasal analysis (e.g., collocations, [KWIC](https://en.wikipedia.org/wiki/Key_Word_in_Context) concordances)
* topic extraction (e.g., [LDA](https://www.quora.com/What-is-a-good-explanation-of-Latent-Dirichlet-Allocation); feel free to skip to the “layman’s explanation”)

### Your turn!

What are the tokenization challenges in your texts? Challenges may involve the writing system, the linguistic structure, or something at a higher level.