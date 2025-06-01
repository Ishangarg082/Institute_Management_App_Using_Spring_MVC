package com.dao;

import java.util.List;

import com.entity.Marks;

public interface MarksDao {

	public void add(Marks mark);

	public void update(Marks mark);

	public Marks get(int marksid);

	public List<Marks> getmarksByRollNumber(String rollnumber);

	public List<Marks> getmarksByCourseId(String courseId);

	public void delete(String rollnumber);

	public void deletecourse(String courseid);

	public void deletemark(int marksid);

	public List<Marks> getall();
}
