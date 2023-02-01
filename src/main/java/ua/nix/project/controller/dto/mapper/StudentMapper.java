package ua.nix.project.controller.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.nix.project.controller.dto.StudentDto;
import ua.nix.project.repository.entity.StudentEntity;

@Mapper
public interface StudentMapper {

  StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

  StudentDto toDto(StudentEntity studentEntity);

  StudentEntity toEntity(StudentDto studentDto);

  List<StudentDto> toDtoList(List<StudentEntity> studentEntityList);

  List<StudentEntity> toEntityList(List<StudentDto> studentDtoList);
}
