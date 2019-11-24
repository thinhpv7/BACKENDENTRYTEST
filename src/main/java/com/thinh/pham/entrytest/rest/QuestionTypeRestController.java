package com.thinh.pham.entrytest.rest;

import com.thinh.pham.entrytest.entity.QuestionType;
import com.thinh.pham.entrytest.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class QuestionTypeRestController {

    private QuestionTypeService questionTypeService;

    @Autowired
    public QuestionTypeRestController(QuestionTypeService questionTypeService) {
        this.questionTypeService = questionTypeService;
    }

    @GetMapping("/questiontypes")
    public List<QuestionType> getAllQuestionType() {
        return questionTypeService.findAll();
    }

    @GetMapping("/questiontypes/{questiontypeId}")
    public QuestionType getQuestionType(@PathVariable int questiontypeId) {
        if (questionTypeService.existsById(questiontypeId)) {
            return questionTypeService.findById(questiontypeId);
        } else {
            return null;
        }
    }

    @PostMapping("/questiontypes")
    public QuestionType addQuestionType(@RequestBody QuestionType questionType) {
        questionTypeService.save(questionType);
        return questionTypeService.findById(questionType.getId());
    }

    @PutMapping("/questiontypes")
    public QuestionType updateQuestionType(@RequestBody QuestionType questionType) {
        questionTypeService.save(questionType);
        return questionTypeService.findById(questionType.getId());
    }

    @DeleteMapping("/questiontypes/{questiontypeId}")
    public String deleteQuestionType(@PathVariable int questiontypeId) {
        if (questionTypeService.existsById(questiontypeId)) {
            questionTypeService.deleteById(questiontypeId);
            return "Deleted question type id - " + questiontypeId;
        } else {
            return "Did not found question type id - " + questiontypeId;
        }
    }
}
