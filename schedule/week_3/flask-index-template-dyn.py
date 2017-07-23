from flask import Flask
from flask import render_template
app = Flask(__name__)
@app.route("/")
def get_my_index():
     return render_template("index-dyn.html", title="template index.html", header="index.html", paragraph="This is index.html with dynamic contents in response to a request for / (ROOT) in flask-index-template-dyn.py")
if __name__ == '__main__':
    app.run(port=5000, debug=True)
