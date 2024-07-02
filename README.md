# University Project: Web Application

This project is a simple web application demonstrating a many-to-many relationship between students, courses, and universities. It includes examples of optimistic locking, asynchronous communication, glass-box extensibility, and RESTful services.

## Project Description

This university project showcases various advanced Java concepts and techniques:

- Optimistic locking
- Asynchronous communication
- Glass-box extensibility using CDI
- RESTful services

## Features

- Many-to-many relationship between students, courses, and universities
- Demonstration of OptimisticLockException handling
- Asynchronous component communication
- CDI alternatives, specialization, interceptor, and decorator examples
- RESTful API for creating, retrieving, and updating entities

## Technologies Used

### Backend:
- Java EE
- JPA (Java Persistence API)
- CDI (Contexts and Dependency Injection)

### Tools and Libraries:
- Maven

## Project Requirements and Implementation Details

### Optimistic Locking:
- **Task:** Demonstrate how `OptimisticLockException` is obtained and how it can be handled by the programmer.
  - **Details:**
    - What happens to the current transaction when `OptimisticLockException` is encountered?
    - What happens to the current `EntityManager` when `OptimisticLockException` is encountered?
    - How to save the entity to the database after `OptimisticLockException`?

### Asynchronous Communication:
- **Task:** Provide an example of a component performing a long calculation (using `Thread.sleep(...)`) and the correct way to communicate with it.
  - **Details:**
    - Can an asynchronous component join a transaction started by the caller?
    - Can an asynchronous component use `@RequestScoped EntityManager`?

### Glass-box Extensibility:
- **Task:** Provide examples of the following:
  - **CDI Alternatives (`@Alternative`):** Selection of the alternative in `beans.xml` file.
  - **CDI Specialization (`@Specializes`):** Provide an example.
  - **CDI Interceptor:** Enabling/disabling interceptors in `beans.xml` file.
  - **CDI Decorator:** Enabling/disabling decorators in `beans.xml` file.

### RESTful Services Example:
- **Task:** Implement RESTful services to:
  - Get (GET) an entity from the database.
  - Create (POST) an entity in the database.
  - Modify (PUT) an entity in the database.
