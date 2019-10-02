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

import com.phamphuthinh.entity.Question;
import com.phamphuthinh.repository.QuestionRepository;



@Service
public class QuestionService {
	@Autowired
	QuestionRepository questionRepository;
	
	public List<Question> getAll() {
        return (List<Question>) questionRepository.findAll();
    }
     
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }
     
    public Question updateQuestion(String questionID, Question question)
    {
    	Question updatedQT;
        Optional<Question> searchEntity = questionRepository.findById(questionID);
        if (searchEntity.isPresent()) {
        	Question tp = searchEntity.get();
        	tp.setQUESTIONID(question.getQUESTIONID());
        	tp.setQUESTIONCONTENT(question.getQUESTIONCONTENT());
        	tp.setCOUNTQUESTION(question.getCOUNTQUESTION());
        	tp.setTOPICID(question.getTOPICID());
        	tp.setQUESTIONTYPEID(question.getQUESTIONTYPEID());
        	updatedQT = questionRepository.save(tp);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedQT;
       }
     
      public ResponseEntity<Object> deleteQuestion(String Id) 
      {
        Optional<Question> topic = questionRepository.findById(Id);
        if (topic.isPresent()) {
        	Question tp = topic.get();
        	questionRepository.delete(tp);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<Question> getQuestionPage(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<Question> pagedResult = questionRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<Question>();
          }
      }
}