package ua.nix.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nix.project.repository.StudentRepository;
import ua.nix.project.repository.entity.StudentEntity;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void createStudent(String name, String email) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(name);
        studentEntity.setEmail(email);
        System.out.println(studentEntity);
        studentRepository.save(studentEntity);
    }
    public StudentEntity createStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }
    public StudentEntity updateStudent(Long studentId,StudentEntity studentEntity) {
         studentRepository.updateStudent(studentId, studentEntity.getName(), studentEntity.getEmail());
         return  studentRepository.findById(studentId).orElseThrow();
    }
    public List<StudentEntity> getStudents () {
        return  studentRepository.findAll();
    }
    public StudentEntity getStudent(Long studentId){
        return  studentRepository.findById(studentId).orElseThrow();
    }
    public void deleteStudent(Long studentId){
        studentRepository.deleteById(studentId);
    }
}