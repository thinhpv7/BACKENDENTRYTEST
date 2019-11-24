package com.thinh.pham.entrytest.dao;

import com.thinh.pham.entrytest.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
