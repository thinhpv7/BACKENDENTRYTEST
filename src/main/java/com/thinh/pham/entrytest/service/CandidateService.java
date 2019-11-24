package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.entity.Candidate;

import java.util.List;

public interface CandidateService {

    public List<Candidate> findAll();

    public Candidate findById(int theId);

    public void save(Candidate candidate);

    public void deleteById(int theId);

    boolean existsById(Integer theID);

    List<Candidate> findByDeleted(boolean isDelete);
}
