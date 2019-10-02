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

import com.phamphuthinh.entity.UserAccount;
import com.phamphuthinh.repository.UserAccountRepository;
import com.phamphuthinh.repository.UserAccountRepository;

@Service
public class UserAccountService {
	
	@Autowired
	UserAccountRepository UserAccountRepository;
        
    public List<UserAccount> getAll() {
        return (List<UserAccount>) UserAccountRepository.findAll();
    }
     
    public UserAccount createUserAccount(UserAccount UserAccount) {
        return UserAccountRepository.save(UserAccount);
    }
     
    public UserAccount updateUserAccount(String id, UserAccount UserAccount)
    {
    	UserAccount updatedUserAccount;
        Optional<UserAccount> searchEntity = UserAccountRepository.findById(id);
        if (searchEntity.isPresent()) {
        	UserAccount us = searchEntity.get();
        	us.setUSERID(UserAccount.getUSERID());
        	us.setHO(UserAccount.getHO());
        	us.setTENLOT(UserAccount.getTENLOT());
        	us.setTEN(UserAccount.getTEN());
        	us.setNGAYSINH(UserAccount.getNGAYSINH());
        	us.setSDT(UserAccount.getSDT());
        	us.setEMAIL(UserAccount.getEMAIL());
        	us.setGIOITINH(UserAccount.getGIOITINH());
        	us.setACCOUNTID(UserAccount.getACCOUNTID());
        	updatedUserAccount = UserAccountRepository.save(us);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedUserAccount;
       }
    

      public ResponseEntity<Object> deleteUserAccount(String id) 
      {
        Optional<UserAccount> UserAccount = UserAccountRepository.findById(id);
        if (UserAccount.isPresent()) {
        	UserAccount us = UserAccount.get();
        	UserAccountRepository.delete(us);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<UserAccount> getUserAccountPage(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<UserAccount> pagedResult = UserAccountRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<UserAccount>();
          }
      }
}
