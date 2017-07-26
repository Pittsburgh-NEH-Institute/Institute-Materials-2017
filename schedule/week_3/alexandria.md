# Configuring Alexandria

Alexandria is a text repository and database that supports Text As Graph (TAG). We’ll use it in the Institute to gain perspective on modeling by exploring non-XML structured text representations.

1. Install Docker
	* _Mac (Yosemite 10.10.3 or later)_: Docker CE (community edition) for Mac from <https://store.docker.com/editions/community/docker-ce-desktop-mac>
	* _Mac (Older than Yosemite 10.10.3)_: Docker toolbox for Mac <https://download.docker.com/mac/stable/DockerToolbox.pkg>
	* _Windows 10 Professional or Enterprise_: Docker CE for Windows <https://docs.docker.com/docker-for-windows/install/>. **Please note that Hyper-V *should only be enabled* which Docker does for you at installation time. It is probably that you do not have _Virtualization_ enabled in your BIOS if there is an error about this. In BIOS it could be named _VT-X_/_AMD-v_ or simply _Virtualization_. 
	* _Windows 10 Home, Windows 8, Windows 7_: This installs Docker CE into a GNU/Linux system in a VirtualBox <https://docs.docker.com/toolbox/toolbox_install_windows> (direct link <https://download.docker.com/win/stable/DockerToolbox.exe>)
	* _GNU/Linux_: Install Docker via your package manager.

2. Create a directory and copy the following file (which must be called `docker-compose.yml`) into it:

	```
	version: '3'
	services:
	  # the alexandria server
	  alexandria:
	        image: huygensing/alexandria-markup-server:latest
	        ports:
	          - 8002:8080
	          - 8003:8081
	        environment:
	          - BASE_URI=http://docker.for.mac.localhost:8002

	  # the tex-util server, which can convert the LaTeX from the alexandria server to SVG)
	  latex:
	        image: huygensing/tex-util-server:latest
	        ports:
	          - 8000:8080
	          - 8001:8081
	        depends_on:
	          - alexandria
	        environment:
	          - BASE_URI= http://docker.for.mac.localhost:8000

	  # the relevant notebooks and python code to connect to the alexandria and latex services
	  notebook:
	        image: huygensing/alexandria-markup-notebook:latest
	        ports:
	          - 8888:8888
	        depends_on:
	          - latex
	          - alexandria
	        volumes:
	          # Your work notebooks will be stored here
	          - /Users/djb/docker:/work
	```

1. Change the last line to specify your own workspace by replacing the “djb” with your own userid. If not on Mac also change the two occurrences of “docker.for.mac.localhost“ to the ip address of your Docker. 

2. Create a subdirectory called `docker` under your home.

1. If you are using ports 8000, 8001, 8002, 8003, or 8888 on your machine for other purposes (you probably aren’t), you need to change the ports Alexandria uses. The only numbers you have to change are for the ports you are using, and only in the following two types of situations:

	1. The numbers after the colons in the lines that set a value for `BASE_URI`.

	1. The numbers *before* the colons in the lines that have two port numbers separated by a colon. Do not change the numbers *after* the colons in these lines, even if you are using ports with those numbers for other purposes.

1. In the directory where you saved `docker-compose.yml`, run:

	```
	docker-compose pull && docker-compose up
	```

1. In a web browser, navigate to either <http://localhost:8888> or <http://ipaddress.of.your.docker:8888> (This is an ip address starting with either 192. or 172. E.g. 172.17.0.1).
1. Click on the “examples” directory and then on the notebook “markup-init.ipynb”. 
1. If required also *change* the ip/host address to that of your docker as above in the *first cell* of the notebook.
1. Run the notebook from the menu bar with “Cell” → “Run All”.
