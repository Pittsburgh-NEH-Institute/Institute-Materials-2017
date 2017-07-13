# How the Internet works, part 2

## Security matters

* Telnet is from the era of the free and open internet
* Free and open to packet sniffers like `tcpdump`, that is!

		sudo tcpdump -A -n -s0 -i en0 port 80
* Secure protocols and SSL

		[winpty] openssl s_client -connect www.somesite:443
		
		GET / HTTP/1.1
		Host: byzantini.st
* What it looks like when you try to packet sniff SSL

## The Hypertext Transfer Protocol (HTTP)

* The components of a URL: protocol, host, port, path(, query, fragment)
* What happens when you run Jupyter?
* Connecting to an HTTP server
* HTTP request verbs
  * HEAD
  * GET
  * POST
  * PUT
  * DELETE
* HTTP headers
* HTTP responses
* How to make an HTTP request in Python