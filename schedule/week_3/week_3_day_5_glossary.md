# More Acronymns and Obscure Terminology

**CORS**: Cross-Origin Resource Sharing
 * Historically, web browsers only allowed you to load certain resources from servers other than the one the browser was currently pointed at. Javascript and CSS were ok, but your Javascript code couldn't load data from `http://example.com` if the page in which it was running was pointed at `http://something.com`. There were various awkward workarounds for this.

**The Cloud**: The Cloud is just servers in a rack somewhere running Virtual Machines.

**Virtual Machine**: An emulated computer running on a physical computer.

**SaaS**: Software as a Service
 * A provider hosts the application which you use to do your stuff. Wordpress.com is an example.

**PaaS**: Platform as a Service
 * A provider hosts a provisioned server platform for you, into which you can deploy your application. AWS Elastic Beanstalk, Google App Engine, and Heroku are examples.

**IaaS**: Infrastructure as a Service
 * A provider gives you infrastructure in which you can provision your own server VMs, deciding on processors, storage, and networking, as well as controlling what applications get deployed on those servers. AWS, Google Cloud Platform, DigitalOcean, and Linode are examples.

**Deployment**: The act of taking an application and setting it up to run on a server. You want to automate this if possible.

**Apache**: A venerable web server still going strong. Fast and reliable. <https://httpd.apache.org/>

**Nginx**: A newer rival to Apache. Also fast and reliable. <https://nginx.org/en/>

**WSGI**: Web Server Gateway Interface
 * A specification for how web servers like Apache communicate with web applications, like [Flask](http://flask.pocoo.org/docs/0.12/deploying/mod_wsgi/). This is how you make Flask able to handle many simultaneous requests, e.g..

**YAGNI**: You Aren't Going to Need It
 * Beware of overdoing it. If you don't need a heavyweight infrastructure this month, don't buy it. If you don't need a function, don't write it just because you think you might need it later. Wait until you need it, then you'll know what you need.
