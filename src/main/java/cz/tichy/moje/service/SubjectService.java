package cz.tichy.moje.service;

import cz.tichy.moje.dto.SubjectDto;
import cz.tichy.moje.entity.SubjectEntity;
import cz.tichy.moje.mapper.SubjectMapper;
import cz.tichy.moje.reposity.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMapper subjectMapper;

    public List<SubjectDto> getSubjects(){
        List<SubjectEntity> subjectEntities = subjectRepository.findAll();
        List<SubjectDto> subjectDtos = new ArrayList<>();
        for(SubjectEntity subjectEntity : subjectEntities){
            subjectDtos.add(subjectMapper.toDto(subjectEntity));

        }
        return  subjectDtos;
    }

  public SubjectDto getSubject(Integer id){
        SubjectEntity subjectEntity = subjectRepository.getReferenceById(id);
        return  subjectMapper.toDto(subjectEntity);
  }

    public  SubjectDto addSubject(SubjectDto subjectDto){
        SubjectEntity subjectEntity = subjectMapper.toEntity(subjectDto);
        SubjectEntity saveEntity = subjectRepository.save(subjectEntity);
        return subjectMapper.toDto(saveEntity);
    }
    public SubjectDto editSubject(Integer id, SubjectDto subjectDto){
        SubjectEntity subjectToEdit = subjectRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        SubjectEntity subjectEntity = subjectMapper.toEntity(subjectDto);
        subjectEntity.setId(id);
    SubjectEntity saveSubject = subjectRepository.save(subjectEntity);
    return  subjectMapper.toDto(saveSubject);
    }
    public  SubjectDto deleteSubject(Integer id){
        SubjectEntity subjectToDelete = subjectRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        subjectRepository.delete(subjectToDelete);
        return     subjectMapper.toDto(subjectToDelete);


    }
}
