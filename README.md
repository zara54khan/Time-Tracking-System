# Time-Tracking-System
The Time Tracking System is a web app that helps users manage tasks and track time spent on each. Users can add, edit, or delete tasks, mark them as completed or pending, and view total time logs. Built with HTML, CSS, and JavaScript for the frontend, and Java Servlets with JDBC for the backend.


# ⏱ Time Tracking Web App (Java + Servlet + JDBC + MySQL)

A simple time-tracking & task management web application that supports:

* User Registration
* User Login
* Contact form submission
* Task UI (Frontend only)
* Usage / Help pages

Backend uses **Java Servlets + JDBC + MySQL** and frontend is in **HTML/CSS/JS**.

---

## 🚀 Features

* Create account (Signup)
* Login using email + password
* Save contact messages to database
* Smooth frontend UI
* Minimal backend complexity
* Very easy to deploy

---

## 🛠 Technologies

**Frontend:** HTML, CSS, JavaScript
**Backend:** Java Servlets, JDBC
**Database:** MySQL
**Server:** Apache Tomcat
**IDE:** VS Code

---

## 📁 Project Structure

```
TimeTrackingProject/
│
├── src/main/java/com/timetrack/
│       Database.java
│       SignupServlet.java
│       LoginServlet.java
│       ContactServlet.java
│
├── src/main/webapp/
│       index.html
│       logintime.html
│       signup.html
│       helpcontact.html
│       help.html
│       task.html
│       use.html
│       WEB-INF/web.xml
│
├── lib/
│       mysql-connector-j.jar
│
└── README.md
```

---

## 🗄️ Database Setup

Run in MySQL:

```sql
CREATE DATABASE time_tracking;
USE time_tracking;

CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(200) UNIQUE,
    password VARCHAR(200)
);

CREATE TABLE contact_messages(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(200),
    message TEXT
);
```

---

## 🔌 Configure Database.java

Update MySQL credentials:

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/time_tracking",
    "root",
    "YOUR_PASSWORD"
);
```

Replace YOUR_PASSWORD with your actual MySQL password.

---

## 🧰 Requirements

* Java JDK
* VS Code
* Apache Tomcat 10+
* MySQL
* mysql-connector-j.jar
* VS Code Java Extensions

---

## ▶️ Running Instructions

1. Open project in VS Code
2. Put `mysql-connector-j.jar` inside `/lib/`
3. Configure database in `Database.java`
4. Create MySQL tables
5. Deploy project on Tomcat
6. Start server
7. Visit in browser:

```
http://localhost:8080/TimeTrackingProject/index.html
```

---

## ✔ Testing

### Signup

* Go to signup page
* Register user
* Check `users` table

### Login

* Enter registered email + password
* Redirects to homepage on success

### Contact Form

* Submit a message
* Check `contact_messages` table

---

## 📌 Notes

* No frameworks required
* Works offline
* Backend is minimal and straightforward
