<?xml version="1.0" encoding="UTF-8"?>
<sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2"
    xmlns:sqf="http://www.schematron-quickfix.com/validator/process"
    xmlns="http://purl.oclc.org/dsdl/schematron">
    <pattern>
        <rule context="slot">
            <let name="actual_time" value="sum(act/@time/number())"/>
            <!-- warning, rather than error, because extra sessions (e.g., add-on evening ones) might have different durations -->
            <assert test="$actual_time eq 30 or $actual_time eq 90" role="warn"> The sum of the
                activity durations must be equal either 30 or 90 minutes. Actual time is <value-of
                    select="$actual_time"/>.</assert>
        </rule>
        <rule context="act[not(preceding-sibling::title = ('Coffee break', 'Lunch'))]">
            <assert test="@type">Activities must have a @type attribute.</assert>
        </rule>
    </pattern>
</sch:schema>
