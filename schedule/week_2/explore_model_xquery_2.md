# Exploring the model with XQuery 2

## Your own data
One of the goals are to use XQuery to begin explore your own data. Especially to get the model features you gathered in the LOD session. General goal to get more familiar with XQuery.

## Recap
This is the query which we were evaulating when we left off yesterday:

```xquery
xquery version "3.1";
declare namespace tei="http://www.tei-c.org/ns/1.0";

let $data-collection := collection("/db/neh-2017")
let $result := "a string"
let $xml := <result><b>no bss</b>another word starting with a {$result}</result>
return $xml//text()
```

We went through:

* Variable assignment `set $result := "a string"`
* Implicit and explicit return, e.g. `0` vs `return $result` 
* Function call `collection("/db/neh-2017")`, `starts-with(., "a")`
* Namespace declaration `declare namespace tei="http://www.tei-c.org/ns/1.0";`
* Dynamically created sequences:
 - (1 to 5), 
 - `($result)`, especially with positional predicates `($result)[last()]`,
 - `("a", "b", "c", "d")[1+2]` -> 3 since 1+2 is evaluated to 3
 - Empty sequence `()`
* Dynamically created xml `let $xml := <result><b>no bss</b>another word starting with a {$result}</result>` 
* Using dynamic content in dynamically created xml, `{$result}`
* Getting elements with fully qualified names `$data-collection//tei:p`
* Geting element with wildcard namespace `$data-collection//*:p`  
* Getting text nodes `$xml//text()`. NB compared to Python you get all descendant text nodes properly
* Looking up things in the function documentation, explicit functions or browse whole module. <http://localhost:8080/exist/apps/fundocs/index.html>

### Previous session 
If you missed yesterday's session:
* [Exploring the model with XQuery, part 1](explore_model_xquery.md)

### Don't forget 
* Don't forget to look at the keyboard shortcuts, e.g. using `Ctrl+Enter/Cmd+Enter` will save you some time executing the queries.
* In the result area you can page forward and backwards with the double arrows showing if your result set is larger than your page size.

## XQuery, continued
### Use a specific document (adapt your collection path, e.g. `/db/hamlet.xml`):
```xquery
xquery version "3.1";
declare namespace tei="http://www.tei-c.org/ns/1.0";

let $data-doc := doc("/db/neh-2017/hamlet.xml")
let $heads := $data-doc//tei:head
for $head in $heads
return 
  if (contains($head,"a")) then $head else ()
```

#### Quick questions
* _How may results do we get?_
* Why do we need the `for` structure? Hint check function documentation for contains function:

```xquery
contains
                            
contains($source-string as xs:string?, $substring as xs:string?) as xs:boolean
```

``` 
Returns an xs:boolean indicating whether or not the value of
$source-string contains (at the beginning, at the end, or anywhere
within) at least one sequence of collation units that provides a
minimal match to the collation units in the value of $substring,
according to the default collation.

Parameters:
    $source-string? 	The source-string
    $substring? 	The substring
Returns:
    xs:boolean : true() if $source-string contains $substring, false() otherwise
```

