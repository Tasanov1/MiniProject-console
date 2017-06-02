import java.util.*;
import java.io.*;

public class Algorithm implements Serializable {

//============== Serialize method 
	public static void serialize(ArrayList users, String file){

 		try{
			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file));

			outStream.writeObject(users);
			outStream.close();

		}catch (Exception e){
			e.printStackTrace();
		}

	}

//============== Deserialize method 
	public static< T extends User, E extends S >ArrayList deserialize(String file, String mode){

		boolean isUser = file.equals("admin.dat") || file.equals("teacher.dat") || file.equals("student.dat");
		boolean isSubject = file.equals("subject.dat");
		boolean isCourse = file.equals("course.dat");

		try{
			ArrayList<T> list1 = new ArrayList<T>();
			ArrayList<E> list2 = new ArrayList<E>();
			ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(file));
		//-------------------------------------------------------------
			if(isUser){
				list1 = (ArrayList<T>)inStream.readObject();
				inStream.close();
			}
			if(isSubject || isCourse){
				list2 = (ArrayList<E>)inStream.readObject();
				inStream.close();
			}

		//-------------------------------------------------------------
			if(mode.equals("read::out")){
			
				if(isUser){
					//@SuppressWarnings("unchecked")
					for(T object : list1) System.out.println(object.getUserData());
					return list1;
				}
				if(isSubject){
					for(E object : list2) System.out.println(object.getSubjectData());
					return list2;
				}
				if(isCourse){
					for(E object : list2) System.out.println(object.getCourseData());
					return list2;
				}
			}
			else if(mode.equals("read")){

				if(isUser){
					//@SuppressWarnings("unchecked")
					for(T object : list1) return list1;
				}
				if(isSubject){
					for(E object : list2) return list2;
				}
				if(isCourse){
					for(E object : list2) return list2;
				}

			}

		}catch (Exception e) {
			
			e.printStackTrace();
			return null;

		}
		return null;
	}
}