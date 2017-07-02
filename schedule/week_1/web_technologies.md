# Web technologies

## The web “stack”

* HTML: HyperText Markup Language. Tags for web documents. Use [HTML5](https://www.w3.org/TR/html5/); supports XML and non-XML syntax
* CSS: Cascading Style Sheets. Use [CSS Snapshot 2017
W3C Working Group Note, 31 January 2017](https://www.w3.org/TR/CSS/)
* JavaScript
* PHP: PHP: Hypertext Preprocessor (recursive acronym). Use whatever version is supported on your server.

## About HTML
HTML is a tag set controlled by a schema (rules for which tags are permitted in which contexts). All content that will appear in the web page goes inside the `<body>` element. A typical page has some of the following components:

* Headers (`<h1>` through `<h6>`)
* Paragraphs (`<p>`)
* Lists (`<ul>` for bulleted lists, `<ol>` for numbered list). The only children allowed for these list are `<li>` (list item).
* Tables. Not covered in this exercise.

## Looking at HTML

1. Start \<oXygen/\>.
2. Open [schedule/week_1/web/html_exercise.html](web/html_exercise.html) in \<oXygen/\>
3. Start a web browser.
4. Open the same file in your browser (`Ctrl+o` [Windows] or `Cmd+o` [Mac OS] to open a file from the filesystem).

## Working with HTML

* Modify the text in \<oXygen/\>. If you see a green square in the upper right corner of the editor windows, your HTML is valid. If not, it isn’t, and you need to fix it. For example, a `<p>` cannot contain another `<p>`.
* When you have a green square, save your document and then reload it into the browser, observing the changes. 

## Styling HTML with CSS

* CSS is typically defined in a separate file, which is associated with the HTML through a `<link>` element in the `<head>` of the HTML file. Storing the CSS outside the HTML page makes it easy to apply the same CSS to multiple files to achieve a consistent appearance.
* CSS instructions consist of a *selector* followed by a set of rules enclosed in curly braces. Each rule has a *property* and a *value*, separated by a colon, and multiple rules are separated by semicolons. For example, `p {color: red; font-weight: bold;}` colors and embolds all `<p>` elements in the document. Selectors can be fine-tuned to target elements only in specific contexts or with specific attributes.

## Working with CSS

1. Open []() in \<oXygen/\>.

## Tutorials and reference

* Mozilla Developer Network [HTML](https://developer.mozilla.org/en-US/docs/Web/HTML)
* Mozilla Developer Network [CSS](https://developer.mozilla.org/en-US/docs/Web/CSS)
* Mozilla Developer Network [JavaScript](https://developer.mozilla.org/en-US/docs/Web/JavaScript)