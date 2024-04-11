-- Thêm dữ liệu vào bảng major
use assignments;
INSERT INTO major (majorname) VALUES
('Công nghệ thông tin'),
('Kỹ thuật điện'),
('Sinh học'),
('Marketing'),
('Văn học Anh');

-- Thêm dữ liệu vào bảng subject
INSERT INTO class (classname) VALUES
('Cấu trúc dữ liệu'),
('Phân tích mạch điện'),
('Di truyền học'),
('Cơ sở dữ liệu'),
('Nghiên cứu Shakespeare');

-- Thêm dữ liệu vào bảng student
INSERT INTO student (name, birthday, hometown, AVG, gender, major_id) VALUES
('Alice Nguyen', '2001-04-12', 'Hà Nội', 9.8, 'Nữ', 2),
('Bob Lee', '2002-07-24', 'San Francisco', 7.7, 'Nam', 1),
('Cathy Zhen', '2000-05-16', 'New York', 9.0, 'Nữ', 5),
('Jodio', '2001-05-06', 'Tokyo', 5.9, 'Nam', 4),
('David Kim', '2001-09-08', 'Seoul', 6.3, 'Nam', 4);

-- Thêm dữ liệu vào bảng exam_management
INSERT INTO student_class (student_id, class_id) VALUES
(1, 2),
(2, 1),
(1, 1),
(2, 2),
(3, 3),
(5, 4),
(4, 5);