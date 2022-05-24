use master
create database quanlilaodong
use quanlilaodong

EXEC msdb.dbo.sp_delete_database_backuphistory @database_name = N'quanlilaodong'
GO
USE [master]
GO
ALTER DATABASE quanlilaodong SET  SINGLE_USER WITH ROLLBACK IMMEDIATE
GO
uSE [master]
GO
DROP DATABASE quanlilaodong
GO
----------------------------------------------------------------------
create table duAn(
maDuAn AS 'DA' + convert(varchar(10),ID) PERSISTED primary key,
tenDuAn nvarchar(50),
chuDauTu nvarchar(50),
trangThai varchar(50)null,
ngayCapPhep date,
ngayKhoiCong date null,
ngayHoanThanh date null,
diaDiemThiCong nvarchar(50),
soLuongNhanSu int,
ghiChu nvarchar(50) null,
ID INT IDENTITY(1,1)
)
----------------------------------------------------------------------

create table congViec(
maCongViec  as 'VV' + convert(varchar(10),ID) PERSISTED primary key,
maDuAn varchar(12),
soLuongNhanSuCV int,
CongViec nvarchar(50),
soLuongNhanSuHienCo int,
ngayThamGiaCongviec date null,
ngayHoanThanhCongviec date null,
trangthaicv varchar(50),
ID INT IDENTITY(1,1)
)
----------------------------------------------------------------------
create table nhanSu(
maNhanSu AS 'NS' + convert(varchar(10),ID) PERSISTED primary key,
maChucVu varchar(12),
hoTen nvarchar(50),
gioiTinh nvarchar(12),
ngaySinh date,
tenPhongBan nvarchar(50),
maPhongBan varchar(4),
queQuan nvarchar(50),
diaChiLienHe nvarchar(50),
trangThai int,
--sdt int,
sdt  varchar(15),
loaiNhanSu nvarchar(30),
soCmnd int,
ID INT  IDENTITY(1,1)
)
----------------------------------------------------------------------
create table phongBan(
maPhongBan varchar(4) primary key,
tenPhongBan nvarchar(50),
soLuongNhanSu int,
truongPhong nvarchar(50)
)

----------------------------------------------------------------------

create table bangCong(
mabangcong  as 'BC' + convert(varchar(10),ID) PERSISTED primary key,
maNhanSu varchar(12),
maCongViec varchar(12),
ngayThamGiaCongTrinh date null,
ngayHoanThanhCongTrinh date null,
SoNgayCong float null,
ID INT IDENTITY(1,1)
)

----------------------------------------------------------------------
create table NgayCongNhanSu(
maNgayCong AS 'NC' + convert(varchar(10),ID) PERSISTED primary key,
maNhanSu varchar(12),
maCongViec varchar(12),
ngayThamGiaCongViec date null,
ngayHoanThanhCongViec date null,
SoNgayCong float null,
ID INT IDENTITY(1,1)
)
----------------------------------------------------------------------
create table chucVu(
maChucVu AS 'CV' + convert(varchar(10),ID) PERSISTED primary key,
tenNhanVien nvarchar(50),
chucVu nvarchar(50),
vaiTro nvarchar(50),
ID INT IDENTITY(1,1)
)
----------------------------------------------------------------------
create table taiKhoan(
maChucVu varchar(12) ,
taiKhoan varchar(10) primary key, 
matkhau varchar(10)
)

--------------------khoa
ALTER TABLE bangCong
ADD CONSTRAINT FK_bangcong_congviec FOREIGN KEY (maCongViec)
REFERENCES CongViec (maCongViec)
ON UPDATE CASCADE
ALTER TABLE bangCong
ADD CONSTRAINT FK_bangcong_nhansu FOREIGN KEY (maNhanSu)
REFERENCES nhanSu (maNhanSu)
ON UPDATE CASCADE
ALTER TABLE nhanSu
ADD CONSTRAINT FK_nhansu_phongban FOREIGN KEY (maPhongBan)
REFERENCES phongBan (maPhongBan)
ON UPDATE CASCADE
ALTER TABLE nhanSu
ADD CONSTRAINT FK_chucVu_nhanSu FOREIGN KEY (maChucVu)
REFERENCES chucVu (maChucVu)
ON UPDATE CASCADE
ALTER TABLE taiKhoan
ADD CONSTRAINT FK_taikhoan_nhansu FOREIGN KEY (maChucVu)
REFERENCES chucVu (maChucVu)
ON UPDATE CASCADE
ALTER TABLE congViec
ADD CONSTRAINT FK_congViec_duAn FOREIGN KEY (maDuAn)
REFERENCES duAn (maDuAn)
ON UPDATE CASCADE
ALTER TABLE NgayCongNhanSu
ADD CONSTRAINT FK_NgayCongNhanSu_NhanSu FOREIGN KEY (maNhanSu)
REFERENCES nhanSu (maNhanSu)
ALTER TABLE NgayCongNhanSu
ADD CONSTRAINT FK_NgayCongNhanSu_congviec FOREIGN KEY (maCongViec)
REFERENCES congViec (maCongViec)
ON UPDATE CASCADE

