package com.ing.mortgageloan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class MortgageLoan {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long loanAccountNumber;
	private Double loanAmount;
	private Integer tenure;
	private String status;
	private Float rateOfInterest;
	private Double emi;
	private String propertyType;
	private Double propertyValue;
	private Double outstandingAmount=loanAmount;
	
	@OneToOne
	private Customer customerId;

	public Long getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(Long loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Double getEmi() {
		return emi;
	}

	public void setEmi(Double emi) {
		this.emi = emi;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public Double getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(Double propertyValue) {
		this.propertyValue = propertyValue;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public Double getOutstandingAmount() {
		return outstandingAmount;
	}
	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}
	@Override
	public String toString() {
		return "MortgageLoan [loanAccountNumber=" + loanAccountNumber + ", loanAmount=" + loanAmount + ", tenure="
				+ tenure + ", status=" + status + ", rateOfInterest=" + rateOfInterest + ", emi=" + emi
				+ ", propertyType=" + propertyType + ", propertyValue=" + propertyValue + ", outstandingAmount="
				+ outstandingAmount + ", customerId=" + customerId + "]";
	}

}
