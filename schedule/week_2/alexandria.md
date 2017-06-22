# Alexandria

## About Alexandria and TAG

Alexandria is a graph database and text repository that implements the Text As Graph (TAG) model of text. You can read more about at **[add link to Balisage paper]**.

## Installing Alexandria

### Install Docker

[Docker](https://hub.docker.com/) is a *container*:

> A container image is a lightweight, stand-alone, executable package of a piece of software that includes everything needed to run it: code, runtime, system tools, system libraries, settings. Available for both Linux and Windows based apps, containerized software will always run the same, regardless of the environment. Containers isolate software from its surroundings, for example differences between development and staging environments and help reduce conflicts between teams running different software on the same infrastructure. [<https://www.docker.com/what-container>]

Because Alexandria runs inside a Docker container, it comes as an operating-system-independent package that bundles Alexandria itself with all of its dependencies. This makes it easy for users to install, and for developers to maintain and distribute.

### Install Alexandria

Alexandria is available at <https://github.com/HuygensING/alexandria-workshop-notebooks>. Clone the repo and follow the instructions at <https://hub.docker.com/r/huygensing/alexandria-workshop-notebooks/>. Notes:

1. You may have installed Python 3 as either `python` or `python3`. The instructions specify the latter, but Anaconda defaults to the former. Use whichever one works.
1. If you are already using port 8888, change the port number in the launch command to something else.

## Test your installation

Do something.