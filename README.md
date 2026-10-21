# Employee Task Management System

A RESTful API application developed using Java and Spring Boot to manage employees and their tasks. The application supports employee management, task creation, task assignment, status updates, sorting, and reporting.

## Project Overview

The Employee Task Management System helps manage employee details and track tasks throughout their lifecycle. It follows a layered architecture to separate controllers, services, repositories, models, and DTOs.

## Technologies Used

- **Language:** Java 17
- **Framework:** Spring Boot 3.5.5
- **Build Tool:** Maven
- **API Style:** REST API
- **Data Storage:** In-memory storage using `ConcurrentHashMap`
- **Java Features:** Collections, Streams, and Lambda Expressions
- **API Testing:** Postman
- **Version Control:** Git and GitHub

## Features

### Employee Management
- Create employees
- Retrieve employee details
- View employees
- Validate employee input

### Task Management
- Create tasks
- Retrieve task details
- Assign tasks to employees
- Update task status
- Track task priorities and statuses

### Additional Features
- Sort and filter task data
- Generate task reports
- Handle exceptions centrally
- Validate incoming API requests
- Use Java Streams for data processing

## Project Structure

```text
employee-task-management/
├── src/
│   └── main/
│       ├── java/
│       │   └── .../
│       │       ├── controller/
│       │       ├── service/
│       │       ├── repository/
│       │       ├── model/
│       │       ├── dto/
│       │       └── exception/
│       └── resources/
├── outputs/
│   └── README.md
├── pom.xml
└── README.md
```

*Note: Package and folder names above are illustrative. Adjust them to match the actual source code.*

## Prerequisites

Install the following before running the project:

- Java Development Kit (JDK) 17 or compatible configured JDK
- Maven, or use the Maven Wrapper if included
- IntelliJ IDEA, Eclipse, or another Java IDE
- Postman for API testing

## How to Run the Project

1. Clone the repository:

   ```bash
   git clone https://github.com/YOUR-USERNAME/employee-task-management.git
   ```

2. Navigate to the project folder:

   ```bash
   cd employee-task-management
   ```

3. Build the application:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

5. The application should start at:

   ```text
   http://localhost:8080
   ```

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/employees` | Create an employee |
| GET | `/employees` | Retrieve employees |
| GET | `/employees/{id}` | Retrieve an employee by ID |
| POST | `/tasks` | Create a task |
| GET | `/tasks` | Retrieve tasks |
| GET | `/tasks/{taskId}` | Retrieve a task by ID |
| PUT | `/tasks/{taskId}/assign/{employeeId}` | Assign a task to an employee |
| PUT | `/tasks/{taskId}/status` | Update task status |

*Check the controller classes to confirm the exact endpoints supported by your implementation.*

## Sample API Requests

### 1. Create Employee

**POST** `/employees`

```json
{
  "id": 1,
  "name": "Arun Kumar",
  "email": "arun@example.com",
  "department": "IT",
  "salary": 45000
}
```

### 2. Create Task

**POST** `/tasks`

```json
{
  "taskId": 101,
  "title": "Develop Employee API",
  "description": "Implement and test employee management APIs",
  "priority": "HIGH"
}
```

The application may assign the initial task status automatically as `PENDING`.

### 3. Assign Task to Employee

**PUT** `/tasks/101/assign/1`

Assigns task 101 to employee 1. The employee must exist.

### 4. Update Task Status

**PUT** `/tasks/101/status`

```json
{
  "status": "IN_PROGRESS"
}
```

Example status values: `PENDING`, `IN_PROGRESS`, and `COMPLETED`.

## Application Outputs

Screenshots of API testing and successful responses are available in the `outputs/` directory.

- Employee creation response
- Task creation response
- Task assignment response
- Task status update response

## Error Handling and Validation

The application includes request validation and centralized exception handling to return appropriate error responses for invalid input or missing resources.

## Architecture

The application follows a layered architecture:

- **Controller:** Handles HTTP requests and responses.
- **Service:** Implements business logic.
- **Repository:** Stores and retrieves application data.
- **Model:** Represents employees and tasks.
- **DTO:** Defines request and response data structures.
- **Exception Handler:** Handles application errors consistently.

## Future Enhancements

- Integrate a relational database such as PostgreSQL or MySQL.
- Add authentication and authorization.
- Implement pagination and advanced filtering.
- Add automated unit and integration tests.

