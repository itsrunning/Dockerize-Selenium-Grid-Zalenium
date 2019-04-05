# Dockerize-Selenium-Grid-Zalenium

Dockerize tests with Selenium Grid/ docker-compose / Zalenium.

This repository provides you an insight on how to leverage dockers to execute tests on Selenium Grid on multiple browsers.

Alternatively, Docker-compose YAML file is also explained for easier Selenium Grid setup. Furthermore, [Zalenium](https://github.com/zalando/zalenium), which is a Selenium Grid extension to scale your local grid dynamically with docker containers. It uses docker-selenium to run your tests in Firefox and Chrome locally.

In this example we have considered here is a simple selenium test with a combination of java-maven project using testng executed on firefox and chrome dockers.

Prequiste - [docker](https://www.docker.com/products/docker-desktop)

Clone the repo - https://github.com/itsrunning/Dockerize-Selenium-Grid-Zalenium.git

To set **Selenium Grid**, execute the commands :

1.  `docker run -d -p 4444:4444 --name selenium-hub selenium/hub` - To get the Selenium Hub running!

2.  `docker run -d -p 5001:5900 --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-firefox` - To get Firefox broswer docker up.

3.  `docker run -d -p 5002:5900 --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-chrome` - To get Chrome broswer docker up.


Note: `"docker ps"` command shows the above 3 dockers running. The browser dockers are registered as nodes to the hub running. Once the grid is up, you can view the hub and nodes(browser dockers) on  [http://172.17.0.2:4444/grid/console](http://172.17.0.2:4444/grid/console). Where 172.17.0.2 is the ip of broswer docker container.

4.  `cd /Dockerize-Selenium-Grid-Zalenium/`

5.  `docker build . -t mavendocker`

6.  `docker run mavendocker` - Will execute the tests.

7.  For reporting, Extent reports plugin has been integrated. Open the file extent.html in your browser to view HTML reports.


Alternatively, The ****docker compose** YAML file** consisting of definition of multi container browser dockers. The "docker-compose up" command is used to bring up all the required broswer dockers.

[Zalenium](https://github.com/zalando/zalenium), is a tool which starts a selenium grid in seconds and scales up and down dynamically. It also provide live dashboard where you can view the execution.

Follow the simplecommands to bring up the neccessary browser dockers using Zalenium:

1. `docker pull elgalu/selenium`

2. `docker pull dosel/zalenium`

3. `docker run --rm -ti --name zalenium -p 4444:4444
-v /var/run/docker.sock:/var/run/docker.sock
-v /tmp/videos:/home/seluser/videos
--privileged dosel/zalenium start`


[http://localhost:4444/dashboard/#](http://localhost:4444/dashboard/#)  the live execution can be viewed here.

Have fun dockerizing your tests!!