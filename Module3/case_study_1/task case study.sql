USE quan_ly_khu_nghi_duong_farama;
-- câu 2:
SELECT * 
FROM nhan_vien
WHERE ho_va_ten REGEXP '^[HTK].{1,14}$';


-- câu 3 cách 1:
SELECT * 
FROM khach_hang
WHERE UNIX_TIMESTAMP(DATE_SUB(curdate(), INTERVAL 18 YEAR))>UNIX_TIMESTAMP(ngay_sinh)
AND UNIX_TIMESTAMP(DATE_SUB(curdate(), INTERVAL 50 YEAR))<UNIX_TIMESTAMP(ngay_sinh)
AND (dia_chi LIKE '%Đà Nẵng%' || dia_chi LIKE '%Quảng Trị%');
--  câu 3 cách 2:
SELECT * 
FROM khach_hang
WHERE UNIX_TIMESTAMP(DATE_SUB(curdate(), INTERVAL 18 YEAR))>UNIX_TIMESTAMP(ngay_sinh)
AND UNIX_TIMESTAMP(DATE_SUB(curdate(), INTERVAL 50 YEAR))<UNIX_TIMESTAMP(ngay_sinh)
AND (INSTR(dia_chi, 'Đà Nẵng') || INSTR(dia_chi, 'Quảng Trị'));


-- câu 4:

SELECT khach_hang.ma_khach_hang, khach_hang.ho_ten, COUNT(hop_dong.ma_khach_hang) AS so_lan_dat_phong 
FROM hop_dong 
INNER JOIN khach_hang ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
WHERE khach_hang.ma_loai_khach = 1
GROUP BY ma_khach_hang
ORDER BY so_lan_dat_phong ASC;

-- câu 5:
SELECT khach_hang.ma_khach_hang,khach_hang.ho_ten,loai_khach.ten_loai_khach, IFNULL(hop_dong.ma_hop_dong,UUID()) AS ma_hop_dong_with_null
, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, (IFNULL(dich_vu.chi_phi_thue,0)+(IFNULL(hop_dong_chi_tiet.so_luong,0)*IFNULL(dich_vu_di_kem.gia,0))) as tong_tien
FROM (((loai_khach INNER JOIN khach_hang ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach) 
LEFT JOIN (dich_vu INNER JOIN hop_dong ON dich_vu.ma_dich_vu=hop_dong.ma_dich_vu)
ON khach_hang.ma_khach_hang=hop_dong.ma_khach_hang)
LEFT JOIN (dich_vu_di_kem INNER JOIN hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem=hop_dong_chi_tiet.ma_hop_dong_chi_tiet)
ON hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong)
GROUP BY ma_hop_dong_with_null
ORDER BY ma_khach_hang ASC;

-- câu 6:

create view full_ma_dich_vu_quy_1 as
select dich_vu.ma_dich_vu
FROM dich_vu INNER JOIN hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where month(hop_dong.ngay_lam_hop_dong)	<=3
and year(hop_dong.ngay_lam_hop_dong) = 2021;

create view ma_dich_vu_quy_1 as
select *
from full_ma_dich_vu_quy_1
group by ma_dich_vu;

select dich_vu.ma_dich_vu,dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.chi_phi_thue,loai_dich_vu.ten_loai_dich_vu
from (loai_dich_vu INNER JOIN dich_vu ON loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu)
left join ma_dich_vu_quy_1 on dich_vu.ma_dich_vu = ma_dich_vu_quy_1.ma_dich_vu
where ma_dich_vu_quy_1.ma_dich_vu is null;

-- câu 7:

CREATE OR REPLACE VIEW ma_dich_vu_2020 as
select dich_vu.ma_dich_vu
FROM dich_vu INNER JOIN hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where year(hop_dong.ngay_lam_hop_dong)	= 2020;

