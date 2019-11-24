package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.dao.CandidateRepository;
import com.thinh.pham.entrytest.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    private CandidateRepository candidateRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate findById(int theId) {
        Optional<Candidate> result = candidateRepository.findById(theId);

        Candidate theCandidate = null;

        if (result.isPresent()) {
            theCandidate = result.get();
        } else {
            throw new RuntimeException("Did not find candidate id - " + theId);
        }

        return theCandidate;
    }

    @Override
    public void save(Candidate candidate) {

        candidateRepository.save(candidate);
    }

    @Override
    public void deleteById(int theId) {

        candidateRepository.deleteById(theId);
    }

    @Override
    public boolean existsById(Integer theID) {
        return candidateRepository.existsById(theID);
    }

    @Override
    public List<Candidate> findByDeleted(boolean isDelete) {
        return candidateRepository.findByDeleted(isDelete);
    }
}
