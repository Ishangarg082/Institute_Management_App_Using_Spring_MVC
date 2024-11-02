package mvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CourseEnrolled")
public class CourseEnrolled {
	@Id
	@Column(name="registerid")
	private int registerid;
	@Column(name="courseid")
	private String courseid;
	@Column(name="rollnumber")
	private String rollnumber;
	
 
	public int getRegisterid() {
		return registerid;
	}
	public void setRegisterid(int registerid) {
		this.registerid = registerid;
	}
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
		return "CourseEnrolled [registerid=" + registerid + ", courseid=" + courseid + ", rollnumber=" + rollnumber
				+ "]";
	}
	public CourseEnrolled(String courseid, String rollnumber,int registerid) {
		super();
		this.courseid = courseid;
		this.rollnumber = rollnumber;
		this.registerid = registerid;
	}
	public CourseEnrolled() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
