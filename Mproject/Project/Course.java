import java.io.*;
import java.util.*;
public class Course extends S implements Serializable{
	int id;
	String name;
	Subject subject;
	Teacher teacher;
	List<Student> students = new ArrayList<Student>();

 //================= Constructors
	Course(){
		id = 0;
		name = "no name";
		//subject = new Subject();
		//users = new ArrayList<User>();
	}
	Course(int id, String name){
		this.id = id;
		this.name = name;
		//subject = new Subject();
		//this.students = students;
	}

  //================== Setters
	public void setID(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	//public void setSubject(Subject subject){
	//	this.subject = subject;
	//}
//	public void setStudents(User students){
//		this.students = students;
//	}
	
  //================== Getters 
	public int getID(){
		return id;
	}
	public String getName(){
		return name;
	}
	//public Subject getSubject(){
	//	return subject;
	//}
//	public User getStudents(){
//		return students;
//	}
	public String getCourseData(){
		return "ID: " + getID() + " Name: " + getName();
	}
}