import java.io.*;
import java.util.*;
public abstract class User implements Serializable{
	static final long serialVersionUID = 123456789L;
	int id;
	String login;
	String password;

//================== Constructors
	User(){
		id = 0;
		login = "no login";
		password = "no password";
	}
	User(int id, String login, String password){
		this.id = id;
		this.login = login;
		this.password = password;
	}

//================== Setters
	public void setID(int id){
		this.id = id;
	}
	public void setLogin(String login){
		this.login = login;
	}
	public void setPassword(String password){
		this.password = password;
	}
//================== Getters

	public int getID(){
		return id;
	}
	public String getLogin(){
		return login;
	}
	public String getPassword(){
		return password;
	}
 
 	abstract String getUserData();
}