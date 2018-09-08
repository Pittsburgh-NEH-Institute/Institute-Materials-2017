# Serving TEI in the browser with just Javascript, CSS, and XML

## Instructions

1. Find the pitt-ceteicean folder in week_3.
1. Open a terminal window.
1. Change directories into the pitt-ceteicean folder
1. Run `python -m "http.server"`
1. In Chrome, open `http://localhost:8000`

Take a look at some of the examples linked on that page. CETEIcean works by loading up a TEI source file (which can be on another server if that server supports [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS)) and turning it into [HTML Customm Elements](https://developer.mozilla.org/en-US/docs/Web/Web_Components/Using_custom_elements). For example, a TEI `<p>` tag ends up as `<tei-p>` in the page. While it does this, it can apply "behaviors" to the elements which customize their look-and-feel and functionality. Plain old CSS can be used to style the elements as well.

## Exercise 1: CSS

1. In your pitt-ceteicean folder, you have a copy of the XML behind the Duke
Databank of Documentary Papyri's TEI source for <http://papyri.info/ddbdp/p.fay;;110#edition>,
plus an HTML wrapper for it.
2. Look at the source files: `p.fay.110.html` and `css/pitt.css`.
3. Our first goal is to try to make our copy look as much as we can like the original, using just CSS.

You can check your work against the file p.fay.110-1.html and the CSS css/pitt-1.css. You can add, for example, brackets around a `<supplied reason="lost">` element using CSS like
```css
tei-supplied[reason=lost]:before {
  content: '[';
}
tei-supplied[reason=lost]:after {
  content: ']';
}
```
but if you look at the resulting page, you'll notce that if you try to copy and paste text including those brackets, the browser won't let you select and copy the brackets themselves. 

You'll notice that while some things are relatively easy using just CSS, others are impossible. You'll notice, fox example, that if you look at word-breaking `<lb/>` tags, they occur on a new line, just like regular `<lb/>`s. So when rendered, they look like
```
  ...ἐλαι -
οὐργίου
```
with a space before the hyphen. This might be a bad decision by the encoder, but nonetheless, if we want to display a line-broken word with a hyphen in the proper place, like
```
  ...ἐλαι-
οὐργίου
```
then we'll have to somehow remove the whitespace between the first part of the word and the `<lb/> `. CSS can't do that. We have to use JavaScript, which can manipulate the DOM (Document Object Model), the data structure representing the document in the browser's memory. 

## Exercise 2: Javascript

* Javascript is just another programming language.
* Runs in pretty much any browser

### Syntax differences from python

* You'll recognize a lot of things:
  * functions look like `fname()`
  * there are objects, whose members you can access with the dot operator: `document.characterSet`
* Things that are different:
  * whitespace doesn't matter as much
  * end your lines with `;`
  * variables should be declared with `var`
  * function bodies get wrapped in curly braces: `{...}`
  * Javascript is **way** more anarchic than Python.

Let's try some! You're going to add a behaviors object to p.fay.110.html that will do some of the things we can't with CSS. For starters, call the `addBehaviors()` method on the CETEIcean object create on line 8:
```js
let c = new CETEI(); //line 8 creates the CETEI object and assigns it to the variable c
c.addBehaviors({
    "tei": {
        // New behaviors will go here.
    }
});
```
So, for example, we want to wrap the content of `<supplied reason="lost">` in square brackets, and the contents of `<supplied reason="omitted">` in angle brackets. Behaviors let us do that like this:
```js
c.addBehaviors({
    "tei": {
        "supplied": [
            ["[reason=lost]", ["[","]"]],
            ["[reason=omitted]", ["&lt;","&gt;"]]
        ]
    }
});
```
This behavior will run on every `<supplied>` element, and for ones that match `@reason='lost'` (note that this is CSS selector syntax, not XPath), they will wrap the content in square brackets. `@reason="omitted"` gets you angle brackets.

Behaviors can look simpler too. For example, the built in behavior for TEI example (`<eg>`) tags is to wrap their content in HTML `<pre>` tags. That behavior is just `"eg": ["<pre>","</pre>"]` because there are no special cases for `<eg>`. They can also take functions instead of arrays, something like: 
```js
"eg": function(elt) {
    // Code to wrap the element content in <pre> tags
}
```

The file p.fay.110-2.html provides you with a relatively complete solution using CETEIcean plus some extra JavaScript and is full of (hopefully helpful) comments.

## Exercise 3: Publish your work on GitHub Pages

1. Copy the pitt-ceteicean folder to a new directory, outside the current Git repo.
1. `cd` into it and run `git init`. Commit your work.
1. Go to GitHub and create a new repository (name it pitt-ceteicean if you want). You should see a page telling you how to add the GitHub repo as a remote of the repo you just set up on your local machine.
1. Go back to your terminal and enter the commands to "push an existing repository from the command line" from inside your local repo.
1. Go to https://`<your repo>`/settings (the "Settings" tab on your repo's front page).
1. Scroll down to right above the "Danger Zone", the "GitHub Pages" section, and under "Source", choose "master branch"
1. Your repo's contents should be available under https://`<your repo>`.github.io.
1. If you do some more work and commit and push it, it should (shortly, not instantaneously) show up there automatically.
