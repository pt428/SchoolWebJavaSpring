package cz.tichy.moje.controller;

import cz.tichy.moje.dto.SubjectDto;
import cz.tichy.moje.mapper.SubjectMapper;
import cz.tichy.moje.reposity.SubjectRepository;
import cz.tichy.moje.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public List<SubjectDto> getSubjects() {
        return subjectService.getSubjects();
    }

    @GetMapping("/subjects{id}")
    public SubjectDto getSubject(@PathVariable("id") Integer id){
        return subjectService.getSubject(id);
    }

    @PostMapping("/subjects")
    public SubjectDto addSubject(@RequestBody SubjectDto subjectDto){
        return  subjectService.addSubject(subjectDto);
    }

    @PutMapping("/subject{id}")
    public  SubjectDto editSubject(@PathVariable("id") Integer id,@RequestBody SubjectDto subjectDto){
        return subjectService.editSubject(id, subjectDto);
    }

    @DeleteMapping("/subject{id}")
    public SubjectDto deleteSubject(@PathVariable("id") Integer id){
        return subjectService.deleteSubject(id);
    }
}
