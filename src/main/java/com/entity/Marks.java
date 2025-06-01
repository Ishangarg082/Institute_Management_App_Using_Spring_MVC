package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="Marks")
public class Marks {
	
	
	@Id
	@Column(name="marksid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int marksid;

	@Column(name="rollnumber")
	private String rollnumber;
	
	@Column(name="courseid")
	private String courseid;
	
	@Column(name="marks")
	private int Marks;

	public int getMarksid() {
		return marksid;
	}

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public int getMarks() {
		return Marks;
	}

	public void setMarks(int marks2) {
		Marks = marks2;
	}

	@Override
	public String toString() {
		return "Marks [marksid=" + marksid + ", rollnumber=" + rollnumber + ", courseid=" + courseid + ", Marks="
				+ Marks + "]";
	}

	public Marks(String rollnumber, String courseid, int marks) {
		super();
		this.rollnumber = rollnumber;
		this.courseid = courseid;
		Marks = marks;
	}

	public Marks() {
		super();
	}
	
	
}
