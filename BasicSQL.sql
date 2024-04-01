use quanlysinhvien;

-- A. BASIC QUERY -- 
	-- 1
	SELECT * FROM student
	ORDER BY id ASC;
	SELECT * FROM student
	ORDER BY gender ASC;
	SELECT * FROM student
	ORDER BY birthday ASC;
	SELECT * FROM student
	ORDER BY scholarship DESC;
    
	-- 2
	SELECT * FROM subject
	WHERE name LIKE "T%";
    
	-- 3
	SELECT * FROM student
	WHERE name LIKE "%i";
    
	-- 4
	SELECT * FROM faculty
	WHERE SUBSTRING(name, 2, 1) = 'n';
    
	-- 5
	SELECT * FROM student
	WHERE name LIKE "%Thị%";
    
	-- 6
	SELECT * FROM student
	WHERE SUBSTRING(name, 1, 1) BETWEEN 'a' AND 'm'
	ORDER BY name;
    
	-- 7
	SELECT * FROM student
	WHERE scholarship > 100000
	ORDER BY faculty_id DESC;
    
	-- 8
	SELECT * FROM student
	WHERE scholarship >= 150000
	AND hometown = 'Ha Noi';
    
	-- 9
	SELECT * FROM student
	WHERE birthday BETWEEN '1991-01-01' AND '1992-06-05';
    
	-- 10
	SELECT * FROM student
	WHERE scholarship BETWEEN 80000 AND 150000;
    
	-- 11
	SELECT * FROM subject
	WHERE lesson_quantity > 30 AND lesson_quantity < 45;
    
-- B. CALCULATION QUERY -- 
	-- 1
   SELECT 
		student.id AS 'Mã sinh viên',
		student.gender AS 'Giới tính',
		student.faculty_id AS 'Mã khoa',
		CASE 
			WHEN student.scholarship > 500000 THEN 'Học bổng cao'
			ELSE 'Mức trung bình'
		END AS 'Mức học bổng'
	FROM 
		student;
        
	-- 2
    SELECT COUNT(*) AS 'Tổng số sinh viên'
	FROM student;
    
    -- 3
	SELECT gender, COUNT(*) AS 'Tổng số sinh viên'
	FROM student
	GROUP BY gender;
    
	-- 4
	SELECT faculty_id, COUNT(*) AS 'Tổng số sinh viên'
	FROM student
	GROUP BY faculty_id;
    
	-- 5
	SELECT subject_id, COUNT(*) AS 'Tổng số sinh viên'
	FROM exam_management
	GROUP BY subject_id;
    
	-- 6
	SELECT student_id, COUNT(*) AS 'Tổng số môn học'
	FROM exam_management
	GROUP BY student_id;
    
	-- 7
	SELECT faculty_id, SUM(scholarship) AS 'Tổng số học bổng'
	FROM student 
	GROUP BY faculty_id;
    
    -- 8
    SELECT faculty_id, MAX(scholarship) AS "HỌC BỔNG CAO NHẤT" 
    FROM student
    GROUP BY faculty_id;
    
	-- 9
	SELECT faculty_id, COUNT(*) AS 'Tổng số sinh viên',
	SUM(gender = 'Nam') AS 'Tổng số sinh viên nam',
	SUM(gender = 'Nữ') AS 'Tổng số sinh viên nữ'
	FROM student
	GROUP BY faculty_id;
    
	-- 10
	SELECT FLOOR(DATEDIFF(CURRENT_DATE, birthday) / 365.25) AS 'Tuổi', COUNT(*) AS 'Số lượng sinh viên'
	FROM student
	GROUP BY FLOOR(DATEDIFF(CURRENT_DATE, birthday) / 365.25);

	-- 11 
	SELECT hometown,COUNT(*) AS 'Số lượng sinh viên'
	FROM student
	GROUP BY hometown
	HAVING COUNT(*) >= 2;
    
	-- 12
	SELECT student_id, COUNT(*) AS 'Số lần thi lại'
	FROM exam_management
	GROUP BY student_id
	HAVING COUNT(*) >= 2;
    
	-- 13
	SELECT 
		student.id AS 'Mã sinh viên',
		student.gender AS 'Giới tính',
		exam_management.mark AS 'Điểm trung bình lần 1'
	FROM student
	JOIN exam_management ON student.id = exam_management.student_id
	WHERE student.gender = 'Nam' 
	AND exam_management.number_of_exam_taking = 1 
	AND exam_management.mark > 7.0;
    
	-- 14
	SELECT student_id, COUNT(*) AS 'Số môn rớt'
	FROM exam_management
	WHERE number_of_exam_taking = 1 AND mark < 4.0
	GROUP BY student_id
	HAVING COUNT(*) >= 2;
    
	-- 15
	SELECT faculty_id, COUNT(*) AS 'Số lượng sinh viên nam'
	FROM student
	WHERE gender = 'Nam'
	GROUP BY faculty_id
	HAVING COUNT(*) > 2;
    
	-- 16
	SELECT faculty_id,COUNT(*) AS 'Số lượng sinh viên'
	FROM student
	WHERE scholarship BETWEEN 200000 AND 300000
	GROUP BY faculty_id
	HAVING COUNT(*) = 2;
    
	-- 17
	SELECT id AS 'Mã sinh viên', scholarship AS 'Học bổng'
	FROM student
	WHERE scholarship = (SELECT MAX(scholarship) FROM student);

