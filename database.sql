-- Police Complaint Management System Database

CREATE DATABASE police_complaints_db;
USE police_complaints_db;

CREATE TABLE complaints (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    address VARCHAR(255),
    complaint TEXT
);
