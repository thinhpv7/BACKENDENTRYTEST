package com.thinh.pham.entrytest.rest;

import com.thinh.pham.entrytest.entity.AnswersSheets;
import com.thinh.pham.entrytest.entity.TestExam;
import com.thinh.pham.entrytest.service.AnswersSheetsService;
import com.thinh.pham.entrytest.service.TestExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AnswersSheetsRestController {

    private AnswersSheetsService answersSheetsService;
    private TestExamService testExamService;

    public AnswersSheetsRestController(AnswersSheetsService answersSheetsService, TestExamService testExamService) {
        this.answersSheetsService = answersSheetsService;
        this.testExamService = testExamService;
    }

    @GetMapping("/answerssheets")
    public List<AnswersSheets> getAllAnswersSheets() {
        return answersSheetsService.findAll();
    }

    @GetMapping("/answerssheets/{answersSheetsId}")
    public AnswersSheets getAnswersSheets(@PathVariable int answersSheetsId) {
        if (answersSheetsService.existsById(answersSheetsId)) {
            return answersSheetsService.findById(answersSheetsId);
        } else {
            throw new RuntimeException("Id not invalid!");
        }
    }

    @PostMapping("/answerssheets")
    public AnswersSheets addAnswersSheets(@RequestBody AnswersSheets answersSheets) {
        if (answersSheets.getPoint() != 0 && answersSheets.getOrderAnswer() != null) {
            answersSheetsService.save(answersSheets);
            return answersSheetsService.findById(answersSheets.getId());
        } else {
            throw new RuntimeException("Data not valid!");
        }
    }

    @PostMapping("/{testExamId}/answerssheets")
    public String addAnswersSheetsIntoTestExam(@RequestBody List<AnswersSheets> answersSheetsList,
                                                      @PathVariable int testExamId) {
        if (testExamService.existsById(testExamId)) {
            TestExam theTestExam = testExamService.findById(testExamId);
            if (!answersSheetsList.isEmpty()) {
                theTestExam.setAnswersSheets(answersSheetsList);
                testExamService.save(theTestExam);
                return "SUCCESS!";

            } else {
                return "Data is empty!!!";
            }
        } else {
            throw new RuntimeException("ERROR!");
        }
    }

    @PutMapping("/answerssheets")
    public AnswersSheets updateAnswersSheets(@RequestBody  AnswersSheets answersSheets) {
        if (answersSheets.getPoint() != 0 && answersSheets.getOrderAnswer() != null) {
            answersSheetsService.save(answersSheets);
            return answersSheetsService.findById(answersSheets.getId());
        } else {
            throw new RuntimeException("Data not valid!");
        }
    }

    @DeleteMapping("/answerssheets/{answersSheetsId}")
    public String deleteAnswersSheets(@PathVariable int answersSheetsId) {
        if (answersSheetsService.existsById(answersSheetsId)) {
            answersSheetsService.deleteById(answersSheetsId);
            return "Deleted answer sheet id - " + answersSheetsId;
        } else {
            throw new RuntimeException("Did not found answer sheet id - " + answersSheetsId);
        }
    }

}
