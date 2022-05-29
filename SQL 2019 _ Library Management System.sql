create database LMS_PROJECT2
go
use LMS_PROJECT2
go
create table Sach(
    maSach varchar(10) primary key,
    tenSach nvarchar(1000) not null,
    maDanhMuc varchar(10) not null,
    maTheLoai varchar(10) not null,
    tacgia nvarchar(100) not null,
    nhaXuatBan nvarchar(100) not null,
    namXuatBan smallint,
    soluong smallint not null,
    mota nvarchar(4000), 
)

create table Danhmuc(
	maDanhmuc varchar(10) primary key,
	tenDanhmuc nvarchar(100) not null
)

create table Theloai(
	maTheloai varchar(10) primary key,
	tenTheloai nvarchar(100) not null
)

create table Docgia(
	maDocgia varchar(10) primary key,
	tenDocgia nvarchar(100) not null,
	NgaySinh smalldatetime not null,
	GioiTinh tinyint not null,
	Email varchar(100),
	sdt	nvarchar(100) not null,
	maTaikhoan varchar(10) not null

)

create table Thuthu(
	maThuThu	varchar(10) primary key,
	tenThuthu	nvarchar(100) not null,
	NgaySinh	smalldatetime not null,
	GioiTinh	tinyint not null,
	Email	varchar(100) not null,
	sdt	varchar(100) not null,
	maTaikhoan varchar(10) not null

)	

create table Taikhoan(
	maTaikhoan	varchar(10) primary key,
	taikhoan	nvarchar(100) not null,
	matkhau	nvarchar(100) not null,
	chucvu	nvarchar(10) not null,
	cam	tinyint not null,
	soluongmuon	tinyint not null 

)
Delete from phieumuon 

create table Phieumuon (
	maPhieumuon	varchar(10) primary key,
	maDocgia	varchar(10) not null,
	maThuthu	varchar(10) not null,
	soNgaymuon	smallint not null,
	Ghichu	nvarchar(100) ,
	Trangthai	nvarchar(100) 

)
Alter Table Phieumuon drop CONSTRAINT FK_MATHUTHU_PHIEUMUON
Alter table Phieumuon alter column maThuthu varchar(10)

create table Chitietphieumuon(
	maPhieumuon	varchar(10) not null,
	maSach	varchar(10) not null, 
	ngayMuon	smalldatetime ,
	ngayTradukien	smalldatetime ,
	ngayTrathucte	smalldatetime ,
	tienphat	float ,
	tinhtrang	nvarchar(100),
	Xetduyet nvarchar(100)

)

ALTER TABLE	SACH ADD CONSTRAINT FK_MADANHMUC_SACH FOREIGN KEY (MADANHMUC) REFERENCES DANHMUC(MADANHMUC);
ALTER TABLE	SACH ADD CONSTRAINT FK_MATHELOAI1_SACH FOREIGN KEY (maTheloai) REFERENCES Theloai(maTheloai);

ALTER TABLE Phieumuon ADD CONSTRAINT FK_MADOCGIA_PHIEUMUON FOREIGN KEY (maDocgia) REFERENCES Docgia(maDocgia)
ALTER TABLE Phieumuon ADD CONSTRAINT FK_MATHUTHU_PHIEUMUON FOREIGN KEY (maThuthu) REFERENCES Thuthu(mathuthu)

ALTER TABLE ChitietPhieumuon ADD CONSTRAINT FK_MASACH_CHITIETPHIEUMUON FOREIGN KEY (maSach) REFERENCES Sach(maSach)
ALTER TABLE ChitietPhieumuon ADD CONSTRAINT FK_MAPHIEUMUON_CHITIETPHIEUMUON FOREIGN KEY (maPhieumuon) REFERENCES Phieumuon(maPhieumuon)

