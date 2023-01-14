package ua.nix.project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.nix.project.repository.dto.StudentDTO;
import ua.nix.project.repository.dto.mapper.StudentMapper;
import ua.nix.project.repository.entity.StudentEntity;
import ua.nix.project.service.StudentService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    final StudentService studentService;

    @PostMapping("/")
    public StudentDTO createStudent(StudentEntity student) {
        return StudentMapper.INSTANCE.toDto(studentService.createStudent(student));
    }

    @PutMapping("/{studentId}")
    public StudentDTO updateStudent(@PathVariable Long studentId, @RequestBody StudentEntity studentEntity) {
        return StudentMapper.INSTANCE.toDto(studentService.updateStudent(studentId, studentEntity));
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/{studentId}")
    public StudentDTO getStudent(@PathVariable Long studentId) {
        return StudentMapper.INSTANCE.toDto(studentService.getStudent(studentId));
    }

    @GetMapping("/")
    public List<StudentDTO> getStudents() {
        return StudentMapper.INSTANCE.toDtoList(studentService.getStudents());
    }
}