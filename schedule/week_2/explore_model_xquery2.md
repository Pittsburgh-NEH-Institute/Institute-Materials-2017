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
 - `("a", "b", "c", "d")[1+2]` -> 3 since 1+3 is evaluated to 3
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