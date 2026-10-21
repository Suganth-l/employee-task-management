# Employee Task Management System

A Spring Boot REST API assignment demonstrating Java, OOP, Collections, validation, exception handling, layered architecture, Comparator, and Java Streams.

## Technology
- Java 17
- Spring Boot 3.5.5
- Maven
- Spring Web
- Jakarta Bean Validation
- In-memory `ConcurrentHashMap` storage

## Run
1. Install JDK 17 or later.
2. Open this folder in IntelliJ IDEA and allow Maven to import dependencies.
3. Run `EmployeeTaskManagementApplication.java`, or run `mvn spring-boot:run`.
4. The API runs at `http://localhost:8080`.

Data is stored in memory and resets when the application restarts.

## Employee APIs

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/employees` | Add employee |
| GET | `/employees` | List employees |
| GET | `/employees/{id}` | Find employee |
| DELETE | `/employees/{id}` | Delete employee |
| GET | `/employees/sort/salary` | Sort salary ascending |
| GET | `/employees/highest-salary` | Find highest-paid employee |

Example employee body:
```json
{
  "id": 1,
  "name": "Arun Kumar",
  "email": "arun@example.com",
  "department": "IT",
  "salary": 45000
}
```

## Task APIs

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/tasks` | Create task |
| GET | `/tasks` | List tasks |
| PUT | `/tasks/{taskId}/assign/{employeeId}` | Assign task |
| PUT | `/tasks/{taskId}/status` | Update status |
| GET | `/employees/{id}/tasks` | Get employee tasks |
| GET | `/tasks/sort/priority` | Sort HIGH, MEDIUM, LOW |
| GET | `/tasks/completed` | Get completed tasks |

Example task body:
```json
{
  "taskId": 101,
  "title": "Build REST API",
  "description": "Implement employee endpoints",
  "priority": "HIGH"
}
```
Status update body:
```json
{ "status": "COMPLETED" }
```
Allowed statuses: `PENDING`, `IN_PROGRESS`, `COMPLETED`. Allowed priorities: `LOW`, `MEDIUM`, `HIGH`.

## Reporting

`GET /reports/task-count` returns each employee's ID, name, and assigned task count, including employees with zero tasks.

## Error handling
- `400 Bad Request`: invalid request data or enum.
- `404 Not Found`: employee or task does not exist.
- `409 Conflict`: duplicate employee or task ID.

## Build and test
```bash
mvn clean test
mvn package
```

## Notes
- Data uses in-memory concurrent maps, not a persistent database.
- Java Streams are used for completed-task filtering, sorting, highest salary, and task count reports.
- Priority sorting explicitly orders HIGH before MEDIUM before LOW.
