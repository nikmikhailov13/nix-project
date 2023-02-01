package ua.nix.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nix.project.repository.entity.PhotoEntity;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {

  PhotoEntity findByDescription(String description);
}