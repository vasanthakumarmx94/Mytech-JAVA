package SerializationDemos;

import java.io.Serializable;
import java.util.Date;

public class Trainer implements Serializable {
	private static final long serialVersionUID=1L;
	//unique identifier for each class
	//JVm uses it to compare the version of the class ensuring that same class
	//used during serialization is loaded during deserialization
	private String name;
	private Date birthday;
	private boolean gender;
	private int age;
	private float salary;
	public Trainer() {
		
	}
	public Trainer(String name, Date birthday, boolean gender, int age, float salary) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	

}
