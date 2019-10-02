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

import com.phamphuthinh.entity.Answer;
import com.phamphuthinh.service.AnswerService;


@RestController
public class AnswerController {
	@Autowired
	AnswerService answerService;
	@RequestMapping(value = "/answer")
    public List<Answer> question() {
        return answerService.getAll();
    }
 
    @RequestMapping(value = "/createanswer", method = RequestMethod.POST)
    public Answer createAnswer(@Valid @RequestBody Answer answer)
    {
        return answerService.createAnswer(answer);
    }
 
    @RequestMapping(value = "/deleteanswer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAnswer(@PathVariable(value = "id") String id) 
    {
        return answerService.deleteAnswer(id);
    }
 
    @RequestMapping(value = "/updateanswer/{id}", method = RequestMethod.PUT)
    public Answer updateAnswer(@PathVariable(value = "id") String id, @Valid @RequestBody Answer answer) 
    {
        return answerService.updateAnswer(id, answer);
    }
    
    @RequestMapping(value = "/answerpage", method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> getTopicPage(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "5") Integer pageSize,
                        @RequestParam(defaultValue = "ANSWERID") String sortBy)
    {
        List<Answer> list = answerService.getAnswerPage(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<Answer>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}