(<http://localhost:8080/exist/apps/fundocs/index.html>)


### XQuery 3(.1) features
If you are new to XQuery these functions might be good to learn from the beginning:
* maps
* arrays
* string constructors

```xquery
query version "3.1";

(: Maps :)
let $map-empty := map { } (: empty map :)
let $map-two-entries := map { 'boolskt': true(), 'sequence': (<a>a</a>, <b>b</b>) }  (: map with two entries :)
let $map-ten-entries := 
map:merge(                                  (: map with ten entries :)
  for $i in 1 to 10
  return map { $i: 'value ' || $i }
)
let $map-put := map:put($map-empty, "put", $map-two-entries?sequence)
let $map-neh := map { 'vad': 'NEH-Instutute', 'when': 2017, 'where': 'Pittsburgh' }

(:  Arrays :)
let $array-empty := [] (: empty array :)
let $array-one-member := [ (1, 2) ]    (: array with single member :)
let $array-two-members := array { ('ett', 'två'), 'tre' }  (: array with two members :)
let $array-three-members := array { 1 to 2, 'TRE' }  (: array with three members :)
(: array:size() :)
(: Arrow operator :)
let $seq-three-items := ('ett', 'två', 'tre' )

(: String constructors :)
let $string-constr := ``["A new way to 'create' strings."]``
let $string-constr-var := ``["A ne w way to use variables in, `{$seq-three-items}`, strings."]``
return 
    (
        <map>{$map-two-entries?boolskt}</map>,
        <map>{$map-two-entries?sequence}</map>,
        <map>{$map-ten-entries?5}</map>,
        <map>{$map-ten-entries?((1, 3))}</map>,
        <map>{$map-ten-entries?*}</map>,
        <map>{$map-put?put}</map>,
        <map>{$map-neh?('what')}</map>,
        <map>{$map-neh?where}</map>,
        <map>{$map-neh?var[. = 'Pittsburgh']}</map>,
        <array>{$array-empty}</array>,
        <array>{try { $array-one-member(2) } catch err:FOAY0001 { "Expected error: index greater than actual size" } }</array>,
        <array>{$array-two-members(2)}</array>, 
        <array>{$array-three-members?2}</array>, 
        <array>{$array-three-members(3)}</array>,
        <array>{reverse($array-three-members)}</array>, 
        <array>{$array-three-members?*}</array>,
        <arrow>{$seq-three-items => count()}</arrow>,
        <arrow>{$seq-three-items => string-join("-") => upper-case()}</arrow>,
        <array>{for $i in 'NEH-Institute' => string-to-codepoints() return $i}</array>,
        <string-constr>{$string-constr}</string-constr>,
        <string-constr>{$string-constr-var}</string-constr>
    )[6]
```

### Functions
local is a special namespace prefix 

```xquery
xquery version "3.1";

declare namespace tei="http://www.tei-c.org/ns/1.0";

declare function local:gen-uuid($prefix as xs:string?) as xs:string {
  concat($prefix, if (empty($prefix)) then "" else "-", util:uuid())
};


declare function local:add-uid-attributes-to-fragment($item as item())
 as item() {
  typeswitch($item)
    case document-node() return
        for $child in $item/node()
        return local:add-uid-attributes-to-fragment($child)
    case element() return
      element {node-name($item)} {
        $item/@*,
        if ($item[not(@uid)]) then attribute {"uid"} {local:gen-uuid(name($item))} else (),
        for $child in $item/node()
        return local:add-uid-attributes-to-fragment($child)
      }
    default return $item
};

let $data-collection := collection("/db/neh-2017")
let $result := "a string"
let $xml := <result><b val="b"> no bss</b> another word starting with a {$result}</result>

return local:add-uid-attributes-to-fragment($xml)

```

Gives as result: 
```xml
<result uid="result-613a47fa-a524-456f-bec8-c89dbadde67d">
  <b val="b" uid="b-0238e7cc-55e6-4f2d-825f-9d7fb2d68f63"> no bss</b> another word starting with a a string</result>
```

## Merge issues

```git
ljo@bakunin ~/filer/fps-gbg/NEH-institute-2017-git$> git pull
remote: Counting objects: 5, done.
remote: Total 5 (delta 4), reused 5 (delta 4), pack-reused 0
Packar upp objekt: 100% (5/5), klart.
Från github.com:Pittsburgh-NEH-Institute/Institute-Materials-2017
   15828fe..d155726  master     -> origin/master
Uppdaterar 15828fe..d155726
error: Dina lokala ändringar av följande filer skulle skrivas över av sammanslagning:
	schedule/week_2/explore_model_xquery2.md
Checka in dina ändringar eller använd "stash" innan du byter gren.
Avbryter
ljo@bakunin ~/filer/fps-gbg/NEH-institute-2017-git$> git pull
Slår ihop schedule/week_2/explore_model_xquery2.md automatiskt
Waiting for Emacs...
Merge made by the 'recursive' strategy.
 schedule/week_2/explore_model_xquery2.md | 2 ++
 1 file changed, 2 insertions(+)
```

```git
ljo@bakunin ~/filer/fps-gbg/NEH-institute-2017-git$> git log schedule/week_2/explore_model_xquery2.md
:
commit 7070aebd53a03fb68efb938b044f64de722a84f8 (HEAD ->
master, origin/master, origin/HEAD) Merge: f7d7f29 d155726 Author:
Leif-Jöran Olsson <ljo@fripost.org> Date: Fri Jul 21 22:28:05 2017
+0200

    Merge branch 'master' of
    github.com:Pittsburgh-NEH-Institute/Institute-Materials-2017

commit f7d7f29e7e007daaa51870586b6d025637b716ec Author: Leif-Jöran
Olsson <ljo@fripost.org> Date: Fri Jul 21 22:27:59 2017 +0200

    Checking in local addition of typeswitch and user defined
    functions

commit d15572627890bec8fcdb7c334dc3c7fa71e5d7c8 Author: David J
Birnbaum <djbpitt@gmail.com> Date: Fri Jul 21 14:09:32 2017 -0400

    fixed markdown quirkiness is explore_model_xquery2.md

commit 15828fe1cf2f6a7177a73501c967200f69b56606 Author: Leif-Jöran
Olsson <ljo@fripost.org> Date: Fri Jul 21 19:59:04 2017 +0200

    Adding 3.1 features

```

```bash
ljo@bakunin ~/filer/fps-gbg/NEH-institute-2017-git$> git branch show-merge-issues 
ljo@bakunin ~/filer/fps-gbg/NEH-institute-2017-git$> git br -a
* master
  show-merge-issues
  remotes/origin/HEAD -> origin/master
  remotes/origin/master
  remotes/origin/schedule
```

```bash
ljo@bakunin ~/filer/fps-gbg/NEH-institute-2017-git$> git co show-merge-issues
M	schedule/week_2/explore_model_xquery2.md
Växlade till grenen "show-merge-issues"

ljo@bakunin ~/filer/fps-gbg/NEH-institute-2017-git$> git br -a
  master
* show-merge-issues
  remotes/origin/HEAD -> origin/master
  remotes/origin/master
  remotes/origin/schedule

```

* Make some changes ...

* Switch back to master

```bash
ljo@bakunin ~/filer/fps-gbg/NEH-institute-2017-git$> git co master
error: Dina lokala ändringar av följande filer skulle skrivas över av utcheckning:
	schedule/week_2/explore_model_xquery2.md
Checka in dina ändringar eller använd "stash" innan du byter gren.
Avbryter

ljo@bakunin ~/filer/fps-gbg/NEH-institute-2017-git$> git br -a
  master
* show-merge-issues
  remotes/origin/HEAD -> origin/master
  remotes/origin/master
  remotes/origin/schedule

```

So still on show-merge-issues branch ...
