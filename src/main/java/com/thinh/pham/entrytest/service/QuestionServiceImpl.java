package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.dao.QuestionRepository;
import com.thinh.pham.entrytest.entity.Part;
import com.thinh.pham.entrytest.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question findById(int theId) {
        Optional<Question> result = questionRepository.findById(theId);

        Question theQuestion = null;

        if (result.isPresent()) {
            theQuestion = result.get();
        } else {
            throw new RuntimeException("Did not find question id - " + theId);
        }

        return theQuestion ;
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void deleteById(int theId) {
        questionRepository.deleteById(theId);
    }

    @Override
    public boolean existsById(Integer theId) {
        return questionRepository.existsById(theId);
    }

    @Override
    public List<Question> findByDeleted(boolean isDeleted) {
        return questionRepository.findByDeleted(isDeleted);
    }

    @Override
    public List<Question> findByPart(Part part) {
        return questionRepository.findByPart(part);
    }
}
