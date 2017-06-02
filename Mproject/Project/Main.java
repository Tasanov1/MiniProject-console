import java.io.*;
import java.util.*;

public class Main{
static final long serialVersionUID = 123456789L;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean c = true;
		Algorithm al = new Algorithm();
		try{
			ObjectInputStream inStream1 = new ObjectInputStream(new FileInputStream("admin.dat"));
			ObjectInputStream inStream2 = new ObjectInputStream(new FileInputStream("student.dat"));
			ObjectInputStream inStream3 = new ObjectInputStream(new FileInputStream("teacher.dat"));
			//@SuppressWarnings("unchecked")
			ArrayList<Admin> list1 = (ArrayList<Admin>)inStream1.readObject();
			ArrayList<Student> list2 = (ArrayList<Student>)inStream2.readObject();
			ArrayList<Teacher> list3 = (ArrayList<Teacher>)inStream3.readObject();
			while(c){
				System.out.println("INSERT LOGIN:");
					String login = in.next();
				System.out.println("INSERT PASSWORD:");
					String password = in.next();
				for (Admin object : list1) {
					if(object.getPassword().equals(password) && object.getLogin().equals(login)){
						Menu user = new Menu();
						user.adminMenu();
						inStream1.close();
						c = false;
					}
				}
				if(c)
					for (Student object : list2) {
						if(object.getPassword().equals(password) && object.getLogin().equals(login)){
							Menu user = new Menu();
							user.studentMenu(object);
							c = false;
							inStream2.close();
						}
					}
				if(c)
					for (Teacher object : list3) {
						if(object.getPassword().equals(password) && object.getLogin().equals(login)){
							Menu user = new Menu();
							user.teacherMenu(object);
							c = false;
							inStream3.close();
						}
					}
				if(c)
					System.out.println("Wrong login or password!");
			}
			

		}catch (Exception e) {
			
			e.printStackTrace();

		}
	}
}
