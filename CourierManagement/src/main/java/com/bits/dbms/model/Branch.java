package com.bits.dbms.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "branch")
public class Branch{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	
	private int branchId;
	private String branchType;
	private String branchManager;
	private  String branchName;
	private  int numEmployees;
	private String contactId;
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchType() {
		return branchType;
	}
	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}
	public String getBranchManager() {
		return branchManager;
	}
	public void setBranchManager(String branchManager) {
		this.branchManager = branchManager;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getNumEmployees() {
		return numEmployees;
	}
	public void setNumEmployees(int numEmployees) {
		this.numEmployees = numEmployees;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	
	@OneToMany(mappedBy = "dstBranchId" ,cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Orders> dstOrders;
	
	
	@OneToMany(mappedBy = "srcBranchId" ,cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Orders> srcorders;
	
}
