# Alexandria

## General

Alexandria is a text repository, graph database, and annotation server, suitable for text-as-graph (TAG) modeling and interaction. 

## Documentation

Documentation for Alexandria is available at <http://huygensing.github.io/alexandria/>. Click on the link to “REST Acceptance Tests” in the footer, although at this time the text there is not necessarily up to date with the latest version.

## Installation (Mac only so far)

For first use you have to install (_pull_) the server and client containers. You can then run and stop the pulled containers as needed. To keep up to date, you can pull before each run, which will update any changed components.

### Server

* Install or Update docker for Mac (<https://docs.docker.com/docker-for-mac/>) stable version. Instructions for testing the installation are at <https://docs.docker.com/docker-for-mac/>. When testing the webserver, the first port number is the client (“native”) port, and can be changed, so if port 80 is in use locally, change the values to something like 8080:80.
* Create a working directory with `mkdir AlexandriaWorkdir` (somewhere)
* Download Alexandria with `docker pull huygensing/alexandria-server`
* Start the Alexandria VM:
	* General command: `docker run -d -v ${workdir}:/home/alexandria/.alexandria -p${native_port}:2015 huygensing/alexandria-server`
	* Specific example: `docker run -d -v /Users/ronalddekker/AlexandriaWorkdir:/home/alexandria/.alexandria -p2000:2015 huygensing/alexandria-server`
* Check server status with `http://localhost:2000` and `http://localhost:2000/about`. The documentation link points to outdated information (at footer link to “REST Acceptance Tests”); up-to-date documentation currently is not installed automatically on the public server. The WADL file is sometimes not displayed in Safari for mysterious Safari-specific reasons.
* Other commands: `docker ps`, `docker stop ${arguments}`. When you stop a container, it lingers in memory. To stop and remove a running container (but not the downloaded image) use `docker rm -f ${name}`, where the name is the value shown in the name column of the output of `docker ps`.  Remove all exited containers with `docker rm -v $(docker ps -a -q -f status=exited)` (<http://blog.yohanliyanage.com/2015/05/docker-clean-up-after-yourself/>).

At this point the server is running. You can interact with it through the REST interface or through a client, about which see below.

### Client

* Install the client with `docker pull huygensing/alexandria-workshop-notebooks`. This takes a long time.
* Start the client with `docker run -d -p${local_port}:8888 -v ${local_workdir}:/data/work huygensing/alexandria-workshop-notebooks`, where `local_workdir` is the Alexandria installation directory.
* Navigate to the local port in a browser, which opens a Jupyter interface.


### Rerunning

You can rerun a pulled container with the appropriate `docker run ${arguments}` command, but that doesn’t check for updates. To check for updates first, repeat the appropriate `docker pull ${arguments}` command. Updating pulls only changed files.
