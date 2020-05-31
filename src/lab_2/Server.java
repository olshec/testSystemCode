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
		Teacher teacher = new Teacher("Киров", "Антон", this, "KirovAnton", "12345678");
		Test test1 = new Test("Робототехника", teacher);
		Test test2 = new Test("Сетевые технологии", teacher);
		Test test3 = new Test("Информатика", teacher);
		
		List<Test> tests=new ArrayList<Test>();
		tests.add(test1);
		tests.add(test2);
		tests.add(test3);
		testBase.addArrayTest(tests);
		
		
		Student student1 = new Student("Шахматов","Антон",this,"ShAnton","1111");
		Student student2 = new Student("Романенко","Егор",this,"REgor","1111");
		
		test2.addStudent(student1);
		test1.addStudent(student2);
		
		userBase.addUser(student1);
		userBase.addUser(student2);
		//END DATA FOR TEST
		
		
	}
	/*
	 * User interface
	 */
	public User login(String username, String password) {
		return userBase.getUser(username, password);
	}

	/*
	 * User interface
	 */
	public User startSession(User user) {
		return new Student();
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
		return testBase.getTests(teacher);
	}
	
	/*
	 * Teacher interface
	 */
	public List<Test> teacherGetTestResult(User teacher) {
		return testBase.getTests(teacher);
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
