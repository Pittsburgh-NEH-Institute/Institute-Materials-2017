<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:djb="http://www.obdurodon.org"
    xmlns:math="http://www.w3.org/2005/xpath-functions/math" exclude-result-prefixes="xs math"
    version="3.0">
    <xsl:output method="text" omit-xml-declaration="yes"/>

    <xsl:function name="djb:timeRange" as="xs:string">
        <!--
            Parameters: $startTime as xs:time, $duration as xs:double
            Returns: hyphenated time range as xs:string
        -->
        <xsl:param name="startTime" as="xs:time"/>
        <xsl:param name="duration" as="xs:double"/>
        <xsl:variable name="end-time" as="xs:string"
            select="
                format-time($startTime + xs:duration(xs:dayTimeDuration(concat('PT', $duration, 'M'))), '[h]:[m01]')
                "/>
        <xsl:sequence select="format-time($startTime, '[h]:[m01]') || '–' || $end-time"/>
    </xsl:function>

    <xsl:template match="/">
        <!-- Create weekly and then daily schedules -->
        <xsl:apply-templates select="//week"/>
        <xsl:apply-templates select="//week" mode="daily"/>
    </xsl:template>

    <!-- Templates for weekly plans -->
    <xsl:template match="week">
        <xsl:variable name="filename" as="xs:string" select="'week_' || @num || '_plan.md'"/>
        <xsl:result-document method="text" omit-xml-declaration="yes" href="{$filename}">
            <xsl:value-of select="'# Week ' || @num || ' plan: ' || ./title || '&#x0a;' || '&#x0a;'"/>
            <xsl:text>Time | </xsl:text>
            <xsl:apply-templates select="day"/>
            <xsl:text>&#x0a;----</xsl:text>
            <xsl:for-each select="day">
                <xsl:text> | ----</xsl:text>
            </xsl:for-each>
            <xsl:text>&#x0a;</xsl:text>
            <xsl:apply-templates select="day[1]/slot"/>
        </xsl:result-document>
    </xsl:template>
    <xsl:template match="day">
        <xsl:variable name="linkname" as="xs:string"
            select="'week_' || ../@num || '_day_' || position() || '_plan.md'"/>
        <xsl:variable name="daynames" as="xs:string"
            select="normalize-space(concat(' [', @d, '](', $linkname, ')', ' | '))"/>
        <xsl:value-of select="$daynames"/>
    </xsl:template>
    <xsl:template match="slot">
        <xsl:variable name="slotContents" as="xs:string"
            select="normalize-space(string-join(//slot[@time eq current()/@time and ancestor::week/@num eq current()/ancestor::week/@num]/title, ' | '))"/>
        <xsl:value-of select="djb:timeRange(@time, sum(act/@time)) || ' |', $slotContents, '&#x0a;'"
        />
    </xsl:template>

    <!-- Templates for daily plans -->
    <xsl:template match="week" mode="daily">
        <xsl:apply-templates mode="daily" select="day"/>
    </xsl:template>
    <xsl:template match="day" mode="daily">
        <xsl:variable name="filename" as="xs:string"
            select="'week_' || ../@num || '_day_' || position() || '_plan.md'"/>
        <xsl:variable name="feedbackname" as="xs:string"
            select="'week_' || ../@num || '_day_' || position() || '_feedback.md'"/>
        <xsl:result-document method="text" omit-xml-declaration="yes" href="{$filename}">
            <xsl:value-of
                select="'# Week ' || ../@num || ', Day ' || position() || ': ' || @d || ', ' || date || '&#x0a;'"/>

            <!-- synopsis -->
            <xsl:text>## Synopsis&#x0a;</xsl:text>
            <xsl:apply-templates select="syn" mode="daily"/>
            <!-- outcome goals -->
            <xsl:text>## Outcome goals&#x0a;</xsl:text>
            <xsl:apply-templates select="./slot//outcome" mode="daily"/>
            <!-- legend -->
            <xsl:text>## Legend

* **Presentation:** by instructors
* **Discussion:** instructors and participants
* **Talk lab:** participants discuss or plan in small groups
* **Code lab:** participants code alone or in small groups&#x0a;&#x0a;* * *&#x0a;</xsl:text>

            <!-- tables for slots -->
            <xsl:apply-templates select="slot" mode="daily"/>
            <!-- feedback -->
            <xsl:text>We’ll end each day with a request for feedback, based on a general version of the day’s outcome goals, and we’ll try to adapt on the fly to your responses. Please complete [</xsl:text>
            <xsl:value-of select="'Week ' || ../@num || ', Day ' || position()"/>
            <xsl:text> feedback](</xsl:text>
            <xsl:value-of select="$feedbackname"/>
            <xsl:text>) (just copy and paste it into a plain-text document) and email your response to Kaylen at [kaylensanders@pitt.edu](mailto:kaylensanders@pitt.edu) with the subject heading “</xsl:text>
            <xsl:value-of select="'Week ' || ../@num || ', Day ' || position()"/>
            <xsl:text> feedback”.</xsl:text>

        </xsl:result-document>
    </xsl:template>
    <xsl:template match="syn" mode="daily">
        <xsl:text>&#x0a;</xsl:text>
        <xsl:value-of select="normalize-space(.)"/>
        <xsl:text>&#x0a;&#x0a;</xsl:text>
    </xsl:template>
    <!-- create and styles time headers -->
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
    <!-- create the activity times in table  -->
    <xsl:template match="act" mode="daily">
        <xsl:value-of
            select="@time || ' min | ' || normalize-space(desc) || ' | ' || translate(@type, '_', ' ') || '&#x0a;'"
        />
    </xsl:template>
    <!-- create list of goals -->
    <xsl:template match="outcome" mode="daily">
        <xsl:if test="goal">
            <xsl:text>* </xsl:text>
            <xsl:apply-templates select="normalize-space(.)"/>
            <xsl:text>&#x0a;</xsl:text>
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>
