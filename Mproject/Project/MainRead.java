import java.util.*;
import java.io.*;

public class MainRead{
	public static void main(String[] args)throws FileNotFoundException {
		
		try{

			ObjectInputStream inStream = 
				new ObjectInputStream(new FileInputStream("subject.dat"));
	@SuppressWarnings("unchecked")
			ArrayList<Subject> list = 
				(ArrayList<Subject>)inStream.readObject();

			inStream.close();

			for(Subject u : list){
				System.out.println(u.getSubjectData());
			}

		}catch (Exception e) {
			
			e.printStackTrace();

		}

	}
}