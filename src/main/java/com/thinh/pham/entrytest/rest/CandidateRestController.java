package com.thinh.pham.entrytest.rest;

import com.thinh.pham.entrytest.entity.Candidate;
import com.thinh.pham.entrytest.entity.Classe;
import com.thinh.pham.entrytest.service.CandidateService;
import com.thinh.pham.entrytest.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CandidateRestController {

    private CandidateService candidateService;

    private ClassService classService;

    @Autowired
    public CandidateRestController(CandidateService candidateService, ClassService classService) {
        this.candidateService = candidateService;
        this.classService = classService;
    }

    @GetMapping("/candidates")
    public List<Candidate> getAllCandidate() {
        return candidateService.findAll();
    }

    @GetMapping("/{isDeleted}/candidates")
    public List<Candidate> getAllCandidateByIsDeleted(@PathVariable boolean isDeleted) {
        return candidateService.findByDeleted(isDeleted);
    }

    @GetMapping("/candidates/{candidateId}")
    public Candidate getCandidateById(@PathVariable int candidateId) {
        return candidateService.findById(candidateId);
    }

    @PostMapping("/candidates")
    public Candidate addCandidate(@RequestBody Candidate candidate) {
        candidate.setId(0);
        candidateService.save(candidate);
        return candidateService.findById(candidate.getId());
    }

    @PostMapping("/{classId}/candidates")
    public Candidate addCandidateIntoClass(@RequestBody Candidate candidate, @PathVariable int classId) {
        if (classService.existsById(classId)) {
            Classe tempClass = classService.findById(classId);
            candidate.setClasse(tempClass);
            candidateService.save(candidate);
            return candidateService.findById(candidate.getId());
        }

        return null;
    }

    @PutMapping("/candidates")
    public Candidate updateCandidate(@RequestBody Candidate candidate) {
        candidateService.save(candidate);
        return candidateService.findById(candidate.getId());
    }

    @DeleteMapping("/candidates/{candidateId}")
    public String deleteCandidate(@PathVariable int candidateId) {
        Candidate tempCandidate = candidateService.findById(candidateId);

        if (tempCandidate == null) {
            throw new RuntimeException("Candidate id not found - " + candidateId);
        }

        candidateService.deleteById(candidateId);

        return "Deleted candidate id - " + candidateId;
    }

}

