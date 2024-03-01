DELIMITER //

-- Trigger for inserting a new student
CREATE TRIGGER after_student_insert
AFTER INSERT ON students
FOR EACH ROW
BEGIN
    DECLARE student_list TEXT;
    
    -- Concatenate student names belonging to the same classroom
    SELECT GROUP_CONCAT(student_name)
    INTO student_list
    FROM students
    WHERE classroom_id = NEW.classroom_id;
    
    -- Insert or update the classroom_students table
    INSERT INTO classroom_students (classroom_name, students_list)
    VALUES (
        (SELECT classroom_name FROM classrooms WHERE id = NEW.classroom_id),
        student_list
    )
    ON DUPLICATE KEY UPDATE students_list = student_list;
END;
//