package onetoone.controller;

import onetoone.entity.Student;
import onetoone.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {


    @Autowired
    private StudentServiceImpl service;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Searching students.....");
    }

    @RequestMapping(value = "/students/all", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> types() {
        List<Student> students = service.getAllStudents();
        return students == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(students);
    }



}