ALTER TABLE Docgia ADD CONSTRAINT FK_MATAIKHOAN_DOCGIA FOREIGN KEY (maTaikhoan) REFERENCES Taikhoan(maTaikhoan)
ALTER TABLE Thuthu ADD CONSTRAINT FK_MATAIKHOAN_THUTHU FOREIGN KEY (maTaikhoan) REFERENCES Taikhoan(maTaikhoan)
go




--INSERT INTO Sach (maSach, tenSach, maDanhMuc, maTheLoai, tacgia, nhaXuatBan, namXuatBan, soluong, mota) VALUES (?,?,?,?,?,?,?,?,?)--

INSERT Danhmuc VALUES ('DM001', N'Kỹ năng sống')
INSERT Danhmuc VALUES ('DM002', 'Bách Tiếng Anh')
INSERT Danhmuc VALUES ('DM003', 'Bách nước ngoài')
INSERT Danhmuc VALUES ('DM004', 'Bách chuyên ngành Công nghê thông tin')


INSERT Theloai VALUES ('TL001', N'Truyện, tiểu thuyết')
INSERT Theloai VALUES ('TL002', N'Chính trị – pháp luật')
INSERT Theloai VALUES ('TL003', N'Văn học nghệ thuật')
INSERT Theloai VALUES ('TL004', N'Văn hóa xã hội – Lịch sử')
INSERT Theloai VALUES ('TL005', N'Giáo trình')
INSERT Theloai VALUES ('TL006', N'Tâm lý, tâm linh, tôn giáo')


