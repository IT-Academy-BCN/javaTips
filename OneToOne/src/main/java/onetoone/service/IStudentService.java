package onetoone.service;

import onetoone.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    public List<Student> getAllStudents();

    public Optional<Student> getStudent(Integer student_id);
}
