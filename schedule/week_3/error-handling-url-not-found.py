import json
import urllib.error
import urllib.parse
import urllib.request

urlbase = "http://localhost:8091/exist/rest/db/karp/karp-stats.xql?op=feat-stats&do-feat-values=true&use-current=true&json=true&resurs={}"

def get_data(resource):
    query = urllib.parse.quote(resource)
    url = urlbase.format(query)
    request = urllib.request.Request(url)
    with urllib.request.urlopen(request) as response: 
        data = response.read().decode('utf-8')
    parsed = json.loads(data)
    info = None
    if parsed.get('resource'):
        info = {'description': parsed['resource'][0]['description'],
                   'name': parsed['resource'][0]['name']
                   }
    return info

try: 
   get_data("dalin")
except urllib.error.URLError:
   print("Connection refused. Please check the URL and port")
