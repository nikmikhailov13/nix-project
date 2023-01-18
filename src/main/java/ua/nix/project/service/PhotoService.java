package ua.nix.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nix.project.entity.PhotoEntity;
import ua.nix.project.entity.StudentEntity;
import ua.nix.project.repository.PhotoRepository;
import ua.nix.project.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;

    public void createPhoto(String descr, String url, StudentEntity studentEntity) {

        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setDescr(descr);
        photoEntity.setStudent(studentEntity);
        photoEntity.setUrl(url);
        photoRepository.save(photoEntity);

    }

    public List<PhotoEntity> findPhotoByDescr(String descr) {
        return photoRepository.findByDescr(descr);
    }

}