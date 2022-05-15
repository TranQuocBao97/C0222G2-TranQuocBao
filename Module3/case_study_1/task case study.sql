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
FROM hop_dong INNER JOIN khach_hang ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
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
where month(hop_dong.ngay_lam_hop_dong)	= 1
|| month(hop_dong.ngay_lam_hop_dong)	= 2
|| month(hop_dong.ngay_lam_hop_dong)	= 3;

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


-- câu 8 cách 3:

select ho_ten
from
(select khach_hang.ho_ten
from khach_hang inner join (select ho_ten, ma_khach_hang from khach_hang) as key_with_ho_ten on khach_hang.ho_ten = key_with_ho_ten.ho_ten
where khach_hang.ho_ten = key_with_ho_ten.ho_ten && khach_hang.ma_khach_hang != key_with_ho_ten.ma_khach_hang) as bang_trung_ten_khac_ma_khach_hang
group by ho_ten;


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


