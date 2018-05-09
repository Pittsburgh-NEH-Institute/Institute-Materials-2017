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

<pre class="xml">
&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;html xmlns="http://www.w3.org/1999/xhtml"&gt;
  &lt;head&gt;
    &#123;% block head %&#125;
    &lt;link rel="stylesheet" href="style.css" /&gt;
    &lt;title&gt;&#123;% block title %&#125;&#123;% endblock %&#125; - Base template page&lt;/title&gt;
    &#123;% endblock %&#125;
  &lt;/head&gt;
  &lt;body&gt;
    &lt;div class="container"&gt;
      &123;% block content %&#125;
      &123;% endblock %&#125;
    &lt;/div&gt;
    &lt;div id="footer"&gt;
      &123;% block footer %&#125;
      &copy; Copyright 2017 by &lt;a href="http://makeyouredition.net/"&gt;Make your edition&lt;/a&gt;.
      &123;% endblock %&#125;
    &lt;/div&gt;
  &lt;/body&gt;
&lt;/html&gt;
</pre>


We see three template blocks <code>&#123;% block head %&#125;</code> <code>&#123;% block content %&#125;</code> <code>&#123;% block footer %&#125;</code>.

In the second new template [resource.html](templates/resource.html) we put some minor logic for including _resources_ into the template: 

<pre class="xml">
&lt;?xml version="1.0" encoding="utf-8"?&gt;
&#123;% extends 'template.html' %&#125;
&#123;% block content %&#125;
    &#123;% if resource_name == 'resource_1' %&#125;
        &#123;% include 'resource_1.html' %&#125;
    &#123;% endif %&#125;
    &#123;% if resource_name == 'missing1' %&#125;
        &#123;% include 'missing1.html' ignore missing %&#125;
    &#123;% endif %&#125;
    &#123;% if resource_name == 'xhtml2' %&#125;
        &#123;% include ['xhtml.html', 'resource_2.xhtml'] %&#125;
	&#123;# Includes the first existing template, e.g. resource_2.xhtml #&#125;
    &#123;% endif %&#125;
    &#123;% if resource_name == 'form_1' %&#125;
        &#123;% include 'form_1.html' %&#125;
    &#123;% endif %&#125;
&#123;% endblock %&#125;
</pre>

It also uses directive <code>&#123;% extends 'template.html' %&#125;</code> to connect the block <code>&#123;% block content %&#125;</code> to the one in _template.html_.

Some of the files are also included. (Not the missing one though :)). In that case we use additional directive to the include <code>&#123;% include 'missing1.html' ignore missing %&#125;</code> otherwise the request would fail.

To continue on the example from Flask intro the new templates could be used like this:

<pre class="python">
from flask import Flask
from flask import render_template
from flask import request

defaults = &#123; 'title': 'dynamic request header index.html' ,
             'header': 'Default "header" is used. Give request parameter header with a value to change it.',
             'paragraph': 'This is index.html with dynamic contents in response to a request for / (ROOT) in flask_request.py'
&#125;

app = Flask(__name__)
@app.route("/")
def get_my_index():
    header = get_request_value_with_fallback('header')
    values = &#123;
        'title': defaults['title'],
        'header': header,
        'paragraph': defaults['paragraph'] 
    &#125;
    return render_template("index_dyn_dict.html", dict=values)

@app.route("/resource/&lt;resource_name&gt;")
def get_local_resource(resource_name = ''):
    return render_template("resource.html", resource_name=resource_name)

@app.route("/resource/&lt;resource_name&gt;/value/&lt;value&gt;")
def get_local_resource_with_value(resource_name = '', value = ''):
    return render_template("resource.html", resource_name=resource_name, value=value)

@app.route("/neh-artifact/&lt;idnbr&gt;")
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
</pre>

See [flask_request_get_resource.py](flask_request_get_resource.py).

We added a couple of new decorators `@app.route("/resource/<resource_name>")`, `@app.route("/resource/<resource_name>/value/<value>")`. Like we saw in the previous session. `<resource_name>` and `<name>` are variables in the decorator that will be passed to the function it decorates.

If you run `python flask_request_get_resource.py` it would not only respond to requests on `/` but also the RESTful request URL we used in in the previous session:

* <http://localhost:5000/resource/form_1/value/ljo>
and a few more: 
* <http://localhost:5000/resource/resource_1>
* <http://localhost:5000/resource/xhtml2>
* <http://localhost:5000/resource/missing1>

It is not good to use too much logic in the templates but it will get you going getting some resources until you have implemented some logic to include other resources.

Exercise: If you want to use any of the other HTTP methods how would you specify it?

Exercise: Implement one of your API methods, use a string value to return firstly.

Exercise: Implement more of your API methods, return the varible parameters to start with.

 
Exercise: Implement one of your API methods to include an external API call like in [error_handling_url_not_found.py](error_handling_url_not_found.py). Either returning json or some other format. Hint you did some in the github API exercise.
