<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xpath-default-namespace="http://www.tei-c.org/ns/1.0"
    xmlns:math="http://www.w3.org/2005/xpath-functions/math" exclude-result-prefixes="xs math"
    version="3.0" xmlns="http://www.tei-c.org/ns/1.0">
    <xsl:strip-space elements="*"/>
    <!-- driver -->
    <xsl:template match="/">
        <xsl:variable name="no_del">
            <xsl:apply-templates mode="no_del"/>
        </xsl:variable>
        <xsl:apply-templates select="$no_del" mode="main"/>
    </xsl:template>
    <!-- no_del mode
        suppress <del> in favor of <add> if both are present
        assumes that they will follow each other without interruption
    -->
    <xsl:template match="node() | @*" mode="no_del">
        <xsl:copy>
            <xsl:apply-templates select="node() | @*" mode="no_del"/>
        </xsl:copy>
    </xsl:template>
    <xsl:template
        match="del[following-sibling::node()[1][self::add] or preceding-sibling::node()[1][self::add]]"
        mode="no_del"/>
    <!-- main mode
        this may insert consecutive <wb> elements, which we clean up in the next step
    -->
    <xsl:template match="*" mode="main">
        <xsl:copy>
            <xsl:apply-templates select="node() | @*" mode="main"/>
        </xsl:copy>
    </xsl:template>
    <xsl:template match="text//p" mode="main">
        <p>
            <xsl:apply-templates mode="main"/>
        </p>
    </xsl:template>
    <xsl:template match="text//p//*" mode="main">
        <milestone unit="{name()}" type="start">
            <xsl:copy-of select="@*"/>
        </milestone>
        <xsl:apply-templates mode="main"/>
        <milestone unit="{name()}" type="end">
            <xsl:copy-of select="@*"/>
        </milestone>
    </xsl:template>
    <xsl:template match="text//p//text()" mode="main">
        <xsl:variable name="text_node" select="."/>
        <xsl:variable name="tokens" select="tokenize($text_node)"/>
        <xsl:for-each select="$tokens">
            <xsl:value-of select="."/>
            <xsl:if test="">
                <milestone unit="wb"/>
            </xsl:if>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
