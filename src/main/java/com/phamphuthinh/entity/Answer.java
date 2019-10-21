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
import javax.persistence.Table;


@Entity
@Table(name = "ANSWER")
public class Answer {
	@Id 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private String ANSWERID;
	
	@Column(nullable = true)
	private String ANSWERCONTENT;
	
	@Column(nullable = true)
	private int ANSWERCHECK;
	
	@Column(nullable = true)
	private String QUESTIONID;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="QUESTIONID", insertable=false, updatable=false)
    private Question question;

	public String getANSWERID() {
		return ANSWERID;
	}

	public void setANSWERID(String aNSWERID) {
		ANSWERID = aNSWERID;
	}

	public String getANSWERCONTENT() {
		return ANSWERCONTENT;
	}

	public void setANSWERCONTENT(String aNSWERCONTENT) {
		ANSWERCONTENT = aNSWERCONTENT;
	}

	public int getANSWERCHECK() {
		return ANSWERCHECK;
	}

	public void setANSWERCHECK(int aNSWERCHECK) {
		ANSWERCHECK = aNSWERCHECK;
	}

	public String getQUESTIONID() {
		return QUESTIONID;
	}

	public void setQUESTIONID(String qUESTIONID) {
		QUESTIONID = qUESTIONID;
	}
	

}