package com.ing.mortgageloan.dto;

public class MortgageRequestDto {

	private Long customerId;
	private Double propertyValue;
	private String propertyType;
	private Double annualSalary;
	private Integer tenure;
	private Double loanAmount;
	private Double emi;
	private Float rateOfInterest;
	private Double outstandingAmount;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Double getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(Double propertyValue) {
		this.propertyValue = propertyValue;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public Double getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(Double annualSalary) {
		this.annualSalary = annualSalary;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Double getEmi() {
		return emi;
	}
	public void setEmi(Double emi) {
		this.emi = emi;
	}
	public Float getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(Float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public Double getOutstandingAmount() {
		return outstandingAmount;
	}
	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}
	
	
	
}
