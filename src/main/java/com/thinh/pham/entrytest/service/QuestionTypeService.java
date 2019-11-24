package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.entity.QuestionType;

import java.util.List;

public interface QuestionTypeService {

    public List<QuestionType> findAll();

    public QuestionType findById(int theId);

    public void save(QuestionType questionType);

    public void deleteById(int theId);

    public boolean existsById(Integer theId);
}