--du lieu du an


insert into duAn values(N'Chung Cư Xanh',N'Công ty Địa Ốc Sg','Dang Thi Cong','2020-09-15','2020-10-15','2020-12-10',N'Gò Vấp',0,N'cần thúc đẩy tiến độ')
insert into duAn values(N'Khu Công Nghiệp Sông Xanh',N'Công ty địa ốc bình minh','Dang Thi Cong','2020-09-05','2020-10-05','2020-12-01',N'Gò Vấp',0,N'cần thúc đẩy tiến độ')
insert into duAn values(N'Tàu điện ngầm metro',N'Công ty tư ếch','Dang Thi Cong','2020-08-15','2020-09-15','2020-11-17',N'Gò Vấp',0,N'cần thúc đẩy tiến độ')
insert into duAn values(N'Tòa Nhà Chính Phủ',N'Công ty tư ếch','Dang Thi Cong','2020-08-15','2020-09-15','2020-11-17',N'Gò Vấp',0,N'cần thúc đẩy tiến độ')
insert into duAn values(N'Đập Thủy Lợi',N'Công ty tư ếch','Dang Thi Cong','2020-08-15','2020-09-15','2020-11-17',N'Gò Vấp',0,N'cần thúc đẩy tiến độ')
insert into duAn values(N'Trùng Tu Khu Công Ngiệp Bình lợi',N'Công ty tư ếch','Dang Thi Cong','2020-08-15','2020-09-15','2020-11-17',N'Gò Vấp',0,N'cần thúc đẩy tiến độ')
insert into duAn values(N'Khu Công Nghiệp Sóng thần',N'Công ty tư ếch','Dang Thi Cong','2020-08-15','2020-09-15','2020-11-17',N'Gò Vấp',0,N'cần thúc đẩy tiến độ')
insert into duAn values(N'Cống thoát nước',N'Công ty tư ếch','Dang Thi Cong','2020-08-15','2020-09-15','2020-11-17',N'Gò Vấp',0,N'cần thúc đẩy tiến độ')
insert into duAn values(N'Khu Xưởng may',N'Công ty tư ếch','Dang Thi Cong','2020-08-15','2020-09-15','2020-11-17',N'Gò Vấp',0,N'cần thúc đẩy tiến độ')
insert into duAn values(N'Khu Công Nghiệp Gió to',N'Công ty tư lân','Dang Thi Cong','2020-08-15','2020-09-15','2020-11-17',N'Gò Vấp',0,N'cần thúc đẩy tiến độ')
--tho xay

