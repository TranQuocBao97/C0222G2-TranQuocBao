CREATE DATABASE demo;
USE demo;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
insert into users(name, email, country) values('Bung Binh','bungbinh@che.uk','My');
insert into users(name, email, country) values('Ngao','ngaote@che.uk','Lao');
insert into users(name, email, country) values('My','nte@che.uk','Han');
insert into users(name, email, country) values('AoKy','kante@che.uk','Pinoy');