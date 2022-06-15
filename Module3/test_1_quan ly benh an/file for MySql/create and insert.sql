create database quan_ly_thu_vien;
use quan_ly_thu_vien;

drop database quan_ly_thu_vien;



create table sach(
 ma_sach varchar(255) primary key,
 ten_sach varchar(255),
 tac_gia varchar(255),
 mo_ta varchar(255),
 so_luong int
);

insert into sach (ma_sach,ten_sach,tac_gia,mo_ta,so_luong)
value
('S-0001','Số đỏ','Đồng Lân','Dỡ',10),
('S-0002','Số đen','Tân Tiến','Hay',10);


create table hoc_sinh(
 ma_hoc_sinh int auto_increment primary key,
 ho_ten varchar(255),
 lop varchar(255)
);

insert into hoc_sinh (ho_ten,lop)
value
('Trần Quất Lâm', '10A2'),
('Nguyễn Tấn','11B1');


create table the_muon_sach(
ma_muon_sach varchar(255) primary key,
trang_thai boolean,
ngay_muon date,
ngay_tra date,
ma_hoc_sinh int,
ma_sach varchar(255),
foreign key(ma_sach) references sach (ma_sach),
foreign key(ma_hoc_sinh) references hoc_sinh(ma_hoc_sinh)
);

insert into the_muon_sach (ma_muon_sach,trang_thai,ngay_muon,ngay_tra,ma_hoc_sinh,ma_sach)
value
('MS-0001',true,'2022-05-22','2022-05-24',1,'S-0001'),
('MS-0002',true,'2022-05-28','2022-05-30',2,'S-0002');

insert into sach (ma_sach,ten_sach,tac_gia,mo_ta,so_luong)
value
('S-0003','Thu Cuối','Mr Tee','Dỡ',0);
