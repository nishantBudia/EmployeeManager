# Employee Manager
Complete employee management api.

Deployed on: 3.110.132.209

***

## Framework and Languages
* Java Platform 8
* JDK 17
* Maven
* SpringBoot starter - ver. 1.3.5
* MySQL
* MongoDB
* Amazon Web Services

## Data Flow
This section outlines implementation of the layers.
## Entity

#### Department :
* id
* name
* creation time
* updation time
#### Employee
* id
* First Name (first letter must be capital and must contain only one word)
* Last name
* email
* department id (fk - Department - id)
* creation time
* updation time


## Controller
Complete Controller Documentation can be viewed on the swagger ui for best experience: https://3.110.132.209:8080/swagger-ui/index.html#/



## Service

There are:

* Department Service
* Employee Service


## Repository
     MongoRepository - Department

     JpaRepository - Employee
## DataBase Design
MySQL database for storing Employee table

MongoDB for storing Department table
