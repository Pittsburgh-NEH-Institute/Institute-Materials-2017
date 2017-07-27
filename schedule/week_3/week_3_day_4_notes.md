# APIs

## Obscure Acronyms Unhelpfully Expanded

**API**: Application Programming Interface
 * Essentially, a syntax and grammar for talking to a computer program.

**REST**: Representational State Transfer
 * A set of conventions used in building APIs for talking to computer programs using HTTP that is generally agreed to be good practice, even though nobody follows it absolutely. Lends itself to puns like "RESTful" and "RESTafarian".

**HTTP**: Hypertext Transfer Protocol
 * A language for transmitting information on the Web between a client and a server. Has 9 methods. we care about 5: GET, POST, PUT, PATCH, DELETE. Well, maybe also HEAD. (give me just a response header for a request, not the whole response).

**HTTPS**: Secure Hypertext Transfer Protocol
 * Same as above, but the communication between client and server is encrypted, so someone listening on the network can't spy on your conversation.

**JSON**: JavaScript Object Notation
  * You've seen a bit of Javascript objects, which look a lot like Python dictionaries. JSON is a format often used for packaging information to be passed around over the web. XML is another such format, but JSON is more popular nowadays. Since it's Javascript, web browsers have a very easy time with it.

**URI**: Uniform Resource Identifier
 * A (hopefully unique) identifier for some resource, probably one on the Web.

**IRI**: Internationalized Resource Identifier
 * Same as above, but allows characters from non-Latin scripts, whereas URIs escape them with %-encoding.

**CRUD**: Create, Read, Update, Delete
 * The things one generally wants to do with a Web API. They correspond to the HTTP "verbs", though sometimes POST = Create, sometimes it's PUT; sometimes POST = Update, sometimes it's PATCH.

**HATEOAS**: Hypermedia as the Engine of Application State
 * Horrible acronym. Means a REST client doesn't need to know the structure of your API before it comes to your site. Your API will tell it how to do the things it needs to. This allows your API to evolve without breaking its clients.

**RTFM**: Read the Fine Manual
 * What you say when somebody asks you a question that is clearly spelled out in the documentation. "F" is sometimes understood to have a different expansion.

**KISS**: Keep It Simple, Stupid

**DRY**: Don't Repeat Yourself

## Not Acronyms, but Worth Explaining Anyway

**State**: When you run a program and it does things, very often its *state* will change. If I have a variable in my program, and I increment it, I have changed its state. One of the principles of REST is that state belongs in the client, not on the server. You have probably experienced inconsistent states in your Jupyter Notebooks when some cells won't run until you've first run the cells above.

**Caching**: A cache is something that sits between the client and the server and speeds up responses to the client by saving the results of the previous request. If, e.g. your GET request is always going to return the same result, then I can just save that result and give it to you again the next time you ask for it, rather than doing work on the server to generate it. REST-style APIs lend themselves to caching, which is a good thing.

**Endpoint**: A URI that is the "front door" to an API.

**HTTP Status Codes**: In an HTTP Response Header, you'll see strings like (hopefully) "200 OK". These are codes which tell you whether your request was successful, and what sort of response it got. A full list may be found at <https://en.wikipedia.org/wiki/List_of_HTTP_status_codes>.

**Link Relations**: If you're doing things RESTfully, then you'll be using these in your API to tell clients what URLs they should visit to get information or perform tasks.

## RESTful APIs

GET should have no side effects. DELETE and PUT should always produce the same result for the same request. POST may have side-effects.

One of the principles of RESTful APIs is that prior knowledge of your site's structure should not be required for the client. Your API will tell the client what it can do using link relations. This kind of design means clients only need to know what sorts of things they want to do, not what specific URIs they need to hit to do them. This means you can change your API without requiring that everyone update their clients.

An older style of API communication relied on POSTing a package of data to an endpoint and getting back a similar package as a result. State was transferred between client and server via these packages.  It was called SOAP (for Simple Object Access Protocol). It is now generally agreed that this was a Terrible Idea.

Nothing stops you from having an API style that consists of a bunch of URIs that do things, and that don't link to each other, and that the client just has to know about. But that means that API versioning becomes much more of an issue. If you change a function location, do you stop supporting the old clients? Do you keep an old version of the API running for them and support newer clients at the new location? How much of that are you willing to put up with?

## Exercise: Let's look at the GitHub API

1. (If you haven't previously) do `pip install requests` in a terminal.
1. Run Python.
1. Try the following:

```
import requests
r = requests.get("https://api.github.com")
r.json()
r.json()["organization_url"]
```

You should see something like `'https://api.github.com/orgs/{org}'`, which means "Information about organizations can be found by plugging in the organization's name at the end of this URL". Try it:

```
r = requests.get("https://api.github.com/orgs/TEIC")
r.json()
```

This is telling us some things we can do with the TEIC organization. We can ask it about its repositories, for example:

```
r = requests.get("https://api.github.com/orgs/TEIC/repos")
r.json()
```

That's rather a lot of stuff. Maybe we should just look at one of them.

```
r.json()[0]
```

Still a lot of stuff. What the Requests library is doing here is reading the HTTP response, which is JSON, and parsing it into a Python data structure, which is why we can navigate it. So we could just ask it what sorts of information it has:

```
r.json()[0].keys()
```

Oh, look, there's a name property:

```
r.json()[0]["name"]
```

I get "pureodd". I don't really care about Pure ODD anymore, let's try another.

```
r.json()[1]["name"]
```
Our old friend, the Stylesheets!

```

## Talk Lab: Planning your API

Think about the things you might want an API for your edition to do. APIs can deal with things like navigation, search, filtering, annotation, creating new resources, and modifying existing resources.

## Discussion: API Best Practices

### Notes
 * The Web is your API
 * API Anti-Patterns
  * Hiding
  * Oversharing
  * Overcomplicating
