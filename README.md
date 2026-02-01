# 🔐 RevPassword Manager (Java + MySQL + JDBC)

A console-based Password Manager application developed using **Core Java, MySQL, and JDBC**.  
This project focuses on **secure password storage**, **user authentication**, and **real-world security practices** such as encryption, OTP verification, and account recovery using security questions.

---

## 🚀 Features

- User Registration & Login with encrypted master password
- Profile Management (update name & email)
- Secure Password Vault (Add, List, Update, Delete, Search passwords)
- View password using **Master Password + OTP verification**
- Strong Random Password Generator using `SecureRandom`
- Security Questions for account recovery
- Forgot Password functionality with secure reset
- Protection against SQL Injection using `PreparedStatement`
- Layered Architecture (Presentation, Service, DAO, Utility)

---

## 🛠️ Tech Stack

| Technology     | Purpose                         |
|----------------|----------------------------------|
| Java           | Core application development     |
| MySQL          | Database storage                |
| JDBC           | Database connectivity           |
| SHA-256        | Password encryption             |
| SecureRandom   | Strong password generation      |

---

## 🏗️ Application Architecture

-Presentation Layer (Console UI)
-          ↓
-Service Layer (Business Logic & Security)
-          ↓
-DAO Layer (JDBC Database Access)
-          ↓
-MySQL Database


This ensures separation of concerns, maintainability, and clean design.

---

## 📊 Database Design (ERD)

### Tables

### 1️⃣ `users`
- `id` (PK)
- `name`
- `email` (unique)
- `master_password` (encrypted)

### 2️⃣ `password_entries`
- `id` (PK)
- `user_id` (FK)
- `account_name`
- `username`
- `encrypted_password`

### 3️⃣ `security_questions`
- `id` (PK)
- `user_id` (FK)
- `question`
- `answer`

---

## 🔐 Security Highlights

- Passwords are never stored in plain text
- OTP expires after single use
- Sensitive operations require re-authentication
- SQL Injection prevented using `PreparedStatement`
- Account recovery via security questions (password never revealed)

---

## ▶️ How to Run the Project

1. Create a MySQL database named:

password_manager

2. Create tables using the provided SQL schema.

3. Update database credentials in:

DBConnection.java

4. Add MySQL JDBC Driver to the project.

5. Run:

PasswordManagerApp.java

---

## 👨‍💻 Author

**Raj**  
Java Backend Developer (Fresher Project)

---

## 📌 Future Enhancements

- AES encryption for reversible password viewing
- Convert to REST API using Spring Boot
- Role-based access control
- GUI/Web interface


The project follows a **layered architecture**:

