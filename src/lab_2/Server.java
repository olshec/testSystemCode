package lab_2;

import java.util.ArrayList;
import java.util.List;

public class Server {

	UserBase userBase;
	TestBase testBase;
	
	public Server() {

		
		testBase = new TestBase();
		userBase=new UserBase();
				
		
		//BEGIN DATA FOR TEST
		Teacher teacher1 = new Teacher("Киров", "Антон", this, "KirovAnton", "12345678");
		Test test1 = new Test("Робототехника", teacher1);
		Test test2 = new Test("Сетевые технологии", teacher1);
		Test test3 = new Test("Информатика", teacher1);
		
		List<Test> tests=new ArrayList<Test>();
		tests.add(test1);
		tests.add(test2);
		tests.add(test3);
		testBase.addArrayTest(tests);
		
		
		Student student1 = new Student("Шахматов","Антон",this,"ShAnton","1111");
		Student student2 = new Student("Романенко","Егор",this,"REgor","1111");
		
		userBase.addUser(student1);
		userBase.addUser(student2);
		userBase.addUser(teacher1);
		
		test1.addStudent(student1);
		test1.addStudent(student2);
		
		test1.addResult(student1, 4);
		test1.addResult(student2, 2);
		
		
		test2.addStudent(student1);
		test2.addResult(student1, 5);

		//END DATA FOR TEST
		
		
	}
	/*
	 * User interface
	 */
	public User login(String username, String password) {
		return userBase.getUser(username, password);
	}

	/*
	 * Student interface
	 */
	public List<Test> studentGetTests(User student)
	{
		return testBase.getTestsStudent(student);
	}
	
	/*
	 * Student interface
	 */
	public Test studentGetTestInfo(User student, int indexTest)
	{
		Test test=testBase.getTestIndex(indexTest);
		if(test!=null && test.hasStudent(student)) {
			return testBase.getTestIndex(indexTest);
		}
		else
			return null;
	}
	
	
	/*
	 * Teacher interface
	 */
	public List<Test> teacherGetTests(User teacher) {
		return testBase.teacherGetTests(teacher);
	}
	
	/*
	 * Teacher interface
	 */
	public Test teacherGetTestResult(User teacher, int indexTest) {
		return testBase.teacherGetTests(teacher).get(indexTest);
	}
	
	/*
	 * Admin interface
	 */
	public List<User> adminGetUser() {
		return userBase.getUsers();
	}
	
	/*
	 * Admin interface
	 */
	private List<User> adminGetUser(String typeUser){
		List<User> masUser = userBase.getUsers();
		for(int i=0;i<masUser.size();i++) {
			if(masUser.get(i).getClass().toString()==typeUser)
				masUser.add(masUser.get(i));
		}
		return masUser;
	}
	public List<User> adminGetStudent() {
		
		return adminGetUser("Student");
	}
	public List<User> adminGetTeacher() {
			
			return adminGetUser("Teacher");
		}
	public List<User> adminGetAdmin() {
		
		return adminGetUser("Admin");
	}
	
}
