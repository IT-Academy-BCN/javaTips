DROP TABLE IF EXISTS student;
CREATE TABLE student (id_student INT AUTO_INCREMENT PRIMARY KEY,
                           first_name VARCHAR(250) NOT NULL,
                           last_name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS tuition;
CREATE TABLE tuition (id_tuition INT AUTO_INCREMENT  PRIMARY KEY,
                      fee INT NOT NULL,
                      student_id INT NOT NULL,
                      FOREIGN KEY (student_id) REFERENCES student(id_student)
);





