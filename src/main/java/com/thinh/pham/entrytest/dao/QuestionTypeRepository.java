package com.thinh.pham.entrytest.dao;

import com.thinh.pham.entrytest.entity.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTypeRepository extends JpaRepository<QuestionType, Integer> {
}
