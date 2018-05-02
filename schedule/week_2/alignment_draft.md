<!-- These material have been incorporated into alignment.md; this page should not be linked. -->
# Alignment

As part of the collation of textual variants, alignment is the process of determining which tokens in one witness should be regarded as parallel to which tokens in another. Alignment thus presupposes [tokenization](week_2_day_1_tokenization.md). Furthermore, texts may be [normalized](week2_day_1_normalization.md) before alignment as a way of treating as equivalent readings that are not string-equal. Normalization may be implemented in the text itself, completely leveling differences that may have been present originally, or it may be performed on shadow copies of the tokens, which lets the alignment process treat different readings as equivalent without irretrievably erasing evidence of the differences.

<img src="images/collation_aligner.png" align="right"/>The image to the right and the accompanying description of it are taken from <https://wiki.tei-c.org/index.php/Textual_Variance>: 

> Looking at an example, assume that we have three witnesses: the first is comprised of the token sequence (a, b, c, d), the second reads (a, c, d, b) and the third (b, c, d). A collator might align these three witnesses as depicted in a tabular fashion on the right. Each witness occupies a column, matching tokens are aligned in a row, necessary gap tokens as inserted during the alignment process are denoted via a hyphen. Depending from which perspective one interprets this alignment table, one can say for example that the (b) in the second row was ommitted in the second witness or it has been added in the first and the third. A similar statement can be made about (b) in the last row by just inverting the relationship of being added/omitted.

Some alignment decisions cannot be resolved unambiguously even by a human. Given the variants “It’s a big problem” and “It’s big, big problem”, there is no principled way to determine which of the “big” tokens in the second string should be regarded as corresponding to the single “big” token in the first string, and which should be regarded as having no counterpart.

## Scalability and presegmentation

Alignment is a computationally complex task, and the complexity (that is, the amount of processing required) increases at a greater than linear rate according to the length of the text and the number of witnesses. For that reason, if you know that all of the variation in your text is within chapters, and that corresponding textual material is never in different chapters in different witnesses, you can increase the efficiency and the accuracy of the alignment process by presegmenting the witnesses into chapters and treating each chapter as an independent collation problem.

## Multiple witnesses and order effects

Aligning two witnesses is relatively easy, and one strategy might be to align the longest common substring, thus dividing the witnesses into three parts: the aligned substring, the part before it, and the part after it. We can then regard the parts before and after as new alignment tasks, find the longest common substrings inside them, and repeat the process recursively. This process is not guaranteed to find all alignment points (see the discussion of transposition, below), but it may represent a reasonable compromise between accuracy (finding all alignment points) and speed (finding them without having to compare every token to every other token, which has exponential complexity—that is, which is very expensive computationally).

The nature of the problem changes, though, with more than two witnesses. One strategy is to align two (which two?), creating a sort of “superwitness”, and then align a third against the superwitness, and continue adding new witnesses. The problem with this approach is that because it does not permit backtracking from an early decision that later turns out to be suboptimal, it creates order effects, that is, the final result may vary depending on the order in which we incorporate the witnesses. On the other hand, trying to evaluate all witnesses at once poses different challenges, such as whether we should prefer the deepest match (the one that includes the largest number of witnesses, even if it isn’t very long in terms of token count) or the longest (even if it isn’t very deep in terms of witness count). Alignment algorithms employ heuristics to reduce the complexity of the problem and arrive at an optimal alignment without having to evaluate all possibilities, which would be prohibitively expensive computationally. 

## Repetition

Repetition poses obvious challenges for alignment. In a typical English-language text, approximately 6% of the word tokens are the word “the”. Alignment must determine which instances of “the” in one witness should be aligned with which instances in another. The instances are not guaranteed to be in order, since some witnesses may include text that is not present in other witnesses. This means that, for example, witnesses might contain the same words in situations where they should not be considered textually parallel, and therefore should not be aligned.

## Transposition

Transposition refers to situations where the same text in different witnesses may occur in different orders. Transposition frustrates the longest-common-substring strategy described above, since text before that substring in one witness may correspond to text after the substring in another. In that situation, if we try to regard the text before and text after as independent collation sets, we will fail to find correspondences outside the boundaries of those sets.

## Exact vs near matching

Finding the tokens in one witness that match those in another exactly requires deciding whether two strings are the same or different. That’s a relatively quick process. For example, if they are different lengths, they can’t be the same, and there’s no need to look at the individual characters. If they are the same length, we can look at the individual characters, but as soon as one fails to match, we can stop looking.

Finding the closest match, on the other hand, requires more processing because we need to fully rank and compare all possible matches. The difference in computational complexity—that is, in processing time—between exact and near matching may be so great as to render near matching impractical except on relatively short texts. Some alignment strategies negotiate this complexity by beginning with exact matching, and falling back on near matching only to make decisions in situations where there is no exact match.

## Near matching and normalization

Near matching is simlar to normalization in that both involve recognizing when tokens that are string-different should nonetheless be regarded as corresponding to one another. One practical difference is that normalization is performed before alignment, and is therefore a logical place to record the equivalence of _systematic_ variants, those that should always be considered equivalent. For example, if a writing system has two ways of spelling the same sound that are used indiscriminately in the witnesses, the difference between them would be a candidate for normalization. In contrast, if a particular token is accidentally or idiosyncratically spelled slightly differently in different witnesses, perhaps by changing a single letter, conflating those variants by neutralizing the distinction between the letters globally during normalization might level variation that is important in other contexts. In that situation, it might be more effective to find the near match at the alignment stage. 

## Alignment and markup

The preceding assumes that we’re comparing textual content across witnesses, but what if witnesses also differ in markup? When should markup be part of an alignment decision and when should it be ignored for alignment purposes? Alignment is typically performed on character data, which makes sense for textual content, but not all character information in  serialized markup is informational. For example, the order in which attributes are specified in serialized XML is not informational, and the same is true of whether attributes are single or double quoted, or whether empty elements are spelled with self-closing single tags or separate start and end tags with nothing between them. Alignment that relies on string comparison will nonetheless find a string difference in all of those situations. One strategy might involve normalizing the markup during the normalization stage to remove non-informational variation. 

## Your turn!

If your edition includes textual variation, what alignment challenges does it pose?  
