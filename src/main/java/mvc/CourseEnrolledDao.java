package mvc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("CourseEnrolledDao")
public class CourseEnrolledDao {

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
    	CourseEnrolled ce = this.template.load(CourseEnrolled.class, registerid);
    	return ce;
    	
    }

    public List<CourseEnrolled> getCoursesByRollNumber(String rollnumber) {
        return this.template.execute(new HibernateCallback<List<CourseEnrolled>>() {
            @Override
            public List<CourseEnrolled> doInHibernate(Session session) {
                String hql = "FROM CourseEnrolled ce WHERE ce.rollnumber = :rollnumber";
                Query<CourseEnrolled> query = session.createQuery(hql, CourseEnrolled.class);
                query.setParameter("rollnumber", rollnumber);
                return query.list();
            }
        });
    }

  
    public List<CourseEnrolled> getStudentsByCourseId(String courseid) {
        return this.template.execute(new HibernateCallback<List<CourseEnrolled>>() {
            @Override
            public List<CourseEnrolled> doInHibernate(Session session) {
                String hql = "FROM CourseEnrolled ce WHERE ce.courseid = :courseid";
                Query<CourseEnrolled> query = session.createQuery(hql, CourseEnrolled.class);
                query.setParameter("courseid", courseid);
                return query.list();
            }
        });
    }

    @Transactional
    public void delete(String courseid, String rollnumber) {
        List<CourseEnrolled> entries = getStudentsByCourseId(courseid);
        for (CourseEnrolled ce : entries) {
            if (ce.getRollnumber().equals(rollnumber)) {
                this.template.delete(ce);
            }
        }
    }

    @Transactional
    public void add(String courseid, String rollnumber) {
        CourseEnrolled ce = new CourseEnrolled();
        ce.setCourseid(courseid);
        ce.setRollnumber(rollnumber);
        this.template.save(ce);
    }

    @Transactional
    public void update(String courseid, String rollnumber) {
        CourseEnrolled ce = new CourseEnrolled();
        ce.setCourseid(courseid);
        ce.setRollnumber(rollnumber);
        this.template.update(ce);
    }
}
