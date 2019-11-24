package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.dao.TestExamRepository;
import com.thinh.pham.entrytest.entity.TestExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestExamServiceImpl implements TestExamService {

    private TestExamRepository testExamRepository;

    @Autowired
    public TestExamServiceImpl(TestExamRepository testExamRepository) {
        this.testExamRepository = testExamRepository;
    }

    @Override
    public List<TestExam> findAll() {
        return testExamRepository.findAll();
    }

    @Override
    public TestExam findById(int theId) {
        Optional<TestExam> result = testExamRepository.findById(theId);

        TestExam theTestExam = null;

        if (result.isPresent()) {
            theTestExam = result.get();
        } else {
            throw new RuntimeException("Did not find test exam id - " + theId);
        }

        return theTestExam;
    }

    @Override
    public void save(TestExam testExam) {
        testExamRepository.save(testExam);
    }

    @Override
    public void deleteById(int theId) {
        testExamRepository.deleteById(theId);
    }

    @Override
    public boolean existsById(Integer theId) {
        return testExamRepository.existsById(theId);
    }
}
