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

import com.phamphuthinh.entity.Account;
import com.phamphuthinh.service.AccountService;


@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
 
    @RequestMapping(value = "/account")
    public List<Account> sample() {
        return accountService.getAll2();
    }
 
    @RequestMapping(value = "/createaccount", method = RequestMethod.POST)
    public Account createSample(@Valid @RequestBody Account account)
    {
        return accountService.createAccount(account);
    }
 
    @RequestMapping(value = "/deleteaccount/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") String id) 
    {
        return accountService.deleteAccount(id);
    }
 
    @RequestMapping(value = "/updateaccount/{id}", method = RequestMethod.PUT)
    public Account updateSample(@PathVariable(value = "id") String id, @Valid @RequestBody Account account) 
    {
        return accountService.updateAccount(id, account);
    }
    
    @RequestMapping(value = "/acountpage", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAllHocVien(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "ACCOUNTID") String sortBy)
    {
        List<Account> list = accountService.getAccountPage(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<Account>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
