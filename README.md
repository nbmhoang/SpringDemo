1. Configure your database information on application.propreties file in /src/main/resource path.
1. Run project: `mvn spring-boot:run`
1. Open Postman, in request URL type:
## Get all of students
[GET] `localhost:8080/api/students`
## Get a student by id
[GET] `localhost:8080/api/student/id`
## Add new student
[POST] `localhost:8080/api/student/create`
## Update a student by id
[PUT] `localhost:8080/api/student/update/id`
## Delete a student by id
[DELETE] `localhost:8080/api/student/delete/id`