-- C. DATE/TIME QUERY --
	-- 1 
	SELECT * FROM student
	WHERE hometown = 'Hà Nội' AND MONTH(birthday) = 2;
    
	-- 2
	SELECT * FROM student
	WHERE FLOOR(DATEDIFF(CURRENT_DATE, birthday) / 365.25) > 20;
    
	-- 3
	SELECT * FROM student
	WHERE MONTH(birthday) BETWEEN 1 AND 3 AND YEAR(birthday) = 1990;
    
-- D. JOIN QUERY --
	-- 1
	SELECT student.*, faculty.name FROM student
	INNER JOIN faculty ON student.faculty_id = faculty.id
	WHERE faculty.name = 'Anh - Văn' OR faculty.name = 'Vật lý';
    
	-- 2
	SELECT student.* FROM student
	INNER JOIN faculty ON student.faculty_id = faculty.id
	WHERE (faculty.name = 'Anh - Văn' OR faculty.name = 'Vật lý')
	AND student.gender = 'Nam';
    
	-- 3
	SELECT student.*, exam_management.mark FROM student
	INNER JOIN exam_management ON student.id = exam_management.student_id
	INNER JOIN subject ON exam_management.subject_id = subject.id
	WHERE subject.name = 'Cơ sở dữ liệu' AND exam_management.number_of_exam_taking = 1
	ORDER BY exam_management.mark DESC
	LIMIT 1;
    
	-- 4
	SELECT student.* FROM student
	INNER JOIN faculty ON student.faculty_id = faculty.id
	WHERE faculty.name = 'Anh - Văn'
	ORDER BY DATEDIFF(CURRENT_DATE, student.birthday) DESC
	LIMIT 1;
    
	-- 5
	SELECT faculty.name, COUNT(*) AS 'Số lượng sinh viên' FROM student
	INNER JOIN faculty ON student.faculty_id = faculty.id
	GROUP BY faculty.name
	ORDER BY COUNT(*) DESC
	LIMIT 1;
    
	-- 6
	SELECT faculty.name, COUNT(*) AS 'Số lượng sinh viên nữ' FROM student
	INNER JOIN faculty ON student.faculty_id = faculty.id
	WHERE student.gender = 'Nữ'
	GROUP BY faculty.name
	ORDER BY COUNT(*) DESC
	LIMIT 1;
    
	-- 7
	SELECT student.*, em.* FROM student
	INNER JOIN (
		SELECT subject_id, MAX(mark) AS max_mark
		FROM exam_management
		GROUP BY subject_id
	) AS max_marks ON student.id = max_marks.subject_id
	INNER JOIN exam_management AS em ON em.subject_id = max_marks.subject_id AND em.mark = max_marks.max_mark
	LIMIT 0, 1000;
    
	-- 8
	SELECT faculty.* FROM faculty
	INNER JOIN student ON faculty.id = student.faculty_id
	WHERE student.id IS NULL;
    
	-- 9
	SELECT student.* FROM student
	INNER JOIN exam_management ON student.id = exam_management.student_id
	INNER JOIN subject ON exam_management.subject_id = subject.id
	WHERE subject.name = 'Cơ sở dữ liệu' AND exam_management.student_id IS NULL;
    
	-- 10
	SELECT em.student_id, student.name FROM exam_management em
	INNER JOIN student ON em.student_id = student.id
	WHERE em.number_of_exam_taking >= 2
	AND em.student_id NOT IN (
		SELECT student_id
		FROM exam_management
		WHERE number_of_exam_taking = 1
	)
	GROUP BY em.student_id;































	






