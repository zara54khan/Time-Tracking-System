
# TimeTracking – Java Web Application

## Project Description

The **TimeTracking** project is a Java-based Dynamic Web Application developed using **Servlets, JDBC, MySQL, and frontend technologies (HTML, CSS, and JavaScript)**.
The application provides basic task tracking functionality where users can **register, log in, manage tasks, and submit contact messages**, all of which are stored in a MySQL database.

The project demonstrates the integration of:

* Frontend user interfaces
* Backend business logic using Servlets
* Database connectivity using JDBC

---

## Technologies Used

### Backend

* Java (JDK 11 / 17 / 24)
* Java Servlets
* JDBC (MySQL Connector/J)
* Apache Tomcat 9

### Frontend

* HTML5
* CSS3
* JavaScript

### Database

* MySQL 8.x

### Tools

* Eclipse IDE (Enterprise Edition)
* MySQL Workbench

---

## Project Structure

```
TimeTracking/
│
├── src/main/java/
│   └── com/timetracking/
│       ├── auth/
│       │   ├── LoginServlet.java
│       │   └── SignupServlet.java
│       │
│       ├── contact/
│       │   └── ContactServlet.java
│       │
│       ├── task/
│       │   └── TaskServlet.java
│       │
│       └── db/
│           └── DBConnection.java
│
├── src/main/webapp/
│   ├── index.html
│   ├── signup.html
│   ├── logintime.html
│   ├── task.html
│   ├── helpcontact.html
│   ├── use.html
│   └── WEB-INF/
│       └── web.xml
│
└── README.md
```

---

## Backend Components Explanation

### Package: `com.timetracking.db`

#### DBConnection.java

This class is responsible for **establishing a connection between the Java application and the MySQL database**.

Responsibilities:

* Loads the MySQL JDBC driver
* Manages database URL, username, and password
* Provides a reusable method to obtain a database connection

All servlets use this class to interact with the database, ensuring centralized and consistent database access.

---

### Package: `com.timetracking.auth`

#### SignupServlet.java

* Handles user registration requests
* Receives email and password from `signup.html`
* Inserts new user records into the `users` table
* Prevents duplicate registrations using a unique email constraint

#### LoginServlet.java

* Handles user authentication
* Receives login credentials from `logintime.html`
* Validates user data against the `users` table
* Allows access only for valid users

---

### Package: `com.timetracking.task`

#### TaskServlet.java

* Manages task-related operations
* Receives task input from `task.html`
* Stores tasks in the `tasks` table
* Associates tasks with users using their email address

---

### Package: `com.timetracking.contact`

#### ContactServlet.java

* Handles contact form submissions
* Receives name, email, and message from `helpcontact.html`
* Stores messages in the `contacts` table

---

## Frontend Files Explanation

### index.html

* Landing page of the application
* Provides navigation to login and signup pages

### signup.html

* Registration page for new users
* Sends form data to `SignupServlet`

### logintime.html

* Login page for registered users
* Sends credentials to `LoginServlet`

### task.html

* Task management interface
* Allows users to add tasks
* Communicates with `TaskServlet`

### helpcontact.html

* Contact form for user queries
* Sends data to `ContactServlet`

### use.html

* Informational page explaining how to use the application

---

## Configuration File

### web.xml

* Deployment descriptor of the application
* Defines servlet mappings and URL patterns
* Controls application behavior on deployment

---

## Database Schema

### Database Creation

```sql
CREATE DATABASE timetracking;
USE timetracking;
```

### Users Table

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);
```

### Tasks Table

```sql
CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_email VARCHAR(100),
    task TEXT,
    completed BOOLEAN DEFAULT FALSE
);
```

### Contacts Table

```sql
CREATE TABLE contacts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    message TEXT
);
```

---

## Application Workflow

1. User accesses `index.html`
2. New users register using `signup.html`
3. Registered users log in using `logintime.html`
4. Logged-in users manage tasks via `task.html`
5. Users submit queries through `helpcontact.html`
6. All requests are processed by Servlets and stored in MySQL

---

## Learning Outcomes

* Understanding of Servlet lifecycle
* JDBC-based database connectivity
* Frontend–backend integration
* MVC-style separation of concerns
* Practical Java web application development

---

## Authors

* **Rakshita** – Frontend Design (HTML, CSS, JavaScript)
* **Zara** – Backend Development, JDBC, Database Design
* **Saurav Kumar** – Servlet Development and Request Handling
