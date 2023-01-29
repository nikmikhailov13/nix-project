package ua.nix.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nix.project.entity.StudentEntity;
import ua.nix.project.repository.StudentRepository;
import ua.nix.project.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping()
    public List<StudentEntity> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable long id) {
        StudentEntity student = studentService.findById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity student) {
        StudentEntity savedStudent = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable long id, @RequestBody StudentEntity student) {
        StudentEntity existingStudent = studentService.findById(id);
        if (existingStudent == null) {
            return ResponseEntity.notFound().build();
        }
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        StudentEntity updatedStudent = studentService.save(existingStudent);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        StudentEntity student = studentService.findById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.delete(student);
        return ResponseEntity.noContent().build();
    }

}
