# Number converter app

-----

## Backend

**Tech stack:**

- Java
- Spring Boot
- Maven
- Lombok
- MySQL
- Docker Compose

Folder: source code in root folder

**API endpoints:**

- http://localhost:8080/api/number-converter/status
- http://localhost:8080/api/number-converter/convert
- http://localhost:8080/api/number-converter/types
- http://localhost:8080/api/number-converter/logs

-----

## Frontend

**Tech stack:**

- React
- HTML, JS, CSS

Folder: source code in folder /frontend/

**Homepage:** 
- http://localhost:8080/

Frontend main page UI consist of converter type selection and number input to be sent to backend API endpoint.

-----

### Starting the app:

Executing following script will start both back and frontend together.
```
./start-app.sh
```

-----

**Additional notes:**

- Call to converter API will log successful and failed conversion log to the MySQL database running on Docker.
- To build and package the React application with Maven, frontend-maven-plugin used.
- To copy the frontend sources to the application target folder maven-resources-plugin used.
- To keep data classes clean from boilerplate codes Lombok used.
- Postman - collection file: NumberConverterApiRequestsCollection.postman_collection.json

-----
