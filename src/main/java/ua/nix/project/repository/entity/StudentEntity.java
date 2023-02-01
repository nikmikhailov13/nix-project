package ua.nix.project.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Setter
@Getter
@ToString
@Table(name = "student", schema = "nix")
public class StudentEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String email;
////    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private List<PhotoEntity> photos;

}
