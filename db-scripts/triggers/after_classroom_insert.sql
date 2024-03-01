CREATE TRIGGER after_classroom_insert
AFTER INSERT ON classrooms
FOR EACH ROW
BEGIN
    -- Insert a new record into classroom_students table with NULL students list
    INSERT INTO classroom_students (classroom_name, students_list)
    VALUES (NEW.classroom_name, NULL);
END;
//

DELIMITER ;