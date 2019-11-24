package com.thinh.pham.entrytest.dao;

import com.thinh.pham.entrytest.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    List<Candidate> findByDeleted(boolean isDelete);
}
