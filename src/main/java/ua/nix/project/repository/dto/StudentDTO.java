package ua.nix.project.repository.dto;

import lombok.*;

@Builder
@Data
public class StudentDTO {
    private long id;
    private String name;
    private String email;
}
