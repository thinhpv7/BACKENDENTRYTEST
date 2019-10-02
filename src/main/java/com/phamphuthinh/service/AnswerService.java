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

import com.phamphuthinh.entity.Answer;
import com.phamphuthinh.repository.AnswerRepository;


@Service
public class AnswerService {
	@Autowired
	AnswerRepository answerRepository;
	
	public List<Answer> getAll() {
        return (List<Answer>) answerRepository.findAll();
    }
     
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }
     
    public Answer updateAnswer(String answerID, Answer answer)
    {
    	Answer updatedQT;
        Optional<Answer> searchEntity = answerRepository.findById(answerID);
        if (searchEntity.isPresent()) {
        	Answer tp = searchEntity.get();
        	tp.setANSWERID(answer.getANSWERID());
        	tp.setANSWERCONTENT(answer.getANSWERCONTENT());
        	tp.setANSWERCHECK(answer.getANSWERCHECK());
        	tp.setQUESTIONID(answer.getQUESTIONID());
        	updatedQT = answerRepository.save(tp);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedQT;
       }
     
      public ResponseEntity<Object> deleteAnswer(String Id) 
      {
        Optional<Answer> topic = answerRepository.findById(Id);
        if (topic.isPresent()) {
        	Answer tp = topic.get();
        	answerRepository.delete(tp);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<Answer> getAnswerPage(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<Answer> pagedResult = answerRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<Answer>();
          }
      }
}