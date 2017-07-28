<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xpath-default-namespace="http://www.tei-c.org/ns/1.0"
    xmlns:math="http://www.w3.org/2005/xpath-functions/math" exclude-result-prefixes="xs math"
    version="3.0" xmlns="http://www.tei-c.org/ns/1.0">
    <xsl:strip-space elements="*"/>
    <!--
        remove <del> elements paired with <add> inside <subst>
        flatten all other markup in text//p
    -->
    <xsl:template match="node()">
        <xsl:copy>
            <xsl:apply-templates select="@* | node()"/>
        </xsl:copy>
    </xsl:template>
    <xsl:template match="subst" priority="10">
        <xsl:apply-templates select="add"/>
    </xsl:template>
    <xsl:template match="//text//p//*">
        <milestone unit="{name()}" type="start"/>
        <xsl:apply-templates/>
        <milestone unit="{name()}" type="end"/>
    </xsl:template>
</xsl:stylesheet>
