package ua.nix.project;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.nix.project.controller.StudentController;
import ua.nix.project.entity.StudentEntity;
import ua.nix.project.service.StudentService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProjectApplicationTests {

  @InjectMocks
  private StudentController studentController;

  @Mock
  private StudentService studentService;

  private StudentEntity student1;
  private StudentEntity student2;
  private List<StudentEntity> studentList;

  @Test
  void contextLoads() {
  }

  @BeforeEach
  public void setUp() {
    student1 = new StudentEntity(1L, "John Doe", "john.doe@example.com", null);
    student2 = new StudentEntity(2L, "Jane Doe", "jane.doe@example.com", null);
    studentList = new ArrayList<>();
    studentList.add(student1);
    studentList.add(student2);
  }

  @Test
  void deleteStudent_ShouldReturnNoContent() {
    long id = 1L;
    StudentEntity student = new StudentEntity();
    student.setId(id);
    when(studentService.findById(id)).thenReturn(student);
    doNothing().when(studentService).delete(student);

    ResponseEntity<Void> response = studentController.deleteStudent(id);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    verify(studentService, times(1)).findById(id);
    verify(studentService, times(1)).delete(student);
  }

  @Test
  void deleteStudent_ShouldReturnNotFound() {
    long id = 1L;
    when(studentService.findById(id)).thenReturn(null);

    ResponseEntity<Void> response = studentController.deleteStudent(id);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    verify(studentService, times(1)).findById(id);
    verify(studentService, times(0)).delete(any());
  }

  @Test
  void updateStudent_ShouldReturnOk() {
    long id = 1L;
    StudentEntity student = new StudentEntity();
    student.setId(id);
    student.setName("John Doe");
    student.setEmail("john.doe@example.com");
    when(studentService.findById(id)).thenReturn(student);
    when(studentService.save(student)).thenReturn(student);

    ResponseEntity<StudentEntity> response = studentController.updateStudent(id, student);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo(student);
    verify(studentService, times(1)).findById(id);
    verify(studentService, times(1)).save(student);
  }

  @Test
  void updateStudent_ShouldReturnNotFound() {
    long id = 1L;
    StudentEntity student = new StudentEntity();
    student.setId(id);
    student.setName("John Doe");
    student.setEmail("john.doe@example.com");
    when(studentService.findById(id)).thenReturn(null);

    ResponseEntity<StudentEntity> response = studentController.updateStudent(id, student);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    verify(studentService, times(1)).findById(id);
    verify(studentService, times(0)).save(student);
  }

  @Test
  public void getAllStudents_returnsListOfStudents() {
    when(studentService.findAll()).thenReturn(studentList);

    List<StudentEntity> result = studentController.getAllStudents();

    verify(studentService, times(1)).findAll();
    assertNotNull(result);
    assertEquals(studentList, result);
  }

  @Test
  public void getStudentById_returnsStudent() {
    when(studentService.findById(1L)).thenReturn(student1);

    ResponseEntity<StudentEntity> result = studentController.getStudentById(1L);

    verify(studentService, times(1)).findById(1L);
    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
    assertEquals(student1, result.getBody());
  }

  @Test
  public void getStudentById_studentNotFound() {
    when(studentService.findById(1L)).thenReturn(null);

    ResponseEntity<StudentEntity> result = studentController.getStudentById(1L);

    verify(studentService, times(1)).findById(1L);
    assertNotNull(result);
    assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
  }


}
