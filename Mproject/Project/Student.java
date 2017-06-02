import java.util.*;
import java.io.*;
public class Student extends User implements Serializable{
	static final long serialVersionUID = 123456789L;
	String name;
	String surname;
	String group;

//=====================	Constructors
	Student(){
		super();
		name = "no name";
		surname = "no surname";
		group = "no group";
	}
	Student(int id, String login, String password, String name, String surname, String group){
		super(id, login, password);
		this.name = name;
		this.surname = surname;
		this.group = group;
	}

//===================== Setters
	public void setName(String name){
		this.name = name;
	} 
	public void setSurname(String surname){
		this.surname = surname;
	}
	public void setGroup(String group){
		this.group = group;
	}

//===================== Getters
	public String getName(){
		return name;
	} 
	public String getSurname(){
		return surname;
	}
	public String getGroup(){
		return group;
	}

	public String getUserData(){
		return  "ID: " + super.getID()
				+ " Name: " + getName() 
				+ " Surname: " + getSurname()
				+ " Group: " + getGroup();
	}
}