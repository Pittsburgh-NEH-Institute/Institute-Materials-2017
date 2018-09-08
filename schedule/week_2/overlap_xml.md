# Overlap in XML

The examples below illustrate that the XML prohibition against overlap not only distorts the markup, but also complicates processing. The point of the XPath and XQuery examples is not so much to analyze the advanced features needed to process milestone workarounds, but to demonstrate that processing overlapping structures represented by milestone workarounds is harder than processing regular XML “container” elements. In other words, the examples below illustrate why resorting to established workarounds is not always the best option. If you do use workarounds to capture complex textuel phenomena, then you need to be aware of the potential consequences for processing, querying, and analyzing.

## Markup complications

Excerpt from TEI edition of [“Ozymandias”](ozymandias.xml):

```xml
<p>
   <lb/><phr>I met a traveller from an antique land,</phr>
   <lb/><phr>Who said —</phr><phr>“Two vast and trunkless legs of stone
   <lb/>Stand in the desart.... </phr><phr>Near them,</phr> <phr>on the sand,</phr>
   <lb/><phr>Half sunk a shattered visage lies,</phr> <phr>whose frown,</phr>
   <lb/><phr>And wrinkled lip,</phr> <phr>and sneer of cold command,</phr>
   <lb/><phr>Tell that its sculptor well those passions read
   <lb/>Which yet survive,</phr> <phr>stamped on these lifeless things,</phr>
   <lb/><phr>The hand that mocked them,</phr> <phr>and the heart that fed;</phr>
   <lb/><phr>And on the pedestal,</phr> <phr>these words appear:</phr>
   <lb/><phr>My name is Ozymandias,</phr> <phr>King of Kings,</phr>
   <lb/><phr>Look on my Works,</phr> <phr>ye Mighty,</phr> <phr>and despair!</phr>
   <lb/><phr>Nothing beside remains.</phr> <phr>Round the decay
   <lb/>Of that colossal Wreck,</phr> <phr>boundless and bare
   <lb/>The lone and level sands stretch far away.”</phr>
</p>
```

