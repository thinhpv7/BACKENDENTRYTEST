package com.thinh.pham.entrytest.rest;

import com.thinh.pham.entrytest.entity.Part;
import com.thinh.pham.entrytest.entity.Question;
import com.thinh.pham.entrytest.entity.QuestionType;
import com.thinh.pham.entrytest.service.PartService;
import com.thinh.pham.entrytest.service.QuestionService;
import com.thinh.pham.entrytest.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class QuestionRestController {

    private QuestionService questionService;

    private QuestionTypeService questionTypeService;

    private PartService partService;

    @Autowired
    public QuestionRestController(QuestionService questionService, QuestionTypeService questionTypeService, PartService partService) {
        this.questionService = questionService;
        this.questionTypeService = questionTypeService;
        this.partService = partService;
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestion() {
        return questionService.findAll();
    }

    @GetMapping("/parts/{partId}/questions")
    public List<Question> getAllQuestionByPart(@PathVariable int partId) {
        if (partService.existsById(partId)) {
            Part thePart = partService.findById(partId);
            return questionService.findByPart(thePart);
        } else {
            return null;
        }
    }

    @GetMapping("/{isDeleted}/questions")
    public List<Question> getAllQuestionByIsDeleted(@PathVariable boolean isDeleted) {
        return questionService.findByDeleted(isDeleted);
    }

    @GetMapping("/questions/{questionId}")
    public Question getQuestion(@PathVariable int questionId) {
        if (questionService.existsById(questionId)) {
            return questionService.findById(questionId);
        } else {
            return null;
        }
    }

    @PostMapping("/questions")
    public Question addQuestion(@RequestBody Question question) {

        System.out.println(question);

        questionService.save(question);
        return questionService.findById(question.getId());
    }

    @PostMapping("/{partId}/{questiontypeId}/questions")
    public String addQuestionIntoQuestionType(@RequestBody Question question, @PathVariable int questiontypeId,
                                              @PathVariable int partId) {
        if (questionTypeService.existsById(questiontypeId) && partService.existsById(partId)) {
            QuestionType questionType = questionTypeService.findById(questiontypeId);
            Part part = partService.findById(partId);
            question.setPart(part);
            questionTypeService.save(questionType);
            return "SUCCESS!!";
        } else {
            return "FAILED!!";
        }
    }

    @PutMapping("/questions")
    public Question updateQuestion(@RequestBody Question question) {
        questionService.save(question);
        return questionService.findById(question.getId());
    }

    @DeleteMapping("/questions/{questionId}")
    public String deleteQuestion(@PathVariable int questionId) {
        if (questionService.existsById(questionId)) {
            questionService.deleteById(questionId);
            return "Deleted question id - " + questionId;
        } else {
            throw new RuntimeException("Question id not found - " + questionId);
        }
    }
}
