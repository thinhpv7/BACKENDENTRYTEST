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

import com.phamphuthinh.entity.AnswerSheet;
import com.phamphuthinh.repository.AnswerSheetRepository;


@Service
public class AnswerSheetService {
	@Autowired
	AnswerSheetRepository answersheetRepository;
	
	public List<AnswerSheet> getAll() {
        return (List<AnswerSheet>) answersheetRepository.findAll();
    }
     
    public AnswerSheet createAnswerSheet(AnswerSheet answersheet) {
        return answersheetRepository.save(answersheet);
    }
     
    public AnswerSheet updateAnswerSheet(String answersheetID, AnswerSheet answersheet)
    {
    	AnswerSheet updatedQT;
        Optional<AnswerSheet> searchEntity = answersheetRepository.findById(answersheetID);
        if (searchEntity.isPresent()) {
        	AnswerSheet tp = searchEntity.get();
        	tp.setANSWERSHEETID(answersheet.getANSWERSHEETID());
        	tp.setANSWERSHEETCONTENT(answersheet.getANSWERSHEETCONTENT());
        	updatedQT = answersheetRepository.save(tp);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedQT;
       }
     
      public ResponseEntity<Object> deleteAnswerSheet(String Id) 
      {
        Optional<AnswerSheet> topic = answersheetRepository.findById(Id);
        if (topic.isPresent()) {
        	AnswerSheet tp = topic.get();
        	answersheetRepository.delete(tp);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<AnswerSheet> getAnswerSheetPage(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<AnswerSheet> pagedResult = answersheetRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<AnswerSheet>();
          }
      }
}