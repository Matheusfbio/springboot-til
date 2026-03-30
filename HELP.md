# Read Me First
The original package name 'io.github.springboot-til' is invalid and this project uses 'io.github.springboot_til' instead.

# Getting Started

## Project Structure

```
src/main/java/io/github/springboot_til/
├── controller/   # ProductController.java - REST endpoints
├── domain/       # Product.java - JPA entity
├── repository/   # ProductRepository.java - data access layer
├── service/      # ProductService.java - business logic
└── http/         # Test.http - HTTP request examples
```

## Product Entity

| Field       | Type          | Description                         |
|-------------|---------------|-------------------------------------|
| id          | UUID          | Auto-generated primary key          |
| productName | String        | Required, must be unique            |
| category    | String        | Product category                    |
| price       | double        | Product price                       |
| createdAt   | LocalDateTime | Auto-set on persist via @PrePersist |

## API Endpoints

Base URL: `http://localhost:8082`

| Method | Endpoint       | Description         |
|--------|----------------|---------------------|
| GET    | /products      | List all products   |
| GET    | /products/{id} | Get product by UUID |
| POST   | /products      | Create new product  |
| PATCH  | /products/{id} | Update product      |
| DELETE | /products/{id} | Delete product      |

### Request body (POST / PATCH)

```json
{
  "productName": "Iphone 14 Pro Max",
  "category": "Smartphone",
  "price": 999.0
}
```

## Running with Docker

> Important: use `postgres:17` instead of `postgres:latest` to avoid breaking changes in PostgreSQL 18+.

```bash
# Start all services (postgres + app)
docker compose up -d

# Stop and remove containers + volumes (clean state)
docker compose down -v
```

| Service  | Container      | Port |
|----------|----------------|------|
| Postgres | springboot-db  | 5436 |
| App      | springboot-app | 8082 |

## Running Locally (without Docker)

```bash
./mvnw spring-boot:run
```

## Building

```bash
./mvnw package -DskipTests
```

---

### Reference Documentation

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.13/maven-plugin)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.5.13/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.13/reference/web/servlet.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.5.13/reference/using/devtools.html)

### Guides

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
