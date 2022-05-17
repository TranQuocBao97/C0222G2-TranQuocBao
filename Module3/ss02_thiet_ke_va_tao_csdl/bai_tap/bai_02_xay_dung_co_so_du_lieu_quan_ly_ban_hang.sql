drop database if exists bai_02_xay_dung_co_so_du_lieu_quan_ly_ban_hang;
create database if not exists bai_02_xay_dung_co_so_du_lieu_quan_ly_ban_hang;
use bai_02_xay_dung_co_so_du_lieu_quan_ly_ban_hang;
create table customer(
	customer_id int auto_increment,
    customer_name varchar(255),
    customer_age int,
    primary key(customer_id)
);

create table order_don_hang (
	order_id int auto_increment,
    order_date date,
    order_total_price double,
    customer_id int,
    primary key(order_id),
    foreign key(customer_id) references customer(customer_id)
);

create table product(
	product_id int auto_increment,
    product_name varchar(255),
    product_price double,
    primary key(product_id)
);

create table order_detail(
	order_detail_quantity int,
    order_id int,
    product_id int,
    primary key(order_id,product_id),
    foreign key(order_id) references order_don_hang(order_id),
    foreign key(product_id) references product(product_id)
);



