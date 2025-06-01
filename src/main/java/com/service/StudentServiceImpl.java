package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.entity.Student;
import com.model.StudentConsoleData;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao sdao;

	public Student authenticate(String rollnumber, String password) {
		return null;
	}

	public List<StudentConsoleData> getStudentConsoleData(String rollnumber) {
		return null;
	}

	public List<Student> getAllStudents() {
		return sdao.getall();
	}

	public void deleteStudent(String rollnumber) {
		sdao.delete(rollnumber);
	}

	@Override
	public Student get(String rollnumber) {
		return sdao.get(rollnumber);
	}

	@Override
	public void add(String rollnumber, String name, String age, String branch, String pass,String address) {
		Student student = new Student();
		student.setAddress(address);
		student.setAge(age);
		student.setBranch(branch);
		student.setName(name);
		student.setRollnumber(rollnumber);
		student.setPass(pass);
		sdao.insert(student);
		
	}

	@Override
	public void update(String rollnumber, String name, String age, String branch, String address, String pass) {
		Student student = sdao.get(rollnumber);
		if(student!=null) {
			student.setAddress(address);
			student.setAge(age);
			student.setBranch(branch);
			student.setName(name);
			student.setRollnumber(rollnumber);
			student.setPass(pass);
			sdao.update(student);	
		}
		
	}


}
