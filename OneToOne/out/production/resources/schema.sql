DROP TABLE IF EXISTS student;
CREATE TABLE student (idStudent INT AUTO_INCREMENT PRIMARY KEY,
                           firstName VARCHAR(250) NOT NULL,
                           lastName VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS tuition;
CREATE TABLE tuition (idTuition INT AUTO_INCREMENT  PRIMARY KEY,
                      fee INT NOT NULL,
                      studentId INT NOT NULL,
                      FOREIGN KEY (studentId) REFERENCES student(idStudent)
);