CREATE OR REPLACE VIEW ma_dich_vu_2021 as
select dich_vu.ma_dich_vu
FROM dich_vu INNER JOIN hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where year(hop_dong.ngay_lam_hop_dong)	= 2021;

CREATE OR REPLACE VIEW ma_dich_vu_only_2020 as
select ma_dich_vu_2020.ma_dich_vu
from ma_dich_vu_2020 left join ma_dich_vu_2021 on ma_dich_vu_2020.ma_dich_vu = ma_dich_vu_2021.ma_dich_vu
where ma_dich_vu_2021.ma_dich_vu is null
group by ma_dich_vu_2020.ma_dich_vu;

select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from ma_dich_vu_only_2020 left join (loai_dich_vu inner join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu) 
on ma_dich_vu_only_2020.ma_dich_vu = dich_vu.ma_dich_vu;


-- câu 8 cách 1:
select new_table.ho_ten
from(select ho_ten, count(ho_ten) as so_lan_trung_ten
from khach_hang
group by ho_ten) as new_table
where new_table.so_lan_trung_ten > 1;


-- câu 8 cách 2:
create or replace view ho_ten_khong_trung as
select ho_ten, ma_khach_hang
from khach_hang
group by ho_ten;

select khach_hang.ho_ten
from khach_hang left join ho_ten_khong_trung on khach_hang.ma_khach_hang = ho_ten_khong_trung.ma_khach_hang
where ho_ten_khong_trung.ma_khach_hang is null;

-- cách 2 làm lại :
select DISTINCT ho_ten
from khach_hang;

-- câu 8 cách 3:

select ho_ten
from
(select khach_hang.ho_ten
from khach_hang inner join (select ho_ten, ma_khach_hang from khach_hang) as key_with_ho_ten on khach_hang.ho_ten = key_with_ho_ten.ho_ten
where khach_hang.ho_ten = key_with_ho_ten.ho_ten && khach_hang.ma_khach_hang != key_with_ho_ten.ma_khach_hang) as bang_trung_ten_khac_ma_khach_hang
group by ho_ten;

-- cách 3 làm lại:

select ho_ten from khach_hang
union
select ho_ten from khach_hang;

-- câu 9:
select month(hop_dong.ngay_lam_hop_dong) as thang, count(hop_dong.ma_khach_hang) as so_luong_khach_hang
from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = 2021
group by thang
order by thang;


-- câu 10:
select hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem
from hop_dong left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by hop_dong.ma_hop_dong;

-- câu 11:

select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem
from
((loai_khach inner join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach)
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang)
inner join
(dich_vu_di_kem inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem)
on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
where instr(khach_hang.dia_chi, 'Vinh') or instr(khach_hang.dia_chi, 'Quảng Ngãi');

-- câu 12:

create or replace view dich_vu_3_thang_cuoi_2020 as
select hop_dong.ma_hop_dong, dich_vu.ten_dich_vu
from
dich_vu inner join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where year(hop_dong.ngay_lam_hop_dong) = 2020
and (month(hop_dong.ngay_lam_hop_dong) >=10);

create or replace view dich_vu_6_thang_dau_2021 as
select hop_dong.ma_hop_dong, dich_vu.ten_dich_vu
from
dich_vu inner join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where year(hop_dong.ngay_lam_hop_dong) = 2021
and (month(hop_dong.ngay_lam_hop_dong) <= 6);

create or replace view dich_vu_only_3_thang_cuoi_2020 as
select dich_vu_3_thang_cuoi_2020.ma_hop_dong, dich_vu_3_thang_cuoi_2020.ten_dich_vu
from dich_vu_3_thang_cuoi_2020 left join dich_vu_6_thang_dau_2021
on dich_vu_3_thang_cuoi_2020.ten_dich_vu = dich_vu_6_thang_dau_2021.ten_dich_vu
where dich_vu_6_thang_dau_2021.ma_hop_dong is null;

