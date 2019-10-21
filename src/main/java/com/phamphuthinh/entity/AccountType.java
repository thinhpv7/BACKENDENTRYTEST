package com.phamphuthinh.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ACCOUNTTYPE")
public class AccountType {
	@Id 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int ACCOUNTTYPEID;
	
	@Column(nullable = true)
	private String NAMEACCOUNTTYPE;
	
	@OneToMany(mappedBy = "accounttype", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Account> account;
	
	@ManyToMany(mappedBy="accounttype",fetch = FetchType.LAZY)
	private Set<QuestionType> questiontype;

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}

	public int getACCOUNTTYPEID() {
		return ACCOUNTTYPEID;
	}

	public void setACCOUNTTYPEID(int aCCOUNTTYPEID) {
		ACCOUNTTYPEID = aCCOUNTTYPEID;
	}

	public String getNAMEACCOUNTTYPE() {
		return NAMEACCOUNTTYPE;
	}

	public void setNAMEACCOUNTTYPE(String nAMEACCOUNTTYPE) {
		NAMEACCOUNTTYPE = nAMEACCOUNTTYPE;
	}

}
