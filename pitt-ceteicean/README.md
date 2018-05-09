# Serving TEI in the browser with just Javascript, CSS, and XML

## Instructions

1. Fork this repo to your account
1. Open a terminal window
1. Clone your copy of the repo to your desktop.
1. Change directories into the pitt-ceteicean folder
1. Run `python -m "http.server"`
1. In Chrome, open `http://localhost:8000`

## Exercise 1: CSS

1. In your pitt-ceteicean folder, you have a copy of the XML behind the Duke
Databank of Documentary Papyri's TEI source for <http://papyri.info/ddbdp/p.fay;;110#edition>,
plus an HTML wrapper for it.
2. Look at the source files: `p.fay.110.html` and `css/pitt.css`.
3. Our first goal is to make our copy look as much like the original, using just CSS.

## Javascript

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

Let's try some!

Exercise 2: Publish your work on GitHub Pages

1. Commit and push your work back to your fork.
1. Go to https://`<your repo>`/settings (the "Settings" tab on your repo's front page).
1. Scroll down to right above the "Danger Zone", the "GitHub Pages" section, and under "Source", choose "master branch"
1. Your repo's contents should be available under https://`<your repo>`.github.io.
1. If you do some more work and commit and push it, it should (shortly, not instantaneously) show up there automatically.
