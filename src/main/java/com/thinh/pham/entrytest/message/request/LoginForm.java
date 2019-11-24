package com.thinh.pham.entrytest.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
 
public class LoginForm {
    @NotBlank
    @Size(min=3, max = 60)
    private String accountname;
 
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
 
    public String getAccountname() {
        return accountname;
    }
 
    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}