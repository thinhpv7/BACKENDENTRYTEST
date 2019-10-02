package com.phamphuthinh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phamphuthinh.entity.Topic;
import com.phamphuthinh.repository.TopicRepository;



@Service
public class TopicService {
	@Autowired
	TopicRepository topicRepository;
	
	public List<Topic> getAll() {
        return (List<Topic>) topicRepository.findAll();
    }
     
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }
     
    public Topic updateTopic(String topicId, Topic topic)
    {
    	Topic updatedTP;
        Optional<Topic> searchEntity = topicRepository.findById(topicId);
        if (searchEntity.isPresent()) {
        	Topic tp = searchEntity.get();
        	tp.setTOPICID(topic.getTOPICID());
        	tp.setTopicName(topic.getTopicName());
        	updatedTP = topicRepository.save(tp);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedTP;
       }
     
      public ResponseEntity<Object> deleteTopic(String Id) 
      {
        Optional<Topic> topic = topicRepository.findById(Id);
        if (topic.isPresent()) {
        	Topic tp = topic.get();
        	topicRepository.delete(tp);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<Topic> getTopicPage(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<Topic> pagedResult = topicRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<Topic>();
          }
      }
}

