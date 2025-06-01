package com.dao;

import java.util.List;

import com.entity.Course;

public interface CourseDao {

	public void delete(String courseid);

	public List<Course> getall();

	public void add(Course course);

	public void update(Course course);
	
	public Course get(String courseid);
}
