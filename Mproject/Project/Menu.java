import java.util.*;
import java.io.*;
public class Menu implements Serializable{
		static final long serialVersionUID = 123456789L;
		static final int BREAK = 99999;

		ArrayList <Admin> adminList = new ArrayList <Admin>();
		ArrayList <Teacher> teacherList = new ArrayList <Teacher>();  
		ArrayList <Student> studentList = new ArrayList <Student>();
		ArrayList <Subject> subjectList = new ArrayList <Subject>();
		ArrayList <Course> courseList = new ArrayList <Course>();
		ArrayList <User> userList = new ArrayList <User>();
		
			Scanner in = new Scanner(System.in);
	//========================================================================================	
		public void adminMenu(){
			adminList = Algorithm.deserialize("admin.dat","read");
			teacherList = Algorithm.deserialize("teacher.dat","read");
			studentList = Algorithm.deserialize("student.dat","read");
			courseList = Algorithm.deserialize("course.dat","read");
			subjectList = Algorithm.deserialize("subject.dat","read");

			//adminList.add(new Admin(-1,"admin","admin"));
			int adminID, teacherID, studentID, subjectID, courseID,ID = 0, insID; 
			String login, password;
			String name, surname;
			String degree, department, group, description;
			String isAdded;
			boolean check = false, breakout = false;
			for (int i = 0; i < 10; i ++) {

				System.out.println("\nPRESS [1] TO ADD A NEW USER");
				System.out.println("PRESS [2] TO ADD A NEW SUBJECT");
				System.out.println("PRESS [3] TO ADD NEW COURSE");
				System.out.println("PRESS [4] TO ASSIGN STUDENTS INTO COURSES");
				System.out.println("PRESS [5] TO EDIT USERS");
				System.out.println("PRESS [6] TO DELETE USERS");
				System.out.println("PRESS [7] TO EDIT COURSES");
				System.out.println("PRESS [8] TO DELETE COURSES");
				System.out.println("PRESS [9] TO EDIT SUBJECT");
				System.out.println("PRESS [10] TO DELETE SUBJECT");		
				
				int press = in.nextInt();
		
				for(int j = 0; j < 100; j ++){
					switch (press) {
						case 1:	System.out.println("\nPRESS [1] TO ADD ADMIN");
								System.out.println("PRESS [2] TO ADD TEACHER");
								System.out.println("PRESS [3] TO ADD STUDENT");
								System.out.println("PRESS [0] TO GO BACK");
								int pressToAdd = in.nextInt();
								switch (pressToAdd) {
									case 0: pressToAdd = 20;
											press = BREAK;
											break ;
									case 1:  ID = (int)(Math.random()*100); adminID = ID;
											System.out.print("\nINSERT LOGIN OF A ADMIN: ");
												login = in.next();
											System.out.print("INSERT PASSWORD OF A ADMIN: ");
												password = in.next();
											adminList.add(new Admin(adminID, login, password));
											Algorithm.serialize(adminList, "admin.dat");
											break;
									case 2:	 ID = (int)(Math.random()*100);teacherID = ID;
											System.out.print("\nINSERT LOGIN OF A TEACHER: ");
												login = in.next();
											System.out.print("INSERT PASSWORD OF A TEACHER: ");
												password = in.next();
											System.out.print("INSERT NAME OF A TEACHER: ");
												name = in.next();
											System.out.print("INSERT SURNAME OF A TEACHER: ");
												surname = in.next();
											System.out.print("INSERT DEGREE OF A TEACHER: ");
												degree = in.next();
											System.out.print("INSERT DEPARTMENT OF A TEACHER: ");
												department = in.next();

											teacherList.add(new Teacher(teacherID, login, password, name, surname, degree, department));
											Algorithm.serialize(teacherList, "teacher.dat");
											break;
									case 3:  ID = (int)(Math.random()*100); studentID = ID;
											System.out.print("\nINSERT LOGIN OF A STUDENT: ");
												login = in.next();
											System.out.print("INSERT PASSWORD OF A STUDENT: ");
												password = in.next();
											System.out.print("INSERT NAME OF A STUDENT: ");
												name = in.next();
											System.out.print("INSERT SURNAME OF A STUDENT: ");
												surname = in.next();
											System.out.print("INSERT GROUP OF A STUDENT: ");
												group = in.next();
											studentList.add(new Student(studentID, login, password, name, surname, group));
											Algorithm.serialize(studentList, "student.dat");
											break;
									default: break;
								}			
								break;
						
						case 2:  ID = (int)(Math.random()*100); subjectID = ID;
								System.out.print("\nINSERT NAME OF SUBJECT: ");
									name = in.next();
								System.out.print("INSERT DESCRIPTION: ");
									description = in.next();
								subjectList.add(new Subject(subjectID, name, description));
								Algorithm.serialize(subjectList, "subject.dat");
								press = BREAK;
								break;
						case 3:  ID = (int)(Math.random()*100);courseID = ID;
								System.out.println("\nINSERT NAME OF COURSE:");
									name = in.next();
								System.out.println("INSERT ID OF SUBJECT:");
									//Here you will list all subjects, so you can choose an ID of subject
									System.out.println("\nSubject:");
								    subjectList =  Algorithm.deserialize("subject.dat","read::out");
								   
									subjectID = in.nextInt();
									Subject foundedSubject = new Subject();
									
									for (Subject object : subjectList ) {
										if(subjectID == object.getID()){
											check = true;
											foundedSubject = object;
										}
									}
									isAdded = (check)? "THE SUBJECT SUCCESSFULLY ADDED":"THE SUBJECT WAS NOT FOUNDED !";
									System.out.println(isAdded);
									check = false;

								System.out.println("\nINSERT ID OF A TEACHER:");
										//Here you will list all teachers, so you can choose an ID of teacher
									teacherList = Algorithm.deserialize("teacher.dat","read::out");
									teacherID = in.nextInt();
									Teacher foundedTeacher = new Teacher(); 
									System.out.println("\nTeacher:");
									for (Teacher object : teacherList) {
										if(teacherID == object.getID()){
											check = true;
											foundedTeacher = object;
										}
									}
									isAdded = (check)? "THE TEACHER SUCCESSFULLY ADDED":"THE TEACHER WAS NOT FOUNDED !";
									System.out.println(isAdded);

									Course course = new Course(courseID, name);
									course.teacher = foundedTeacher;
									course.subject = foundedSubject;
									courseList.add(course);
									Algorithm.serialize(courseList, "course.dat");
									check = false;
									press = BREAK;
								break;
						case 4: int pos = 0;
								 while(!check){
									System.out.println("\nINSERT ID OF A COURSE: ");
									//Here you will list all courses, so you can choose an ID of course
									System.out.println("\nCourse:");
									courseList =  Algorithm.deserialize("course.dat", "read::out");
									courseID = in.nextInt();
								
									for (int k = 0; k < courseList.size(); k ++) {
										if(courseID == courseList.get(k).getID()){
											check = true;
											pos = k;
										}
									}
									isAdded = (check)? "THE COURSE FOUNDED":"THE COURSE WAS NOT FOUNDED! TRY AGAIN";
								}
								check = false;
									
								//After choosing a course, you will add students into course
								for(int k = 0; k < 100; k ++){

									System.out.println("\nPRESS [1] TO ADD STUDENT");
									System.out.println("PRESS [2] TO REMOVE STUDENT");
									System.out.println("PRESS [0] TO GO BACK");

									int press3 = in.nextInt();

									switch(press3){
										case 0: press3 = BREAK;
												breakout = true;
												break;
										case 1: while(!check){
													System.out.println("INSERT ID OF A STUDENT:");

													//Here you will list all students, not assigned to this course
													System.out.println("\nStudent:");
													studentList = Algorithm.deserialize("student.dat","read::out");
													studentID = in.nextInt();

														for (int m = 0; m < studentList.size(); m ++) {
															if(studentID == studentList.get(m).getID()){
																check = true;
																courseList.get(pos).students.add(studentList.get(m));
															}
														}
														isAdded = (check)? "THE STUDENT SUCCESSFULLY ADDED ":"THE STUDENT WAS NOT FOUNDED! TRY AGAIN";
													
														System.out.println(isAdded);
												}
												Algorithm.serialize(courseList, "course.dat");
												press3 = BREAK;
												check = false;
												//After adding one student, you will be again asked to add/remove student or go back to main menu.
												break;

										case 2: while(!check){

													System.out.println("\nINSERT ID OF A STUDENT:");
													//Here you will list all students, assigned to this course to remove
													System.out.println("\nStudent:");
													courseList = Algorithm.deserialize("course.dat","read");
													
													for (Student object : courseList.get(pos).students)
															System.out.println(object.getUserData());
												
													studentID = in.nextInt();

													for (int n = 0; n < courseList.size(); n ++) {
														for (int m = 0; m < courseList.get(n).students.size(); m ++){
															if(studentID == courseList.get(n).students.get(m).getID()){
																check = true;
																courseList.get(n).students.remove(m);
																break;
															}
														}
													}
													isAdded = (check)? "THE STUDENT SUCCESSFULLY REMOVED ":"THE STUDENT WAS NOT FOUNDED! TRY AGAIN";
													System.out.println(isAdded);
												}
												Algorithm.serialize(courseList, "course.dat");
												check = false;
												//After adding one student, you will be again asked to add/remove student or go back to main menu.
												break;
											default: break;
									}
									if(breakout){
										press = BREAK;
										break;
									}
								}
								breakout = false;
								break;
						case 5: System.out.println("\nINSERT ID OF USER:");
								//Here you will list all users, so you can choose an ID of user
								System.out.println("\nTeacher:");
								teacherList = Algorithm.deserialize("teacher.dat","read::out");
								System.out.println("\nAdmin:");
								adminList = Algorithm.deserialize("admin.dat","read::out");
								System.out.println("\nStudent:");
								studentList = Algorithm.deserialize("student.dat","read::out");

								//Now, you can update user data
								insID = in.nextInt();
								for (Teacher object : teacherList) {
									if(insID == object.getID()){
										System.out.print("INSERT NEW LOGIN OF A TEACHER: ");
											login = in.next();
										System.out.print("INSERT NEW PASSWORD OF A TEACHER: ");
											password = in.next();
										System.out.print("INSERT NEW NAME OF A TEACHER: ");
											name = in.next();
										System.out.print("INSERT NEW SURNAME OF A TEACHER: ");
											surname = in.next();
										System.out.print("INSERT NEW DEGREE OF A TEACHER: ");
											degree = in.next();
										System.out.print("INSERT NEW DEPARTMENT OF A TEACHER: ");
											department = in.next();
										object.setLogin(login);
										object.setPassword(password);
										object.setName(name);
										object.setSurname(surname);
										object.setDegree(degree);
										object.setDepartment(department);
										Algorithm.serialize(teacherList, "teacher.dat");
										check = true;
										break;
									}
								}
								for (Admin object : adminList) {
									if(insID == object.getID()){
										System.out.print("INSERT NEW LOGIN OF A ADMIN: ");
											login = in.next();
										System.out.print("INSERT NEW PASSWORD OF A ADMIN: ");
											password = in.next();
										object.setLogin(login);
										object.setPassword(password);
										Algorithm.serialize(adminList, "admin.dat");
										check = true;
										break;
									}
								}
								for (Student object : studentList) {
									if(insID == object.getID()){
										System.out.print("INSERT NEW LOGIN OF A STUDENT: ");
											login = in.next();
										System.out.print("INSERT NEW PASSWORD OF A STUDENT: ");
											password = in.next();
										System.out.print("INSERT NEW NAME OF A STUDENT: ");
											name = in.next();
										System.out.print("INSERT NEW SURNAME OF A STUDENT: ");
											surname = in.next();
										System.out.print("INSERT NEW GROUP OF A STUDENT: ");
											group = in.next();
										object.setLogin(login);
										object.setPassword(password);
										object.setName(name);
										object.setSurname(surname);
										object.setGroup(group);
										Algorithm.serialize(studentList, "student.dat");
										check = true;
										break;
									}
								}
								isAdded = (check)? "THE USER DATA SUCCESSFULLY UPDATED" : "THE USER WAS NOT FOUNDED!";
								System.out.println(isAdded);
								check = false;
								press = BREAK;
								break;
									
						case 6: System.out.println("INSERT ID OF USER:");
								//Here you will list all users, so you can choose an ID of user
								System.out.println("\nTeacher:");
								teacherList = Algorithm.deserialize("teacher.dat","read::out");
								System.out.println("\nAdmin:");
								adminList = Algorithm.deserialize("admin.dat","read::out");
								System.out.println("\nStudent:");
								studentList = Algorithm.deserialize("student.dat","read::out");

								insID = in.nextInt();
								//Now, you can delete user
								for (int k = 0; k < teacherList.size(); k ++) {
									if(insID == teacherList.get(k).getID()){
										teacherList.remove(k);
										check = true;
										Algorithm.serialize(teacherList, "teacher.dat");
										break;
									}
								}
								for (int k = 0; k < adminList.size(); k ++) {
									if(insID == adminList.get(k).getID()){
										adminList.remove(k);
										check = true;
										Algorithm.serialize(adminList, "admin.dat");
										break;
									}
								}
								for (int k = 0; k < studentList.size(); k ++) {
									if(insID == studentList.get(k).getID()){
										studentList.remove(k);
										check = true;
										Algorithm.serialize(studentList, "student.dat");
										break;
									}
								}
								isAdded = (check)?"THE USER SUCCESSFULLY REMOVED" : "THE USER WAS NOT FOUND! ";
								System.out.println(isAdded);
								check = false;
								press = BREAK;  
								break;
						case 7: System.out.println("INSERT ID OF COURSES:"); 
								//Here you will list all courses, so you can choose an ID of course
								System.out.println("\nCourse:");
								courseList = Algorithm.deserialize("course.dat","read::out");
								
								courseID = in.nextInt();

								//Now, you can update course data
								for (Course object : courseList) {
									if(courseID == object.getID()){
										check = true;
										System.out.println("THE NEW NAME OF COURSE");
										name = in.next();
										object.setName(name);
										Algorithm.serialize(courseList, "course.dat");
										break;
									}
								}
								isAdded = (check)? "THE COURSE DATA SUCCESSFULLY UPDATED" : "THE SUBJECT WAS NOT FOUNDED!";
								check = false;
								press = BREAK;
								break;
						case 8: System.out.println("\nINSERT ID OF COURSE:");
								//Here you will list all courses, so you can choose an ID of course
								System.out.println("\nCourse:");
								courseList = Algorithm.deserialize("course.dat","read::out");
								
								courseID = in.nextInt();

								//Now, you can delete course
								for (int k = 0; k < courseList.size(); k++) {
									if(courseID == courseList.get(k).getID()){
										check = true;
										courseList.remove(k);
										Algorithm.serialize(courseList, "course.dat");
										break;
									}
								}
								isAdded = (check)? "THE COURSE SUCCESFULLY REMOVED" : "THE COURSE WAS NOT FOUNDED!";
								System.out.println(isAdded);
								check = false;
								press = BREAK;
								break;
						case 9: while(!check){
								    System.out.println("INSERT ID OF SUBJECT:");
								    //Here you will list all courses, so you can choose an ID of subject
								    System.out.println("\nStudent:");
								    subjectList = Algorithm.deserialize("subject.dat","read::out");
								
									subjectID = in.nextInt();
									for (Subject object : subjectList) {

										if(subjectID == object.getID()){
								    		check = true;
								    		//Now, you can update subject data
											System.out.print("INSERT NEW NAME OF SUBJECT: ");
												name = in.next();
											System.out.print("INSERT NEW DESCRIPTION: ");
												description = in.next();
											object.setName(name);
											object.setDescription(description);
											Algorithm.serialize(subjectList, "subject.dat");
								    	}
								    }
								    isAdded = (check)? "THE SUBJECT DATA SUCCESSFULLY UPDATED ":"THE SUBJECT WAS NOT FOUNDED! TRY AGAIN";
									System.out.println(isAdded);
								}
								check = false;
								press = BREAK;
								break;
						case 10: while(!check){
									System.out.println("\nINSERT ID OF SUBJECT:");
									//Here you will list all subjects, so you can choose an ID of subject
									System.out.println("\nSubject:");
								    subjectList = Algorithm.deserialize("subject.dat", "read::out");
								
								    subjectID = in.nextInt();
								 
								    for (int k = 0; k < subjectList.size(); k ++) {
								 
								    	if(subjectID == subjectList.get(k).getID()){
								    		check = true;
								   			//Now, you can delete subject
								    		subjectList.remove(k);
								    		Algorithm.serialize(subjectList, "subject.dat");
								    		break;
								    	}
								    }
								    isAdded = (check)? "THE SUBJECT IS SUCCESSFULLY DELETETED" : "THE SUBJECT WAS NOT FOUNDED! TRY AGAIN";
								    System.out.println(isAdded);
								 }
								check = false;
								press = BREAK;
								break;
						default: break;
					}
				}
			}
		}

