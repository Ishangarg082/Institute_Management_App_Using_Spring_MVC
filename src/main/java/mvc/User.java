package mvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_info")
public class User {
	@Id
	@Column(name="user_id")
	private String user_id;
	@Column(name="name")
	private String name;
	
	@Column(name="pass")
	private String pass;
	@Column(name="role")
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(String user_id, String name, String pass, String role) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.pass = pass;
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_id() {
		return user_id;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", pass=" + pass + ", role=" + role + "]";
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public User() {
		super();	
	}

	
}
