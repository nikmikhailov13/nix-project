package ua.nix.project.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Setter
@Getter
@ToString
@Table(name = "photo",schema = "nix")
public class PhotoEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;
    private String url;
    private String description;
    @Column(name = "student_id")
    private long studentId;
}