	//=========================================================
	public void teacherMenu(Teacher u){
		int courseID;	
		boolean check = false;
		while(!check){
			System.out.println("Teacher:");
			System.out.println(u.getUserData());
			System.out.println("\nPRESS [1] TO LIST MY COURSES");
			System.out.println("PRESS [2] TO LIST MY STUDENTS");
			System.out.println("PRESS [3] TO EXIT");
			int press = in.nextInt();
			switch(press){
				case 1: //HERE YOU WILL HAVE A LIST OF COURSES
						courseList = Algorithm.deserialize("course.dat","read");
						for (Course object : courseList) {
							if(u.getID() == object.teacher.getID()){
								System.out.println(object.getCourseData());
							}
						}
						break;
				case 2: System.out.println("INSERT COURSE ID:");
						//HERE YOU WILL HAVE A LIST OF ALL COURSES, BY inserting ID, you will list students assigned to
						//your course
						courseList = Algorithm.deserialize("course.dat","read");

						for (Course object : courseList) {
							if(object.teacher.getID() == u.getID())
								System.out.println(object.getCourseData());
						}
						courseID = in.nextInt();

						for (Course object : courseList) {
							if(courseID == object.getID()){
								if(object.teacher.getID() == u.getID()){
									for (Student st : object.students) 
										System.out.println(st.getUserData());
								}
							}
						}
						
						break;
				case 3: check = true;
						break;
				default: break;
			}
			
		}
		check = false;
	}
		//========================================================
	public void studentMenu(Student u){
		boolean check = false;
		
		while(!check){
			System.out.println("Student:");
			System.out.println(u.getUserData());
			System.out.println("\nPRESS [1] TO LIST MY COURSES");
			System.out.println("PRESS [0] EXIT");
			
			int press = in.nextInt();
			switch(press){
				case 0: check = true;
						break;
				case 1: courseList = Algorithm.deserialize("course.dat","read");
						for (Course object : courseList) {		
							for(int k = 0; k < object.students.size(); k ++)					
								if(u.getID() == object.students.get(k).getID()){
									System.out.println(object.getCourseData());
								}
						}
						break;
				default: check = true;
						break;
			}
		}
		check = false;
	}

	//=========================================================

	//}
}