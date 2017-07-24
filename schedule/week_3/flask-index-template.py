from flask import Flask
from flask import render_template
app = Flask(__name__)
@app.route("/")
def get_my_index():
    return render_template("index.html")
if __name__ == '__main__':
    app.run(port=5000, debug=True)
