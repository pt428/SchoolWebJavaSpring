package cz.tichy.moje.service;

import cz.tichy.moje.dto.StudentDto;
import cz.tichy.moje.entity.StudentEntity;
import cz.tichy.moje.mapper.StudentMapper;
import cz.tichy.moje.reposity.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    public List<StudentDto> getStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDto> studentDto = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntities) {
            studentDto.add(studentMapper.toDto(studentEntity));
        }
        return studentDto;
    }
    public StudentDto getStudent(Integer id) {
/*        StudentEntity studentEntity =  studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
           if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }*/
        StudentEntity studentEntity = studentRepository.getReferenceById(id);
        return studentMapper.toDto(studentEntity);
    }

    public StudentDto addStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.toEntity(studentDto);
        StudentEntity savedEntity = studentRepository.save(studentEntity);
        return studentMapper.toDto(savedEntity);
    }


    public  StudentDto editStudent(Integer id,StudentDto studentDto){
/*        StudentEntity studentToEdit = studentRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);*/
        if(!studentRepository.existsById(id)){
            throw  new EntityNotFoundException();
        }
        StudentEntity studentEntity = studentMapper.toEntity(studentDto);
        studentEntity.setId(id);
        StudentEntity savedStudent =  studentRepository.save(studentEntity);
        return  studentMapper.toDto(savedStudent);
    }
    public StudentDto deleteStudent(Integer id){
        StudentEntity studentToDelete = studentRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        StudentDto deletedStudent = studentMapper.toDto(studentToDelete);
        studentRepository.delete(studentToDelete);
        return  deletedStudent;
    }
}
