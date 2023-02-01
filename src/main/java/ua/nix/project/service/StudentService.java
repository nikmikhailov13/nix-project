package ua.nix.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nix.project.entity.StudentEntity;
import ua.nix.project.repository.StudentRepository;

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

}