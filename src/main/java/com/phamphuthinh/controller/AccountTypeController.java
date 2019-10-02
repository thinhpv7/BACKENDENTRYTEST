package com.phamphuthinh.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.phamphuthinh.entity.AccountType;
import com.phamphuthinh.service.AccountTypeService;


@RestController
public class AccountTypeController {

	@Autowired
	AccountTypeService accountTypeService;
 
    @RequestMapping(value = "/accounttype")
    public List<AccountType> sample() {
        return accountTypeService.getAll();
    }
 
    @RequestMapping(value = "/createaccounttype", method = RequestMethod.POST)
    public AccountType createSample(@Valid @RequestBody AccountType accounttype)
    {
        return accountTypeService.createAccountType(accounttype);
    }
 
    @RequestMapping(value = "/deleteaccounttype/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") Integer id) 
    {
        return accountTypeService.deleteAccountType(id);
    }
 
    @RequestMapping(value = "/updateaccounttype/{id}", method = RequestMethod.PUT)
    public AccountType updateSample(@PathVariable(value = "id") Integer id, @Valid @RequestBody AccountType accounttype) 
    {
        return accountTypeService.updateAccountType(id, accounttype);
    }
    
    @RequestMapping(value = "/acounttypepage", method = RequestMethod.GET)
    public ResponseEntity<List<AccountType>> getAllHocVien(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "ACCOUNTTYPEID") String sortBy)
    {
        List<AccountType> list = accountTypeService.getAccountTypePage(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<AccountType>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
