#!/usr/bin/env bash

# Adds word tagging to TEI XML, flattening markup under text//p

for file in witnesses/*
do
    echo "Flattening $(basename ${file%.xml})"
    java -jar saxon/saxon9he.jar -s:${file} -xsl:flatten.xsl -o:flattened/$(basename ${file})
    echo "Adding wb milestones to $(basename ${file%.xml})"
    java -jar saxon/saxon9he.jar -s:flattened/$(basename ${file}) -xsl:add-wb.xsl -o:with-wb/$(basename ${file})
    echo "Word-tagging $(basename ${file%.xml})"
    java -jar saxon/saxon9he.jar -s:with-wb/$(basename ${file}) -xsl:wrap_words.xsl -o:word_tagged/$(basename ${file})
done
python xml_and_python.py
echo "Done!"
