package com.thinh.pham.entrytest.dao;

import com.thinh.pham.entrytest.entity.Part;
import com.thinh.pham.entrytest.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByDeleted(boolean isDeleted);

    List<Question> findByPart(Part part);
}