create or replace view table_12 as
select hop_dong.ma_hop_dong, nhan_vien.ho_va_ten, khach_hang.ho_ten
, khach_hang.so_dien_thoai,dich_vu.ma_dich_vu , dich_vu.ten_dich_vu, sum(so_luong) as so_luong_dich_vu_di_kem, hop_dong.tien_dat_coc
from 
(dich_vu inner join (nhan_vien inner join (khach_hang inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang)
on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien) on dich_vu.ma_dich_vu=hop_dong.ma_dich_vu )
left join (dich_vu_di_kem inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem)
on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by hop_dong.ma_hop_dong
order by ma_hop_dong;

select table_12.ma_hop_dong, table_12.ho_va_ten as ho_ten_nhan_vien , table_12.ho_ten as ho_ten_khach_hang , table_12.so_dien_thoai as sdt_nhan_vien
, table_12.ma_dich_vu, table_12.ten_dich_vu, table_12.so_luong_dich_vu_di_kem, table_12.tien_dat_coc
from dich_vu_only_3_thang_cuoi_2020 inner join table_12 on dich_vu_only_3_thang_cuoi_2020.ma_hop_dong = table_12.ma_hop_dong;


-- câu 13:

create or replace view tong_so_luong_dich_vu_di_kem as
select table_13.ma_hop_dong, table_13.ma_dich_vu_di_kem, table_13.ten_dich_vu_di_kem, sum(table_13.so_luong) as so_luong_dich_vu_di_kem
from
(select hop_dong_chi_tiet.ma_hop_dong, dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, hop_dong_chi_tiet.so_luong
from dich_vu_di_kem inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem) as table_13
group by table_13.ma_dich_vu_di_kem;

select tong_so_luong_dich_vu_di_kem.ma_dich_vu_di_kem, tong_so_luong_dich_vu_di_kem.ten_dich_vu_di_kem, tong_so_luong_dich_vu_di_kem.so_luong_dich_vu_di_kem
from
tong_so_luong_dich_vu_di_kem inner join
(select max(tong_so_luong_dich_vu_di_kem.so_luong_dich_vu_di_kem) as so_luong_dich_vu_di_kem_max
from tong_so_luong_dich_vu_di_kem) as max on tong_so_luong_dich_vu_di_kem.so_luong_dich_vu_di_kem = max.so_luong_dich_vu_di_kem_max;


-- câu 14:

create or replace view dich_vu_di_kem_chi_duoc_dung_1_lan as
select *
from tong_so_luong_dich_vu_di_kem
where tong_so_luong_dich_vu_di_kem.so_luong_dich_vu_di_kem = 1;

create or replace view table_14 as
select hop_dong.ma_hop_dong, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem, dich_vu_di_kem.ma_dich_vu_di_kem
from
((kieu_thue inner join (loai_dich_vu inner join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu) on kieu_thue.ma_kieu_thue = dich_vu.ma_kieu_thue)
right join (hop_dong inner join (dich_vu_di_kem inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem) on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong)
on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu);

select dich_vu_di_kem_chi_duoc_dung_1_lan.ma_hop_dong, table_14.ten_loai_dich_vu, table_14.ten_dich_vu_di_kem, dich_vu_di_kem_chi_duoc_dung_1_lan.so_luong_dich_vu_di_kem as so_lan_su_dung
from dich_vu_di_kem_chi_duoc_dung_1_lan inner join table_14 on dich_vu_di_kem_chi_duoc_dung_1_lan.ma_hop_dong = table_14.ma_hop_dong
where dich_vu_di_kem_chi_duoc_dung_1_lan.ten_dich_vu_di_kem = table_14.ten_dich_vu_di_kem
group by ten_dich_vu_di_kem;


-- câu 15:

select nhan_vien.ma_nhan_vien, nhan_vien.ho_va_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai,
nhan_vien.dia_chi, count(nhan_vien.ma_nhan_vien) as so_luong_hop_dong
from 
(trinh_do inner join (bo_phan inner join nhan_vien on bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan)
on trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do) 
inner join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where year(hop_dong.ngay_lam_hop_dong) = 2020 or year(hop_dong.ngay_lam_hop_dong) = 2021
group by ma_nhan_vien
having so_luong_hop_dong <=3;

