package com.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.CourseEnrolled;

@Repository("CourseEnrolledDao")
public class CourseEnrolledDaoImpl implements CourseEnrolledDao {

	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public List<CourseEnrolled> getAll() {
		return this.template.loadAll(CourseEnrolled.class);
	}

	public CourseEnrolled get(String registerid) {
		return this.template.load(CourseEnrolled.class, registerid);

	}

	public List<CourseEnrolled> getCoursesByRollNumber(String rollnumber) {
		return this.template.execute(session->{
				String hql = "FROM CourseEnrolled ce WHERE ce.rollnumber = :rollnumber";
				Query<CourseEnrolled> query = session.createQuery(hql, CourseEnrolled.class);
				query.setParameter("rollnumber", rollnumber);
				return query.list();
		});
	}

	public List<CourseEnrolled> getStudentsByCourseId(String courseid) {
		return this.template.execute(session -> {
			String hql = "FROM CourseEnrolled ce WHERE ce.courseid = :courseid";
			Query<CourseEnrolled> query = session.createQuery(hql, CourseEnrolled.class);
			query.setParameter("courseid", courseid);
			return query.list();
		});
	}

	@Transactional
	public void delete(String rollnumber) {
		List<CourseEnrolled> entries = getCoursesByRollNumber(rollnumber);
		for (CourseEnrolled ce : entries) {
			if(ce!=null) {
				this.template.delete(ce);
			}
		}
	}

	@Transactional
	public void add(CourseEnrolled ce) {
		this.template.save(ce);
	}

	@Transactional
	public void update(CourseEnrolled ce) {
		this.template.update(ce);
	}

	@Transactional
	public void deletecourse(String courseid) {
		List<CourseEnrolled> enroll = getStudentsByCourseId(courseid);
		for (CourseEnrolled ce : enroll) {
			if(ce!= null) {
				this.template.delete(ce);
			}
		}
	}

}
