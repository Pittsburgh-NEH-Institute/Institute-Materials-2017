# XSLT

To start with, some setup. In a terminal:

1. In the same folder where you cloned your Institute repo, do `git clone https://github.com/TEIC/Stylesheets.git`
2. Get the path for that folder and copy it.
3. Run `docker run --name pitt -v <INSERT THE PATH YOU COPIED>:/pitt -it teic/teidev-docker`. Note that files in mounted directories may cause problems on Windows due to the different line-endings problem.

For a full set of documentation on building and testing the TEI Guidelines and Stylesheets, see <http://teic.github.io/TCW/testing_and_building.html>.

The TEI Stylesheets will do a lot of things for you, but they are not (nor could they ever be) comprehensive. You will probably have to customize them to do what you want. The Stylesheets repository (https://github.com/TEIC/Stylesheets) contains roughly one folder for each kind of transformation it deals with. Configurable parameters may be found in the `NAME_param.xsl` file, if there is one. Some directories contain code which depends on the code in other directories. The `html5` transform relies upon the `html` one, for example, as does `epub`. The `common` directory contains code used by several of the transforms. Some transforms are not simple XSLT conversions. They may rely on other software. The `pdf` conversion first transforms the input file to LaTeX, for example, and then uses XeLaTeX to convert that to PDF.

The `bin` directory contains a set of command-line scripts to run various kinds of conversions. For example, you can run something like

```
bin/teitorelaxng --odd ../TEI/P5/Exemplars/tei_all.odd tei_all.rng
```
to convert the TEI All ODD to a Relax NG schema. And you could use the same tool to build schemas from your own ODDs. This is using the same method as the TEI OxGarage tool uses, just from the command line, on your own machine instead of a server.

The TEI Stylesheets are written in version 2.0 of the XSLT language. Version 3.0 became a W3C Recommendation on June 8, 2017, so eventually, they will probably be ported to XSLT 3.0. The situation with XSLT and XSLT processing is complicated. Version 1.0 became a recommendation in 1999, and there were many implementations of it, the most popular of which was libxslt, which was written in the C language and is the basis for the XSLT support in Python, Ruby, JavaScript and many other scripting languages. The only Open Source implementation of XSLT 2.0 and 3.0 is Saxon HE (Home Edition), which uses Java or .NET. Saxon also comes in more advanced proprietary versions. The upshot of all this is that you can't do XSLT 2.0 in Python or Ruby unless you want to use the Java Virtual Machine (JVM) versions of the language (not what we're using here). So you can't use the TEI Stylesheets directly using Python, though you can call them on the command line or use a JVM-based Python (which substantially lags the usual verson—there's always a downside).
