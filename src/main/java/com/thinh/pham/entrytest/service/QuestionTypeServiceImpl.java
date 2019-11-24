package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.dao.QuestionTypeRepository;
import com.thinh.pham.entrytest.entity.QuestionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

    private QuestionTypeRepository questionTypeRepository;

    @Autowired
    public QuestionTypeServiceImpl(QuestionTypeRepository questionTypeRepository) {
        this.questionTypeRepository = questionTypeRepository;
    }

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public QuestionType findById(int theId) {
        Optional<QuestionType> result = questionTypeRepository.findById(theId);

        QuestionType theQuestionType = null;

        if (result.isPresent()) {
            theQuestionType = result.get();
        } else {
            throw new RuntimeException("Did not find question type id - " + theId);
        }

        return theQuestionType;
    }

    @Override
    public void save(QuestionType questionType) {
        questionTypeRepository.save(questionType);
    }

    @Override
    public void deleteById(int theId) {
        questionTypeRepository.deleteById(theId);
    }

    @Override
    public boolean existsById(Integer theId) {
        return questionTypeRepository.existsById(theId);
    }
}
