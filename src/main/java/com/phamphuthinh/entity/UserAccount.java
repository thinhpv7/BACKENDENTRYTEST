package com.phamphuthinh.entity;

import java.math.BigInteger;
import java.util.Date;
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
@Table(name = "USERACCOUNT")
public class UserAccount {
	@Id 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private String USERID;
	
	@Column(nullable = true)
	private String HO;
	
	@Column(nullable = true)
	private String TENLOT;
	
	@Column(nullable = true)
	private String TEN;
	
	@Column(nullable = true)
	private Date NGAYSINH;
	
	@Column(nullable = true)
	private BigInteger SDT;
	
	@Column(nullable = true)
	private String EMAIL;
	
	@Column(nullable = true)
	private String GIOITINH;
	
	@Column(nullable = true)
	private String ACCOUNTID;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ACCOUNTID", insertable=false, updatable=false)
    private Account account;


	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getHO() {
		return HO;
	}

	public void setHO(String hO) {
		HO = hO;
	}

	public String getTENLOT() {
		return TENLOT;
	}

	public void setTENLOT(String tENLOT) {
		TENLOT = tENLOT;
	}

	public String getTEN() {
		return TEN;
	}

	public void setTEN(String tEN) {
		TEN = tEN;
	}

	public Date getNGAYSINH() {
		return NGAYSINH;
	}

	public void setNGAYSINH(Date nGAYSINH) {
		NGAYSINH = nGAYSINH;
	}

	public BigInteger getSDT() {
		return SDT;
	}

	public void setSDT(BigInteger sDT) {
		SDT = sDT;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getGIOITINH() {
		return GIOITINH;
	}

	public void setGIOITINH(String gIOITINH) {
		GIOITINH = gIOITINH;
	}

	public String getACCOUNTID() {
		return ACCOUNTID;
	}

	public void setACCOUNTID(String aCCOUNTID) {
		ACCOUNTID = aCCOUNTID;
	}

}
