# 📚 Library Management System (Spring Boot)

A backend **Library Management System** built with **Java Spring Boot** that manages books, members,
borrowing/returning operations, and authentication. This project is designed to demonstrate **clean architecture**,
, **validation**, **exception handling**, and **secure REST APIs** — suitable for academic projects and backend-focused portfolios.

---

## 🚀 Features

- 📖 Book management (CRUD)
- 👤 Member/User management
- 🔐 Authentication & Authorization (JWT / Spring Security)
- 🔄 Borrow & return books
- ✅ Input validation (`@Valid`, `@NotNull`, etc.)
- ⚠️ Global exception handling (`@ControllerAdvice`)
- 🗄️ PostgreSQL database integration

---

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot
- **Security:** Spring Security, JWT
- **Persistence:** Spring Data JPA (Hibernate)
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **Utilities:** Lombok
- **Validation:** Jakarta Validation

---

## 📁 Project Structure

```
src/main/java/com/example/librarymanagement
│
├── controller     # REST Controllers (API layer)
├── service        # Business logic
├── repository     # JPA repositories
├── model          # JPA entities
├── mapper         # Entity ↔ DTO mapping
├── exception      # Custom exceptions & handlers
├── security       # JWT & Spring Security config
└── config         # Application configuration
```

---

## 🔑 API Overview (Sample Endpoints)

| Method | Endpoint | Description |
|------|--------|------------|
| POST | `/api/auth/login` | User login |
| POST | `/api/auth/register` | Register user |
| GET | `/api/books` | Get all books |
| POST | `/api/books` | Add a new book |
| PUT | `/api/books/{id}` | Update book |
| DELETE | `/api/books/{id}` | Delete book |
| POST | `/api/borrow/{bookId}` | Borrow a book |
| POST | `/api/return/{bookId}` | Return a book |

---

## ⚙️ Configuration

Update `application.yml` or `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/library_management
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=your_secret_key
jwt.expiration=86400000
```

---

## ▶️ Running the Project

```bash
# Clone the repository
git clone https://github.com/your-username/library-management-system.git

# Navigate to project
cd library-management-system

# Run the application
mvn spring-boot:run
```

The API will be available at:
```
http://localhost:8080
```

---

## 🧪 Testing

You can test the APIs using:
- Postman
- cURL
---

## 🎯 Learning Goals

This project focuses on:

- Building RESTful APIs with Spring Boot
- Writing clean, maintainable backend code
- Implementing authentication & authorization
- Working with relational databases using JPA

---

## 📌 Future Improvements

- Swagger/OpenAPI documentation
- Role-based access control (Admin/User)
- Pagination & filtering
- Docker support
- Unit & integration tests

---

## 👨‍💻 Author

**Owais Al-Hajri**  
Final-year Software Engineering student  
Focused on Backend Development with Java Spring Boot

- GitHub: https://github.com/owais-alhjri
- LinkedIn: https://linkedin.com/in/owais-al-hajri-541a75265

---

## 📄 License

This project is for educational purposes.

