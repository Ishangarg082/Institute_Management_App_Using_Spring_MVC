package mvc;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("CourseDao")
public class CourseDao {
	
	
	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	
	@Transactional
	public Course get(String courseid) {
		Course cs = this.template.load(Course.class, courseid);
		return cs;
	}
	
	@Transactional
	public void delete(String courseid) {
		Course cs = this.template.load(Course.class, courseid);
		this.template.delete(cs);
	}
	
	@Transactional
	public List<Course> getall(){
		List<Course> courses = this.template.loadAll(Course.class);
		return courses;
	}
	
	@Transactional
	public void add(String courseid, String name) {
		Course cs = new Course();
		cs.setCourseid(courseid);
		cs.setName(name);
		this.template.save(cs);
	}
	@Transactional
	public void update(String courseid, String name) {
		Course cs = new Course();
		cs.setCourseid(courseid);
		cs.setName(name);
		this.template.update(cs);
	}
}
