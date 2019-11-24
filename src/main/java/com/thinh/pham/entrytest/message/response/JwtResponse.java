package com.thinh.pham.entrytest.message.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
 
public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private String accountname;
  private Collection<? extends GrantedAuthority> authorities;
 
  public JwtResponse(String accessToken, String accountname, Collection<? extends GrantedAuthority> authorities) {
    this.token = accessToken;
    this.accountname = accountname;
    this.authorities = authorities;
  }
 
  public String getAccessToken() {
    return token;
  }
 
  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }
 
  public String getTokenType() {
    return type;
  }
 
  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }
 
  public String getAccountname() {
    return accountname;
  }
 
  public void setAccountname(String accountname) {
    this.accountname = accountname;
  }
  
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }
}