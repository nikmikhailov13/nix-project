package ua.nix.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Struct;

@Entity
@Setter
@Getter
@Table(name = "photo", schema = "nix")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String url;

    @Column
    private String descr;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private StudentEntity student;

}
