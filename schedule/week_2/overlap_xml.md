# Overlap in XML

The examples below illustrate that the XML prohibition against overlap not only distorts the markup, but also complicates processing. The point of the XPath and XQuery examples is not as much to analyze the advanced features needed to process milestone workarounds as to demonstrate that processing overlapping structures represented by milestone workarounds is harder than processing wrapper elements.

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

Phrases and lines overlap. We can’t make both of them containers, so instead of the standard TEI `<lg>` (line group) and `<l>` (line) [wrapper markup of lines](http://www.tei-c.org/release/doc/tei-p5-doc/en/html/CO.html#COVE), we've used [wrapper markup of phrases](http://www.tei-c.org/release/doc/tei-p5-doc/en/html/AI.html#AILC) (`<phr>`) and tagged the beginnings of lines with empty (`<lb/>`) milestones (glossed as ‘line break’ in the [TEI guidelines](http://www.tei-c.org/release/doc/tei-p5-doc/en/html/ref-lb.html), but more appropriately understood as ‘line beginning’). We could, alternatively, have used regular wrapper tags for lines and milestones for phrases. What we can’t do, because of the XML prohibition against overlap, is use both `<l>` and `<phr>`—or, at least, unless we do some fancy joining with attribute pointers, which distorts what constitutes a line or a phrase.

This isn’t a problem in LMNL, though, because LMNL ranges, unlike XML elements, are permitted to overlap:

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

## Processing complications

Overlap in XML is problematic not only during markup, buit also during processing. Processing elements tagged with wrappers (like `<phr>` in the XML above) is easy because the XPath target is a single element. Processing elements delimited by milestones (like `<lb>` above) is harder.

### XPath

An XPath expression to find phrases is easy because `<phr>` elements have content:

```xpath
for $phr in //phr return $phr
```

Likewise for emjambment, that is phrases that cross line boundaries, for the same reason:

```xpath
for $enj in //phr[lb] return $enj
```

Here we use a predicate to filter the phrases and keep only the ones that have line break children, but the XPath expression is still straightforward.

Finding lines, though, is more complicated:

```xpath
for $lb in //lb return string-join($lb/following::text()[preceding::lb[1] is $lb])
```

The preceding XPath expression finds of the `text()` nodes that follow each `<lb>` and filters them with a predicate that keeps only the ones whose first preceding `<lb>` is the one we’re processing at the moment. The predicate is complex, and because we’re returning multiple nodes on each pass through the loop (unlike the single `<phr>` elements returned in the earlier examples), we need to assemble the ones that belong to the same line, which we do with the `string-join()` function.

### XQuery

Below is an XQuery script that outputs the information from the XPath expressions above as XML, enriched with additional markup:


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