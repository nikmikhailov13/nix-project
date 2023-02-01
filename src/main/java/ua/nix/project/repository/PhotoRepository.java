package ua.nix.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nix.project.entity.PhotoEntity;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {

     List<PhotoEntity> findByDescr(String name);
}
