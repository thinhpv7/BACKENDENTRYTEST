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
@Table(name = "QUESTIONTYPE")
public class QuestionType {
	@Id 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private String QUESTIONTYPEID;
	
	@Column(nullable = true)
	private String QUESTIONTYPENAME;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ACCOUNTTYPEQUESTIONTYPE",
	        joinColumns = @JoinColumn(name = "QUESTIONTYPEID"),
	        inverseJoinColumns = @JoinColumn(name = "ACCOUNTTYPEID"))
	private Set<AccountType> accounttype;
	
	@OneToMany(mappedBy = "questiontype", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Question> question;

	public Set<Question> getQuestion() {
		return question;
	}


	public void setQuestion(Set<Question> question) {
		this.question = question;
	}

	public String getQUESTIONTYPEID() {
		return QUESTIONTYPEID;
	}


	public void setQUESTIONTYPEID(String qUESTIONTYPEID) {
		QUESTIONTYPEID = qUESTIONTYPEID;
	}


	public String getQUESTIONTYPENAME() {
		return QUESTIONTYPENAME;
	}


	public void setQUESTIONTYPENAME(String qUESTIONTYPENAME) {
		QUESTIONTYPENAME = qUESTIONTYPENAME;
	}


	public Set<AccountType> getAccounttype() {
		return accounttype;
	}


	public void setAccounttype(Set<AccountType> accounttype) {
		this.accounttype = accounttype;
	}

	
	
}