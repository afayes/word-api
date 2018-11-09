# Word API

## Overview
This Word API is built using Java 10, Spring Boot, JUnit 5, Swagger, Lombok, and Docker. TDD was used to implement code, 
have a look at the commits too see the TDD approach.

## Quick start
To run the project execute from the project root
```
docker-compose up
```

This will pull the pre-built images from Docker Hub and run it in docker.

Navigate to: http://localhost:8080/swagger-ui.html to access the API through SWAGGER

## Tests
You can run all unit and integration tests by executing the following from the project root
```
mvn clean verify
```

## Useful Commands
A [run.sh](run.sh) Bash script has been written to provide useful commands for the project. It is executed in the following way:

``` ./run.sh {build|start|stop|run|push|logs}```

- build: build the application

- start: start the docker containers

- stop: stop and remove the docker containers

- run: build and start

- push: push the images to Docker Hub

- logs: shows log output from docker containers

## TODO
- Add logging