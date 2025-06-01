package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="fee")
public class Fee {
	
	@Id
	@Column(name = "rollnumber")
	private String rollnumber;
	
	@Column(name="fees")
	private String fees;
	
	@Column(name="paid")
	private String paid;

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return "Fee [rollnumber=" + rollnumber + ", fees=" + fees + ", paid=" + paid + "]";
	}

	public Fee(String rollnumber, String fees, String paid) {
		super();
		this.rollnumber = rollnumber;
		this.fees = fees;
		this.paid = paid;
	}

	public Fee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
