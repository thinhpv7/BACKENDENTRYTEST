package com.phamphuthinh.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "TOPIC")
public class Topic {
	@Id 
	@Column(nullable = false)
	private String TOPICID;
	
	@Column(name ="TOPICNAME", nullable = true)
	private String TopicName;
	
	@OneToMany(mappedBy = "topic", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Question> question;
	

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	public String getTOPICID() {
		return TOPICID;
	}

	public void setTOPICID(String tOPICID) {
		TOPICID = tOPICID;
	}

	public String getTopicName() {
		return TopicName;
	}

	public void setTopicName(String topicName) {
		TopicName = topicName;
	}
	
//	@OneToMany(mappedBy = "topic", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
//    private Set<Question> question;


}
