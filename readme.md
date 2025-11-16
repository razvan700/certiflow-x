Certiflow-X is a modular microservices-based employee certification and analytics platform built with Spring Boot, PostgreSQL, Docker, and Maven multi-module architecture.

The project is structured as a distributed system composed of independent Spring Boot microservices that communicate asynchronously. Each service owns its own data and interacts with others through REST APIs or message queues.

Currently, there are two functional modules. The first is common-libs, which contains shared entities, exceptions, and configurations. It defines a BaseEntity class that provides a UUID identifier and timestamps for creation and updates. It also includes an ApiException class for custom business exceptions with HTTP status codes and a GlobalExceptionHandler that converts exceptions into unified JSON error responses.

The second module, employee-service, manages all operations related to employees. It provides complete CRUD functionality with a soft-delete mechanism using an “active” flag. The service includes an Employee entity that inherits from BaseEntity and contains fields for first name, last name, email, department, and active status. Email validation is implemented using the @Email annotation, and the email field is also unique in the database. Lombok annotations are used to reduce boilerplate.

The EmployeeRepository extends JpaRepository and defines methods such as findByActiveTrue() to return only active employees and findByEmail() to verify email uniqueness. The EmployeeService class provides business logic for creating, updating, retrieving, and deactivating employees. It validates that no two employees share the same email, throws ApiException when business rules are violated, and handles both deactivation and reactivation instead of physical deletion.

The EmployeeController exposes REST endpoints for all these operations. Available endpoints include retrieving all active employees, retrieving an employee by ID, creating an employee, updating employee details, deactivating an employee, and reactivating one. The service uses PostgreSQL for persistence and integrates with the shared exception handler from common-libs for consistent error responses.

The technology stack includes Java 17, Spring Boot 3.3, JPA with Hibernate, PostgreSQL, Jakarta Validation for input validation, Lombok for annotations, Docker and Docker Compose for containerization, and Maven as the build system.

The current folder structure includes the parent project with common-libs and employee-service modules. Future modules such as certificate-service, notification-service, and analytics-service will be added to handle certifications, messaging, and reporting.