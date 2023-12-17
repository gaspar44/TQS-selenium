# Selenium website tests

We're going to make some test at the page [automation exercises](https://automationexercise.com/)

### Preconditions
We are going to use the selenium hub approach to be able to test in most browsers, for this reason, the official selenium's
docker images will be used.
1. Have [docker compose](https://docs.docker.com/compose/install/linux/) installed
2. The selenium hub will run in the port 4444 at the localhost. This port must be free.
3. To execute the containers , execute the command `docker compose up -d`
4. To check any browser execution you can check the container's ip with the command `docker inspect <containerName>`, access via your default browser to the "http://ContainerIP:7900", click on "Connect" and you may be able to check the browser's activity.
5. Windows operative system has not been tested. We can not make a guarantee of this project behaviour if executed at Windows.

### Executing test
There are two ways to execute the tests.
1. From your IDE, import the project as a "Gradle project", and run with the cucumber plugin. Depends on your IDE.
2. The test are prepared to be executed from a command line with gradle(your IDE can use a local installation or may download one). In this case, just execute the command `gradle test`, to execute all the tests.