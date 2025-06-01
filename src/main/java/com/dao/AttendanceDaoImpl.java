package com.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Attendance;

@Repository("attendancedao")
public class AttendanceDaoImpl implements AttendanceDao {

	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public void add(Attendance attendance) {
		this.template.save(attendance);
	}

	@Transactional
	public void update(Attendance attendance) {
		this.template.update(attendance);
	}

	@Transactional
	public void deletestudent(String rollnumber) {

		List<Attendance> at = getbyroll(rollnumber);
		for (Attendance attendance : at) {
			this.template.delete(attendance);
		}
	}

	public List<Attendance> getbyroll(String rollnumber) {
		return template.execute(session -> {
			String hql = "FROM Attendance at WHERE at.rollnumber = :rollnumber";
			Query<Attendance> query = session.createQuery(hql, Attendance.class);
			query.setParameter("rollnumber", rollnumber);
			return query.list();
		});
	}

	public List<Attendance> getbydate(String date) {
		return this.template.execute(session -> {
			String hql = "FROM Attendance at WHERE at.date = :date";
			Query<Attendance> query = session.createQuery(hql, Attendance.class);
			query.setParameter("date", date);
			return query.list();
		});
	}

	public List<Attendance> getbycourse(String courseid) {
		return this.template.execute(session -> {
			String hql = "FROM Attendance at WHERE at.courseid = :courseid";
			Query<Attendance> query = session.createQuery(hql, Attendance.class);
			query.setParameter("courseid", courseid);
			return query.list();
		});
	}

	public Attendance get(int attendanceid) {
		return this.template.load(Attendance.class, attendanceid);
	}

	@Transactional
	public void deletecourse(String courseid) {
		List<Attendance> att = getbycourse(courseid);
		for (Attendance attendance : att) {
			this.template.delete(attendance);
		}

	}

	@Transactional
	public void delete(String rollnumber, String courseid, String date) {
		List<Attendance> att = getbyroll(rollnumber);
		for (Attendance attendance : att) {
			if (attendance.getCourseid().equals(courseid) && attendance.getDate().equals(date)) {
				this.template.delete(attendance);
			}
		}
	}

	public List<Attendance> getall() {
		return this.template.loadAll(Attendance.class);
	}


}
