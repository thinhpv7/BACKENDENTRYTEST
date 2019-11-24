package com.thinh.pham.entrytest.dao;

import com.thinh.pham.entrytest.entity.Part;
import com.thinh.pham.entrytest.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, Integer> {

    List<Part> findBySubject(Subject subject);
}
