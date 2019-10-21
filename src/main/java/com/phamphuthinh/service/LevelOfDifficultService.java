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

import com.phamphuthinh.entity.LevelOfDifficult;
import com.phamphuthinh.repository.LevelOfDifficultRepository;


@Service
public class LevelOfDifficultService {
	@Autowired
	LevelOfDifficultRepository levelOfDifficultRepository;
	
	public List<LevelOfDifficult> getAll() {
        return (List<LevelOfDifficult>) levelOfDifficultRepository.findAll();
    }
     
    public LevelOfDifficult createLevelOfDifficult(LevelOfDifficult level) {
        return levelOfDifficultRepository.save(level);
    }
     
    public LevelOfDifficult updateLevelOfDifficult(Integer Id, LevelOfDifficult level)
    {
    	LevelOfDifficult updatedAC;
        Optional<LevelOfDifficult> searchEntity = levelOfDifficultRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	LevelOfDifficult ac = searchEntity.get();
        	ac.setLEVELOFDIFFICULTID(level.getLEVELOFDIFFICULTID());
        	ac.setNAMEDIFFICULT(level.getNAMEDIFFICULT());
        	updatedAC = levelOfDifficultRepository.save(ac);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedAC;
       }
     
      public ResponseEntity<Object> deleteLevelOfDifficult(Integer Id) 
      {
        Optional<LevelOfDifficult> level = levelOfDifficultRepository.findById(Id);
        if (level.isPresent()) {
        	LevelOfDifficult ac = level.get();
        	levelOfDifficultRepository.delete(ac);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<LevelOfDifficult> getLevelOfDifficultPage(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<LevelOfDifficult> pagedResult = levelOfDifficultRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<LevelOfDifficult>();
          }
      }
}
