package com.model;

public class MarkData {
	
	private int marksid;
	
	private int marks;
	
	private String rollnumber;
	
	private String studentname;
	
	private String courseid;
	
	private String coursename;

	public int getMarksid() {
		return marksid;
	}

	public void setMarksid(int marksid) {
		this.marksid = marksid;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int i) {
		this.marks = i;
	}

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
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

	@Override
	public String toString() {
		return "MarkData [marksid=" + marksid + ", marks=" + marks + ", rollnumber=" + rollnumber + ", studentname="
				+ studentname + ", courseid=" + courseid + ", coursename=" + coursename + "]";
	}

	public MarkData(int marksid, int marks, String rollnumber, String studentname, String courseid,
			String coursename) {
		super();
		this.marksid = marksid;
		this.marks = marks;
		this.rollnumber = rollnumber;
		this.studentname = studentname;
		this.courseid = courseid;
		this.coursename = coursename;
	}

	public MarkData() {
		super();
	}
	
	
}
