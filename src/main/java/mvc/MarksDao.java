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

@Component("MarksDao")
public class MarksDao {
	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public void add(int marksid, String rollnumber, String courseid, String marks) {
		Marks mark = new Marks();
		mark.setCourseid(courseid);
		mark.setMarks(marks);
		mark.setMarksid(marksid);
		mark.setRollnumber(rollnumber);

		this.template.save(mark);
	}

	@Transactional
	public void update(int marksid, String rollnumber, String courseid, String marks) {
		Marks mark = new Marks();
		mark.setCourseid(courseid);
		mark.setMarks(marks);
		mark.setMarksid(marksid);
		mark.setRollnumber(rollnumber);

		this.template.update(mark);
	}

	public Marks get(Long marksid) {
		Marks mark = this.template.load(Marks.class, marksid);
		return mark;

	}

	public List<Marks> getmarksByRollNumber(String rollnumber) {
		return this.template.execute(new HibernateCallback<List<Marks>>() {
			@Override
			public List<Marks> doInHibernate(Session session) {
				String hql = "FROM Marks mark WHERE mark.rollnumber = :rollnumber";
				Query<Marks> query = session.createQuery(hql, Marks.class);
				query.setParameter("rollnumber", rollnumber);
				return query.list();
			}
		});
	}

	public List<Marks> getmarksByCourseId(String CourseId) {
		return this.template.execute(new HibernateCallback<List<Marks>>() {
			@Override
			public List<Marks> doInHibernate(Session session) {
				String hql = "FROM Marks mark WHERE mark.courseid = :CourseId";
				Query<Marks> query = session.createQuery(hql, Marks.class);
				query.setParameter("CourseId", CourseId);
				return query.list();
			}
		});
	}

	@Transactional
	public void delete(String rollnumber) {
		List<Marks> mark = getmarksByRollNumber(rollnumber);
		for (Marks marks : mark) {
			this.template.delete(marks);

		}
	}

	public void deletecourse(String courseid) {
		List<Marks> marks = getmarksByCourseId(courseid);
		for(Marks mark : marks) {
			this.template.delete(mark);
		}
		
	}

}
