# Institute API

A Spring Boot RESTful API for managing students and courses in an institute. This project is built for assessment purposes for Bhasha.

## Features

- Manage students and courses with CRUD operations
- MySQL database integration using Spring Data JPA
- Input validation with Hibernate Validator
- API documentation with OpenAPI (Swagger UI)
- DTO and entity mapping with MapStruct

## Technologies Used

- Java 21
- Spring Boot 3.4.5
- Spring Data JPA
- MySQL
- Lombok
- MapStruct
- OpenAPI (springdoc-openapi)
- Maven

## Getting Started

### Prerequisites

- Java 21+
- Maven
- MySQL

### Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/sahandev404/institute-api.git
   cd institute-api
   ```

2. **Configure the database:**

   Update the database credentials in [`src/main/resources/application.properties`](src/main/resources/application.properties) if needed:
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/institute-api?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=root
   ```

3. **Build the project:**
   ```sh
   ./mvnw clean install
   ```

4. **Run the application:**
   ```sh
   ./mvnw spring-boot:run
   ```

   The API will be available at `http://localhost:8080`.

5. **API Documentation:**

   Visit [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) for interactive API docs.

## API Endpoints

### Students

- `POST /api/v1/student` - Add a new student
- `GET /api/v1/student/{id}` - Get student by ID
- `GET /api/v1/student` - Get all students

### Courses

- `POST /api/v1/course` - Add a new course
- `GET /api/v1/course` - Get all courses

## Project Structure

- `controller/` - REST controllers
- `service/` - Service interfaces
- `service/impl/` - Service implementations
- `repository/` - Spring Data JPA repositories
- `entity/` - JPA entities
- `dto/` - Data Transfer Objects
- `util/` - Utility classes (e.g., response wrappers)
- `util/mappers/` - MapStruct mappers

## License

This project is for assessment purposes only.

---

**Author:** Sahan Devaka
