package ua.nix.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nix.project.entity.StudentEntity;
import ua.nix.project.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentEntity createStudent(String name, String email) {

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(name);
        studentEntity.setEmail(email);

        studentRepository.save(studentEntity);

        return studentEntity;
    }
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    public StudentEntity findById(long id) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    public StudentEntity save(StudentEntity student) {
        return studentRepository.save(student);
    }

    public void delete(StudentEntity student) {
        studentRepository.delete(student);
    }

}