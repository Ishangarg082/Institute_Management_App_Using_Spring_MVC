package mvc;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("attendancedao")
public class AttendanceDao {

	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public void add(int attendanceid, String rollnumber, Date date, String Attendance, String courseid) {
		Attendance att = new Attendance();
		att.setAttendance(Attendance);
		att.setDate(date);
		att.setRollnumber(rollnumber);
		att.setAttendanceid(attendanceid);
		att.setCourseid(courseid);

		this.template.save(att);
	}

	@Transactional
	public void update(String rollnumber, Date date, String Attendance, int attendanceid,String courseid) {
		Attendance att = new Attendance();
		att.setAttendance(Attendance);
		att.setDate(date);
		att.setRollnumber(rollnumber);
		att.setAttendanceid(attendanceid);
		att.setCourseid(courseid);

		this.template.update(att);
	}

	@Transactional
	public void delete(String rollnumber, Date date, String Attendance) {

		Attendance at = new Attendance();
		at.setAttendance(Attendance);
		at.setDate(date);
		at.setRollnumber(rollnumber);
		List<Attendance> att = getbyroll(rollnumber);
		List<Attendance> att2 = getbydate(date);
		if (att.contains(at) || att2.contains(at)) {
			this.template.delete(at);
		}
	}

	public List<Attendance> getbyroll(String rollnumber) {
		return this.template.execute(new HibernateCallback<List<Attendance>>() {
			@Override
			public List<Attendance> doInHibernate(Session session) {
				String hql = "FROM Attendance at WHERE at.rollnumber = :rollnumber";
				Query<Attendance> query = session.createQuery(hql, Attendance.class);
				query.setParameter("rollnumber", rollnumber);
				return query.list();
			}
		});
	}

	public List<Attendance> getbydate(Date date) {
		return this.template.execute(new HibernateCallback<List<Attendance>>() {
			@Override
			public List<Attendance> doInHibernate(Session session) {
				String hql = "FROM Attendance at WHERE at.date = :date";
				Query<Attendance> query = session.createQuery(hql, Attendance.class);
				query.setParameter("date", date);
				return query.list();
			}
		});
	}

	public Attendance get(String attendanceid) {
		Attendance att = this.template.load(Attendance.class, attendanceid);
		return att;
	}

}
