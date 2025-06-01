package com.dao;

import java.util.List;

import com.entity.Student;

public interface StudentDao {
	public void insert(Student student);
	public Student get(String roll_number);
	public void delete(String roll_number);
	public List<Student> getall();
	public void update(Student student);
}
