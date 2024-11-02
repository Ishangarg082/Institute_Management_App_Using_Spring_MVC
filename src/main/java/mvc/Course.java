package mvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {

	@Id
	@Column(name="courseid")
	private String courseid;
	
	@Column(name="name")
	private String name;
	


	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", name=" + name + "]";
	}

	public Course() {
		super();
	
	}

	public Course(String courseid, String name) {
		super();
		this.courseid = courseid;
		this.name = name;
	}
	
	
	
}
