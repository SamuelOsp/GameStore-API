# NeoGame Store API 🎮

A professional Spring Boot REST API and Web Application for a modern video game store. This project features a robust backend architecture with JPA persistence, MariaDB integration, and a dynamic frontend powered by Thymeleaf.

## 🚀 Features

- **Inventory Management**: Full CRUD operations for video games via JPA.
- **Shopping Cart System**: Real-time cart management with AJAX/Fetch API.
- **Automated Seeding**: Intelligent service layer that populates the database with initial products and users if empty.
- **Responsive UI**: Sleek, futuristic dark-themed interface built with Bootstrap 5.
- **Relational Data**: Complex entity mapping between Users, Games, and Purchases.

## 🛠️ Tech Stack

- **Backend**: Java 21, Spring Boot 3.5.7
- **Database**: MariaDB / MySQL
- **ORM**: Spring Data JPA / Hibernate
- **Frontend**: Thymeleaf, Bootstrap 5, Vanilla JS
- **Build Tool**: Maven

## 📋 Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Home page / Product listing |
| GET | `/videojuegos` | Alternative redirect to listing |
| POST | `/checkout` | Processes purchase for a list of game IDs |

## ⚙️ How to Run Locally

1. **Prerequisites**:
   - JDK 21
   - MariaDB/MySQL Server
   - Maven

2. **Database Setup**:
   - Create a database named `videojuegos`.
   - Update `src/main/resources/application.properties` with your credentials or set the following environment variables:
     - `DB_URL`
     - `DB_USERNAME`
     - `DB_PASSWORD`

3. **Build & Run**:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access**:
   - Open `http://localhost:8083` in your browser.

## 👤 Author

**Samuel Ospina** - *Junior Developer*

---
*This project was developed for the "Data Analysis 2" course - Semester 6.*
