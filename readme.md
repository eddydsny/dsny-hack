# Team 1 (William, Eddy, Brad)

### Overview
Provides a solution for server-to-client requests that are consumed in order of a unique sequence identifier.

### Installation

###### Database
Install Mongo - https://www.mongodb.org/downloads. If not running as a service navigate to c:/mongo/bin and execute:
```sh
mongod
```

###### Java Server
Import the application as a Gradle project in STS, then run as Spring Boot App. The server will be accessible at http://localhost:8080

###### Client Server
Requires node to be installed, you can download it here - https://nodejs.org/en/.

Navigate to src/main/web/ and run:
```sh
$ npm install
```

Start the node server by running:

```sh
$ gulp server
```
Then open sessions at http://localhost:9090/

### Java Server Endpoints

##### Retrieve a list of Events
URL: http://localhost:8080/event/list
Method: GET

##### Create a new Event
URL: http://localhost:8080/event
Method: POST
Body: {} - Event structure

##### Get individual event
URL: http://localhost:8080/event/{id}
Method: Get

##### Update individual Event
URL: http://localhost:8080/event
Method: Put
Body: {} - Event structure

##### Delete an event
URL: http://localhost:8080/event/{id}
Method: DELETE

### Todos

 - Write Tests

License
----

MIT