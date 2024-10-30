package mvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Marks")
public class Marks {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="marksid")
	private int marksid;

	@Column(name="rollnumber")
	private String rollnumber;
	
	@Column(name="courseid")
	private String courseid;
	
	@Column(name="marks")
	private String Marks;

	public int getMarksid() {
		return marksid;
	}

	public void setMarksid(int marksid) {
		this.marksid = marksid;
	}

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getMarks() {
		return Marks;
	}

	public void setMarks(String marks) {
		Marks = marks;
	}

	@Override
	public String toString() {
		return "Marks [marksid=" + marksid + ", rollnumber=" + rollnumber + ", courseid=" + courseid + ", Marks="
				+ Marks + "]";
	}

	public Marks(int marksid, String rollnumber, String courseid, String marks) {
		super();
		this.marksid = marksid;
		this.rollnumber = rollnumber;
		this.courseid = courseid;
		Marks = marks;
	}

	public Marks() {
		super();
	}
	
	
}
