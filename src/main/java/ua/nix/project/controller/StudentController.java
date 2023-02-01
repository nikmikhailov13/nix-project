package ua.nix.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nix.project.entity.StudentEntity;
import ua.nix.project.repository.StudentRepository;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping("/showallstudents")
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }


}
