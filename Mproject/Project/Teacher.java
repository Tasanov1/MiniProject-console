import java.util.*;
import java.io.*;
public class Teacher extends User implements Serializable{
	static final long serialVersionUID = 123456789L;
	String name;
	String surname;
	String degree;
	String department;

//================== Constructors
	Teacher(){
		super();
		name = "no name";
		surname = "no surname";
		degree = "no degree";
		department = "no department";
	}
	Teacher(int id, String login, String password, String name, String surname, String degree, String department){
		super(id, login, password);
		this.name = name;
		this.surname = surname;
		this.degree = degree;
		this.department = department;
	}

//================== Setters  
	public void setName(String surname){
		this.name = name;
	}
	public void setSurname(String surname){
		this.surname = surname;
	}
	public void setDegree(String degree){
		this.degree = degree;
	}
	public void setDepartment(String department){
		this.department = department;
	}

//================== Getters
	public String getName(){
		return name;
	}
	public String getSurname(){
		return surname;
	}
	public String getDegree(){
		return degree;
	}
	public String getDepartment(){
		return department;
	}
	public String getUserData(){
		return " ID: " + super.getID()
				+ " Name: " + getName() 
				+ " Surname: " + getSurname() 
				+ " Degree: "  + getDegree() 
				+ " Department: " + getDepartment()
				+ " Login: " + super.getLogin()
				+ " Password: " + super.getPassword(); 
	 }

}