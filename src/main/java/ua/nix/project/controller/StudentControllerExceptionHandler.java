package ua.nix.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.nix.project.controller.dto.ErrorDto;
import ua.nix.project.exception.StudentNotFoundException;

@ControllerAdvice
public class StudentControllerExceptionHandler {

  @ExceptionHandler(StudentNotFoundException.class)
  public ResponseEntity<ErrorDto> handleException(StudentNotFoundException e) {

    return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.NOT_FOUND);
  }

}
