package ua.nix.project.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nix.project.exception.StudentNotFoundException;
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

    public StudentEntity updateStudent(StudentEntity studentEntity) {

        StudentEntity entity = studentRepository.findById(studentEntity.getId())
            .orElseThrow(StudentNotFoundException::new);

        if (studentEntity.getName() != null){
            entity.setName(studentEntity.getName());
        }

        if (studentEntity.getEmail() != null){
            entity.setEmail(studentEntity.getEmail());
        }

        if (studentEntity.getPhotos() != null  && studentEntity.getPhotos().isEmpty()){
            entity.setPhotos(studentEntity.getPhotos());
        }

        return studentRepository.save(entity);
    }


    public List<StudentEntity> getStudents () {
        return studentRepository.findAll();
    }

    public StudentEntity getStudent(Long studentId){
        return studentRepository.findById(studentId)
            .orElseThrow(StudentNotFoundException::new);
    }
    public void deleteStudent(Long studentId){

        StudentEntity entity = studentRepository.findById(studentId)
            .orElseThrow(StudentNotFoundException::new);

        studentRepository.delete(entity);
    }
}