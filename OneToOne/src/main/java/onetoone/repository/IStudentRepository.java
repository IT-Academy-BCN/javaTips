package onetoone.repository;

import onetoone.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAll();

    Optional<Student> findById(Integer idStudent);

}
