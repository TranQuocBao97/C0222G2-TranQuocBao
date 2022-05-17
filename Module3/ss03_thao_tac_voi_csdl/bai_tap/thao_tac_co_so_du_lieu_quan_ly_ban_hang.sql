use bai_02_xay_dung_co_so_du_lieu_quan_ly_ban_hang;

insert into Customer (customer_name,customer_age)
value('Minh Quan',10),
('Ngoc Oanh',20),
('Hong Ha',50);

insert into order_don_hang (customer_id,order_date)
value (1,'2006-03-21'),
(2,'2006-03-23'),
(1,'2006-03-16');
 
 insert into product (product_name,product_price)
 value('May Giat',3),
 ('Tu Lanh',5),
 ('Dieu Hoa',7),
 ('Quat',1),
 ('Bep Dien',2);
 
 insert into order_detail (order_id,product_id,order_detail_quantity)
 value(1,1,3),
 (1,3,7),
 (1,4,2),
 (2,1,1),
 (3,1,8),
 (2,5,4),
 (2,3,3);
 -- ---------
 
 
 select order_don_hang.order_id, order_don_hang.order_date, product.product_price
 from order_don_hang
 inner join order_detail on order_don_hang.order_id = order_detail.order_id
 inner join product on order_detail.product_id = product.product_id;
 
 
 -- ---------
 
 
select Customer.customer_name , Product.product_name
from customer inner join
order_don_hang on customer.customer_id = order_don_hang.customer_id
inner join order_detail on order_don_hang.order_id = order_detail.order_id
inner join product on order_detail.product_id = product.product_id;

-- ----------

select customer.customer_name
from customer left join
order_don_hang on customer.customer_id = order_don_hang.customer_id
where order_don_hang.order_id is null;

-- ----------

select order_don_hang.order_id, order_don_hang.order_date, sum(tong_tien_tung_mon_hang) as order_total_price
from order_don_hang inner join
(select order_detail.order_id, (order_detail.order_detail_quantity*product.product_price) as tong_tien_tung_mon_hang
from order_detail inner join
product on order_detail.product_id = product.product_id) as table_bai_tap
on order_don_hang.order_id = table_bai_tap.order_id
group by order_id


