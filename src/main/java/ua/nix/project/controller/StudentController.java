package ua.nix.project.controller;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nix.project.controller.dto.StudentDto;
import ua.nix.project.controller.dto.mapper.StudentMapper;
import ua.nix.project.repository.entity.StudentEntity;
import ua.nix.project.service.StudentService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

  private final StudentService studentService;

  @PostMapping("/")
  public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {

    StudentEntity student = StudentMapper.INSTANCE.toEntity(studentDto);

    StudentDto responseDto = StudentMapper.INSTANCE.toDto(
        studentService.createStudent(student));

    return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
  }

  @PutMapping("/")
  public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) {

    StudentEntity student = StudentMapper.INSTANCE.toEntity(studentDto);

    StudentDto responseDto = StudentMapper.INSTANCE.toDto(studentService.updateStudent(student));

    return ResponseEntity.ok(responseDto);
  }

  @DeleteMapping("/{studentId}")
  public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {

    studentService.deleteStudent(studentId);

    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{studentId}")
  public ResponseEntity<StudentDto> getStudent(@PathVariable Long studentId) {

    StudentDto responseDto = StudentMapper.INSTANCE.toDto(studentService.getStudent(studentId));
    return new ResponseEntity<>(responseDto, HttpStatus.OK);
  }

  @GetMapping("/")
  public ResponseEntity<List<StudentDto>> getStudents() {

    List<StudentDto> responseDto = StudentMapper.INSTANCE.toDtoList(
        studentService.getStudents());

    return new ResponseEntity<>(responseDto, HttpStatus.OK);
  }
}