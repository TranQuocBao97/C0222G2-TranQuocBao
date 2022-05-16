create database bai_02_chuyen_doi_erd_sang_mo_hinh_quan_he;


create table nha_cc(
	ma_nha_cc varchar(255),
	ten_nha_cung_cap varchar(255),
	dia_chi varchar(255),
	primary key(ma_nha_cc)
);

create table don_dh(
	so_dh int,
	ngay_dh date,
    ma_nha_cc varchar(255),
	primary key(so_dh),
    foreign key(ma_nha_cc) references nha_cc(ma_nha_cc)
);


create table vat_tu(
	ma_vtu varchar(255),
    ten_vtu varchar(255),
    primary key(ma_vtu)
);

create table don_dh_chi_tiet_vat_tu(
	so_dh int,
    ma_vtu varchar(255),
    primary key(so_dh,ma_vtu),
    foreign key(so_dh) references don_dh(so_dh),
    foreign key(ma_vtu) references vattu(ma_vtu)

);


create table phieu_nhap(
	so_pn int,
    ngay_nhap date,
    primary key(so_pn)
);

create table vat_tu_chi_tiet_phieu_nhap(
	dg_nhap varchar(255),
    sl_nhap int,
    ma_vtu varchar(255),
    so_pn int,
    primary key(ma_vtu,so_pn),
    foreign key(ma_vtu) references vat_tu(ma_vtu),
    foreign key(so_pn) references phieu_nhap(so_pn)
);


create table phieu_xuat(
	so_px int,
    ngay_xuat date,
    primary key(so_px)
);

create table vat_tu_chi_tiet_phieu_xuat(
	dg_xuat varchar(255),
    sl_xuat int,
    ma_vtu varchar(255),
    so_px int,
    primary key(ma_vtu,so_px),
    foreign key(ma_vtu) references vat_tu(ma_vtu),
    foreign key(so_px) references phieu_xuat(so_px)
);

create table dien_thoai(
	so_dien_thoai int,
	ma_nha_cc varchar(255),
	primary key(so_dien_thoai),
	foreign key(ma_nha_cc) references nha_cc(ma_nha_cc)
);