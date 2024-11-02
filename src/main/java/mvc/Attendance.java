package mvc;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attendance")
public class Attendance {
	
	@Id
	@Column(name="attendanceid")
	private int attendanceid;
	
	@Column(name="rollnumber")
	private String rollnumber;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="attendance")
	private String attendance;
	
	@Column(name="courseid")
	private String courseid;

	public String getRollnumber() {
		return rollnumber;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	
	

	public int getAttendanceid() {
		return attendanceid;
	}

	public void setAttendanceid(int attendanceid) {
		this.attendanceid = attendanceid;
	}

	@Override
	public String toString() {
		return "Attendance [attendanceid=" + attendanceid + ", rollnumber=" + rollnumber + ", date=" + date
				+ ", attendance=" + attendance + ", courseid=" + courseid + "]";
	}
	public Attendance(String rollnumber, Date date, String attendance, int attendanceid, String courseid) {
		super();
		this.rollnumber = rollnumber;
		this.date = date;
		this.attendance = attendance;
		this.attendanceid = attendanceid;
		this.courseid = courseid;
	}

	public Attendance() {
		super();
	}
	public boolean isPresent() {
	    return "present".equalsIgnoreCase(attendance);
	}
	
	
}
