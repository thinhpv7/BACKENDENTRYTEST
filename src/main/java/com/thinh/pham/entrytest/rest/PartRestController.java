package com.thinh.pham.entrytest.rest;

import com.thinh.pham.entrytest.entity.Part;
import com.thinh.pham.entrytest.entity.Subject;
import com.thinh.pham.entrytest.service.PartService;
import com.thinh.pham.entrytest.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PartRestController {

    private PartService partService;
    private SubjectService subjectService;

    @Autowired
    public PartRestController(PartService partService, SubjectService subjectService) {
        this.partService = partService;
        this.subjectService = subjectService;
    }

    @GetMapping("/parts")
    public List<Part> getAllPart() {
        return partService.findAll();
    }

    @GetMapping("/parts/{partId}")
    public Part getPart(@PathVariable int partId) {
        if (partService.existsById(partId)) {
            return partService.findById(partId);
        } else {
            return null;
        }
    }

    @GetMapping("/{subjectId}/parts")
    public List<Part> getAllPartBySubject(@PathVariable int subjectId) {
        if (subjectService.existsById(subjectId)) {
            Subject theSubject = subjectService.findById(subjectId);
            return partService.findBySubject(theSubject);
        } else {
            return null;
        }
    }

    @PostMapping("/parts")
    public Part addPart(@RequestBody Part part) {
        partService.save(part);
        return partService.findById(part.getId());
    }

    @PutMapping("/parts")
    public Part updatePart(@RequestBody Part part) {
        partService.save(part);
        return partService.findById(part.getId());
    }

    @DeleteMapping("/parts/{partId}")
    public String deletePart(@PathVariable int partId) {
        if (partService.existsById(partId)) {
            partService.deleteById(partId);
            return "Deleted part id - " + partId;
        } else {
            throw new RuntimeException("Part id not found - " + partId);
        }
    }
}
