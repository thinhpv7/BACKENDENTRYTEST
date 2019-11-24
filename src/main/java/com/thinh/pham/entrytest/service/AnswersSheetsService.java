package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.entity.AnswersSheets;

import java.util.List;

public interface AnswersSheetsService {

    public List<AnswersSheets> findAll();

    public AnswersSheets findById(int theId);

    public void save(AnswersSheets answersSheets);

    public void deleteById(int theId);

    public boolean existsById(Integer theId);
}
