# Simple interest API with Spring Boot

Java project showing how to publish a REST api based on Spring Boot. This project shows how to break down the number of payments of a loan based on the input parameters

## Requirements

* Java 8
* It is recommended to have Docker installed on your computer.

## Build and start the Docker container
1. Execute the maven command:  **mvn clean install** to get the latest version of *.jar

2. Build the docker image with name simple-interest-service: **docker build -t simple-interest-service .**

3. Run the docker image and expose it in the port 8080 of the local machine the port 8085 of the docker image: **docker run -p 8080:8085 simple-interest-service** 

## Execution

### With swagger-ui

Once started access the url **http://localhost:8085/swagger-ui.html**
