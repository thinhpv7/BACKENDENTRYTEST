package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.dao.AnswersSheetsRepository;
import com.thinh.pham.entrytest.entity.AnswersSheets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswersSheetsServiceImpl implements AnswersSheetsService {

    private AnswersSheetsRepository answersSheetsRepository;

    @Autowired
    public AnswersSheetsServiceImpl(AnswersSheetsRepository answersSheetsRepository) {
        this.answersSheetsRepository = answersSheetsRepository;
    }

    @Override
    public List<AnswersSheets> findAll() {
        return answersSheetsRepository.findAll();
    }

    @Override
    public AnswersSheets findById(int theId) {
        Optional<AnswersSheets> result = answersSheetsRepository.findById(theId);

        AnswersSheets theAnswersSheets = null;

        if (result.isPresent()) {
            theAnswersSheets = result.get();
        } else {
            throw new RuntimeException("Did not find answers sheet id - " + theId);
        }

        return theAnswersSheets;
    }

    @Override
    public void save(AnswersSheets answersSheets) {
        answersSheetsRepository.save(answersSheets);
    }

    @Override
    public void deleteById(int theId) {
        answersSheetsRepository.deleteById(theId);
    }

    @Override
    public boolean existsById(Integer theId) {
        return answersSheetsRepository.existsById(theId);
    }
}
