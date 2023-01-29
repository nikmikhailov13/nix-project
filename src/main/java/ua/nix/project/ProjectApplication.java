package ua.nix.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ua.nix.project.entity.PhotoEntity;
import ua.nix.project.entity.StudentEntity;
import ua.nix.project.service.PhotoService;
import ua.nix.project.service.StudentService;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProjectApplication {

  @Autowired
  private StudentService studentService;

  @Autowired
  private PhotoService photoService;

  public static void main(String[] args) {
    SpringApplication.run(ProjectApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      StudentEntity studentEntity = studentService.createStudent("Mark", "mark1234@gmail.com");
      photoService.createPhoto("myPhoto", "/myphoto1.jpg", studentEntity);
      List<PhotoEntity> photoEntity = photoService.findPhotoByDescr("myPhoto");
      photoEntity.stream().forEach(System.out::println);
    };
  }

}
