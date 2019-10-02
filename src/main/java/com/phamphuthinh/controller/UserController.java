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

import com.phamphuthinh.entity.User;
import com.phamphuthinh.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService userService;
	
    @RequestMapping(value = "/user")
    public List<User> user() {
        return userService.getAll();
    }
 
    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public User createSample(@Valid @RequestBody User user)
    {
        return userService.createUser(user);
    }
 
    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") String id) 
    {
        return userService.deleteUser(id);
    }
 
    @RequestMapping(value = "/updateuser/{id}", method = RequestMethod.PUT)
    public User updateSample(@PathVariable(value = "id") String id, @Valid @RequestBody User user) 
    {
        return userService.updateUser(id, user);
    }
    
    @RequestMapping(value = "/userpage", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllHocVien(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "USERID") String sortBy)
    {
        List<User> list = userService.getUserPage(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}

