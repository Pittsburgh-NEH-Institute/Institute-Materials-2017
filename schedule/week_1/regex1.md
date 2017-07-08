#Regular Expressions

_Regular expressions_ (called _REs_, _regexes_, _regexps_, _regex patterns_) are essentially a tiny, _highly specialized programming language_ embedded inside general purpose programming languages (Python, XQuery, javascript).
Using this little _language_, you specify the _rules_ for the _set_ of possible _strings_ that you want to _match_:
* sentences in a language, 
* e-mail addresses, 
* TeX commands, or
* anything you like. 

You can then ask questions such as:
* Does this _string_ _match_ _the pattern_?, or
* Is there a _match_ for the _pattern_ _anywhere_ in this _string_?.

You can also use _REs_ to modify a string or to split it apart in various ways.

_RE patterns_ are usually compiled into a series of bytecodes which are then executed by a matching engine.
(For advanced use, it may be necessary to pay careful attention to how the engine will execute a given _RE_, and write the _RE_ in a certain way in order to produce bytecode that runs faster or just not use too much resources to be useful).

A _RE language_ is relatively small and restricted, so not all possible string processing tasks can be done using _REs_. There are also tasks that can be done with _REs_, but the expressions turn out to be very complicated. 

In these cases, you may be better off writing code in the programming language, e.g. Python, to do the processing; Usually it is **slower** than an elaborate _RE_ but probably **a lot easier to understand**.

##Simple patterns
We will start by learning about the _simplest possible REs_. Since _REs_ are used to operate on strings, we will begin with the most common task: _matching characters_.

###Characters

* Most letters and characters will simply match themselves.
* Though some characters are special _metacharacters_, and do not match themselves: 
** They signal that some out-of-the-ordinary thing should be matched, or
** affect other portions of the _RE_ by repeating them or changing their meaning.

####Metcharacters
The complete list of metacharacters:
```
. ^ $ * + ? { } [ ] \ | ( )
```

Character classes are surrounded by `[` and `]` to form a _set of characters_. Either you specify the characters _individually_ or use _ranges_ by giving a `-` inbetween. Metacharacters **are not active** inside classes. Since the _character class_ is a _set_ you can also _complement_ it. To do complementing you give a `^` as the first character of the class. 

One of the most important metacharacters is the backslash `\` which is used to: 
* indicate various _special sequences_
* _escape_ all metacharacters so they can be used in patterns without their special mening, e.g. use `\[` to match an actual `[` in the string.

Some of the special sequences beginning with `\` represent predefined sets of characters that are often useful:
* the set of _digits_,
* the set of _letters_, or
* the set of anything that is _not whitespace_. 

`\w` matches any _alphanumeric_ character. For use with Python this set **differs** depending on whether the RE pattern is: 
* a _string_, `\w` will match all the characters marked as letters in the Unicode data, or 
* _bytes_, then this is equivalent to the class `[a-zA-Z0-9_]`. 

| Special sequence | Matches | Equivalent to |
| `\d` | any _decimal digit_ | `[0-9]` |
| `\D` | any _non-digit character_ | `[^0-9]` |
| `\s` | any _whitespace character_ | `[ \t\n\r\f\v]` |
| `\S` | any _non-whitespace character_ | `[^ \t\n\r\f\v]` |
| `\w` | _alphanumeric character_ | sometimes `[a-zA-Z0-9_]` |
| `\W` | _non-alphanumeric character_ | sometimes `[^a-zA-Z0-9_]` |
(With Python you can use the more restricted definition of `\w` in a string pattern by supplying the `re.ASCII` flag when compiling the regular expression.)

_Sequences_ can be included inside a _character class_. E.g. `[\s:;]` will match any whitespace character, a colon `:` or semicolon `;`.

The final metacharacter in this section is `.`. It matches anything except a newline character. 
(In Python you can use `re.DOTALL` to match even a _newline_. `.` is often used where you want to match _any character_.)

## Repetition

_Matching varying sets of characters_ is the first thing REs can do. Another capability is that you can specify that portions of the _RE_ must be _repeated_, i.e. _qualified_, a certain number of times.

All _repeating qualifiers_:
```
* + ? {m,n}
```

The first _metacharacter_ for _repeating_ things that we will look at is `*`. `*` does not match the _literal character_ `*`. It specifies that the previous character can be matched _zero or more times_, instead of _exactly once_. This means whatever is being repeated may not be present at all.

Another _repeating metacharacter_ is `+` which matches _one or more times_. This requires at least one occurrence compared to `*`.

There are two more repeating _qualifiers_. The question mark character, `?`, matches either _once or zero times_. The most complicated repeated qualifier is `{m,n}`, where `m` and `n` are _decimal integers_. This _qualifier_ means there must be _at least_ `m` repetitions, and _at mos_ `n` repetitions.

