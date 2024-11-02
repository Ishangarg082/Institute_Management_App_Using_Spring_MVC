package mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("studentDao")
public class StudentDao {
	Student student = new Student();
	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public void insert(String rollnumber, String name,String age,String branch,String address,String pass) {
		Student st = new Student();
		st.setAddress(address);
		st.setAge(age);
		st.setBranch(branch);
		st.setName(name);
		st.setRollnumber(rollnumber);
		st.setPass(pass);
		this.template.save(st);

	}
	@Transactional
	public void update(String rollnumber, String name,String age,String branch,String address,String pass) {
		Student st = new Student();
		st.setAddress(address);
		st.setAge(age);
		st.setBranch(branch);
		st.setName(name);
		st.setRollnumber(rollnumber);
		st.setPass(pass);
		
		this.template.update(st);

	}

	public Student get(String roll_number) {
		Student st = this.template.get(Student.class, roll_number);
		return st;
	}

	@Transactional
	public void delete(String roll_number) {
		student = this.template.get(Student.class, roll_number);
		this.template.delete(student);
	}

	public List<Student> getall() {
		List<Student> list = this.template.loadAll(Student.class);
		return list;
	}

	@Transactional
	public void update(Student student) {
		this.template.update(student);
	}

}
