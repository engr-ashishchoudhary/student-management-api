# Student Management REST API

A RESTful API built using Spring Boot to manage student records. The application supports creating, retrieving, updating, and deleting student information using MySQL as the database.

## Tech Stack

- **Language:** Java 21
- **Framework:** Spring Boot 3.3.5
- **Database:** MySQL 8
- **ORM:** Spring Data JPA / Hibernate
- **Build Tool:** Apache Maven 3.10.0
- **API Testing:** Postman

## Features

- Add a new student
- Retrieve all students
- Retrieve a student by ID
- Update student details
- Delete a student
- Search students by course
- Handle requests for students that do not exist

## Project Structure

```text
student-management-api/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/studentmanagement/
│       │       ├── controller/
│       │       ├── entity/
│       │       ├── exception/
│       │       ├── repository/
│       │       ├── service/
│       │       └── StudentManagementApplication.java
│       └── resources/
│           └── application.properties
├── screenshots/
├── pom.xml
└── README.md
```

## Prerequisites

Before running the application, install:

1. Java JDK 21 or later
2. MySQL Server 8
3. Apache Maven 3.10.0 or later

## Database Configuration

The application uses a MySQL database named `student_db`.

Open `src/main/resources/application.properties` and configure your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Replace `your_password` with your own MySQL password.

The database and students table are created automatically when the application starts.

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/student-management-api.git
```

2. Navigate to the project directory:

```bash
cd student-management-api
```

3. Configure your MySQL username and password in `application.properties`.

4. Start the application:

```bash
mvn spring-boot:run
```

The application runs at:

`http://localhost:8080`

## REST API Endpoints

| Method | Endpoint | Description | Status |
|---|---|---|---|
| POST | `/api/students` | Add a student | 201 Created |
| GET | `/api/students` | Get all students | 200 OK |
| GET | `/api/students/{id}` | Get student by ID | 200 OK |
| PUT | `/api/students/{id}` | Update student | 200 OK |
| DELETE | `/api/students/{id}` | Delete a student | 204 No Content |
| GET | `/api/students/course/{course}` | Get students by course | 200 OK |

A student that does not exist returns `404 Not Found` for the tested student-by-ID request.

## Sample JSON Request

```json
{
  "name": "Ashish",
  "email": "ash@example.com",
  "course": "IT",
  "age": 21
}
```

## API Testing

All REST API endpoints were tested using Postman.

The tests include:

- Adding a student
- Retrieving all students
- Retrieving a student by ID
- Updating student details
- Searching students by course
- Deleting a student
- Testing a student ID that does not exist

## Screenshots

The `screenshots/` directory contains 9 screenshots documenting the API testing and database results.

1. Add Student
2. Get All Students
3. Get Student By ID
4. Update Student
5. Get Students By Course
6. Add Rahul
7. Delete Student
8. Student Not Found (404)
9. MySQL Student Table

## Author

Developed as a Student Management REST API project using Java, Spring Boot, and MySQL.