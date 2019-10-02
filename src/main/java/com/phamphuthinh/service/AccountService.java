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

import com.phamphuthinh.entity.Account;
import com.phamphuthinh.repository.AccountRepository;



@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
       
        
    public List<Account> getAll2() {
        return (List<Account>) accountRepository.findAll();
    }
     
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
     
    public Account updateAccount(String id, Account account)
    {
    	Account updatedAccount;
        Optional<Account> searchEntity = accountRepository.findById(id);
        if (searchEntity.isPresent()) {
        	Account ac = searchEntity.get();
        	ac.setACCOUNTID(account.getACCOUNTID());
        	ac.setPASSWORD(account.getPASSWORD());
        	//ac.setAcountId(account.getAcountId());
        	ac.setACCOUNTTYPEID(account.getACCOUNTTYPEID());
        	//ac.setAccounttype(account.getAccounttype());
        	updatedAccount = accountRepository.save(ac);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedAccount;
       }
    

      public ResponseEntity<Object> deleteAccount(String id) 
      {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
        	Account ac = account.get();
        	accountRepository.delete(ac);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<Account> getAccountPage(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<Account> pagedResult = accountRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<Account>();
          }
      }
}