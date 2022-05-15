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