--du lieu cong viec
insert into congViec values('DA1',10,N'Thợ xây',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA1',10,N'Thợ hàn',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA1',3,N'Tài Xế Xe Lu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA1',3,N'Tài Xế Xe Cẩu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA1',3,N'tài xế máy xúc',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA1',2,N'kế toán',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA1',2,N'giám sát thi công',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA1',2,N'Kĩ Sư Thiết kế',0,'2020-09-15',null,'Dang Thi Cong')

insert into congViec values('DA2',5,N'Thợ xây',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA2',5,N'Thợ hàn',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA2',3,N'Tài Xế Xe Lu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA2',3,N'Tài Xế Xe Cẩu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA2',3,N'tài xế máy xúc',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA2',2,N'kế toán',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA2',2,N'giám sát thi công',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA2',2,N'Kĩ Sư Thiết kế',0,'2020-09-15',null,'Dang Thi Cong')

insert into congViec values('DA3',5,N'Thợ xây',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA3',5,N'Thợ hàn',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA3',3,N'Tài Xế Xe Lu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA3',3,N'Tài Xế Xe Cẩu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA3',3,N'tài xế máy xúc',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA3',2,N'kế toán',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA3',2,N'giám sát thi công',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA3',2,N'Kĩ Sư Thiết kế',0,'2020-09-15',null,'Dang Thi Cong')

insert into congViec values('DA4',5,N'Thợ xây',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA4',5,N'Thợ hàn',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA4',3,N'Tài Xế Xe Lu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA4',3,N'Tài Xế Xe Cẩu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA4',3,N'tài xế máy xúc',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA4',2,N'kế toán',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA4',2,N'giám sát thi công',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA4',2,N'Kĩ Sư Thiết kế',0,'2020-09-15',null,'Dang Thi Cong')

insert into congViec values('DA5',5,N'Thợ xây',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA5',5,N'Thợ hàn',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA5',3,N'Tài Xế Xe Lu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA5',3,N'Tài Xế Xe Cẩu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA5',3,N'tài xế máy xúc',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA5',2,N'kế toán',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA5',2,N'giám sát thi công',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA5',2,N'Kĩ Sư Thiết kế',0,'2020-09-15',null,'Dang Thi Cong')

insert into congViec values('DA6',5,N'Thợ xây',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA6',5,N'Thợ hàn',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA6',3,N'Tài Xế Xe Lu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA6',3,N'Tài Xế Xe Cẩu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA6',3,N'tài xế máy xúc',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA6',2,N'kế toán',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA6',2,N'giám sát thi công',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA6',2,N'Kĩ Sư Thiết kế',0,'2020-09-15',null,'Dang Thi Cong')

insert into congViec values('DA7',5,N'Thợ xây',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA7',5,N'Thợ hàn',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA7',3,N'Tài Xế Xe Lu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA7',3,N'Tài Xế Xe Cẩu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA7',3,N'tài xế máy xúc',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA7',2,N'kế toán',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA7',2,N'giám sát thi công',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA7',2,N'Kĩ Sư Thiết kế',0,'2020-09-15',null,'Dang Thi Cong')

insert into congViec values('DA8',5,N'Thợ xây',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA8',5,N'Thợ hàn',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA8',3,N'Tài Xế Xe Lu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA8',3,N'Tài Xế Xe Cẩu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA8',3,N'tài xế máy xúc',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA8',2,N'kế toán',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA8',2,N'giám sát thi công',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA8',2,N'Kĩ Sư Thiết kế',0,'2020-09-15',null,'Dang Thi Cong')

insert into congViec values('DA9',5,N'Thợ xây',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA9',5,N'Thợ hàn',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA9',3,N'Tài Xế Xe Lu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA9',3,N'Tài Xế Xe Cẩu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA9',3,N'tài xế máy xúc',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA9',2,N'kế toán',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA9',2,N'giám sát thi công',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA9',2,N'Kĩ Sư Thiết kế',0,'2020-09-15',null,'Dang Thi Cong')

insert into congViec values('DA10',5,N'Thợ xây',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA10',5,N'Thợ hàn',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA10',3,N'Tài Xế Xe Lu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA10',3,N'Tài Xế Xe Cẩu',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA10',3,N'tài xế máy xúc',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA10',2,N'kế toán',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA10',2,N'giám sát thi công',0,'2020-09-15',null,'Dang Thi Cong')
insert into congViec values('DA10',2,N'Kĩ Sư Thiết kế',0,'2020-09-15',null,'Dang Thi Cong')
--dulieunhansu

insert into nhanSu values('CV1',N'Nguyen Van A','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV2',N'Nguyen Van B','Nam','2020-09-15','Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV3',N'Nguyen Van C','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV4',N'Nguyen Van E','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV5',N'Nguyen Van D','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV6',N'Nguyen Van F','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV7',N'Nguyen Van G','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV8',N'Nguyen Van H','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV9',N'Nguyen Van T','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV10',N'Nguyen Van Y','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV11',N'Nguyen Van Z','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV12',N'Nguyen Van X','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV13',N'Nguyen Van R','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV14',N'Phạm Xuân Lộc','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Trưởng phòng',123456789)
insert into nhanSu values('CV15',N'Nguyen Van O','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV16',N'Mai Phát Huy','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV17',N'Nguyen Van hat','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV18',N'Phạm Xuân ca','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV19',N'Nguyen Van lan','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV20',N'Mai Phát triển','Nam','2020-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV21',N'Nguyen Van la','Nam','2020-09-15',N'phòng cung ứng vật liệu và phương tiện','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV22',N'Mai Phát Loc','Nam','2020-09-15',N'phòng cung ứng vật liệu và phương tiện','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV23',N'Nguyen Van ba','Nam','2020-09-15',N'phòng cung ứng vật liệu và phương tiện','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV24',N'Mai Phát tai','Nam','2020-09-15',N'phòng cung ứng vật liệu và phương tiện','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Trưởng phòng',123456789)
insert into nhanSu values('CV25',N'Phạm Văn Toàn','Nam','2020-09-15',N'Phòng Kế Toán','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Trưởng phòng',123456789)
insert into nhanSu values('CV26',N'Phạm Xuân Chuối','Nam','2020-09-15',N'Phòng Giám Sát','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Trưởng phòng',123456789)
insert into nhanSu values('CV27',N'Nguyễn Văn Xuống','Nam','2020-09-15',N'Phòng Kĩ Thuật','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Trưởng phòng',123456789)

--
insert into nhanSu values('CV28',N'Nguyen Van ha','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV29',N'Nguyen Van La','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV30',N'Nguyen Van Lu','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV31',N'Nguyen Van UI','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV32',N'Nguyen Van Con','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV33',N'Nguyen Van Ba','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV34',N'Nguyen Van Long','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV35',N'Nguyen Van Lala','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV36',N'Nguyen Van Lalala','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV37',N'Nguyen Van ka','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV38',N'Nguyen Van ma','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV39',N'Nguyen Van za','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV40',N'Nguyen Van ca','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV41',N'Nguyen Van xa','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV42',N'Nguyen Van ta','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV43',N'Nguyen Van no','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV44',N'Nguyen Van doi','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV45',N'Nguyen Van lop','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV46',N'Nguyen Van lo','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV47',N'Nguyen Vn te','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV48',N'Nguyen Van doi','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV49',N'Nguyen Van lop','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV50',N'Nguyen Vn te','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
--
insert into nhanSu values('CV51',N'Nguyen Van Lun','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV52',N'Ma Van xun','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV53',N'Le van toan','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV54',N'Nam Can','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV55',N'Nguyen thi teo','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV56',N'Nguyen van tam','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV57',N'la van cau','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV58',N'Van kinh','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV59',N'Xa Xam','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV60',N'Nguyen Cao za','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV61',N'Nam ca','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV62',N'Nguyen Van oa','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV63',N'Nguyen ta','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV64',N'ha Van no','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV65',N'thai Van doi','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV66',N'Nguyen Van lolo','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV67',N'Nguyen Vn tata','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV68',N'Nguyen Van han','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV69',N'Nguyen Van op','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV70',N'Giàng A Chề','Nam','2000-09-15',N'Phòng Thi Công','PB1',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
--
insert into nhanSu values('CV71',N'Nguyen Thi','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV72',N'Giàng a bưởi','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV73',N'Le van Chí','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV74',N'Cần văn ca','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV75',N'Ca văn li','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV76',N'Nguyen thi tằm','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV77',N'la van cau','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV78',N'Ngô kinh','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV79',N'Chung tử Đơn','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV80',N'Điệp Vấn','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV81',N'Sơn Tung MTP','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV82',N'Ngô thị tàu','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV83',N'Jack','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV84',N'KICM','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV85',N'Karis','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV86',N'Nguyen Van Lực','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV87',N'Yamaha','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV88',N'Nguyen văn exciter','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV89',N'Nguyen Van Honda','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV90',N'Giàng A Chu','Nam','2000-09-15',N'Phòng Thi Công','PB2',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
--
insert into nhanSu values('CV91',N'Nguyen Thi ta','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV92',N'Giàng hai bưởi','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV93',N'Le van Cho','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV94',N'Cần văn la','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV95',N'Ca văn lan','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV96',N'Nguyen van tằm','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV97',N'la van lan','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV98',N'Ngô Quá kinh','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV99',N'Chung tử vong','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV100',N'Điệp Vấn','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV101',N'Sơn Tung PTM','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV102',N'Ngô thị taa','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV103',N'Jacker','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV104',N'KICMc','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV105',N'Kariss','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV106',N'Nguyen Van Lực','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV107',N'Yamaha','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV108',N'Nguyen văn exciter','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV109',N'Nguyen Van Honda','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV110',N'Giàng A Chu','Nam','2000-09-15',N'Phòng Thi Công','PB4',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
--
insert into nhanSu values('CV111',N'Tống Giang','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV112',N'Yasua','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV113',N'Lee Sin','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV114',N'Garen','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV115',N'Xin ZHao','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV116',N'Nguyen Nam','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV117',N'la van han','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV118',N'Ngô Quá','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV119',N'Dương Quá','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV120',N'Điệp Quá Vấn','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV121',N'Sơn Tung PKM','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV122',N'Ngô thị tAn','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV123',N'Jacker','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV124',N'KICMc','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV125',N'Kariss','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV126',N'Nguyen Van Lực','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV127',N'Yamaha haha','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV128',N'Nguyen văn exCivet','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV129',N'Nguyen Van Dream','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV130',N'Giàng A Wave','Nam','2000-09-15',N'Phòng Thi Công','PB5',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
--
insert into nhanSu values('CV131',N'Tống ca','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV132',N'Ya van sua','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV133',N'Lee van Sin','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV134',N'Garen thi Kayle','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV135',N'Xin van ZHao','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV136',N'Nguyen La Nam','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV137',N'la Thi han','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV138',N'Ngô van Quá','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV139',N'Dương van Quá','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV140',N'Điệp Quá','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV141',N'Sơn Tung ABC','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV142',N'Ngô thị tien','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV143',N'le Jacker','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV144',N'le KICMc','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV145',N'le Kariss','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV146',N'Nguyen Van Gun','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV147',N'Ya van ha','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV148',N'Nguyen văn ex','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV149',N'le Van Dream','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV150',N'Giàng A tàu','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV151',N'Tống văn linh','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV152',N'Thái minh','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV153',N'Thái Lân','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV154',N'Thái văn ka','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Công nhân',123456789)
insert into nhanSu values('CV155',N'Cuc van tang','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV156',N'Nguyen van nam','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV157',N'la van ha','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV158',N'Ngô van quan','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV159',N'Dương van viêt','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV160',N'nguyễn văn Điệp','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV161',N'Sơn Tung thái bình','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV162',N'Ngô van bánh','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV163',N'tan thi tành','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV164',N'jonh wick','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV165',N'ngô van con','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV166',N'đặng Van Lực','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV167',N'Lê căn ya','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV168',N'Nguyen văn lam','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV169',N'Nguyen Van Dan','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV170',N'Giàng A sử','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV171',N'Nguyen tiến Lực','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV172',N'nông đúc tiến','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV173',N'Nguyen văn se','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV174',N'Nguyen tien luật','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
insert into nhanSu values('CV175',N'Giàng Van tân','Nam','2000-09-15',N'Phòng Thi Công','PB3',N'Bình Dương',N'12 huynh khuong an',0,'0390200063',N'Nhân viên',123456789)
--

--insert into bangCong values('NS1','VV2','2020-09-15',null,0)
--insert into bangCong values('NS3','VV2','2020-09-15',null,0)
--insert into bangCong values('NS4','VV2','2020-09-15',null,0)
--insert into bangCong values('NS5','VV2','2020-09-15',null,0)
--insert into bangCong values('NS6','VV2','2020-09-15',null,0)
--insert into bangCong values('NS7','VV6','2020-09-15',null,0)
--insert into bangCong values('NS8','VV6','2020-09-15',null,0)
--insert into bangCong values('NS9','VV6','2020-09-15',null,0)


--
insert into phongBan values('PB1',N'Phòng Thi Công',87,N'Phạm Xuân Lộc')
insert into phongBan values('PB2',N'Phòng Kĩ thuật',20,N'Nguyễn Văn Xuống')
insert into phongBan values('PB3',N'phòng cung ứng vật liệu và phương tiện',45,N'Mai Phát tai')
insert into phongBan values('PB4',N'phòng giám sát',20,N'Phạm văn Toàn')
insert into phongBan values('PB5',N'phòng kế toán',20,N'Phạm Xuân Chuối')
--
insert into chucVu values(N'Nguyen Van A',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van B',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van C',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van E',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van D',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van F',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van G',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van H',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Nguyen Van T',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Nguyen Van Y',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Nguyen Van Z',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van X',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van R',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Phạm Xuân Lộc',N'Trưởng Phòng',N'Trưởng Phòng thi công')
insert into chucVu values(N'Nguyen Van O',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Mai Phat Huy',N'Quản Lí Nhân sự',N'Quản Lí Nhân sự')
insert into chucVu values(N'Nguyen Van hat',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Phạm Xuân ca',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van lan',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Mai Phat triển',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van la',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'Mai Phát Loc',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'Nguyen Van ba',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'Mai Phát tai',N'Trưởng Phòng',N'Trưởng phòng cung ứng vật liệu và phương tiện')
insert into chucVu values(N'Phạm Văn Toàn',N'Trưởng Phòng',N'Trưởng Phòng Kế Toán')
insert into chucVu values(N'Phạm Xuân Chuối',N'Trưởng Phòng',N'Trưởng Phòng Giám sát')
insert into chucVu values(N'Nguyễn Văn Xuống',N'Trưởng Phòng',N'Trưởng Phòng kĩ thuật')
--
insert into chucVu values(N'Nguyen Van ha',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van La',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van Lu',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van UI',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van Con',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van Ba',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van Long',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van Lala',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van Lalala',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van ka',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van ma',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van za',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van ca',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van xa',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van ta',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van no',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van doi',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van lop',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van lo',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Vn te',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van doi',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Van lop',N'Công Nhân',N'Thợ xây')
insert into chucVu values(N'Nguyen Vn te',N'Công Nhân',N'Thợ xây')
--
insert into chucVu values(N'Nguyen Van Lun',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Ma Van xun',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Le van toan',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Nam Can',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Nguyen thi teo',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Nguyen van tam',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'la van cau',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Van kinh',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Xa Xam',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Nguyen Cao za',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Nam ca',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Nguyen Van oa',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Nguyen ta',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'ha Van no',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'thai Van doi',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Nguyen Van lolo',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Nguyen Vn tata',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Nguyen Van han',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Nguyen Van op',N'Công Nhân',N'Thợ hàn')
insert into chucVu values(N'Giàng A Chề',N'Công Nhân',N'Thợ hàn')

--
insert into chucVu values(N'Nguyen Thi',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Giàng a bưởi',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Le van Chí',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Cần văn ca',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Ca văn li',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Nguyen thi tằm',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'la van cau',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Ngô kinh',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Chung tử Đơn',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Điệp Vấn',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Sơn Tung MTP',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Ngô thị tàu',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Jack',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'KICM',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Karis',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Nguyen Van Lực',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Yamaha',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Nguyen văn exciter',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Nguyen Van Honda',N'Nhân viên',N'Kiến trúc sư')
insert into chucVu values(N'Giàng A Chu',N'Nhân viên',N'Kiến trúc sư')
--
insert into chucVu values(N'Nguyen Thi ta',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Giàng hai bưởi',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Le van Cho',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Cần văn la',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Ca văn lan',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Nguyen van tằm',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'la van lan',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Ngô Quá kinh',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Chung tử dong',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Điệp Vấn',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Sơn Tung PTM',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Ngô thị taa',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Jacker',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'KICMc',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Kariss',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Nguyen Van Lực',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Yamaha',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Nguyen văn exciter',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Nguyen Van Honda',N'Nhân viên',N'Giám sát thi công')
insert into chucVu values(N'Giàng A Chu',N'Nhân viên',N'Giám sát thi công')
--
insert into chucVu values(N'Tống Giang',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Yasua',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Lee Sin',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Garen',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Xin ZHao',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Nguyen Nam',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'la van han',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Ngô Quá',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Dương Quá',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Điệp Quá Vấn',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Sơn Tung PKM',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Ngô thị tAn',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Jacker',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'KICMc',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Kariss',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Nguyen Van Lực',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Yamaha haha',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Nguyen văn exCivet',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Nguyen Van Dream',N'Nhân viên',N'Kế toán')
insert into chucVu values(N'Giàng A Wave',N'Nhân viên',N'Kế toán')
--
insert into chucVu values(N'Tống ca',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'Ya van sua',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'Lee van Sin',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'Garen thi Kayle',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'Xin van ZHao',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'Nguyen La Nam',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'la Thi han',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'Ngô van Quá',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'Dương van Quá',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'Điệp Quá',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'Sơn Tung ABC',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'Ngô thị tien',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'le Jacker',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'le KICMc',N'Nhân viên',N'Giám sát dự án')
insert into chucVu values(N'le Kariss',N'Nhân viên',N'Giám sát dự án')
--
insert into chucVu values(N'Nguyen Van Gun',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'Ya van ha',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'Nguyen văn ex',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'le Van Dream',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'Giàng A tàu',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'Tống văn linh',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'Thái minh',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'Thái Lân',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'Thái văn ka',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'Cuc van tang',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'Nguyen van nam',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'la van ha',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'Ngô van quan',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'Dương van viêt',N'Nhân viên',N'Tư vấn viên')
insert into chucVu values(N'nguyễn văn Điệp',N'Nhân viên',N'Tư vấn viên')
--
insert into chucVu values(N'Sơn Tung thái bình',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'Ngô van bánh',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'tan thi tành',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'jonh wick',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'ngô van con',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'đặng Van Lực',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'Lê căn ya',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'Nguyen văn lam',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'Nguyen Van Dan',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'Giàng A sử',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'Nguyen tiến Lực',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'nông đúc tiến',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'Nguyen văn se',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'Nguyen tien luật',N'Nhân viên',N'Kỹ sư xây dựng')
insert into chucVu values(N'Giàng Van tân',N'Nhân viên',N'Kỹ sư xây dựng')
--

insert into taiKhoan values('CV16','qlns','qlns')
insert into taiKhoan values('CV14','tptc','tptc')
insert into taiKhoan values('CV24','tpcuvlvpt','tpcuvlvpt')
insert into taiKhoan values('CV27','tpkt','tpkt')
insert into taiKhoan values('CV26','tpgs','tpgs')
insert into taiKhoan values('CV25','tpktt','tpktt')


 --Phan cong nhan su

--drop proc phancong
 create proc phancong
 (
 @maNhanSu varchar(10),
 @maDuAn varchar(10),
 @ngayThamGiaCongTrinh date ,
 @ngayhoanthanhcongtrinh date,
 @SoNgayCong float,
 @maCongViec varchar(10)
 )
 as
 begin 
	--insert  bangCong values(@mabangcong,@maNhanSu, @maCongViec,convert(date,@ngayThamGiaCongTrinh,103),convert(date,@ngayhoanthanhcongtrinh,103),@SoNgayCong)
	insert  bangCong values(@maNhanSu, @maCongViec,@ngayThamGiaCongTrinh,@ngayhoanthanhcongtrinh,@SoNgayCong)
	update duAn set soLuongNhanSu = soLuongNhanSu + 1 where @maDuAn = maDuAn
	update nhanSu set trangThai = 1 where @maNhanSu = maNhanSu 
	update congViec set soLuongNhanSuHienCo = soLuongNhanSuHienCo + 1 where [maDuAn] = @maDuAn and maCongViec = @maCongViec
	--update congViec set ngayThamGiaCongviec = @ngayThamGiaCongTrinh where [maDuAn] = @maDuAn and maCongViec = @maCongViec
 end
go

------------------------------------------------------------------------------------------------------------------------------------------
-- proc luân chuyển
--drop proc luanchuyen
create proc luanchuyen
(
 @maBangCong varchar(12),
 @maDuAnB varchar(12),
 @maCongViecB varchar(12),
 @maNhanSu varchar(12),
 @ngayhoanthanhcongtrinh date
-- @soNgayCongCu float
 )
 as
 begin 
 declare  @maDuAnA varchar(10),@maCongViecA varchar(10),@ngayThamGiaCongTrinh date
	select @ngayThamGiaCongTrinh = ngayThamGiaCongTrinh from bangCong where maNhanSu = @maNhanSu
	select @maDuAnA=cv.maDuAn,@maCongViecA = cv.[maCongViec]from [dbo].[congViec] cv join [dbo].[bangCong] bc on cv.maCongViec = bc.[maCongViec] where maNhanSu = @maNhanSu
	select @maCongViecB = cv.[maCongViec]from [dbo].[congViec] cv join [dbo].[bangCong] bc on cv.maCongViec = bc.[maCongViec] join duAn da on da.maDuAn = cv.maDuAn where @maDuAnB = da.maDuAn
	--select cv.maDuAn,cv.[maCongViec]from [dbo].[congViec] cv join [dbo].[bangCong] bc on cv.maCongViec = bc.[maCongViec] where maNhanSu = 'NS1'
	--select cv.[maCongViec]from [dbo].[congViec] cv join [dbo].[bangCong] bc on cv.maCongViec = bc.[maCongViec] join duAn da on da.maDuAn = cv.maDuAn where da.maDuAn = 'DA1'
	delete from bangCong where maNhanSu = @maNhanSu
    insert  bangCong values(@maNhanSu,@maCongViecB,@ngayThamGiaCongTrinh,@ngayhoanthanhcongtrinh,0)
	update duAn set soLuongNhanSu = soLuongNhanSu + 1 where @maDuAnB = maDuAn
	update duAn set soLuongNhanSu = soLuongNhanSu - 1 where @maDuAnA = maDuAn
	update congViec set [soLuongNhanSuHienCo] = [soLuongNhanSuHienCo] - 1 where @maCongViecA = maCongViec
	update congViec set [soLuongNhanSuHienCo] = [soLuongNhanSuHienCo] + 1 where @maCongViecB = maCongViec
	--update congViec set ngayThamGiaCongviec = @ngayThamGiaCongTrinh where [maDuAn] = @maDuAnB and maCongViec = @maCongViecB
end
go
--- test

-------------------------------------------------------------------------------------------------------------------------------------------------
--drop proc chamcongnhansu
create proc chamcongnhansu
(
@maduan varchar(10),
@macongviec varchar(10),
@ngayhoanthanh date,
@ngayCong int
)
as
begin
declare @songaycong int,@sonhansuduan int,@sonhansutrongcongviec int,@ngaythamgia date, @manhansu varchar(10), @manhansuloop varchar(10),@mangaycong int,@n int = 0
select @sonhansutrongcongviec = [soLuongNhanSuHienCo] from [dbo].[congViec] where @macongviec = maCongViec
WHILE  @n < @sonhansutrongcongviec 
BEGIN
  SELECT  @manhansuloop = maNhanSu,@songaycong  =  DATEDIFF(day,[ngayThamGiaCongTrinh] , @ngayhoanthanh),@ngaythamgia = ngayThamGiaCongTrinh from [dbo].[bangCong] where [maCongViec] = @macongviec
  insert [dbo].[NgayCongNhanSu] values(@manhansuloop,@macongviec,@ngaythamgia,@ngayhoanthanh,@ngayCong)
  update [dbo].[congViec] set [soLuongNhanSuHienCo] = soLuongNhanSuHienCo - 1 where @macongviec = maCongViec
  update [dbo].[congViec] set ngayHoanThanhCongviec = @ngayhoanthanh where @macongviec = maCongViec
  update ns set [trangThai] = 0 from [dbo].[nhanSu] ns join [dbo].[bangCong] bc on bc.maNhanSu = ns.maNhanSu where bc.maNhanSu = @manhansuloop
  update [dbo].[duAn] set [soLuongNhanSu] = [soLuongNhanSu] - 1 where @maduan = maDuAn
  delete from bangCong where maNhanSu = @manhansuloop
  set @n = @n + 1
END
select @sonhansutrongcongviec = [soLuongNhanSuHienCo] from [dbo].[congViec] where @macongviec = maCongViec
if @sonhansutrongcongviec = 0
begin 
update [dbo].[congViec] set trangthaicv = 'Hoan Thanh' where @macongviec = maCongViec
end
select @sonhansuduan = [soLuongNhanSu] from [dbo].[duAn] where @maduan = maDuAn
end

-------------------------------------------------------------------------------------------------------------------------------------------------
create proc kiemtrangay
(
@ngaythamgia date,
@ngayhoanthanh date

)
as
begin
declare @ketqua int
select @ketqua = datediff(day,@ngaythamgia,@ngayhoanthanh) 
return @ketqua
end
-------------------------------------------------------------------------------------------------------------------------------------------------
create proc trungaycong
(
 @maNgaycong varchar(10)
)
as
begin
update NgayCongNhanSu set SoNgayCong = SoNgayCong - 1 where maNgayCong = @maNgaycong
end
------------------------------------------------------------------------------------------------------------------------------------------------
create proc trungaycongtheocongviec
(
 @maCongViec varchar(10)
)
as
begin
update NgayCongNhanSu set SoNgayCong = SoNgayCong - 1 where maCongViec = @maCongViec
end
-------------------------------------------------------------------------------------------------------------------------------------------------
create proc congngaycong
(
 @maNgaycong varchar(10)
)
as
begin
update NgayCongNhanSu set SoNgayCong = SoNgayCong + 1 where maNgayCong = @maNgaycong
end
-------------------------------------------------------------------------------------------------------------------------------------------------
create proc congngaycongtheocongviec
(
 @maCongViec varchar(10)
)
as
begin
update NgayCongNhanSu set SoNgayCong = SoNgayCong + 1 where maCongViec = @maCongViec
end
-------------------------------------------------------------------------------------------------------------------------------------------------
--drop proc themnhansu
create proc themnhansu
(
@hoTen nvarchar(50),
@gioiTinh nvarchar(12),
@ngaySinh date,
@TenPhongBan nvarchar(50),
@maphongban varchar(50),
@queQuan nvarchar(50),
@diaChiLienHe nvarchar(50),
@trangThai int,
@sdt int,
@loaiNhanSu nvarchar(30),
@soCmnd int,
@chucvu varchar(50),
@vaitro nvarchar(50)
)
as
begin 
declare @machucvu varchar(12),@ID int
insert chucVu values(@hoTen,@chucvu,@vaitro)
SELECT @ID = SCOPE_IDENTITY() from [dbo].[chucVu]
set @machucvu = 'CV' + convert(varchar(10),@ID)
--select @machucvu = maChucVu from [dbo].[chucVu] 
insert nhanSu values(@machucvu,@hoTen,@gioiTinh, @ngaySinh,@TenPhongBan,@maphongban,@queQuan,@diaChiLienHe,@trangThai,@sdt,@loaiNhanSu,@soCmnd)
update phongBan set soLuongNhanSu = soLuongNhanSu + 1 where maPhongBan = @maphongban
end
-------------------------------------------------------------------------------------------------------------------------------------------------
create proc xoanhansu
(
@manhansu varchar(12),
@hoTen nvarchar(50),
@maphongban varchar(12)
)
as
begin
delete from nhanSu where maNhanSu = @manhansu
delete from chucVu where  [tenNhanVien]= @hoTen
update phongBan set soLuongNhanSu = soLuongNhanSu - 1  where @maphongban= maPhongBan
end
-------------------------------------------------------------------------------------------------------------------------------------------------
create proc capnhatnhansu
(
@maNhanSu varchar(12),
@hoTen nvarchar(50),
@gioiTinh nvarchar(12),
@ngaySinh date,
@queQuan nvarchar(50),
@diaChiLienHe nvarchar(50),
@trangThai int,S
@sdt int,
@soCmnd int
)
as
begin 

update nhanSu set hoTen=@hoTen, gioiTinh=@gioiTinh, ngaySinh=@ngaySinh, queQuan=@queQuan, diaChiLienHe=@diaChiLienHe,trangThai=@trangThai,sdt=@sdt,soCmnd=@soCmnd where maNhanSu = @maNhanSu
end

-------------------------------------------------------------------------------------------------------------------------------------------------
--drop proc themduan
create proc themduan
(
@tenDuAn nvarchar(50),
@chuDauTu nvarchar(50),
@ngayCapPhep date,
@ngayKhoiCong date,
@diaDiemThiCong nvarchar(50),
@ghiChu nvarchar(50) ,

@soLuongNhanSuCV int,
@CongViec nvarchar(50),
@ngayThamGiaCongviec date 
)
as
begin
declare @maduan varchar(12),@ID int
insert into duAn values(@tenDuAn,@chuDauTu,'Dang Thi Cong',@ngayCapPhep,@ngayKhoiCong,null,@diaDiemThiCong,0,@ghiChu)
SELECT @ID = SCOPE_IDENTITY() from duAn
set @maduan = 'DA' + convert(varchar(10),@ID)
insert into congViec values(@maduan,@soLuongNhanSuCV,@CongViec,0,@ngayThamGiaCongviec,null,'Dang Thi Cong')
end
-------------------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------------------
