package com.service;

import java.util.List;

import com.entity.Student;
import com.model.StudentConsoleData;

public interface StudentService {
	Student authenticate(String rollnumber, String password);

	List<StudentConsoleData> getStudentConsoleData(String rollnumber);

	List<Student> getAllStudents();

	void deleteStudent(String rollnumber);

	Student get(String rollnumber);

	void add(String rollnumber, String name, String age, String branch, String pass,String address);

	void update(String rollnumber, String name, String age, String branch, String address, String pass);
}
