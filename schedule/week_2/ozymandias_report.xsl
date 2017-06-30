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
