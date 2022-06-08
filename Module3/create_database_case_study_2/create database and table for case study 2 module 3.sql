drop database if exists control_furama;
create database if not exists control_furama;
use control_furama;

create table employee_position(
 employee_position_id int not null auto_increment,
 employee_position_name varchar(45) not null,
 primary key (employee_position_id)
);

create table education_degree(
education_degree_id int not null auto_increment,
education_degree_name varchar(45) not null,
primary key (education_degree_id)
);
create table division(
division_id int not null auto_increment,
division_name varchar(45) not null,
primary key (division_id)
);

create table role(
role_id int not null auto_increment,
role_name varchar(45) not null,
primary key (role_id)
);

create table user(
username varchar(45) not null,
password varchar(45) not null,
primary key (username)
);

create table user_role(
role_id int,
username varchar(45),
primary key (role_id,username),
foreign key (role_id) references role(role_id),
foreign key (username) references user(username)
);

create table employee(
employee_id int primary key not null auto_increment,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_id_card varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45) not null,
employee_email varchar(45) not null,
employee_address varchar(45) not null,
employee_position_id int,
education_degree_id int,
division_id int,
username varchar(255) unique,
foreign key (employee_position_id) references employee_position(employee_position_id),
foreign key (education_degree_id) references education_degree(education_degree_id),
foreign key (division_id) references division(division_id),
foreign key (username) references user(username)
);

create table customer_type(
customer_type_id int primary key auto_increment,
customer_type_name varchar(45) not null
);

create table customer(
customer_id int primary key auto_increment,
customer_name varchar(45) not null,
customer_birthday date not null,
customer_gender bit(1) not null,
customer_id_card varchar(45) not null,
customer_phone varchar(45) not null,
customer_email varchar(45) not null,
customer_address varchar(45) not null,
customer_type_id int,
foreign key (customer_type_id) references customer_type(customer_type_id)
);

create table rent_type(
rent_type_id int primary key auto_increment,
rent_type_name varchar(45) not null
);

create table service_type(
service_type_id int primary key auto_increment,
service_type_name varchar(45) not null
);

create table service(
service_id int primary key auto_increment,
service_name varchar(45) not null,
service_area int not null,
service_cost double not null,
service_max_people int,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
rent_type_id int,
service_type_id int,
foreign key (rent_type_id) references rent_type(rent_type_id),
foreign key (service_type_id) references service_type(service_type_id)
);


create table contract(
contract_id int primary key auto_increment,
contract_start_date date not null,
contract_end_date date not null,
contract_deposit double not null,
employee_id int,
customer_id int,
service_id int,
foreign key (employee_id) references employee(employee_id),
foreign key (customer_id) references customer(customer_id),
foreign key (service_id) references service(service_id)
);

create table attach_service(
attach_service_id int primary key auto_increment,
attach_service_name varchar(45) not null,
attach_service_cost double not null,
attach_service_unit int not null,
attach_service_status varchar(45)
);

create table contract_detail(
contract_detail_id int primary key auto_increment,
quantity int not null,
contract_id int,
attach_service_id int,
foreign key (contract_id) references contract(contract_id),
foreign key (attach_service_id) references attach_service(attach_service_id)
);
