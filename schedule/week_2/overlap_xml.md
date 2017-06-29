# Overlap in XML

## Markup complications

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

## Processing complications

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