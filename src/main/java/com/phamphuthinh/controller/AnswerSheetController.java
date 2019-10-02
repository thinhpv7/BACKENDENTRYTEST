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

import com.phamphuthinh.entity.AnswerSheet;
import com.phamphuthinh.service.AnswerSheetService;


@RestController
public class AnswerSheetController {
	@Autowired
	AnswerSheetService answerSheetService;
	@RequestMapping(value = "/answersheet")
    public List<AnswerSheet> question() {
        return answerSheetService.getAll();
    }
 
    @RequestMapping(value = "/createanswersheet", method = RequestMethod.POST)
    public AnswerSheet createAnswerSheet(@Valid @RequestBody AnswerSheet answersheet)
    {
        return answerSheetService.createAnswerSheet(answersheet);
    }
 
    @RequestMapping(value = "/deleteanswersheet/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAnswerSheet(@PathVariable(value = "id") String id) 
    {
        return answerSheetService.deleteAnswerSheet(id);
    }
 
    @RequestMapping(value = "/updateanswersheet/{id}", method = RequestMethod.PUT)
    public AnswerSheet updateAnswerSheet(@PathVariable(value = "id") String id, @Valid @RequestBody AnswerSheet answersheet) 
    {
        return answerSheetService.updateAnswerSheet(id, answersheet);
    }
    
    @RequestMapping(value = "/answersheetpage", method = RequestMethod.GET)
    public ResponseEntity<List<AnswerSheet>> getTopicPage(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "5") Integer pageSize,
                        @RequestParam(defaultValue = "ANSWERSHEETID") String sortBy)
    {
        List<AnswerSheet> list = answerSheetService.getAnswerSheetPage(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<AnswerSheet>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}