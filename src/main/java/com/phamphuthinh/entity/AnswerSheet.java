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
@Table(name = "ANSWERSHEET")
public class AnswerSheet {
	@Id 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private String ANSWERSHEETID;
	
	@Column(nullable = true)
	private String ANSWERSHEETCONTENT;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ANSWERSHEETQUESTION",
	        joinColumns = @JoinColumn(name = "ANSWERSHEETID"),
	        inverseJoinColumns = @JoinColumn(name = "QUESTIONID"))
	private List<Question> question;


	public String getANSWERSHEETID() {
		return ANSWERSHEETID;
	}


	public void setANSWERSHEETID(String aNSWERSHEETID) {
		ANSWERSHEETID = aNSWERSHEETID;
	}

	public String getANSWERSHEETCONTENT() {
		return ANSWERSHEETCONTENT;
	}

	public void setANSWERSHEETCONTENT(String aNSWERSHEETCONTENT) {
		ANSWERSHEETCONTENT = aNSWERSHEETCONTENT;
	}

//	public List<Question> getQuestion() {
//		return question;
//	}
//
//	public void setQuestion(List<Question> question) {
//		this.question = question;
//	}
	
}