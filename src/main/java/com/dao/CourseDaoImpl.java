package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Course;

@Repository("CourseDao")
public class CourseDaoImpl implements CourseDao {

	@Autowired
	private HibernateTemplate template;

	@Transactional
	public Course get(String courseid) {
		return this.template.load(Course.class, courseid);
	}

	@Transactional
	public void delete(String courseid) {
		Course cs = this.template.load(Course.class, courseid);
		if (cs != null) {
			this.template.delete(cs);
		}
	}

	@Transactional
	public List<Course> getall() {
		return this.template.loadAll(Course.class);
	}

	@Transactional
	public void add(Course course) {
		this.template.save(course);
	}

	@Transactional
	public void update(Course course) {
		this.template.update(course);
	}

}
