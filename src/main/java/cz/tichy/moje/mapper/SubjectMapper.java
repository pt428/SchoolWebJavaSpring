package cz.tichy.moje.mapper;

import cz.tichy.moje.dto.StudentDto;
import cz.tichy.moje.dto.SubjectDto;
import cz.tichy.moje.entity.SubjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectEntity toEntity(SubjectDto subjectDto);
    SubjectDto toDto(SubjectEntity subjectEntity);
}