INSERT INTO SACH VALUES ('B0001', N'Xé vài trang thanh xuân, đổi lấy một bản thân nỗ lực','DM001','TL001',N'Văn Cát Nhi',N'Nhà Xuất Bản Hồng Đức',2020,60,'Bạn có biết làm sao để cảm nhận rằng mình đang trưởng thành hay không? Đó chính là hai khoảnh khắc khi nhắm mắt và mở mắt mỗi ngày của chúng ta đấy. Với từng ngày trôi qua trong cuộc đời mà chúng ta đang sống, không chỉ cần phải cố gắng bước về phía trước, mà còn phải học được cách tìm kiếm niềm hạnh phúc cho chính mình.')
INSERT INTO SACH VALUES ('B0001', N'Lập trình cơ bản với C', N'DM003     ', N'TL001     ', N'Hoàng Thị Mỹ Lệ', N'NXB Công nghệ thông tin', 2016, 5, N'Với mong muốn chia sẻ kinh nghiệm học lập trình và các kỹ năng mà anh đã trải qua trong suốt quá trình học và làm việc với tư cách là người đi trước cũng như là một Developer Full Stack, nên anh đã quyết định xuất bản sách')
INSERT INTO SACH VALUES ('B0002', N'Giáo trình kỹ thuật xung số và ứng dụng', N'DM003     ', N'TL001     ', N'Nguyễn Linh Nam', N'NXB Công nghệ thông tin', 2016, 3, N'Với mong muốn chia sẻ kinh nghiệm học lập trình và các kỹ năng mà anh đã trải qua trong suốt quá trình học và làm việc với tư cách là người đi trước cũng như là một Developer Full Stack, nên anh đã quyết định xuất bản sách')
INSERT INTO SACH VALUES ('B0003', N'Trường điện từ - Lý thuyết và bài tập', N'DM003     ', N'TL001     ', N'Lê Văn Sung', N'NXB Công nghệ thông tin', 2016, 3, N'Với mong muốn chia sẻ kinh nghiệm học lập trình và các kỹ năng mà anh đã trải qua trong suốt quá trình học và làm việc với tư cách là người đi trước cũng như là một Developer Full Stack, nên anh đã quyết định xuất bản sách')
INSERT INTO SACH VALUES ('B0004', N'Cơ sở dữ liệu', N'DM003     ', N'TL001     ', N'Hoàng Thị Mỹ Lệ', N'NXB Công nghệ thông tin', 2016, 3, N'Với mong muốn chia sẻ kinh nghiệm học lập trình và các kỹ năng mà anh đã trải qua trong suốt quá trình học và làm việc với tư cách là người đi trước cũng như là một Developer Full Stack, nên anh đã quyết định xuất bản sách')
INSERT INTO SACH VALUES ('B0005', N'Tin học văn phòng', N'DM003     ', N'TL001     ', N'Hoàng Thị Mỹ Lệ', N'NXB Công nghệ thông tin', 2016, 3, N'Với mong muốn chia sẻ kinh nghiệm học lập trình và các kỹ năng mà anh đã trải qua trong suốt quá trình học và làm việc với tư cách là người đi trước cũng như là một Developer Full Stack, nên anh đã quyết định xuất bản sách')
INSERT INTO SACH VALUES ('B0006', N'Bơm nhiệt', N'DM002     ', N'TL001     ', N'Nguyễn Đức Lợi', N'NXB Cơ Khí', 2018, 3, N'Giáo trình gồm có 10 chương, trình bày các vấn đề về cơ cấu máy, phân tích động lực học cơ cấu máy, các vấn đề cơ bản trong thiết kế truyền động cơ khí, thiết kế các bộ truyền cơ khí và bộ phận đỡ nổi các bộ truyền. ')
INSERT INTO SACH VALUES ('B0007', N'Cơ sở thiết kế máy', N'DM002     ', N'TL001     ', N'Nguyễn Đức Lợi', N'NXB Cơ Khí', 2018, 3, N'Giáo trình gồm có 10 chương, trình bày các vấn đề về cơ cấu máy, phân tích động lực học cơ cấu máy, các vấn đề cơ bản trong thiết kế truyền động cơ khí, thiết kế các bộ truyền cơ khí và bộ phận đỡ nổi các bộ truyền. ')
INSERT INTO SACH VALUES ('B0008', N'Đo lường nhiệt', N'DM002     ', N'TL001     ', N'Võ Huy Hoàng', N'NXB Cơ Khí', 2018, 3, N'Giáo trình gồm có 10 chương, trình bày các vấn đề về cơ cấu máy, phân tích động lực học cơ cấu máy, các vấn đề cơ bản trong thiết kế truyền động cơ khí, thiết kế các bộ truyền cơ khí và bộ phận đỡ nổi các bộ truyền. ')
INSERT INTO SACH VALUES ('B0009', N'Nhiên liệu sạch', N'DM002     ', N'TL001     ', N'Nguyễn Đức Lợi', N'NXB Cơ Khí', 2018, 3, N'Giáo trình gồm có 10 chương, trình bày các vấn đề về cơ cấu máy, phân tích động lực học cơ cấu máy, các vấn đề cơ bản trong thiết kế truyền động cơ khí, thiết kế các bộ truyền cơ khí và bộ phận đỡ nổi các bộ truyền. ')
INSERT INTO SACH VALUES ('B0010', N'Giáo trình kỹ thuật nhiệt', N'DM002     ', N'TL001     ', N'Nguyễn Đức Lợi', N'NXB Cơ Khí', 2018, 3, N'Giáo trình gồm có 10 chương, trình bày các vấn đề về cơ cấu máy, phân tích động lực học cơ cấu máy, các vấn đề cơ bản trong thiết kế truyền động cơ khí, thiết kế các bộ truyền cơ khí và bộ phận đỡ nổi các bộ truyền. ')
INSERT INTO SACH VALUES ('B0011', N'Ngoại ngữ 1', N'DM004     ', N'TL002     ', N'Nguyễn Như Hiền', N'NXB Ngoại ngữ', 2010, 1, N'Nội dung chính của sách, gồm từ mới, mẫu câu được giới thiệu bằng hình ảnh trực quan kết hợp với việc nghe đĩa,
								kế đến là những bài tập đọc hiểu. Các chủ điểm ngữ pháp được đưa vào sách một cách nhẹ nhàng và tự nhiên thông qua 
								các tình huống thực tế.')
INSERT INTO SACH VALUES ('B0012', N'Grammar in use', N'DM004     ', N'TL002     ', N'Nguyễn Đức Trí', N'NXB Ngoại ngữ', 2018, 4, N'Nội dung chính của sách, gồm từ mới, mẫu câu được giới thiệu bằng hình ảnh trực quan kết hợp với việc nghe đĩa,
								kế đến là những bài tập đọc hiểu. Các chủ điểm ngữ pháp được đưa vào sách một cách nhẹ nhàng và tự nhiên thông qua 
								các tình huống thực tế.')
INSERT INTO SACH VALUES ('B0013', N'Listen carefully', N'DM004     ', N'TL002     ', N'Nguyễn Như Hiền', N'NXB Ngoại ngữ', 2018, 2, N'Nội dung chính của sách, gồm từ mới, mẫu câu được giới thiệu bằng hình ảnh trực quan kết hợp với việc nghe đĩa,
								kế đến là những bài tập đọc hiểu. Các chủ điểm ngữ pháp được đưa vào sách một cách nhẹ nhàng và tự nhiên thông qua 
								các tình huống thực tế.')
INSERT INTO SACH VALUES ('B0014', N'Ngoại ngữ cơ bản', N'DM004     ', N'TL002     ', N'Nguyễn Như Hiền', N'NXB Ngoại ngữ', 2018, 2, N'Nội dung chính của sách, gồm từ mới, mẫu câu được giới thiệu bằng hình ảnh trực quan kết hợp với việc nghe đĩa,
								kế đến là những bài tập đọc hiểu. Các chủ điểm ngữ pháp được đưa vào sách một cách nhẹ nhàng và tự nhiên thông qua 
								các tình huống thực tế.')
INSERT INTO SACH VALUES ('B0015', N'Ngoại ngữ 2', N'DM004     ', N'TL002     ', N'Nguyễn Như Hiền', N'NXB Ngoại ngữ', 2018, 1, N'Nội dung chính của sách, gồm từ mới, mẫu câu được giới thiệu bằng hình ảnh trực quan kết hợp với việc nghe đĩa,
								kế đến là những bài tập đọc hiểu. Các chủ điểm ngữ pháp được đưa vào sách một cách nhẹ nhàng và tự nhiên thông qua 
								các tình huống thực tế.')
INSERT INTO SACH VALUES ('B0016', N'Kỹ thuật xử lý tín hiệu điều khiển', N'DM001     ', N'TL001     ', N'	Phạm Ngọc Thắng', N'NXB Điện-Điện Tử', 2014, 1, N'Giáo trình này được sử dụng làm tài liệu học tập cho sinh viên các khối ngành kỹ thuật và các ngành có liên quan đến kỹ thuật.')
INSERT INTO SACH VALUES ('B0017', N'Bài tập vi điều khiển và PLC', N'DM001     ', N'TL001     ', N'Đặng Văn Tuệ', N'NXB Điện-Điện Tử', 2014, 4, N'')
INSERT INTO SACH VALUES ('B0018', N'Khí cụ điện - kết cấu, sử dụng và sửa chữa', N'DM001     ', N'TL001     ', N'Nguyễn Xuân Phú', N'NXB Điện-Điện Tử', 2014, 2, N'Giáo trình này được sử dụng làm tài liệu học tập cho sinh viên các khối ngành kỹ thuật và các ngành có liên quan đến kỹ thuật.')
INSERT INTO SACH VALUES ('B0019', N'Bổ tay chuyên ngành điện', N'DM001     ', N'TL002     ', N'Tăng Văn Mùi - Trần Duy Nam', N'NXB Điện-Điện Tử', 2013, 2, N'Giáo trình này được sử dụng làm tài liệu học tập cho sinh viên các khối ngành kỹ thuật và các ngành có liên quan đến kỹ thuật.')
INSERT INTO SACH VALUES ('B0020', N'Bài tập điều khiển tự động', N'DM001     ', N'TL001     ', N'	Nguyễn Công Phương', N'NXB Điện-Điện Tử', 2013, 1, N'Giáo trình này được sử dụng làm tài liệu học tập cho sinh viên các khối ngành kỹ thuật và các ngành có liên quan đến kỹ thuật.')
INSERT INTO SACH VALUES ('B0021', N'Bổ tay máy làm đất và làm đường', N'DM004     ', N'TL002     ', N'Lưu Bá Thuận', N'NXB Xây dựng', 2015, 10, N'Cuốn sách này nhằm hệ thống hóa và trang bị các khái niệm, thông tin cơ bản về các hệ thống kỹ thuật trong công trình cho các sinh viên trong trường Đại học Xây dựng nói riêng cũng như các trường đại học có đạo tạo ngành kỹ thuật xây dựng.')
INSERT INTO SACH VALUES ('B0022', N'Móng cọc phân tích và thiết kế', N'DM004     ', N'TL001     ', N'Nguyễn Thái', N'NXB Xây dựng', 2014, 4, N'Cuốn sách này nhằm hệ thống hóa và trang bị các khái niệm, thông tin cơ bản về các hệ thống kỹ thuật trong công trình cho các sinh viên trong trường Đại học Xây dựng nói riêng cũng như các trường đại học có đạo tạo ngành kỹ thuật xây dựng.')
INSERT INTO SACH VALUES ('B0023', N'Cấu tạo bê tông cốt thép', N'DM004     ', N'TL001     ', N'Bộ Xây dựng', N'NXB Xây dựng', 2014, 2, N'Cuốn sách này nhằm hệ thống hóa và trang bị các khái niệm, thông tin cơ bản về các hệ thống kỹ thuật trong công trình cho các sinh viên trong trường Đại học Xây dựng nói riêng cũng như các trường đại học có đạo tạo ngành kỹ thuật xây dựng.')
INSERT INTO SACH VALUES ('B0024', N'Kết cấu thép - Công trình đặc biệt', N'DM004     ', N'TL001     ', N'GS.TS.Phạm Văn Hội ', N'NXB Xây dựng', 2013, 2, N'Cuốn sách này nhằm hệ thống hóa và trang bị các khái niệm, thông tin cơ bản về các hệ thống kỹ thuật trong công trình cho các sinh viên trong trường Đại học Xây dựng nói riêng cũng như các trường đại học có đạo tạo ngành kỹ thuật xây dựng.')
INSERT INTO SACH VALUES ('B0025', N'Kết cấu bê tông cốt thép - Phần cấu kiện cơ bản', N'DM004     ', N'TL001     ', N'Phan Quang Minh', N'NXB Xây dựng', 2013, 1, N'Cuốn sách này nhằm hệ thống hóa và trang bị các khái niệm, thông tin cơ bản về các hệ thống kỹ thuật trong công trình cho các sinh viên trong trường Đại học Xây dựng nói riêng cũng như các trường đại học có đạo tạo ngành kỹ thuật xây dựng.')

Insert into Taikhoan values ('TK1','admin','abc123',N'Thủ thư',0,0)
Insert into Taikhoan values ('TK2','user3','abc123',N'Độc giả',0,0)
Insert into Taikhoan values ('TK3','user2','abc123',N'Độc giả',0,0)
Insert into Taikhoan values ('TK4','user3','abc123',N'Độc giả',0,0)

Insert into Docgia values ('DG1','Kiel Darenl','2012-01-01',1,'9','65156','TK2')
Insert into Docgia values ('DG2','Kiel ','2003-02-05',1,'11','656','TK3')
Insert into Docgia values ('DG3','Kiel KK','2012-03-02',1,'1666','1651485','TK4')

Insert into Thuthu values ('TT1','Kiel Darenl','2012-01-01',1,'9','65156','TK1')
