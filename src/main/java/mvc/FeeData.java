package mvc;

public class FeeData {
	
	private String rollnumber;
	
	private String name;
	
	private String fees;
	
	private String paid;
	
	private String branch;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return "FeeData [rollnumber=" + rollnumber + ", name=" + name + ", fees=" + fees + ", paid=" + paid
				+ ", branch=" + branch + "]";
	}

	public FeeData(String rollnumber, String name, String fees, String paid, String branch) {
		super();
		this.rollnumber = rollnumber;
		this.name = name;
		this.fees = fees;
		this.paid = paid;
		this.branch = branch;
	}

	public FeeData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
