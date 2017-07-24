import json
import urllib
import urllib2

urlbase = "http://localhost:8091/exist/rest/db/karp/karp-stats.xql?op=feat-stats&do-feat-values=true&use-current=true&json=true&resurs={}"

def get_data(resource):
    query = urllib.quote(resource)
    url = urlbase.format(query)
    data = urllib2.urlopen(url).read()
    parsed = json.loads(data)
    info = None
    if parsed.get('resource'):
        info = {'description': parsed['resource'][0]['description'],
                   'name': parsed['resource'][0]['name']
                   }
    return info

try: 
   get_data("dalin")
except urllib2.URLError:
   print "Connection refused. Please check the URL and port"
