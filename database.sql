create database Shop;
use Shop;

create table Account
(
	id int not null AUTO_INCREMENT primary key,
	username varchar(50) ,
	password varchar(50) ,
	role boolean
);

create table DanhMuc
(
	MaDM int not null AUTO_INCREMENT primary key,
	TenDM varchar(100) not null
);

create table SanPham
(
	MaSP int not null AUTO_INCREMENT primary key,
	TenSP varchar(50) not null,
	DonGia double,
	Hinh varchar(100),
	MaDM int references DanhMuc(MaDM)
);

create table KhachHang
(
	MaKH int not null AUTO_INCREMENT primary key,
	TenKH varchar(50) not null,
	DiaChi varchar(100),
	DienThoai varchar(15)
);

create table DonHang
(
	MaDH int not null AUTO_INCREMENT primary key,
	NgayDatHang date,
	MaKH int references KhachHang(MaKH)
);

create table ChiTietDonHang
(
	MaDH int references DonHang(MaDH),
	MaSP int references SanPham(MaSP),
	DonGia double,
	SoLuong int,
	primary key(MaDH,MaSP)
);

insert into Account values
(null,'admin','admin',1),
(null,'teo','123456',0),
(null,'minh','123456',0),
(null,'nhan','123456',0);

insert into KhachHang values
(null,'Đinh Đạt Thông','Trần Duy Hưng','01356789'),
(null,'Dinh Nokia','Sầm Sơn','01234789');

insert into DanhMuc values
(null,'Điện Thoại'),
(null,'Đồ Gia Dụng');

insert into SanPham values
(null,'Iphone 11',21690,'iphone 11.jpg',1),
(null,'Iphone 11 Pro',42990,'iphone 11pro.jpg',1),
(null,'Iphone X',17000,'iphone x.jpg',1),
(null,'Iphone XS',31690,'iphone xs.jpg',1),
(null,'Note 10',22990,'note 10.jpg',1),
(null,'Samsung S10',13290,'samsung s10.jpg',1),
(null,'Samsung S20',29990,'samsung s20.jpg',1),
(null,'Samsung Fold',50000,'samsung fold.jpg',1);


insert into DonHang values
(null,'12/12/2018',2),
(null,'12/10/2017',1);

insert into ChiTietDonHang values
(1,2,13000,4),
(2,1,190000,5);
