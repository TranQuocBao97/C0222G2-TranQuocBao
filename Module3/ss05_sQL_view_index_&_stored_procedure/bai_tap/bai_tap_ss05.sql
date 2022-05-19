create database ss_05;
create table products_05(
	id int primary key auto_increment,
    productCode varchar(255),
    productName varchar(255),
    productPrice int,
    productAmount int,
    productDescription varchar(255),
    productStatus varchar(255)
);

insert into products_05(productCode,productName,productPrice,productAmount,productDescription,productStatus)
value ('A1-01','Rice',100000,10,'gao ngon','con hang'),
('A1-02','bim bim',5000,10,'re','con hang'),
('A1-03','xe dap',2000000,10,'xe 2 banh','con hang'),
('A1-04','nuoc ngot',100000,10,'co gas','con hang');


select * from products_05;

-- ----------------
CREATE UNIQUE INDEX productCode_idx ON products_05(productCode);
CREATE UNIQUE INDEX products_idx ON products_05(productName,productPrice);
EXPLAIN select id from products_05
where productCode = 'A1-03';
drop index productCode_idx on products_05;

-- ----------------
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view products_05_view as
select productCode,productName,productPrice,productStatus
from products_05;

select * from products_05_view ;

-- sửa đổi view
insert into products_05_view
value('B1-01','day dien','30000','het hang');

--  xoá view
drop view products_05_view;

-- ---------------------

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
create procedure display_products_05()
begin
select * from products_05;
end //
DELIMITER ;

call display_products_05();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
create procedure add_product_05(in code varchar(255),in name varchar(255),in price int,in amount int,in description varchar(255),in status varchar(255))
begin
insert into products_05(productCode,productName,productPrice,productAmount,productDescription,productStatus)
value(code, name, price, amount, description, status);
end //
DELIMITER ;

call add_product_05('B2-01','xa phong',4000,5,'xa phong oganic','con hang');

select * from products_05;

-- Tạo store procedure sửa thông tin sản phẩm theo id

DELIMITER // 
create procedure update_product_05_by_id(in search_id int,in code varchar(255),in name varchar(255),in price int,in amount int,in description varchar(255),in status varchar(255))
begin
update products_05
set productCode = code,
    productName = name,
    productPrice = price,
    productAmount = amount,
    productDescription = description,
    productStatus = status
where id = search_id;
end //
DELIMITER ;

call update_product_05_by_id(5,'B2-02','xa phong 02',8000,10,'xa phong oganic','con hang');

select * from products_05;

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER //
create procedure delete_product_05_by_id(in id_for_delete int)
begin
delete from products_05
where id = id_for_delete;
end //
DELIMITER ;

call delete_product_05_by_id(6);
select * from products_05;