package com.rs.bean;

/**
 * @author gowthc
 *
 */
public class CustomerBean {
	private String custName;
	private long custMobile;
	private String planName;
	private String custEmail;
	private static String custStatus = "Success";
	private int custAmount;


	public int getCustAmount() {
		return custAmount;
	}
	public void setCustAmount(int custAmount) {
		this.custAmount = custAmount;
	}
	public String getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public long getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(long custMobile) {
		this.custMobile = custMobile;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	@Override
	public String toString(){
		return "Customer Name : "+this.custName+"\nMobile Number : "+this.custMobile+"\nPlan Name : "+this.planName+"\nAmount : "+this.custAmount;
	}
}
