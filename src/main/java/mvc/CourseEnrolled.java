package mvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CourseEnrolled")
public class CourseEnrolled {
	@Id
	@Column(name="registerid")
	private String registerid;
	@Column(name="courseid")
	private String courseid;
	@Column(name="rollnumber")
	private String rollnumber;
	
 
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}
	@Override
	public String toString() {
		return "CourseEnrolled [courseid=" + courseid + ", rollnumber=" + rollnumber + "]";
	}
	public CourseEnrolled(String courseid, String rollnumber) {
		super();
		this.courseid = courseid;
		this.rollnumber = rollnumber;
	}
	public CourseEnrolled() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
