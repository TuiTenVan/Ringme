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
insert into subject (id, name, lesson_quantity) values (1, n'Cơ sở dữ liệu', 45);
insert into subject values (2, n'Trí tuệ nhân tạo', 45);
insert into subject values (3, n'Truyền tin', 45);
insert into subject values (4, n'Đồ họa', 60);
insert into subject values (5, n'Văn phạm', 45);


-- faculty
insert into faculty values (1, n'Anh - Văn');
insert into faculty values (2, n'Tin học');
insert into faculty values (3, n'Triết học');
insert into faculty values (4, n'Vật lý');


-- student
INSERT INTO student VALUES (1, 'Nguyễn Thị Hải', 'Nữ', '1990-02-23', 'Hà Nội', 130000, 2);
INSERT INTO student VALUES (2, 'Trần Văn Chính', 'Nam', '1992-12-24', 'Bình Định', 150000, 4);
INSERT INTO student VALUES (3, 'Lê Thu Yến', 'Nữ', '1990-02-21', 'TP HCM', 150000, 2);
INSERT INTO student VALUES (4, 'Lê Hải Yến', 'Nữ', '1990-02-21', 'TP HCM', 170000, 2);
INSERT INTO student VALUES (5, 'Trần Anh Tuấn', 'Nam', '1990-12-20', 'Hà Nội', 180000, 1);
INSERT INTO student VALUES (6, 'Trần Thanh Mai', 'Nữ', '1991-08-12', 'Hải Phòng', NULL, 3);
INSERT INTO student VALUES (7, 'Trần Thị Thu Thủy', 'Nữ', '1991-01-02', 'Hải Phòng', 10000, 1);


-- exam_management
insert into exam_management values (1, 1, 1, 1, 3);
insert into exam_management values (2, 1, 2, 2, 6);
insert into exam_management values (3, 1, 3, 1, 5);
insert into exam_management values (4, 2, 1, 1, 4.5);
insert into exam_management values (5, 2, 3, 1, 10);
insert into exam_management values (6, 2, 5, 1, 9);
insert into exam_management values (7, 3, 1, 2, 5);
insert into exam_management values (8, 3, 3, 1, 2.5);
insert into exam_management values (9, 4, 5, 2, 10);
insert into exam_management values (10, 5, 1, 1, 7);
insert into exam_management values (11, 5, 3, 1, 2.5);
insert into exam_management values (12, 6, 2, 1, 6);
insert into exam_management values (13, 6, 4, 1, 10);


/*================================================*/

/* III. QUERY */
