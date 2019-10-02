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

import com.phamphuthinh.entity.Topic;
import com.phamphuthinh.service.TopicService;



@RestController
public class TopicController {
	@Autowired
	TopicService topicService;
	@RequestMapping(value = "/topic")
    public List<Topic> topic() {
        return topicService.getAll();
    }
 
    @RequestMapping(value = "/createtopic", method = RequestMethod.POST)
    public Topic createTopic(@Valid @RequestBody Topic topic)
    {
        return topicService.createTopic(topic);
    }
 
    @RequestMapping(value = "/deletetopic/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTopic(@PathVariable(value = "id") String id) 
    {
        return topicService.deleteTopic(id);
    }
 
    @RequestMapping(value = "/updatetopic/{id}", method = RequestMethod.PUT)
    public Topic updateTopic(@PathVariable(value = "id") String id, @Valid @RequestBody Topic topic) 
    {
        return topicService.updateTopic(id, topic);
    }
    
    @RequestMapping(value = "/topicpage", method = RequestMethod.GET)
    public ResponseEntity<List<Topic>> getTopicPage(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "5") Integer pageSize,
                        @RequestParam(defaultValue = "TOPICID") String sortBy)
    {
        List<Topic> list = topicService.getTopicPage(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<Topic>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}