Phrases and lines overlap. We can’t make both of them containers, so instead of the standard TEI `<lg>` (line group) and `<l>` (line) [wrapper markup of lines](http://www.tei-c.org/release/doc/tei-p5-doc/en/html/CO.html#COVE), we've used [wrapper markup of phrases](http://www.tei-c.org/release/doc/tei-p5-doc/en/html/AI.html#AILC) (`<phr>`) and tagged the beginnings of lines with empty `<lb/>` (line beginning) milestones, but more appropriately understood as ‘line break'. We could, alternatively, have used regular wrapper tags for lines and milestones for phrases. What we can’t do straightforwardly, because of the XML prohibition against overlap, is use both `<l>` and `<phr>` unless we do some joining with attribute pointers, for example:

```xml
<p>
  <l><phr>I met a traveller from an antique land,</phr></l>
  <l><phr>Who said —</phr><phr xml:id="l2p2" next="#l3p1">“Two vast and trunkless legs of stone</phr></l>
  <l><phr xml:id="l3p1" prev="#l2p2">Stand in the desart.... </phr><phr>Near them,</phr> <phr>on the sand,</phr></l>
  <l><phr>Half sunk a shattered visage lies,</phr> <phr>whose frown,</phr></l>
  <l><phr>And wrinkled lip,</phr> <phr>and sneer of cold command,</phr></l>
  <l><phr xml:id="l6p1" next="#l7p1">Tell that its sculptor well those passions read</phr></l>
  <l><phr xml:id="l7p1" prev="#l6p1">Which yet survive,</phr> <phr>stamped on these lifeless things,</phr></l>
  <l><phr>The hand that mocked them,</phr> <phr>and the heart that fed;</phr></l>
  <l><phr>And on the pedestal,</phr> <phr>these words appear:</phr></l>
  <l><phr>My name is Ozymandias,</phr> <phr>King of Kings,</phr></l>
  <l><phr>Look on my Works,</phr> <phr>ye Mighty,</phr> <phr>and despair!</phr></l>
  <l><phr>Nothing beside remains.</phr> <phr xml:id="l12p2" next="#l13p1">Round the decay</phr></l>
  <l><phr xml:id="l13p1" prev="#l12p2">Of that colossal Wreck,</phr> <phr xml:id="l13p3"
    next="#l14p1">boundless and bare</phr></l>
  <l><phr xml:id="l14p1" prev="#l13p3">The lone and level sands stretch far away.”</phr></l>
</p>
```

This version, though, means that phrases are tagged in two different ways not because they are intrinsically different kinds of content objects, but because of their interaction with the division of the poem into metrical lines. The use of pointers also moves the representation of enjambed phrases out of the XML tree model and into TEI markup semantics. That is, an XML parser doesn’t know that the separated pieces of an enjambed phrase are a single content object, and it is only on the application level that the semantics of the TEI `@prev` and `@next` attributes notify the processor that the pieces should be recombined.

In comparison, the fact that lines and phrases may overlap isn’t a problem in LMNL because LMNL ranges, unlike XML elements, are permitted to overlap:

```
[sonneteer [id}ozymandias{id]}
[meta [author}Percy Bysshe Shelley{author] [title}Ozymandias{title]]
[sonnet}[s}[octave}[quatrain}
[l}[voice [who}Narrator{]}[phr}I met a traveller from an antique land,{phr]{l]
[l}[phr}Who said —{phr][voice [who}traveller{][discourse}direct{]}[phr}“Two vast and trunkless legs of stone{l]
[l}Stand in the desart.[caesura}...{caesura]{phr][phr}Near them,{phr] [phr}on the sand,{phr]{l]
[l}[phr}Half sunk a shattered visage lies,{phr] [voice [who}sculptor{][discourse}implicit{]}[phr}whose frown,{phr]{l]{quatrain]
[quatrain}[l}[phr}And wrinkled lip,{phr] [phr}and sneer of cold command,{phr]{l]
[phr}[l}Tell that its sculptor well those passions read{l]
[l}Which yet survive,{phr] [phr}stamped on these lifeless things,{phr]{l]
[l}[voice [who}Ozymandias{][discourse}implicit{]}[phr}The hand that mocked them,{phr] [phr}and the heart that fed;{phr]{voice]{voice]{l]{quatrain]{octave]
[sestet}[tercet}[l}[phr}And on the pedestal,{phr] [phr}these words appear:{phr]{l]
[l}[voice [who}Ozymandias{][discourse}direct{]}[phr}My name is Ozymandias,{phr] [phr}King of Kings,{phr]{l]
[l}[phr}Look on my Works,{phr] [phr}ye Mighty,{phr] [phr}and despair!{phr]{l]{voice]{tercet]{s]
[tercet}[l}[s}[phr}Nothing beside remains.{phr]{s] [s}[phr}Round the decay{l]
[l}Of that colossal Wreck,{phr] [phr}boundless and bare{l]
[l}The lone and level sands stretch far away.{phr]”{l]{s]{tercet]{sestet]{voice]{voice]{sonnet]
{sonneteer [encoding [resp}ebeshero{][resp}wap{]]]
```

## Processing complications: XPath

Overlap in XML is problematic not only during markup, but also during processing. Processing elements tagged with wrappers (like `<phr>` in the XML above) is easy because the XPath target is a single element. Processing elements delimited by milestones (like `<lb>` above) is harder. Try the following in the \<oXygen/\> XPath browser box, using the first version above, the one with `<lb>` milestone tags. In the following paragraphs we look at the processing consequences of Markup Style 1 and Markup Style 2.

### XPath

An XPath expression to find phrases is easy because `<phr>` elements have content:

```xpath
for $phr in //phr return $phr
```

This can be simplified as:

```xpath
//phr
```

If we want to do the same thing for the XML using @prev and @next, then we probably can't just use XPath, as we have to put together the pieces.

Likewise for emjambment, that is phrases that cross line boundaries, for the same reason:

```xpath
for $enj in //phr[lb] return $enj
```

which can be simplified as:

```xpath
//phr[lb]
```

For our Style 2 XML, we can simply look for `<phr>`s that don't have `@prev`, but then we will have to join the split ones:

```xpath
for $p in //phr[not(@prev)] return
	string-join(($p, //phr[@xml:id = substring-after($p/@next, '#')]),' ')
```

This does part of the job. Note that this XPath-only strategy doesn’t work with phrases spread over more than two lines because XPath alone cannot check recursively to see whether the “next” part of the phrase has another “next” part after it, etc.

Finding lines is more complicated for Style 1:

```xpath
for $lb in //lb return string-join($lb/following::text()[preceding::lb[1] is $lb])
```

The preceding XPath expression (which cannot be expressed without the `for` clause) finds all of the `text()` nodes that follow each `<lb>` and filters them with a predicate that keeps only the ones whose first preceding `<lb>` is the one we’re processing at the moment. The predicate is complex, and because we’re returning multiple nodes on each pass through the loop (unlike the single `<phr>` elements returned in the earlier examples), we need to assemble the ones that belong to the same line, which we do with the `string-join()` function.

Whereas, for Style 2, it's trivial:

```xpath
//l
```

What the preceding shows is that not only is the milestone workaround for overlapping hierarchies more complex for the human during markup, but it is also more complex for the computer during search and retrieval. Tree traversal is relatively quick, but the XPath long horizontal (`preceding::` and `following::`) axes are unable to take the same navigational advantage of the tree structure as the other axes. The consequences may not be noticeable if the data set is small, or if the processing environment uses indexing or internal optimizations to mitigate the effects, but, in general, traversing the long horizontal axes will not be as fast as other traversals.

### XQuery

Below is an XQuery script that outputs the information from the XPath expressions above as XML, enriched with additional markup. The corresponding simple XPath expressions are given as XQuery comments, which are delimited by smiley faces: `(:` and `:)`.


```xquery
declare namespace tei = "http://www.tei-c.org/ns/1.0";
<results>
  (: for $phr in //phr return $phr :)
  <phrases>{
      for $phr in //tei:phr
      let $startLine := $phr/preceding::tei:lb[1]/count(preceding::tei:lb) + 1
      let $endLine := ($phr/following::tei:lb[1]/count(preceding::tei:lb),count(//tei:lb))[1]
      return
        <phrase starts="{$startLine}" ends="{$endLine}">{replace($phr, '\n\s+',' | ')}</phrase>
  }</phrases>
  (: for $enj in //phr[lb] return $enj :)
  <enjambments>{
      for $enj in //tei:phr[tei:lb]
      let $lbpos := $enj/tei:lb/count(preceding::tei:lb)
      return
        <enjambment spans="{$lbpos, $lbpos+1}">{(replace($enj,'\n\s+',' | '))}</enjambment>
    }</enjambments>
  (: for $lb in //lb return string-join($lb/following::text()[preceding::lb[1] is $lb]) :)
  <lines>{
      for $lb at $pos in //tei:lb
      return
        <line n="{$pos}">{normalize-space(string-join($lb/(following::text()[preceding::tei:lb[1] is $lb])/.))}</line>
    }
  </lines>
</results>
```

We could write a similar XQuery producing the same results for Style 2:

```xquery
declare namespace tei = "http://www.tei-c.org/ns/1.0";
<results>
  <phrases>{
    for $phr in //tei:phr[not(@prev)]
    let $p := if ($phr/@next) then
      string-join(($phr, $phr/following::tei:phr[@prev = concat('#',$phr/@xml:id)]), " | ")
      else
        $phr/text()
    let $startLine := $phr/parent::tei:l/count(preceding-sibling::tei:l) + 1
    let $endLine := if ($phr/@next)
      then id(substring-after($phr/@next, '#'))/parent::tei:l/count(preceding-sibling::tei:l) + 1
      else $phr/parent::tei:l/count(preceding-sibling::tei:l) + 1
    return
      <phrase starts="{$startLine}" ends="{$endLine}">{$p}</phrase>
  }</phrases>
  <enjambments>{
    for $phr in //tei:phr[@next]
    let $lpos := $phr/parent::tei:l/count(preceding-sibling::tei:l) + 1
    return
      <enjambment spans="{$lpos, $lpos+1}">{concat($phr/text(), " | ", $phr/following::tei:phr[1]/text())}</enjambment>
  }</enjambments>
  <lines>{
    for $l at $pos in //tei:l
    return
      <line n="{$pos}">{string-join($l//text())}</line>
  }</lines>
</results>
```

Notice that the tradeoff we make in Style 1 vs. Style 2 is in either making lines harder to process, or having to resolve phrases. We can make either one work.

Running the preceding XQuery against the XML of the poem creates the following output:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<results>
  (: for $phr in //phr return $phr :)
  <phrases>
      <phrase starts="1" ends="1">I met a traveller from an antique land,</phrase>
      <phrase starts="2" ends="2">Who said —</phrase>
      <phrase starts="2" ends="3">“Two vast and trunkless legs of stone | Stand in the desart.... </phrase>
      <phrase starts="3" ends="3">Near them,</phrase>
      <phrase starts="3" ends="3">on the sand,</phrase>
      <phrase starts="4" ends="4">Half sunk a shattered visage lies,</phrase>
      <phrase starts="4" ends="4">whose frown,</phrase>
      <phrase starts="5" ends="5">And wrinkled lip,</phrase>
      <phrase starts="5" ends="5">and sneer of cold command,</phrase>
      <phrase starts="6" ends="7">Tell that its sculptor well those passions read | Which yet survive,</phrase>
      <phrase starts="7" ends="7">stamped on these lifeless things,</phrase>
      <phrase starts="8" ends="8">The hand that mocked them,</phrase>
      <phrase starts="8" ends="8">and the heart that fed;</phrase>
      <phrase starts="9" ends="9">And on the pedestal,</phrase>
      <phrase starts="9" ends="9">these words appear:</phrase>
      <phrase starts="10" ends="10">My name is Ozymandias,</phrase>
      <phrase starts="10" ends="10">King of Kings,</phrase>
      <phrase starts="11" ends="11">Look on my Works,</phrase>
      <phrase starts="11" ends="11">ye Mighty,</phrase>
      <phrase starts="11" ends="11">and despair!</phrase>
      <phrase starts="12" ends="12">Nothing beside remains.</phrase>
      <phrase starts="12" ends="13">Round the decay | Of that colossal Wreck,</phrase>
      <phrase starts="13" ends="14">boundless and bare | The lone and level sands stretch far away.”</phrase>
   </phrases>
  (: for $enj in //phr[lb] return $enj :)
  <enjambments>
      <enjambment spans="2 3">“Two vast and trunkless legs of stone | Stand in the desart.... </enjambment>
      <enjambment spans="6 7">Tell that its sculptor well those passions read | Which yet survive,</enjambment>
      <enjambment spans="12 13">Round the decay | Of that colossal Wreck,</enjambment>
      <enjambment spans="13 14">boundless and bare | The lone and level sands stretch far away.”</enjambment>
   </enjambments>
  (: for $lb in //lb return string-join($lb/following::text()[preceding::lb[1] is $lb]) :)
  <lines>
      <line n="1">I met a traveller from an antique land,</line>
      <line n="2">Who said —“Two vast and trunkless legs of stone</line>
      <line n="3">Stand in the desart.... Near them, on the sand,</line>
      <line n="4">Half sunk a shattered visage lies, whose frown,</line>
      <line n="5">And wrinkled lip, and sneer of cold command,</line>
      <line n="6">Tell that its sculptor well those passions read</line>
      <line n="7">Which yet survive, stamped on these lifeless things,</line>
      <line n="8">The hand that mocked them, and the heart that fed;</line>
      <line n="9">And on the pedestal, these words appear:</line>
      <line n="10">My name is Ozymandias, King of Kings,</line>
      <line n="11">Look on my Works, ye Mighty, and despair!</line>
      <line n="12">Nothing beside remains. Round the decay</line>
      <line n="13">Of that colossal Wreck, boundless and bare</line>
      <line n="14">The lone and level sands stretch far away.”</line>
   </lines>
</results>
```

### XSLT

The XSLT `<xsl:for-each-group>` elements makes it possible to collect just the `<lb>` elements and the `text()` nodes and group them into lines:

```xslt
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="3.0"
  xpath-default-namespace="http://www.tei-c.org/ns/1.0">
  <xsl:output method="xml" indent="yes"/>
  <xsl:template match="/">
    <xsl:apply-templates select="//text//p"/>
  </xsl:template>
  <xsl:template match="p">
    <lines>
      <xsl:for-each-group select="descendant::lb | descendant::text()"
        group-starting-with="lb">
        <xsl:if test="position() gt 1">
          <line n="{count(preceding::lb) + 1}">
            <xsl:value-of select="normalize-space(string-join((current-group())))"/>
          </line>
        </xsl:if>
      </xsl:for-each-group>
    </lines>
  </xsl:template>
</xsl:stylesheet>
```

This avoids the uncommon XPath `is` operator, but it requires attention to using the descendant axis (since `text()` nodes and `<lb>` elements are not all children of `<p>`) and to skipping the first group (the white space `text()` node before the first `<lb>`). The output is:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<lines>
   <line n="1">I met a traveller from an antique land,</line>
   <line n="2">Who said —“Two vast and trunkless legs of stone</line>
   <line n="3">Stand in the desart.... Near them, on the sand,</line>
   <line n="4">Half sunk a shattered visage lies, whose frown,</line>
   <line n="5">And wrinkled lip, and sneer of cold command,</line>
   <line n="6">Tell that its sculptor well those passions read</line>
   <line n="7">Which yet survive, stamped on these lifeless things,</line>
   <line n="8">The hand that mocked them, and the heart that fed;</line>
   <line n="9">And on the pedestal, these words appear:</line>
   <line n="10">My name is Ozymandias, King of Kings,</line>
   <line n="11">Look on my Works, ye Mighty, and despair!</line>
   <line n="12">Nothing beside remains. Round the decay</line>
   <line n="13">Of that colossal Wreck, boundless and bare</line>
   <line n="14">The lone and level sands stretch far away.”</line>
</lines>
```

We really don't need to do this for Style 2, as we already have lines. Stripping out the phrases would be a trivial exercise in XSLT.

Returning to Style 2, the XPath-only strategy wouldn't work with phrases spread over more than two lines because XPath alone cannot check recursively to see whether the “next” part of the phrase has another “next” part after it, etc. Here is an XQuery script that follows `@next` pointers:

```xquery
declare namespace djb="http://www.obdurodon.org";
declare function djb:processPhrase($nodes as element(phr)*, $input as element(phr)) as xs:string{
    if ($input/@next) then
        djb:processPhrase(($nodes, $input), root($input)//phr[@xml:id eq substring-after($input/@next, '#')])
    else
        normalize-space(string-join(($nodes, $input), ' '))
};
<results>{
    let $phrases := //phr[not(@prev)]
    for $phrase in $phrases
    return
        <phrase>{djb:processPhrase((),$phrase)}</phrase>
}</results>
```

Notice the function starting in the second line. If the current element has a `@next` attribute, the function calls **itself** with the sequence of phrases it has accumulated so far, plus the next phrase element. If that element has a `@next`, the function is called again with that phrase added to the sequence and the following phrase, if the current phrase has a `@next` (or with an empty sequence otherwise). If the current phrase doesn't have a `@next`, then the function returns the list of accumulated phrases joined together with the input node (which may be empty). This pattern is called "recursion" and is a kind of programming superpower. It is used very often in processing lists, trees, or other data structures of indeterminate size.

When run against the poem, the output is:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<results>
   <phrase>I met a traveller from an antique land,</phrase>
   <phrase>Who said —</phrase>
   <phrase>“Two vast and trunkless legs of stone Stand in the desart....</phrase>
   <phrase>Near them,</phrase>
   <phrase>on the sand,</phrase>
   <phrase>Half sunk a shattered visage lies,</phrase>
   <phrase>whose frown,</phrase>
   <phrase>And wrinkled lip,</phrase>
   <phrase>and sneer of cold command,</phrase>
   <phrase>Tell that its sculptor well those passions read Which yet survive,</phrase>
   <phrase>stamped on these lifeless things,</phrase>
   <phrase>The hand that mocked them,</phrase>
   <phrase>and the heart that fed;</phrase>
   <phrase>And on the pedestal,</phrase>
   <phrase>these words appear:</phrase>
   <phrase>My name is Ozymandias,</phrase	>
   <phrase>King of Kings,</phrase>
   <phrase>Look on my Works,</phrase>
   <phrase>ye Mighty,</phrase>
   <phrase>and despair!</phrase>
   <phrase>Nothing beside remains.</phrase>
   <phrase>Round the decay Of that colossal Wreck,</phrase>
   <phrase>boundless and bare The lone and level sands stretch far away.”</phrase>
</results>
```

The XSLT `<xsl:for-each-group>` element is a good choice for this task, and produces the same output as the preceding XQuery:

```xslt
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:t="http://www.tei-c.org/ns/1.0"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs t"
    version="3.0">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="/">
        <results>
            <xsl:for-each-group select="//t:phr" group-starting-with="t:phr[not(@prev)]">
                <result>
                    <xsl:sequence select="normalize-space(string-join(current-group(),' '))"/>
                </result>
            </xsl:for-each-group>
        </results>
    </xsl:template>
</xsl:stylesheet>

```
