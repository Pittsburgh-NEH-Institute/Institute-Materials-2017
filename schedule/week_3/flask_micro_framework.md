# Introduction to Flask
Flask [http://flask.pocoo.org/](http://flask.pocoo.org/) is a microframework for Python. There are _no batteries included_, but it has a bunch of available plugins you can use, e.g.[Flask plugins](http://flask.pocoo.org/extensions/) By using this microframwork you will be able to get close to all individual parts in the publication process and glue it all together.

## Flask installation
It is a really simple installation. All you have to do if it is not already installed is to run:
```bash
 $ pip install flask
```
To test that it works you can run the follwing code [Available in the repo as flask-index.py](flask-index.py) in your terminal commandline:
```python
from flask import Flask
app = Flask(__name__)
@app.route("/")
def get_my_index():
    return "This is index for / (ROOT) in flask-index.py"
if __name__ == '__main__':
    app.run(port=5000, debug=True)
```
When running this Flask app from the commandline it will output something like this: 
```bash
 $ python flask-index.py 
 * Running on http://127.0.0.1:5000/ (Press CTRL+C to quit)
 * Restarting with stat
 * Debugger is active!
 * Debugger pin code: nnn-nnn-nnn
```

And when accessing you app through the url specified <http://localhost:5000/> it will continue to output the access information:

```
127.0.0.1 - - [23/Jul/2017 19:02:15] "GET / HTTP/1.1" 200 -
127.0.0.1 - - [23/Jul/2017 19:02:16] "GET /favicon.ico HTTP/1.1" 404 -
127.0.0.1 - - [23/Jul/2017 19:02:17] "GET /favicon.ico HTTP/1.1" 404 -
```

So with this small amount of code you have actually brought up a simple web server eventhough only answering your request for `/`.

