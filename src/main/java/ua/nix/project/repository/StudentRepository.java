package ua.nix.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.nix.project.repository.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Modifying
    @Query("UPDATE StudentEntity s SET s.name = :name, s.email = :email WHERE s.id = :id")
    int updateStudent(@Param("id") Long studentId, @Param("name") String name, @Param("email") String email);
}
