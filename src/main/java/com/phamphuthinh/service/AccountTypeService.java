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

import com.phamphuthinh.entity.AccountType;
import com.phamphuthinh.repository.AccountTypeRepository;



@Service
public class AccountTypeService {
	@Autowired
	AccountTypeRepository accounttypeRepository;
	
	public List<AccountType> getAll() {
        return (List<AccountType>) accounttypeRepository.findAll();
    }
     
    public AccountType createAccountType(AccountType accounttype) {
        return accounttypeRepository.save(accounttype);
    }
     
    public AccountType updateAccountType(Integer Id, AccountType accounttype)
    {
    	AccountType updatedAC;
        Optional<AccountType> searchEntity = accounttypeRepository.findById(Id);
        if (searchEntity.isPresent()) {
        	AccountType ac = searchEntity.get();
        	ac.setACCOUNTTYPEID(accounttype.getACCOUNTTYPEID());
        	ac.setNAMEACCOUNTTYPE(accounttype.getNAMEACCOUNTTYPE());
        	updatedAC = accounttypeRepository.save(ac);
         } else {
             throw new EntityNotFoundException();
         }
         return updatedAC;
       }
     
      public ResponseEntity<Object> deleteAccountType(int Id) 
      {
        Optional<AccountType> accounttype = accounttypeRepository.findById(Id);
        if (accounttype.isPresent()) {
        	AccountType ac = accounttype.get();
        	accounttypeRepository.delete(ac);
         } else {
                throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
      }
      
      public List<AccountType> getAccountTypePage(Integer pageNo, Integer pageSize, String sortBy)
      {
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
   
          Page<AccountType> pagedResult = accounttypeRepository.findAll(paging);
           
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
          } else {
              return new ArrayList<AccountType>();
          }
      }
}
