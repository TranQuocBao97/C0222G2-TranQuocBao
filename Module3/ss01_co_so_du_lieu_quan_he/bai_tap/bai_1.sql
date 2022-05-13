DROP DATABASE IF EXISTS student_management;
CREATE DATABASE IF NOT EXISTS student_management;

USE student_management;

CREATE TABLE student (
id INT PRIMARY KEY,
`name` VARCHAR (16335),
age INT,
country VARCHAR(45)
);

CREATE TABLE class (
id INT PRIMARY KEY,
`name` VARCHAR (50)
);

CREATE TABLE teacher (
id INT PRIMARY KEY,
`name` VARCHAR (60),
age INT,
country VARCHAR(40)
);