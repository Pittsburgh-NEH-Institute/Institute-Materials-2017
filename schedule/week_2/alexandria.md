# Alexandria

## About Alexandria and TAG

Alexandria is a graph database and text repository that implements the Text As Graph (TAG) model of text. You can read more about at **[add link to Balisage paper]**.

## Installing Alexandria

## Install Docker

[Docker](https://hub.docker.com/) is a *container*:

> A container image is a lightweight, stand-alone, executable package of a piece of software that includes everything needed to run it: code, runtime, system tools, system libraries, settings. Available for both Linux and Windows based apps, containerized software will always run the same, regardless of the environment. Containers isolate software from its surroundings, for example differences between development and staging environments and help reduce conflicts between teams running different software on the same infrastructure. <https://www.docker.com/what-container>

Because Alexandria runs inside a Docker container, it comes as an operating-system-independent package that bundles Alexandria itself with all of its dependencies. This makes it easy to users to install and easy for developers to maintain and distribute.

## Install Alexandria

Alexandria is available at <https://github.com/HuygensING/alexandria-workshop-notebooks>. There are two ways to install it, which have the same last step (“to run the Docker image”):

1. Clone the repo, `cd` into it, and follow the instructions at <https://hub.docker.com/r/huygensing/alexandria-workshop-notebooks/>. If you are already using port 8888, change the port number to something else on the launch command.
2. Run `docker pull huygensing/alexandria-workshop-notebooks` and then launch Alexandria as described at the page above.

## Test your installation

Do something.