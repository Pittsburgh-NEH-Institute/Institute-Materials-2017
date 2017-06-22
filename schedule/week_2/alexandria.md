# Alexandria

## About Alexandria and TAG

Alexandria is a graph database and text repository that implements the Text As Graph (TAG) model of text. You can read more about at **[add link to Balisage paper]**.

## Installing Alexandria

### Install Docker

[Docker](https://hub.docker.com/) is a *container*:

> A container image is a lightweight, stand-alone, executable package of a piece of software that includes everything needed to run it: code, runtime, system tools, system libraries, settings. Available for both Linux and Windows based apps, containerized software will always run the same, regardless of the environment. Containers isolate software from its surroundings, for example differences between development and staging environments and help reduce conflicts between teams running different software on the same infrastructure. [<https://www.docker.com/what-container>]

Because Alexandria runs inside a Docker container, it comes as an operating-system-independent package that bundles Alexandria itself with all of its dependencies. This makes it easy for users to install, and for developers to maintain and distribute.

### Install Alexandria

You have to do the following only once:

1. Install the Alexandria server with `docker pull huygensing/alexandria-server`.
2. Install the Alexandria notebooks with `docker pull huygensing/alexandria-workshop-notebooks`.

## Run Alexandria

1. Launch the server by running the following command, but **first make the changes listed below it**:

	`docker run -v /Users/djb/tmp/tmp:/home/alexandria/.alexandria -p2015:2015 huygensing/alexandria-server`

	Make the following changes before running the command:
	
	1. Replace the part that reads “/Users/djb/tmp/tmp” with a directory on your own system that you want to use to save data when the database isn’t running (the technical term is to **persist** the database).
	2. If your local port 2015 is already in use (unlikely, and if it is, you’ll get an error when you try to launch the Alexandria server), change the *first* instance of “2015” to another number (don’t use a number below 1024). Don’t change the second instance of “2015”.

	When you start the server, the terminal remains open and provides feedback about the operation, which you can ignore. When you want to quit, return to the terminal and type `Ctrl+c`, which will kill the server process (= shut down the server).

2. In a different terminal window, launch the Alexandria notebooks by running the following command, but **first make the changes listed below it**:

	`docker run -d -p8888:8888 -v /Users/djb/tmp/tmp:/data/work huygensing/alexandria-workshop-notebooks`

	Make the following changes before running hte command: 
	
	1. Replace the part that reads “/Users/djb/tmp/tmp” with whatever you used as a replacement when you launched the server.
	2. If your port 8888 is already in use (you’ll get an error if it is), change the *first* instance of “8888” to another number (don’t use a number below 1024). Don’t change the second instance of “8888”.
	3. Navigate in your web browser to `http://localhost:8888` (or whatever port you are using for the notebooks).
	4. You will be prompted to paste in the login token. **[Doesn’t work, and `jupyter notebook list` shows no notebooks running]**

## Test your installation

Do something.