package com.thinh.pham.entrytest.rest;

import com.thinh.pham.entrytest.entity.Subject;
import com.thinh.pham.entrytest.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SubjectRestController {

    private SubjectService subjectService;

    @Autowired
    public SubjectRestController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public List<Subject> getAllSubject() {
        return subjectService.findAll();
    }

    @GetMapping("/subjects/{subjectId}")
    public Subject getSubjectById(@PathVariable int subjectId) {
        if (subjectService.existsById(subjectId)) {
            return subjectService.findById(subjectId);
        }

        return null;
    }

    @PostMapping("/subjects")
    public Subject addSubject(@RequestBody Subject subject) {
        subjectService.save(subject);
        return subjectService.findById(subject.getId());
    }

    @PutMapping("/subjects")
    public Subject updateSubject(@RequestBody Subject subject) {
        subjectService.save(subject);
        return subjectService.findById(subject.getId());
    }

    @DeleteMapping("/subjects/{subjectId}")
    public  String deleteSubject(@PathVariable int subjectId) {
        Subject tempSubject = subjectService.findById(subjectId);

        if (tempSubject == null) {
            throw new RuntimeException("Subject id not fount - " + subjectId);
        }

        subjectService.deleteById(subjectId);

        return "Deleted subject id - " + subjectId;
    }
}
