from flask import Flask
from flask import render_template
from flask import request

defaults = { 'title': 'dynamic request header index.html' ,
             'header': 'Default "header" is used. Give request parameter header with a value to change it.',
             'paragraph': 'This is index.html with dynamic contents in response to a request for / (ROOT) in flask_request.py'
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
    return render_template("index_dyn_dict.html", dict=values)

@app.route("/resource/form_mye")
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
