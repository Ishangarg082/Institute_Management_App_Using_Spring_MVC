package com.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Marks;

@Repository("MarksDao")
public class MarksDaoImpl implements MarksDao {

    @Autowired
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return template;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Transactional
    public void add(Marks mark) {
        this.template.save(mark);
    }

    @Transactional
    public void update(Marks mark) {
        this.template.update(mark);
    }

    public Marks get(int marksid) {
        return this.template.get(Marks.class, marksid);
    }

    public List<Marks> getmarksByRollNumber(String rollnumber) {
        return template.execute(session -> {
            String hql = "FROM Marks mark WHERE mark.rollnumber = :rollnumber";
            Query<Marks> query = session.createQuery(hql, Marks.class);
            query.setParameter("rollnumber", rollnumber);
            return query.list();
        });
    }

    public List<Marks> getmarksByCourseId(String courseId) {
        return template.execute(session -> {
            String hql = "FROM Marks mark WHERE mark.courseid = :courseId";
            Query<Marks> query = session.createQuery(hql, Marks.class);
            query.setParameter("courseId", courseId);
            return query.list();
        });
    }

    @Transactional
    public void delete(String rollnumber) {
        List<Marks> marksList = getmarksByRollNumber(rollnumber);
        for (Marks mark : marksList) {
            if (mark != null) {
                this.template.delete(mark);
            }
        }
    }

    @Transactional
    public void deletecourse(String courseid) {
        List<Marks> marksList = getmarksByCourseId(courseid);
        for (Marks mark : marksList) {
            if (mark != null) {
                this.template.delete(mark);
            }
        }
    }

    @Transactional
    public void deletemark(int marksid) {
        template.execute(session -> {
            String hql = "delete from Marks mark where mark.marksid = :marksid";
            Query<?> query = session.createQuery(hql);
            query.setParameter("marksid", marksid);
            return query.executeUpdate();
        });
    }

    public List<Marks> getall() {
        return this.template.loadAll(Marks.class);
    }
}
