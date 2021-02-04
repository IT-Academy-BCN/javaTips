package onetoone.service;

import onetoone.entity.Student;
import onetoone.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {

    @Autowired
    private IStudentRepository repository;

    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    public Optional<Student> findStudent(int idStudent){ return repository.findById(idStudent);}

}
