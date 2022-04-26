package com.bits.dbms.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	int orderId;
	
	String customerId;
	
	String empId;
			
	int invoiceNumber;
	
	String dimensions;
	
	Timestamp orderTimestamp;
	
	int weight;
	
	Timestamp deliveryTimestamp;
	
	String recipient;
	
	String contactId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public Timestamp getOrderTimestamp() {
		return orderTimestamp;
	}

	public void setOrderTimestamp(Timestamp orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Timestamp getDeliveryTimestamp() {
		return deliveryTimestamp;
	}

	public void setDeliveryTimestamp(Timestamp deliveryTimestamp) {
		this.deliveryTimestamp = deliveryTimestamp;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "transportId"), name = "transportId", insertable = true, updatable = true)
    private Transport transportId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "dst_branch_id"), name = "dst_branch_id" , insertable = true, updatable = true)
    private Branch dstBranchId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "src_branch_id"), name = "src_branch_id" , insertable = true, updatable = true)
    private Branch srcBranchId;

	public Transport getTransportId() {
		return transportId;
	}

	public void setTransportId(Transport transportId) {
		this.transportId = transportId;
	}

	public Branch getDstBranchId() {
		return dstBranchId;
	}

	public void setDstBranchId(Branch dstBranchId) {
		this.dstBranchId = dstBranchId;
	}

	public Branch getSrcBranchId() {
		return srcBranchId;
	}

	public void setSrcBranchId(Branch srcBranchId) {
		this.srcBranchId = srcBranchId;
	}
	
	
}
