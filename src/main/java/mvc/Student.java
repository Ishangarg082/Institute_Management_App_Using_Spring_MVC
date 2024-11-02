package mvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Student_Details")
public class Student {
    @Id
    @Column(name = "rollnumber")
    private String rollnumber; 

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "branch")
    private String branch;

    @Column(name = "address")
    private String address;

    @Column(name = "pass")
    private String pass;

    
    // Default constructor
    public Student() {}

    // Constructor with parameters
    public Student(String rollnumber, String name, String age, String branch, String address, String pass) {
        this.rollnumber = rollnumber;
        this.name = name;
        this.age = age;
        this.branch = branch;
        this.address = address;
        this.pass = pass;
    }

    // Getters and Setters
    public String getRollnumber() { // Change from getRoll_number() to getRollnumber()
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Student [rollnumber=" + rollnumber + ", name=" + name + ", age=" + age + ", branch=" + branch
                + ", address=" + address + ", pass=" + pass + "]";
    }
}
