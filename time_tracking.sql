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
