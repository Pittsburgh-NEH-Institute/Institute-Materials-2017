from flask import Flask
app = Flask(__name__)
@app.route("/")
def get_my_index():
    return "This is index for / (ROOT) in flask-index.py"
if __name__ == '__main__':
    app.run(port=5000, debug=True)
