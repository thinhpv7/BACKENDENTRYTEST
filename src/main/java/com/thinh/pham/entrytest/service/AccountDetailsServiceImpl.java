package com.thinh.pham.entrytest.service;

//import com.grokonez.jwtauthentication.model.User;
//import com.grokonez.jwtauthentication.repository.UserRepository;
import com.thinh.pham.entrytest.dao.AccountRepository;
import com.thinh.pham.entrytest.entity.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
public class AccountDetailsServiceImpl implements UserDetailsService  {
 
  @Autowired
  AccountRepository accountRepository;
 
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
    Account account = accountRepository.findByAccountname(username).orElseThrow(
        () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
 
    return AccountPrinciple.build(account);
  }
}