import java.io.*;
import java.util.*;

public class Subject extends S implements Serializable{
	int id;
	String name;
	String description;
 //==================== Constructors
	Subject(){
		id = 0;
		name = "no name";
		description = "no description";
	}
	Subject(int id, String name, String description){
		this.id = id;
		this.name = name;
		this.description = description;
	}

 //==================== Setters 
	public void setID(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setDescription(String description){
		this.description = description;
	}

 //==================== Getters  
	public int getID(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getDescription(){
		return description;
	} 
	public String getSubjectData(){
		return "ID: " + getID() + " Name: " + getName() + " Description: " + getDescription();
	}
}