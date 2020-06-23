## Pre-Requisites
###Apache Maven
###JDK 1.8

###Mongo DB
Install Mongo DB
https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/

## Build
mvn clean install

## Deploy
####On Your Desktop
mvn spring-boot:run

runs on embedded tomact accessible on port 8080

####Containerised
The application can be built into a JAR
and run inside a Docker Container - Ref DockerFile

## Testing
###Service Integration Tests
Postman collection to test the service endpoints
 
GET /customers

GET /customer/{customer_id}

POST /customer

DELETE /customers

DELETE /customer/{customer_id}
