package com.thinh.pham.entrytest.dao;

import com.thinh.pham.entrytest.entity.TestExam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestExamRepository extends JpaRepository<TestExam, Integer> {
}
