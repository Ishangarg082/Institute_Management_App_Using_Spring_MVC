package com.dao;

import java.util.List;

import com.entity.CourseEnrolled;

public interface CourseEnrolledDao {
	public List<CourseEnrolled> getAll();

	public CourseEnrolled get(String registerid);

	public List<CourseEnrolled> getCoursesByRollNumber(String rollnumber);

	public List<CourseEnrolled> getStudentsByCourseId(String courseid);

	public void delete(String rollnumber);

	public void add(CourseEnrolled ce);

	public void update(CourseEnrolled ce);

	public void deletecourse(String courseid);
}
