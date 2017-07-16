<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:math="http://www.w3.org/2005/xpath-functions/math" exclude-result-prefixes="xs math"
    version="3.0">
    <xsl:output method="text" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <xsl:apply-templates/>
        <xsl:apply-templates mode="daily"/>
    </xsl:template>
    <!-- Templates for weekly plans -->
    <xsl:template match="week">
        <xsl:variable name="filename" as="xs:string" select="'week_' || @num || '_plan.md'"/>
        <xsl:result-document method="text" omit-xml-declaration="yes" href="{$filename}">
            <xsl:value-of select="'# Week ' || @num || ' plan'"/>
        </xsl:result-document>
    </xsl:template>
    <!-- Templates for daily plans -->
    <xsl:template match="week" mode="daily">
        <xsl:apply-templates mode="daily" select="day"/>
    </xsl:template>
    <xsl:template match="day" mode="daily">
        <xsl:variable name="filename" as="xs:string"
            select="'week_' || ../@num || '_day_' || position() || '_plan.md'"/>
        <xsl:result-document method="text" omit-xml-declaration="yes" href="{$filename}">
            <xsl:value-of select="'# Week ' || ../@num || ', Day ' || position() || ','"/>
            <xsl:apply-templates select="syn" mode="daily"/>

            <xsl:for-each select="slot">
                <xsl:text>
                    &lt;table>&lt;th>Time&lt;/th>&lt;th>Topic&lt;/th>&lt;th>Link&lt;/th>
                </xsl:text>
                <xsl:for-each select="act">
                    <xsl:text>&lt;tr>&lt;td></xsl:text><xsl:value-of select="@time"/><xsl:text>&lt;/td>&lt;/tr></xsl:text>
                    <xsl:text>&lt;tr>&lt;td></xsl:text><xsl:value-of select="desc"/><xsl:text>&lt;/td>&lt;/tr></xsl:text>
                    <xsl:text>&lt;tr>&lt;td></xsl:text><xsl:apply-templates select="link"/><xsl:text>&lt;/td>&lt;/tr></xsl:text>
                </xsl:for-each>
            </xsl:for-each>

        </xsl:result-document>
    </xsl:template>
    <xsl:template match="syn" mode="daily">
        <xsl:text>&#x0a;</xsl:text>
        <xsl:value-of select="normalize-space(.)"/>
    </xsl:template>
    <xsl:template match="/slot/act/link" mode="daily">
       <xsl:text>&lt;</xsl:text><xsl:apply-templates/><xsl:text>></xsl:text> 
    </xsl:template>
        

</xsl:stylesheet>
