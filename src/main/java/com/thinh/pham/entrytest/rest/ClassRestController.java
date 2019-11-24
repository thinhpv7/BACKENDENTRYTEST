package com.thinh.pham.entrytest.rest;

import com.thinh.pham.entrytest.entity.Classe;
import com.thinh.pham.entrytest.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClassRestController {

    private ClassService classService;

    @Autowired
    public ClassRestController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/classes")
    public List<Classe> getAllClasses() {
        return classService.findAll();
    }

    @GetMapping("/classes/{classId}")
    public Classe getClassById(@PathVariable int classId) {
        return classService.findById(classId);
    }

    @PostMapping("/classes")
    public Classe addClass(@RequestBody Classe classe) {
        classe.setId(0);

        classService.save(classe);
        return classService.findById(classe.getId());
    }

    @PutMapping("/classes")
    public Classe updateClass(@RequestBody Classe classe) {

        classService.save(classe);
        return classService.findById(classe.getId());
    }

    @DeleteMapping("/classes/{classId}")
    public String deleteClass(@PathVariable int classId) {
        Classe tempClass = classService.findById(classId);

        if (tempClass == null) {
            throw new RuntimeException("Class id not found - " + classId);
        }

        classService.deleteById(classId);
        return "Deleted class id - " + classId;
    }
}
