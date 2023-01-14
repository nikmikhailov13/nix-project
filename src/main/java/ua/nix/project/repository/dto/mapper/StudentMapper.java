package ua.nix.project.repository.dto.mapper;

import org.mapstruct.factory.Mappers;
import ua.nix.project.repository.dto.StudentDTO;
import ua.nix.project.repository.entity.StudentEntity;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO toDto(StudentEntity studentEntity);

    List<StudentDTO> toDtoList(List<StudentEntity> studentEntity);
}
