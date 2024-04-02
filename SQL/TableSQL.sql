use quanlysinhvien;

/* I. CREATE TABLES */

-- faculty (Khoa trong trường)
CREATE TABLE faculty (
    id INT PRIMARY KEY,
    name NVARCHAR(30) NOT NULL
);

-- subject (Môn học)
CREATE TABLE subject(
    id INT PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    lesson_quantity INT NOT NULL -- tổng số tiết học
);

-- student (Sinh viên)
CREATE TABLE student (
    id INT PRIMARY KEY,
    name NVARCHAR(30) NOT NULL,
    gender NVARCHAR(10) NOT NULL, -- giới tính
    birthday DATE NOT NULL,
    hometown NVARCHAR(100) NOT NULL, -- quê quán
    scholarship INT, -- học bổng
    faculty_id INT NOT NULL,
    FOREIGN KEY (faculty_id) REFERENCES faculty(id) -- mã khoa
);

-- exam management (Bảng điểm)
CREATE TABLE exam_management(
    id INT PRIMARY KEY,
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    number_of_exam_taking INT NOT NULL, -- số lần thi (thi trên 1 lần được gọi là thi lại) 
    mark DECIMAL(4,2) NOT NULL, -- điểm
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (subject_id) REFERENCES subject(id)
);



/*================================================*/

/* II. INSERT SAMPLE DATA */

-- subject
INSERT INTO subject (id, name, lesson_quantity) VALUES (1, N'Cơ sở dữ liệu', 45);
INSERT INTO subject VALUES (2, N'Trí tuệ nhân tạo', 45);
INSERT INTO subject VALUES (3, N'Truyền tin', 45);
INSERT INTO subject VALUES (4, N'Đồ họa', 60);
INSERT INTO subject VALUES (5, N'Văn phạm', 45);


-- faculty
INSERT INTO faculty VALUES (1, N'Anh - Văn');
INSERT INTO faculty VALUES (2, N'Tin học');
INSERT INTO faculty VALUES (3, N'Triết học');
INSERT INTO faculty VALUES (4, N'Vật lý');


-- student
INSERT INTO student VALUES (1, N'Nguyễn Thị Hải', N'Nữ', '1990-02-23', 'Hà Nội', 130000, 2);
INSERT INTO student VALUES (2, N'Trần Văn Chính', N'Nam', '1992-12-24', 'Bình Định', 150000, 4);
INSERT INTO student VALUES (3, N'Lê Thu Yến', N'Nữ', '1990-02-21', 'TP HCM', 150000, 2);
INSERT INTO student VALUES (4, N'Lê Hải Yến', N'Nữ', '1990-02-21', 'TP HCM', 170000, 2);
INSERT INTO student VALUES (5, N'Trần Anh Tuấn', N'Nam', '1990-12-20', 'Hà Nội', 180000, 1);
INSERT INTO student VALUES (6, N'Trần Thanh Mai', N'Nữ', '1991-08-12', 'Hải Phòng', NULL, 3);
INSERT INTO student VALUES (7, N'Trần Thị Thu Thủy', N'Nữ', '1991-01-02', 'Hải Phòng', 10000, 1);


-- exam_management
INSERT INTO exam_management VALUES (1, 1, 1, 1, 3);
INSERT INTO exam_management VALUES (2, 1, 1, 2, 6);
INSERT INTO exam_management VALUES (3, 1, 2, 2, 6);
INSERT INTO exam_management VALUES (4, 1, 3, 1, 5);
INSERT INTO exam_management VALUES (5, 2, 1, 1, 4.5);
INSERT INTO exam_management VALUES (6, 2, 1, 2, 7);
INSERT INTO exam_management VALUES (7, 2, 3, 1, 10);
INSERT INTO exam_management VALUES (8, 2, 5, 1, 9);
INSERT INTO exam_management VALUES (9, 3, 1, 1, 2);
INSERT INTO exam_management VALUES (10, 3, 1, 2, 5);
INSERT INTO exam_management VALUES (11, 3, 3, 1, 2.5);
INSERT INTO exam_management VALUES (12, 3, 3, 2, 4);
INSERT INTO exam_management VALUES (13, 4, 5, 2, 10);
INSERT INTO exam_management VALUES (14, 5, 1, 1, 7);
INSERT INTO exam_management VALUES (15, 5, 3, 1, 2.5);
INSERT INTO exam_management VALUES (16, 5, 3, 2, 5);
INSERT INTO exam_management VALUES (17, 6, 2, 1, 6);
INSERT INTO exam_management VALUES (18, 6, 4, 1, 10);



/*================================================*/

/* III. QUERY */
