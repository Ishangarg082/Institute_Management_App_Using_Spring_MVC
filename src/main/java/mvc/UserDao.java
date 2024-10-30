package mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userdao")
public class UserDao {
	User user = new User();
	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public List<User> getusers(){
		List<User> users = this.template.loadAll(User.class);
		return users;
	}
	public User get(String userid) {
		user = this.template.get(User.class, userid);
		return user;
	}
	
	@Transactional
	public void add(String userid,String pass,String role,String name) {
		user.setUser_id(userid);
		user.setPass(pass);
		user.setRole(role);
		user.setName(name);
		this.template.save(user);
	}
	@Transactional
	public void remove(String userid) {
		user = this.template.get(User.class, userid);
		this.template.delete(user);
	}
	
	@Transactional
	public void update(String userid,String name,String role, String pass) {
		user.setName(name);
		user.setPass(pass);
		user.setRole(role);
		user.setUser_id(userid);
		this.template.update(user);
	}
}
