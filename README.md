# ShareCircle – Rent & Share Platform

ShareCircle is a web application built with Java and Spring Boot that allows users to browse items, explore categories, and manage item bookings. The platform is designed to encourage sharing and renting items instead of purchasing everything individually.

## 🚀 Features

- **User Authentication:** User registration and login.
- **Browse Items:** Explore available items across different categories.
- **Category Management:** Organize items into categories such as Books, Electronics, Furniture, Sports, Clothing, Kitchen, Tools, and Musical Instruments.
- **Item Management:** Store item details, descriptions, prices, locations, images, and availability status.
- **Booking Management:** Create and manage item bookings.
- **Reviews:** Support reviews for items.
- **Responsive Web Pages:** Server-rendered pages using Thymeleaf.
- **Database Migrations:** Manage database schema using Flyway.
- **Mock Payment:** A demonstration checkout/payment flow.

## 🛠️ Technologies Used

- **Backend:** Java 21, Spring Boot
- **Frontend:** HTML, CSS, Thymeleaf
- **Database:** MySQL
- **ORM:** Spring Data JPA, Hibernate
- **Security:** Spring Security
- **Database Migration:** Flyway
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA
- **Version Control:** Git and GitHub

## 📁 Project Structure

```text
ShareCircle/
├── .mvn/
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
- MySQL Server and MySQL Workbench
- IntelliJ IDEA (or another Java IDE)
- Git

## 🔧 Installation and Setup

### 1. Clone the repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
cd ShareCircle
```

Replace `YOUR_GITHUB_REPOSITORY_URL` with your repository's HTTPS URL.

### 2. Create the MySQL database

Open MySQL Workbench and execute:

```sql
CREATE DATABASE sharecircle;
```

### 3. Configure the database connection

Configure your database connection in `src/main/resources/application.properties`.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sharecircle
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Set `DB_USERNAME` and `DB_PASSWORD` in your local environment, or configure your local credentials securely. Keep real passwords out of GitHub.

Retain the other required Spring Boot, JPA, and Flyway settings from your project configuration.

### 4. Run the application

On Windows, open a terminal in the project root and execute:

```powershell
.\mvnw.cmd spring-boot:run
```

Alternatively, open the project in IntelliJ IDEA and run `SharecircleApplication.java`.

### 5. Open the application

Once the application starts successfully, open:

http://localhost:8080

## 🗄️ Database

The application uses MySQL to store application data, including users, items, bookings, reviews, and categories.

Flyway migration scripts are located in:

`src/main/resources/db/migration/`

The database schema is created or updated according to the configured migration scripts.

**Note:** Database tables and sample data may require additional setup depending on your local configuration.

## 🔐 Security

- Do not commit database passwords, API keys, or other secrets.
- Use your own local database credentials.
- The mock payment feature is for demonstration purposes and does not represent a real payment gateway.

## 🎯 Project Objective

The objective of ShareCircle is to provide a convenient platform for sharing and renting useful items, helping users discover items they need while encouraging resource reuse.

## 👨‍💻 Author

**Aditya Ghodke**

GitHub: [AdityaGhodk](https://github.com/AdityaGhodk)

---

*Built as a Java and Spring Boot web application project.*
