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

import com.phamphuthinh.entity.QuestionType;
import com.phamphuthinh.repository.QuestionTypeRepository;



@Service
public class QuestionTypeService {
	@Autowired
	QuestionTypeRepository questionTypeRepository;
	
	public List<QuestionType> getAll() {
        return (List<QuestionType>) questionTypeRepository.findAll();
    }
     
    public QuestionType createQuestionType(QuestionType questiontype) {
        return questionTypeRepository.save(questiontype);
    }
     
    public QuestionType updateQuestionType(String questionTypeID, QuestionType questiontype)
    {
    	QuestionType updatedQT;
        Optional<QuestionType> searchEntity = questionTypeRepository.findById(questionTypeID);
        if (searchEntity.isPresent()) {
        	QuestionType tp = searchEntity.get();
        	tp.setQUESTIONTYPEID(questiontype.getQUESTIONTYPEID());
        	tp.setQUESTIONTYPENAME(questiontype.getQUESTIONTYPENAME());
        	updatedQT = questionTypeRepository.save(tp);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedQT;
       }
     
      public ResponseEntity<Object> deleteQuestionType(String Id) 
      {
        Optional<QuestionType> topic = questionTypeRepository.findById(Id);
        if (topic.isPresent()) {
        	QuestionType tp = topic.get();
        	questionTypeRepository.delete(tp);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<QuestionType> getQuestionTypePage(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<QuestionType> pagedResult = questionTypeRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<QuestionType>();
          }
      }
}