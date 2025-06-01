package com.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Fee;

@Repository("FeeDao")
public class FeeDaoImpl implements FeeDao {
	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public void update(Fee fee) {
		this.template.update(fee);
	}

	public Fee getbyroll(String rollnumber) {
		return this.template.get(Fee.class, rollnumber);
	}

	public List<Fee> getall() {
		return this.template.loadAll(Fee.class);
	}

	public List<Fee> getbypaid(String paid) {
		return this.template.execute(session -> {
			String hql = "FROM Fee fee WHERE fee.paid = :status";
			Query<Fee> query = session.createQuery(hql, Fee.class);
			query.setParameter("status", paid);
			return query.list();
		});
	}

	@Transactional
	public void add(Fee fee) {
		this.template.save(fee);
	}

	@Transactional
	public void delete(String rollnumber) {
		Fee fee = getbyroll(rollnumber);
		if (fee != null) {
			this.template.delete(fee);
		}
	}
}
