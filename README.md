# ShareCircle – Rent & Share Platform

ShareCircle is a web application developed using Java and Spring Boot that allows users to browse, rent, and share useful items. The platform helps users discover items across different categories and manage their bookings through a simple web interface.

The goal of ShareCircle is to encourage resource sharing and make useful items accessible without purchasing everything individually.

## 🚀 Features

- **User Authentication:** User registration, login, and authentication using Spring Security.
- **Dashboard:** View and explore available items.
- **Browse Items:** Browse items across different categories.
- **Category Management:** Organize items into categories such as Books, Electronics, Furniture, Sports, Clothing, Kitchen, Tools, and Musical Instruments.
- **Item Details:** View item descriptions, prices, locations, images, and availability status.
- **Booking Management:** Create and manage item bookings.
- **My Bookings:** View personal booking details.
- **Mock Payment:** Demonstration checkout and payment flow.
- **Reviews:** Support reviews for items.
- **Support & Help:** Help, contact, and support pages.
- **Information Pages:** Privacy Policy and Terms & Conditions.
- **Responsive UI:** Server-rendered web pages using Thymeleaf and CSS.
- **Database Migrations:** Manage database schema using Flyway.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Backend programming |
| Spring Boot | Application framework |
| Spring MVC | Web controllers and routing |
| Spring Security | Authentication and access control |
| Spring Data JPA | Database operations |
| Hibernate | ORM |
| MySQL | Relational database |
| Thymeleaf | Server-side HTML rendering |
| HTML & CSS | User interface |
| Flyway | Database migrations |
| Maven | Build and dependency management |
| IntelliJ IDEA | Development environment |
| Git & GitHub | Version control |

## 📁 Project Structure

```text
ShareCircle/
├── src/
│   ├── main/
│   │   ├── java/com/sharecircle/sharecircle/
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── entity/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── SharecircleApplication.java
│   │   └── resources/
│   │       ├── db/migration/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## ⚙️ Prerequisites

Make sure you have installed:

- Java JDK 21
- MySQL Server
- MySQL Workbench
- IntelliJ IDEA or another Java IDE
- Git

## 🔧 Installation and Setup

### 1. Clone the Repository

```bash
git clone https://github.com/AdityaGhodk/ShareCircle.git
cd ShareCircle
```

### 2. Create the MySQL Database

Open MySQL Workbench and execute:

```sql
CREATE DATABASE sharecircle;
```

### 3. Configure the Database Connection

Open:

`src/main/resources/application.properties`

Configure your local MySQL connection:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sharecircle
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Set `DB_USERNAME` and `DB_PASSWORD` in your local environment, or use your own local database credentials.

Keep your real database password and other secrets out of GitHub.

Retain the other required Spring Boot, JPA, and Flyway settings from your project configuration.

### 4. Run the Application

On Windows, open a terminal in the project root and execute:

```powershell
.\mvnw.cmd spring-boot:run
```

Alternatively, open the project in IntelliJ IDEA and run:

`SharecircleApplication.java`

### 5. Open the Application

Once the application starts successfully, open:

[http://localhost:8080](http://localhost:8080)

## 🗄️ Database

ShareCircle uses MySQL to store application data, including:

- Users
- Items
- Categories
- Bookings
- Reviews

Flyway migration scripts are located in:

`src/main/resources/db/migration/`

The database schema is created or updated according to the configured migration scripts.

Database tables and sample data may require additional setup depending on your local configuration.

## 🔐 Security

- User authentication is handled using Spring Security.
- Database credentials should be configured locally.
- Do not commit database passwords, API keys, or other sensitive information.
- The mock payment feature is for demonstration purposes only and does not represent a real payment gateway.

## 🎯 Project Objective

The objective of ShareCircle is to provide a convenient platform for sharing and renting useful items. It helps users discover items they need, manage bookings, and encourages resource reuse.

## 👨‍💻 Author

**Aditya Ghodke**

GitHub: [AdityaGhodk](https://github.com/AdityaGhodk)

Project Repository: [ShareCircle](https://github.com/AdityaGhodk/ShareCircle)

---

*Built as a Java and Spring Boot web application project.*
