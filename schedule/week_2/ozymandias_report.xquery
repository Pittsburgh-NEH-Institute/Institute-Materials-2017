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