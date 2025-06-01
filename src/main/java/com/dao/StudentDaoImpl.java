package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Student;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public void insert(Student student) {
		this.template.save(student);

	}

	public Student get(String roll_number) {
		Student st = this.template.get(Student.class, roll_number);
		return st;
	}

	@Transactional
	public void delete(String roll_number) {
		Student student = this.template.get(Student.class, roll_number);
		if(student!=null) {
			this.template.delete(student);
		}
	}

	public List<Student> getall() {
		return this.template.loadAll(Student.class);
	}

	@Transactional
	public void update(Student student) {
		this.template.update(student);
	}

}
