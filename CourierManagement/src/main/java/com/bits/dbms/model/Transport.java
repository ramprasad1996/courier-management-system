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
@Table(name = "transport")
public class Transport {
	
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	int transportId;
	
	String vehicleNum;
	
	String empId;
	
	int srcBranchId;
	
	int dstBranchId;
	
	String currLocation;
	
	int numOrdersInTransit;

	public int getTransportId() {
		return transportId;
	}

	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public int getSrcBranchId() {
		return srcBranchId;
	}

	public void setSrcBranchId(int srcBranchId) {
		this.srcBranchId = srcBranchId;
	}

	public int getDstBranchId() {
		return dstBranchId;
	}

	public void setDstBranchId(int dstBranchId) {
		this.dstBranchId = dstBranchId;
	}

	public String getCurrLocation() {
		return currLocation;
	}

	public void setCurrLocation(String currLocation) {
		this.currLocation = currLocation;
	}

	public int getNumOrdersInTransit() {
		return numOrdersInTransit;
	}

	public void setNumOrdersInTransit(int numOrdersInTransit) {
		this.numOrdersInTransit = numOrdersInTransit;
	}
	
	@OneToMany(mappedBy = "transportId" ,cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public List<Orders> orders;

}
