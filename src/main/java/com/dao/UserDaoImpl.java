package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;

@Repository("userdao")
public class UserDaoImpl implements UserDao{
	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public List<User> getusers(){
		return this.template.loadAll(User.class);
	}
	
	public User get(String userid) {
		return this.template.get(User.class, userid);
	}
	
	@Transactional
	public void add(User user) {
		this.template.save(user);
	}
	@Transactional
	public void remove(String userid) {
		User user = this.template.get(User.class, userid);
		if(user!=null) {
			this.template.delete(user);
		}
	}
	
	@Transactional
	public void update(User user) {
		this.template.update(user);
	}
}
