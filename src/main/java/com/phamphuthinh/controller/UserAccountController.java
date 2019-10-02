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

import com.phamphuthinh.entity.UserAccount;
import com.phamphuthinh.service.UserAccountService;



@RestController
public class UserAccountController {

	@Autowired
	UserAccountService userAccountService;
	
    @RequestMapping(value = "/useraccount")
    public List<UserAccount> userAccount() {
        return userAccountService.getAll();
    }
 
    @RequestMapping(value = "/createuseraccount", method = RequestMethod.POST)
    public UserAccount createSample(@Valid @RequestBody UserAccount useraccount)
    {
        return userAccountService.createUserAccount(useraccount);
    }
 
    @RequestMapping(value = "/deleteuseraccount/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") String id) 
    {
        return userAccountService.deleteUserAccount(id);
    }
 
    @RequestMapping(value = "/updateuseraccount/{id}", method = RequestMethod.PUT)
    public UserAccount updateSample(@PathVariable(value = "id") String id, @Valid @RequestBody UserAccount useraccount) 
    {
        return userAccountService.updateUserAccount(id, useraccount);
    }
    
    @RequestMapping(value = "/useraccountpage", method = RequestMethod.GET)
    public ResponseEntity<List<UserAccount>> getAllHocVien(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "USERID") String sortBy)
    {
        List<UserAccount> list = userAccountService.getUserAccountPage(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<UserAccount>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}

