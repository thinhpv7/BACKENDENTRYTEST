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
@Table(name = "LEVELOFDIFFICULT")
public class LevelOfDifficult {
	@Id 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int LEVELOFDIFFICULTID;
	
	@Column(nullable = true)
	private String NAMEDIFFICULT;
	
	@OneToMany(mappedBy = "levelofdifficult", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Question> question;

	public int getLEVELOFDIFFICULTID() {
		return LEVELOFDIFFICULTID;
	}

	public void setLEVELOFDIFFICULTID(int lEVELOFDIFFICULTID) {
		LEVELOFDIFFICULTID = lEVELOFDIFFICULTID;
	}

	public String getNAMEDIFFICULT() {
		return NAMEDIFFICULT;
	}

	public void setNAMEDIFFICULT(String nAMEDIFFICULT) {
		NAMEDIFFICULT = nAMEDIFFICULT;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}
	
}
