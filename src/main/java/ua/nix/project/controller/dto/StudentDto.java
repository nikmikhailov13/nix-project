package ua.nix.project.controller.dto;

import lombok.*;

@Builder
@Data
public class StudentDto {
    private long id;
    private String name;
    private String email;
}
