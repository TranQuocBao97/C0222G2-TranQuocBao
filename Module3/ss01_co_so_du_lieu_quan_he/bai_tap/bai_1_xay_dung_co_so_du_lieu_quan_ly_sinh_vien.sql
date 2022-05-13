CREATE DATABASE student_management;

CREATE TABLE student (
id INT PRIMARY KEY,
name VARCHAR (45),
age INT,
country VARCHAR(45)
);

CREATE TABLE class (
id INT PRIMARY KEY,
name VARCHAR (50)
);

CREATE TABLE teacher (
id INT PRIMARY KEY,
name VARCHAR (60),
age INT,
country VARCHAR(40)
);