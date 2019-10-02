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

import com.phamphuthinh.entity.QuestionType;
import com.phamphuthinh.service.QuestionTypeService;


@RestController
public class QuestionTypeController {
	@Autowired
	QuestionTypeService questionTypeService;
	@RequestMapping(value = "/questiontype")
    public List<QuestionType> topic() {
        return questionTypeService.getAll();
    }
 
    @RequestMapping(value = "/createquestiontype", method = RequestMethod.POST)
    public QuestionType createTopic(@Valid @RequestBody QuestionType questiontype)
    {
        return questionTypeService.createQuestionType(questiontype);
    }
 
    @RequestMapping(value = "/deletequestiontype/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteQuestionType(@PathVariable(value = "id") String id) 
    {
        return questionTypeService.deleteQuestionType(id);
    }
 
    @RequestMapping(value = "/updatequestiontype/{id}", method = RequestMethod.PUT)
    public QuestionType updateQuestionType(@PathVariable(value = "id") String id, @Valid @RequestBody QuestionType questiontype) 
    {
        return questionTypeService.updateQuestionType(id, questiontype);
    }
    
    @RequestMapping(value = "/questiontypepage", method = RequestMethod.GET)
    public ResponseEntity<List<QuestionType>> getTopicPage(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "5") Integer pageSize,
                        @RequestParam(defaultValue = "QUESTIONTYPEID") String sortBy)
    {
        List<QuestionType> list = questionTypeService.getQuestionTypePage(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<QuestionType>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}