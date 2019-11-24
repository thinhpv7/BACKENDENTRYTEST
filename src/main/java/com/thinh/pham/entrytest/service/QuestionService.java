package com.thinh.pham.entrytest.service;


import com.thinh.pham.entrytest.entity.Part;
import com.thinh.pham.entrytest.entity.Question;

import java.util.List;

public interface QuestionService {

    public List<Question> findAll();

    public Question findById(int theId);

    public void save(Question question);

    public void deleteById(int theId);

    public boolean existsById(Integer theId);

    List<Question> findByDeleted(boolean isDeleted);

    List<Question> findByPart(Part part);
}
