package com.thinh.pham.entrytest.rest;

import com.thinh.pham.entrytest.entity.TestExam;
import com.thinh.pham.entrytest.entity.User;
import com.thinh.pham.entrytest.service.TestExamService;
import com.thinh.pham.entrytest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TestExamRestController {

    private TestExamService testExamService;
    private UserService userService;

    public TestExamRestController(TestExamService testExamService, UserService userService) {
        this.testExamService = testExamService;
        this.userService = userService;
    }

    @GetMapping("/testexams")
    public List<TestExam> getAllTestExam() {
        return testExamService.findAll();
    }

    @GetMapping("/testexams/{testexamsId}")
    public TestExam getTestExamById(@PathVariable int testexamsId) {
        if (testExamService.existsById(testexamsId)) {
            return testExamService.findById(testexamsId);
        } else {
            return null;
        }
    }

    @PostMapping("/{userName}/testexams")
    public String addTestExam(@RequestBody TestExam testExam, @PathVariable String userName) {
        if (userService.existsById(userName)) {
            User theUserName = userService.findById(userName);
            testExam.setUser(theUserName);
            testExamService.save(testExam);
            return "SUCCESS!";
        } else {
            return "FAILED!";
        }
    }

    @PostMapping("/testexams")
    public TestExam addTestExam(@RequestBody TestExam testExam) {
        testExamService.save(testExam);
        return testExamService.findById(testExam.getId());
    }

    @PutMapping("/testexams")
    public TestExam updateTestExam(@RequestBody TestExam testExam) {
        testExamService.save(testExam);
        return testExamService.findById(testExam.getId());
    }

    @DeleteMapping("/testexams/{testexamsId}")
    public String deleteById(@PathVariable int testexamsId) {
        if (testExamService.existsById(testexamsId)) {
            testExamService.deleteById(testexamsId);
            return "Deleted test exam id - " + testexamsId;
        } else {
            throw new RuntimeException("Test exam id not found - " + testexamsId);
        }
    }
}
