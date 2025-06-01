package com.dao;

import java.util.List;

import com.entity.Attendance;

public interface AttendanceDao {
	public void add(Attendance attendance);

	public void update(Attendance attendance);

	public void deletestudent(String rollnumber);

	public List<Attendance> getbyroll(String rollnumber);

	public List<Attendance> getbydate(String date);

	public List<Attendance> getbycourse(String courseid);

	public Attendance get(int attendanceid);

	public void deletecourse(String courseid);

	public void delete(String rollnumber, String courseid, String date);

	public List<Attendance> getall();
}
