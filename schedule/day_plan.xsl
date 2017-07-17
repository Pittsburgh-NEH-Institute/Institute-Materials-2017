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
            <xsl:value-of select="'# Week ' || @num || ' plan: ' || ./title"/>
           
            
            <xsl:text>&lt;table></xsl:text>
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
            
            
            <xsl:text>&lt;/table></xsl:text>
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
            <xsl:value-of select="'# Week ' || ../@num || ', Day ' || position() || ': ' || ./@d || ', ' || ./date"/>
            <xsl:apply-templates select="syn" mode="daily"/>

            <!-- Trying to get the coffee and lunch break tables to go away
                
                <xsl:if test="not(slot/act/desc = 'Coffee break')">-->
                <xsl:for-each select="slot">
                    <xsl:apply-templates select="."/>

                    <xsl:text>&lt;table></xsl:text>
                    <xsl:text>&lt;tr></xsl:text>
                    <xsl:text>&lt;th>Topic&lt;/th></xsl:text>
                    <xsl:text>&lt;th>Link&lt;/th></xsl:text>
                    <xsl:text>&lt;th>Time&lt;/th></xsl:text>
                    <xsl:text>&lt;th>Type&lt;/th></xsl:text>
                    <xsl:text>&lt;/tr></xsl:text>


                    <xsl:for-each select="act">
                        <xsl:text>&lt;tr></xsl:text>
                        <xsl:apply-templates select="desc" mode="daily"/>
                        <xsl:apply-templates select="link" mode="daily"/>
                        <xsl:apply-templates select="." mode="daily"/>
                        <xsl:text>&lt;/tr></xsl:text>

                    </xsl:for-each>
                    <xsl:text>&lt;/table>&#x0a;</xsl:text>

                </xsl:for-each>
            <!--</xsl:if>-->
        </xsl:result-document>
    </xsl:template>
    <xsl:template match="syn" mode="daily">
        <xsl:text>&#x0a;</xsl:text>
        <xsl:value-of select="normalize-space(.)"/>
        <xsl:text>&#x0a;</xsl:text>
    </xsl:template>
    <!-- creates and styles time headers -->
    <xsl:template match="slot" mode="daily">
        <xsl:if test="@time = '09:00:00'">
            <xsl:text>&#x0a;</xsl:text>
            <xsl:text>## 9:00-10:30: </xsl:text>
            <xsl:value-of select="./title"/>
            <xsl:text>&#x0a;</xsl:text>
        </xsl:if>
        <xsl:if test="@time = '10:30:00'">
            <xsl:text>&#x0a;</xsl:text>
            <xsl:text>## 10:30-11:00: Coffee break</xsl:text>
            <xsl:text>&#x0a;</xsl:text>
        </xsl:if>
        <xsl:if test="@time = '11:00:00'">
            <xsl:text>&#x0a;</xsl:text>
            <xsl:text>## 11:00-12:30: </xsl:text>
            <xsl:value-of select="./title"/>
            <xsl:text>&#x0a;</xsl:text>
        </xsl:if>
        <xsl:if test="@time = '12:30:00'">
            <xsl:text>&#x0a;</xsl:text>
            <xsl:text>## 12:30-2:00: Lunch</xsl:text>
            <xsl:text>&#x0a;</xsl:text>
        </xsl:if>
        <xsl:if test="@time = '14:00:00'">
            <xsl:text>&#x0a;</xsl:text>
            <xsl:text>## 2:00-3:30: </xsl:text>
            <xsl:value-of select="./title"/>
            <xsl:text>&#x0a;</xsl:text>
        </xsl:if>
        <xsl:if test="@time = '15:30:00'">
            <xsl:text>&#x0a;</xsl:text>
            <xsl:text>## 3:30-4:00: Coffee break</xsl:text>
            <xsl:text>&#x0a;</xsl:text>
        </xsl:if>
        <xsl:if test="@time = '16:00:00'">
            <xsl:text>&#x0a;</xsl:text>
            <xsl:text>## 4:00-5:30: </xsl:text>
            <xsl:value-of select="./title"/>
            <xsl:text>&#x0a;</xsl:text>
        </xsl:if>

    </xsl:template>

  <!-- creates the activity times in table  -->
    <xsl:template match="act" mode="daily">
        <xsl:text>&lt;td></xsl:text>
        <xsl:apply-templates select="@time"/>
        <xsl:text>&lt;/td></xsl:text>
        <xsl:text>&lt;td></xsl:text>
        <xsl:apply-templates select="@type"/>
        <xsl:text>&lt;/td></xsl:text>
    </xsl:template>
  <!-- creates the descriptions in table-->
    <xsl:template match="desc" mode="daily">
        <xsl:text>&lt;td></xsl:text>
        <xsl:apply-templates/>
        <xsl:text>&lt;/td></xsl:text>
    </xsl:template>
    <!-- creates links in table -->
    <xsl:template match="link" mode="daily">
        <xsl:text>&lt;td></xsl:text>
        <xsl:text>&lt;a href="</xsl:text>
        <xsl:apply-templates/>
        <xsl:text>"></xsl:text>
        <xsl:apply-templates/>
        <xsl:text>&lt;/a></xsl:text>
        <xsl:text>&lt;/td></xsl:text>
    </xsl:template>
  

</xsl:stylesheet>
