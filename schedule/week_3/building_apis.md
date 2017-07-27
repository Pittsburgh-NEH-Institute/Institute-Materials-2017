# Building your APIs
In this session we are focusing on building your API, i.e. the interface to your functionality programatically fulfilling your use cases. This build on the modeling you did in the previous session [Using APIs in your edition](using_apis_edition.md). It also gives you more some more fluency working with Flask [Flask intro](flask_micro_framework.md)


## More on templates
As in the Flask intro we use the Jinja templating engine available in Python. Remember the convention to put the templates in a subdirectory called `templates`.
You need to include it in your python header:
```python
from flask import render_template
```

We added a few more templates and resources in the [templates directory](templates/)

One is the base template [template.html](templates/template.html) with the following contents:

```html
<?xml version="1.0" encoding="utf-8"?>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    {% block head %}
    <link rel="stylesheet" href="style.css" />
    <title>{% block title %}{% endblock %} - Base template page</title>
    {% endblock %}
  </head>
  <body>
    <div class="container">
      {% block content %}
      {% endblock %}
    </div>
    <div id="footer">
      {% block footer %}
      &copy; Copyright 2017 by <a href="http://makeyouredition.net/">Make your edition</a>.
      {% endblock %}
    </div>
  </body>
</html>
```

We see three template blocks `{% block head %}` `{% block content %}` `{% block footer %}`.

In the second new template [resource.html](templates/resource.html) we put some minor logic for including _resources_ into the template: 

```html
?xml version="1.0" encoding="utf-8"?&gt;
{% extends 'template.html' %}
{% block content %}
    {% if resource_name == 'resource1' %}
        {% include 'resource1.html' %}
    {% endif %}
    {% if resource_name == 'missing1' %}
        {% include 'missing1.html' ignore missing %}
    {% endif %}
    {% if resource_name == 'xhtml2' %}
        {% include ['xhtml.html', 'resource2.xhtml'] %}
	{# Includes the first existing template, e.g. resource2.xhtml #}
    {% endif %}
    {% if resource_name == 'form1' %}
        {% include 'form1.html' %}
    {% endif %}
{% endblock %}
```

It also uses directive `{% extends 'template.html' %}` to connect the block `{% block content %}` to the one in _template.html_.

Some of the files are also included. (Not the missing one though :)). In that case we use additional directive to the include `{% include 'missing1.html' ignore missing %}` otherwise the request would fail.

To continue on the example from Flask intro the new templates could be used like this:

```python
from flask import Flask
from flask import render_template
from flask import request

defaults = { 'title': 'dynamic request header index.html' ,
             'header': 'Default "header" is used. Give request parameter header with a value to change it.',
             'paragraph': 'This is index.html with dynamic contents in response to a request for / (ROOT) in flask-request.py'
}

app = Flask(__name__)
@app.route("/")
def get_my_index():
    header = get_request_value_with_fallback('header')
    values = {
        'title': defaults['title'],
        'header': header,
        'paragraph': defaults['paragraph'] 
    }
    return render_template("index-dyn-dict.html", dict=values)

@app.route("/resource/<resource_name>")
def get_local_resource(resource_name = ''):
    return render_template("resource.html", resource_name=resource_name)

@app.route("/resource/<resource_name>/value/<value>")
def get_local_resource_with_value(resource_name = '', value = ''):
    return render_template("resource.html", resource_name=resource_name, value=value)

@app.route("/neh-artifact/<idnbr>")
def get_neh_artifact(idnbr = ''):
    #return render_template("resource.html", resource_name=idnbr)
    primary_accept = get_list_comma_header(get_request_header('Accept', ''))[0]
    if (primary_accept == "text/html"):
        return ("Request for artifact: " + idnbr + " You primarily want: " + primary_accept + " " + " but not available yet.", 404)
    return ("Request for artifact: " + idnbr + " You primarily want: " + primary_accept) 

def get_list_comma_header(header_value):
    return [x.strip() for x in header_value.split(',')]

def get_request_header(header, default):
    # Accept:text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
    return request.headers.get(header, default)

def get_request_value_with_fallback(key):
    if request.args.get(key):
        return request.args.get(key)
    return defaults[key]

if __name__ == '__main__':
    app.run(port=5000, debug=True)
``` 

See [flask-request-get-resource.py](flask-request-get-resource.py).

We added a couple of new decorators `@app.route("/resource/<resource_name>")`, `@app.route("/resource/<resource_name>/value/<value>")`. Like we saw in the previous session. `<resource_name>` and `<name>` are variables in the decorator that will be passed to the function it decorates.

If you run `python flask-request-get-resource.py` it would not only respond to requests on `/` but also the RESTful request URL we used in in the previous session:

* <http://localhost:5000/resource/form1/value/ljo>
and a few more: 
* <http://localhost:5000/resource/resource1>
* <http://localhost:5000/resource/xhtml2>
* <http://localhost:5000/resource/missing1>

It is not good to use too much logic in the templates but it will get you going getting some resources until you have implemented some logic to include other resources.

Exercise: If you want to use any of the other HTTP methods how would you specify it?

Exercise: Implement one of your API methods, use a string value to return firstly.

Exercise: Implement more of your API methods, return the varible parameters to start with.

 
Exercise: Implement one of your API methods to include an external API call like in [error-handling-url-not-found.py](error-handling-url-not-found.py). Either returning json or some other format. Hint you did some in the github API exercise.
