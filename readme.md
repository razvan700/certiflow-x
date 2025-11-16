Certiflow-X is a modular microservices-based employee certification and analytics platform built with Spring Boot, PostgreSQL, Docker, and Maven multi-module architecture.

The project is structured as a distributed system composed of independent Spring Boot microservices that communicate asynchronously. Each service owns its own data and interacts with others through REST APIs or message queues.

Currently, there are two functional modules. The first is common-libs, which contains shared entities, exceptions, and configurations. It defines a BaseEntity class that provides a UUID identifier and timestamps for creation and updates. It also includes an ApiException class for custom business exceptions with HTTP status codes and a GlobalExceptionHandler that converts exceptions into unified JSON error responses.

The second module, employee-service, manages all operations related to employees. It provides complete CRUD functionality with a soft-delete mechanism using an “active” flag. The service includes an Employee entity that inherits from BaseEntity and contains fields for first name, last name, email, department, and active status. 
