# Regular Expressions 2

Last session we covered _simple patterns_ and _repetition_. We also did some exercises on this using `egrep`. Today we firstly want to cover _alternation_ and _grouping_ before we continue using `egrep` with more andvanced expressions. Later on we will start compare `egrep`s REs to `python`. 

## Alternation

_Alternation_ is the _RE_ equivalent of `or`. `word|weapon` matches _words_ in _About words and other mighty weapons_. Applied again the _RE alternation_ matches _weapons_. You can add as many alternatives as you want, e.g. `letter|syllable|word|phrase|sentence|paragraph`.

_Alternation_ has the **lowest precedence** of all _RE operators_.

Exercise: Find the preference for all types, e.g _concatenation_, _repetition_ and _alternation_.

## Grouping
Since we introduced _precedence_ in the previous section we also want to be able to change the behaviour. This is one of the things _grouping_ does.  

| Metacharacter | Explanation |
| --- | --- |
| `(` | starts a group |
| `)` | ends a group |

### Precedence examples

<table>
<tr><th>String</th><th>Pattern</th><th>Match?</th></tr>
<tr><td> word and phrase level</td><td><code>word|phrase level</code></td><td>Yes, both <em>word</em> and <em>phrase level</em></td></tr>
<tr><td>walked up to the talking lamp post</td><td><code>ed\b|ing\b</code></td><td>Yes, both <em>ed</em> at the end of <em>walked</em> and <em>ing</em> at the end of <em>talking</em></td></tr>
<tr><td>word level and phrase level</td><td><code>word|phrase level</code></td><td>Yes, but only <em>word</em> and <em>phrase level</em> (not all of <em>word level</em>)</td></tr>
<tr><td>word level and phrase level</td><td><code>(word|phrase) level</code></td><td>Yes, both <em>word level</em> and <em>phrase level</em></td></tr>
</table>

In addition to use the _grouping metachararacters_ to alter the precedence you can use it for _back reference_. Some RE implementations have named grouping back references others just `\1`, `\2` etcetera.

Exercise: Check out how this is in `egrep`.   
 

## Comparing to Python
Without going into actual Python programming we are going to see how the `egrep` REs compare to Python's:  
* [Regular expressions 101](https://regex101.com/)

Make sure to tick Python in the _Flavour_ list to the left.
