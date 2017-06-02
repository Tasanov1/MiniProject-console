import java.util.*;
import java.io.*;
public class Admin extends User implements Serializable{
	static final long serialVersionUID = 123456789L;
//=============== Constructors
	Admin(){
		super();
	}
	Admin(int id, String login, String password){
		super(id, login, password);
	}


//================== Setters
	public void setID(int id){
		super.setID(id);
	}
	public void setLogin(String login){
		super.setLogin(login);
	}
	public void setPassword(String password){
		super.setPassword(password);
	}
//================== Getters

	public int getID(){
		return super.getID();
	}
	public String getLogin(){
		return super.getLogin();
	}
	public String getPassword(){
		return super.getPassword();
	}
 
 	public String getUserData(){
 		return "ID: " + getID() 
 				+ " Login: " + getLogin() 
 				+ " Password: " + getPassword(); 
 	} 

}