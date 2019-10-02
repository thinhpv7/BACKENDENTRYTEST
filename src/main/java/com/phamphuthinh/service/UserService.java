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

import com.phamphuthinh.entity.User;
import com.phamphuthinh.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
        
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }
     
    public User createUser(User user) {
        return userRepository.save(user);
    }
     
    public User updateUser(String id, User user)
    {
    	User updatedUser;
        Optional<User> searchEntity = userRepository.findById(id);
        if (searchEntity.isPresent()) {
        	User us = searchEntity.get();
        	us.setUSERID(user.getUSERID());
        	us.setHO(user.getHO());
        	us.setTENLOT(user.getTENLOT());
        	us.setTEN(user.getTEN());
        	us.setNGAYSINH(user.getNGAYSINH());
        	us.setSDT(user.getSDT());
        	us.setEMAIL(user.getEMAIL());
        	us.setGIOITINH(user.getGIOITINH());
        	us.setACCOUNTID(user.getACCOUNTID());
        	updatedUser = userRepository.save(us);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedUser;
       }
    

      public ResponseEntity<Object> deleteUser(String id) 
      {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
        	User us = user.get();
        	userRepository.delete(us);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<User> getUserPage(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<User> pagedResult = userRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<User>();
          }
      }
}
