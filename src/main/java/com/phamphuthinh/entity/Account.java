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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "ACCOUNT")
public class Account {
	@Id 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private String ACCOUNTID;
	
	@Column(nullable = true)
	private String PASSWORD;
	
	@Column(nullable = true)
	private int ACCOUNTTYPEID;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ACCOUNTTYPEID", insertable=false, updatable=false)
    private AccountType accounttype;
	
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "account")
    private UserAccount useraccount;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<AnswerSheet> answersheet;

	public String getACCOUNTID() {
		return ACCOUNTID;
	}

	public void setACCOUNTID(String aCCOUNTID) {
		ACCOUNTID = aCCOUNTID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}	


	public int getACCOUNTTYPEID() {
		return ACCOUNTTYPEID;
	}

	public void setACCOUNTTYPEID(int aCCOUNTTYPEID) {
		ACCOUNTTYPEID = aCCOUNTTYPEID;
	}

	public Set<AnswerSheet> getAnswersheet() {
		return answersheet;
	}

	public void setAnswersheet(Set<AnswerSheet> answersheet) {
		this.answersheet = answersheet;
	}

}
