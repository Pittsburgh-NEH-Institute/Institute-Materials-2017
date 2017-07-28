<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:math="http://www.w3.org/2005/xpath-functions/math" exclude-result-prefixes="xs math"
    version="3.0" xpath-default-namespace="http://www.tei-c.org/ns/1.0"
    xmlns="http://www.tei-c.org/ns/1.0">
    <xsl:template match="node()">
        <xsl:copy>
            <xsl:apply-templates select="node() | @*"/>
        </xsl:copy>
    </xsl:template>
    <xsl:template match="text//p//milestone[not(@unit eq 'wb')]">
        <xsl:sequence select="copy-of(.)"/>
    </xsl:template>
    <xsl:template match="text//p//milestone[@unit eq 'wb']">
        <!-- keep a wb unless there is no text() between it and the preceding wb -->
        <xsl:variable name="preceding-wb" select="preceding-sibling::milestone[@unit eq 'wb'][1]"/>
        <xsl:variable name="preceding-text" select="preceding-sibling::text()[1]"/>
        <xsl:choose>
            <xsl:when
                test="not($preceding-wb) or not($preceding-text) or $preceding-text &lt;&lt; $preceding-wb"/>
            <xsl:otherwise>
                <xsl:sequence select="copy-of(.)"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
</xsl:stylesheet>
