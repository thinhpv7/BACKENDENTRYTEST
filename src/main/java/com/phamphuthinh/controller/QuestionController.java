package com.phamphuthinh.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phamphuthinh.entity.Question;
import com.phamphuthinh.service.QuestionService;


@RestController
public class QuestionController {
	@Autowired
	QuestionService questionService;
	@RequestMapping(value = "/question")
    public List<Question> question() {
        return questionService.getAll();
    }
 
    @RequestMapping(value = "/createquestion", method = RequestMethod.POST)
    public Question createQuestion(@Valid @RequestBody Question question)
    {
        return questionService.createQuestion(question);
    }
 
    @RequestMapping(value = "/deletequestion/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteQuestion(@PathVariable(value = "id") String id) 
    {
        return questionService.deleteQuestion(id);
    }
 
    @RequestMapping(value = "/updatequestion/{id}", method = RequestMethod.PUT)
    public Question updateQuestion(@PathVariable(value = "id") String id, @Valid @RequestBody Question question) 
    {
        return questionService.updateQuestion(id, question);
    }
    
    @RequestMapping(value = "/questionpage", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getTopicPage(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "5") Integer pageSize,
                        @RequestParam(defaultValue = "QUESTIONID") String sortBy)
    {
        List<Question> list = questionService.getQuestionPage(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<Question>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}