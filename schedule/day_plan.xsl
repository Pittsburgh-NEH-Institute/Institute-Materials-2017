<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:djb="http://www.obdurodon.org"
    xmlns:math="http://www.w3.org/2005/xpath-functions/math" exclude-result-prefixes="xs math"
    version="3.0">
    <xsl:output method="text" omit-xml-declaration="yes"/>

    <xsl:function name="djb:timeRange" as="xs:string">
        <xsl:param name="startTime" as="xs:time"/>
        <xsl:param name="duration" as="xs:double"/>
        <!--xs:time('09:00:00') + xs:duration(xs:dayTimeDuration('PT1H30M'))-->
        <xsl:variable name="end-time" as="xs:string"
            select="
                format-time($startTime + xs:duration(xs:dayTimeDuration(concat('PT', $duration, 'M'))), '[h]:[m01]')
                "/>
        <xsl:sequence select="format-time($startTime, '[h]:[m01]') || '–' || $end-time"/>
    </xsl:function>

    <xsl:template match="/">
        <xsl:apply-templates/>
        <xsl:apply-templates mode="daily"/>
    </xsl:template>

    <!-- Templates for weekly plans -->
    <xsl:template match="week">
        <xsl:variable name="filename" as="xs:string" select="'week_' || @num || '_plan.md'"/>
        <xsl:result-document method="text" omit-xml-declaration="yes" href="{$filename}">
            <xsl:value-of select="'# Week ' || @num || ' plan: ' || ./title"/>

            <!--<xsl:text>&lt;table></xsl:text>
            <xsl:text>&lt;tr></xsl:text>
            <xsl:text>&lt;th>Times&lt;/th></xsl:text>
            <xsl:text>&lt;th>Monday&lt;/th></xsl:text>
            <xsl:text>&lt;th>Tuesday&lt;/th></xsl:text>
            <xsl:text>&lt;th>Wednesday&lt;/th></xsl:text>
            <xsl:text>&lt;th>Thursday&lt;/th></xsl:text>
            <xsl:text>&lt;th>Friday&lt;/th></xsl:text>
            <xsl:text>&lt;/tr></xsl:text>

            <xsl:text>&lt;tr></xsl:text>
            <xsl:apply-templates select="./slot"/>
            <xsl:text>&lt;/tr></xsl:text>

            <xsl:text>&lt;/table></xsl:text>-->
        </xsl:result-document>
    </xsl:template>
    <xsl:template match="slot">
        <xsl:text>&lt;td></xsl:text>
        <xsl:apply-templates select="@time"/>
        <xsl:text>&lt;/td></xsl:text>
        <xsl:for-each select="//day">
            <xsl:text>&lt;td></xsl:text>
            <xsl:apply-templates select="/slot/title"/>
            <xsl:text>&lt;/td></xsl:text>
        </xsl:for-each>
    </xsl:template>

    <!-- Templates for daily plans -->
    <xsl:template match="week" mode="daily">
        <xsl:apply-templates mode="daily" select="day"/>
    </xsl:template>
    <xsl:template match="day" mode="daily">
        <xsl:variable name="filename" as="xs:string"
            select="'week_' || ../@num || '_day_' || position() || '_plan.md'"/>
        <xsl:result-document method="text" omit-xml-declaration="yes" href="{$filename}">
            <xsl:value-of
                select="'# Week ' || ../@num || ', Day ' || position() || ': ' || @d || ', ' || date || '&#x0a;'"/>
            
<!-- synopsis -->
            <xsl:text>&#x0a;## Synopsis&#x0a;</xsl:text>
            <xsl:apply-templates select="syn" mode="daily"/>
<!-- outcome goals -->            
            <xsl:text>## Outcome goals&#x0a;&#x0a;</xsl:text>
            <xsl:apply-templates select="./slot//outcome" mode="daily"/>

<!-- tables for slots -->
            <xsl:apply-templates select="slot" mode="daily"/>
            
        </xsl:result-document>
    </xsl:template>
    <xsl:template match="syn" mode="daily">
        <xsl:text>&#x0a;</xsl:text>
        <xsl:value-of select="normalize-space(.)"/>
        <xsl:text>&#x0a;&#x0a;</xsl:text>
    </xsl:template>
    <!-- creates and styles time headers -->
    <xsl:template match="slot" mode="daily">
        <xsl:value-of
            select="'## ' || djb:timeRange(@time, sum(act/@time)) || ': ' || title || '&#x0a;&#x0a;'"/>
        <xsl:if test="desc">
            <xsl:value-of select="normalize-space(desc) || '&#x0a;&#x0a;'"/>
        </xsl:if>
        <xsl:if test="not(title = ('Coffee break', 'Lunch'))">
            <xsl:text>Time | Topic | Type&#x0a;</xsl:text>
            <xsl:text>---- | ---- | ---- &#x0a;</xsl:text>
            <xsl:apply-templates select="act" mode="daily"/>
            <xsl:text>&#x0a;</xsl:text>
        </xsl:if>
    </xsl:template>

    <!-- creates the activity times in table  -->
    <xsl:template match="act" mode="daily">
        <xsl:value-of select="@time || ' min | ' || normalize-space(desc) || ' | ' || translate(@type,'_',' ') || '&#x0a;'"/>
    </xsl:template>
    <!-- creates the descriptions in table-->
    <xsl:template match="desc" mode="daily">
        <xsl:text>&lt;td></xsl:text>
        <xsl:apply-templates/>
        <xsl:text>&lt;/td></xsl:text>
    </xsl:template>
    <!-- creates list of goals -->
    <xsl:template match="outcome" mode="daily">
        <xsl:if test="goal">
        <xsl:text>* </xsl:text><xsl:apply-templates select="normalize-space(.)"/><xsl:text>&#x0a;&#x0a;</xsl:text>
        </xsl:if>
    </xsl:template>


</xsl:stylesheet>
