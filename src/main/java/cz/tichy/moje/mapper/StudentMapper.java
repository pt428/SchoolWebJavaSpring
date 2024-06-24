package cz.tichy.moje.mapper;

import cz.tichy.moje.dto.StudentDto;
import cz.tichy.moje.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentEntity toEntity(StudentDto studentDto);
    StudentDto toDto(StudentEntity studentEntity);

}
