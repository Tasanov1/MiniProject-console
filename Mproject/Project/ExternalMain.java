import java.util.*;
import java.io.*;

public class ExternalMain implements Serializable{
	public static void main(String[] args) {
		ArrayList<Subject> users = new ArrayList<Subject>();
		users.add(new Subject(56,"Java","admin"));
 		try{

			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("subject.dat"));
			outStream.writeObject(users);
			outStream.close();

		}catch (Exception e) {
			
			e.printStackTrace();

		}
	}
}