package com.model;

public class StudentConsoleData {
	
	private String courseid;
	private String coursename;
	private int marks;
	private int totalclasses;
	private int totalpresent;
	@Override
	public String toString() {
		return "StudentConsoleData [courseid=" + courseid + ", coursename=" + coursename + ", marks=" + marks
				+ ", totalclasses=" + totalclasses + ", totalpresent=" + totalpresent + "]";
	}
	public StudentConsoleData(String courseid, String coursename, int marks, int totalclasses, int totalpresent) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.marks = marks;
		this.totalclasses = totalclasses;
		this.totalpresent = totalpresent;
	}
	public int getTotalclasses() {
		return totalclasses;
	}
	public void setTotalclasses(int totalclasses) {
		this.totalclasses = totalclasses;
	}
	public int getTotalpresent() {
		return totalpresent;
	}
	public void setTotalpresent(int totalpresent) {
		this.totalpresent = totalpresent;
	}

	public StudentConsoleData() {
		super();
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}

	

}
