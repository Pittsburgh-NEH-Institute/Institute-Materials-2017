<?xml version="1.0" encoding="UTF-8"?>
<sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2"
    xmlns:sqf="http://www.schematron-quickfix.com/validator/process"
    xmlns="http://purl.oclc.org/dsdl/schematron">
    <pattern>
        <rule context="slot">
            <assert test="sum(act/@time/number()) eq 30 or sum(act/@time/number()) eq 90"> The sum
                of the activity durations must be equal to either 30 or 90 minutes.
            </assert>
        </rule>
    </pattern>
</sch:schema>