-- câu 16:

select nhan_vien.ma_nhan_vien from nhan_vien
where nhan_vien.ma_nhan_vien not in (select * from
(select nhan_vien.ma_nhan_vien
from 
nhan_vien left join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where year(hop_dong.ngay_lam_hop_dong) >= 2019
|| year(hop_dong.ngay_lam_hop_dong) <= 2021
group by nhan_vien.ma_nhan_vien) year_table);	

-- xóa :
set sql_safe_updates = 0;
delete from nhan_vien
where 
nhan_vien.ma_nhan_vien not in 
(select * from
(select nhan_vien.ma_nhan_vien
from 
nhan_vien left join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where year(hop_dong.ngay_lam_hop_dong) >= 2019
|| year(hop_dong.ngay_lam_hop_dong) <= 2021
group by nhan_vien.ma_nhan_vien) nhan_vien_co_hop_dong_tu_2019_den_2021);
set sql_safe_updates = 1;

-- bài 17 (nâng mỗi mã khách hàng lên 1 cấp):



update khach_hang
set khach_hang.ma_loai_khach = (khach_hang.ma_loai_khach-1)
where (khach_hang.ma_loai_khach > 1) 
and (khach_hang.ma_khach_hang in ( select abc.ma_khach_hang from
(select table_17.ma_khach_hang, sum(tong_tien_cua_mot_dich_vu_di_kem)+((to_days(table_17.ngay_ket_thuc) - to_days(table_17.ngay_lam_hop_dong)+1)*table_17.chi_phi_thue) as tong_tien
from
(select khach_hang.ma_khach_hang, hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong
, hop_dong.ngay_ket_thuc, dich_vu_di_kem.ten_dich_vu_di_kem, hop_dong_chi_tiet.so_luong, dich_vu_di_kem.gia, (ifnull(so_luong,0)*ifnull(gia,0)) as tong_tien_cua_mot_dich_vu_di_kem
, dich_vu.chi_phi_thue
from
(khach_hang inner join 
(dich_vu inner join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu)
on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang)
left join
(dich_vu_di_kem inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem)
on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
order by ma_khach_hang) as table_17
group by table_17.ma_khach_hang
having tong_tien >= 10000000
order by table_17.ma_khach_hang) abc));



-- bài 18:

delete from khach_hang
where khach_hang.ma_khach_hang in 
(select table_18.ma_khach_hang from (select khach_hang.ma_khach_hang, khach_hang.ho_ten
from khach_hang
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where year(hop_dong.ngay_lam_hop_dong) < 2021) as table_18);

-- bài 19:
set sql_safe_updates = 0;
update dich_vu_di_kem
set dich_vu_di_kem.gia = dich_vu_di_kem.gia*2
where dich_vu_di_kem.ma_dich_vu_di_kem in
(select table_19.ma_dich_vu_di_kem from (select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.gia ,sum(so_luong) as tong_lan_su_dung_2020
from dich_vu_di_kem inner join
hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
inner join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
where year(hop_dong.ngay_lam_hop_dong) = 2020
group by ma_dich_vu_di_kem
having tong_lan_su_dung_2020 > 10) as table_19);
set sql_safe_updates = 1;


-- bài 20:

select khach_hang.ma_khach_hang as id, khach_hang.ho_ten, khach_hang.email, khach_hang.so_dien_thoai, khach_hang.ngay_sinh, khach_hang.dia_chi from khach_hang
union all
select nhan_vien.ma_nhan_vien, nhan_vien.ho_va_ten, nhan_vien.email, nhan_vien.so_dien_thoai, nhan_vien.ngay_sinh, nhan_vien.dia_chi  from nhan_vien