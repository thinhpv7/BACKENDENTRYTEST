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
@Table(name = "QUESTION")
public class Question {
	@Id 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private String QUESTIONID;
	
	@Column(nullable = true)
	private String QUESTIONCONTENT;
	
	@Column(nullable = true)
	private int COUNTQUESTION;
	
	@Column(nullable = true)
	private String TOPICID;
	
	@Column(nullable = true)
	private String QUESTIONTYPEID;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TOPICID", insertable=false, updatable=false)
    private Topic topic;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="QUESTIONTYPEID", insertable=false, updatable=false)
    private QuestionType questiontype;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Answer> answer;
	
	@ManyToMany(mappedBy="question",fetch = FetchType.LAZY)
	private List<AnswerSheet> answersheet;
	
//	public List<AnswerSheet> getAnswersheet() {
//		return answersheet;
//	}
//
//	public void setAnswersheet(List<AnswerSheet> answersheet) {
//		this.answersheet = answersheet;
//	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public String getQUESTIONID() {
		return QUESTIONID;
	}

	public void setQUESTIONID(String qUESTIONID) {
		QUESTIONID = qUESTIONID;
	}

	public String getQUESTIONCONTENT() {
		return QUESTIONCONTENT;
	}

	public void setQUESTIONCONTENT(String qUESTIONCONTENT) {
		QUESTIONCONTENT = qUESTIONCONTENT;
	}

	public int getCOUNTQUESTION() {
		return COUNTQUESTION;
	}

	public void setCOUNTQUESTION(int cOUNTQUESTION) {
		COUNTQUESTION = cOUNTQUESTION;
	}

	public String getTOPICID() {
		return TOPICID;
	}

	public void setTOPICID(String tOPICID) {
		TOPICID = tOPICID;
	}

	public String getQUESTIONTYPEID() {
		return QUESTIONTYPEID;
	}

	public void setQUESTIONTYPEID(String qUESTIONTYPEID) {
		QUESTIONTYPEID = qUESTIONTYPEID;
	}

//	public Topic getTopic() {
//		return topic;
//	}
//
//	public void setTopic(Topic topic) {
//		this.topic = topic;
//	}

//	public QuestionType getQuestiontype() {
//		return questiontype;
//	}
//
//	public void setQuestiontype(QuestionType questiontype) {
//		this.questiontype = questiontype;
//	}
//	
}