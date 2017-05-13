# Tokenization

## What’s easy and what’s hard

Tokenization (the first of the five parts of the [Gothenburg model](http://wiki.tei-c.org/index.php/Textual_Variance#The_.E2.80.9CGothenburg_model.E2.80.9D:_A_modular_architecture_for_computer-aided_collation)) divides the texts to be collated into tokens, which are most commonly (but not obligatorily) words. Dividing continuous text into words feel intuitive as long as the text contains nothing but words, but text also typically contains punctuation. By default, the [CollateX](https://pypi.python.org/pypi/collatex) collation toolkit considers punctuation to be its own token, which means that the witness readings “Hi!” and “Hi” will both contain a token that reads “Hi” (and the first witness will contain an additional token, which reads “!”). In this situation, that’s the behavior the user probably wants, since both witnesses contain what a human would recognize as the same word.

We’ll explore tokenization in more detail [tomorrow](week_2_day_2_plan.md), but here’s a brief introduction.

## Issues with default tokenization

### English possessive constructions

But is a word like “Peter’s” the same word as “Peter” for collation purposes? Because CollateX will regard the apostrophe as a separate token, “Peter’s” will be tokenized as three tokens: the name, the apostrophe, and the possessive. Here’s the default behavior:

Siglum | 1 | 2 | 3 | 4 | 5 
---- | ---- | ---- | ---- | ---- | ---- 
A | Peter | ' | s | cat | .
B | Peter | has | a | cat | .


For possessives that may or may not be acceptable behavior, but how about contractions like “didn’t” (how many tokens, and what are they?) or “A’dam” (short for “Amsterdam”, and logically one token)?

### English hyphenation

Assuming you can reliably distinguish hard and soft hyphens:

1. How many words is “ne’er-do-well”?
1. If we tokenize “first-rate” as `first | - | rate`, how does that differ from “first rate”? From one perspective, a hyphen token has been added between two word tokens, so the variation is between the presence and absence of a hyphen token. But from a human perspective, the difference might be understood as whether we are dealing with a two-word phrase or a hyphenated phrase. That is, “first” and “rate” might be felt to participate in phrase-level variation. How about “first- and second-rate”?

### Punctuation in numbers

The rules are different for different languages, but numerical values of the sort used for currency often contain commas and periods, e.g., US English “$1,234.56”. How many tokens? It seems natural that the currency symbol might be one token, and perhaps the dollars, cents, and period separator are separate tokens, but is the rest three tokens: `1 | , | 234`?

### Tokenization below the word level

Characters (at least in English) are sequential, but that’s only partially true of morphemes (e.g., “bring” ~ “brought”, “code” ~ “coding”). Is there a practical use for tokenization into characters? Morphemes? 

### Tokenization above the word level

Tokenizing some phrasal constructions into words might misrepresent the lexical makeup of a text. For example, “White House” has little to do with “white” or “house”, and a “bad actor” may or may not be a talentless thespian. If tokenization is to be used for lexico-semantic purposes, splitting naively on white space may misrepresent the meaning (and perhaps also the lexicon) of the text.

### Other

What are the tokenization challenges in your texts? Challenges may involve the writing system, the linguistic structure, or something at a higher level.