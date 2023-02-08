package ua.nix.project;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import ua.nix.project.entity.StudentEntity;
import ua.nix.project.repository.StudentRepository;
import ua.nix.project.service.StudentService;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    private int port;

    private String baseUrl;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        baseUrl = "http://localhost:" + port + "/students";
    }

    @Test
    public void testGetAllStudents() {
        given().when().get(baseUrl).then().statusCode(200);
    }

    @Test
    public void testGetStudentById() {
        StudentEntity student = new StudentEntity(1L, "Jane Doe", "jane.doe@example.com", null);
        student = studentRepository.save(student);
        long id = student.getId();
        given().when().get(baseUrl + "/" + id).then().statusCode(200);
    }

    @Test
    public void testCreateStudent() {
        StudentEntity student = new StudentEntity(1L, "John Doe", "john.doe@example.com",  null);
        given().contentType(ContentType.JSON).body(student)
                .when().post(baseUrl)
                .then().statusCode(201);
    }

    @Test
    public void testUpdateStudent() {
        StudentEntity student = new StudentEntity(1L, "Jane Doe", "jane.doe@example.com", null);
        student = studentRepository.save(student);
        long id = student.getId();
        given().contentType(ContentType.JSON).body(student)
                .when().put(baseUrl + "/" + id)
                .then().statusCode(200);
    }

    @Test
    public void testDeleteStudent() {
        StudentEntity student = new StudentEntity(1L, "Jane Doe", "jane.doe@example.com", null);
        student = studentRepository.save(student);
        long id = student.getId();
        given().when().delete(baseUrl + "/" + id).then().statusCode(204);
    }
}