<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xpath-default-namespace="http://www.tei-c.org/ns/1.0" xmlns="http://www.tei-c.org/ns/1.0"
    xmlns:math="http://www.w3.org/2005/xpath-functions/math" exclude-result-prefixes="xs math"
    version="3.0">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="node() | @*">
        <xsl:copy>
            <xsl:apply-templates select="node() | @*"/>
        </xsl:copy>
    </xsl:template>
    <xsl:template match="//text//p">
        <p>
            <xsl:for-each-group select="node()" group-starting-with="milestone[@unit eq 'wb']">
                <w>
                    <xsl:copy-of select="current-group()[not(self::milestone[@unit eq 'wb'])]"/>
                </w>
            </xsl:for-each-group>
        </p>
    </xsl:template>
</xsl:stylesheet>
