package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.dao.TestRepository;
import com.thinh.pham.entrytest.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService{

    private TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public Test findById(int theId) {

        Optional<Test> result = testRepository.findById(theId);

        Test theTest = null;

        if (result.isPresent()) {
            theTest = result.get();
        } else {
            throw new RuntimeException("Did not find test id - " + theId);
        }

        return theTest;
    }

    @Override
    public void save(Test test) {
        testRepository.save(test);
    }

    @Override
    public void deleteById(int theId) {
        testRepository.deleteById(theId);
    }

    @Override
    public boolean existsById(int theId) {
        return testRepository.existsById(theId);
    }

    @Override
    public List<Test> findByDeleted(boolean isDeleted) {
        return testRepository.findByDeleted(isDeleted);
    }
}
