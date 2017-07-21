# Exploring the model with XQuery 2

This is query where we left off yesterday:
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
* Function call `collection("/db/neh-2017")`
* Namespace declaration `declare namespace tei="http://www.tei-c.org/ns/1.0";`
* Dynamically created sequences:
 - (1 to 5), 
 - `($result)`, especially with positional predicates `($result)[last()]`,
 - `("a", "b", "c", "d")[1+2]` -> 3 since 1+3 is evaluated to 3
 - Empty sequence `()`
* Dynamically created xml `let $xml := <result><b>no bss</b>another word starting with a {$result}</result>` 

If you missed yesterdays session:
* [Exploring the model with XQuery, part 1](explore_model_xquery.md)


* Don't forget to look at the keyboard shortcuts, e.g. using `Ctrl+Enter/Cmd+Enter` will save you some time executing the queries.
* In theresult area you can page forward and backwards with the double arrows showing if your result set is larger than your page size.

