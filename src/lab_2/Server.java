package lab_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a server.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Server {

	private UserBase userBase;
	private TestBase testBase;

	public Server() {

		testBase = new TestBase();
		userBase = new UserBase();

		// BEGIN DATA FOR TEST

		Admin admin1 = new Admin("Примарев", "Игорь", this, "Admin1", "0000");
		userBase.addUser(admin1);

		Teacher teacher1 = new Teacher("Киров", "Антон", this, "KirovAnton", "12345678");
		userBase.addUser(teacher1);
		Test test1 = new Test("Робототехника", teacher1);
		Test test2 = new Test("Сетевые технологии", teacher1);
		Test test3 = new Test("Информатика", teacher1);

		Question q1 = new Question("Основы роботетхники");
		Question q2 = new Question("AI");
		Question q3 = new Question("Микроконтроллеры");
		test1.addQuestion(q1);
		test1.addQuestion(q2);
		test1.addQuestion(q3);

		Question q4 = new Question("Протокол HTTP");
		Question q5 = new Question("Характеристика OSI");
		Question q6 = new Question("Протокол TCP");
		test2.addQuestion(q3);
		test2.addQuestion(q4);
		test2.addQuestion(q5);
		test2.addQuestion(q6);

		List<Test> tests = new ArrayList<Test>();
		tests.add(test1);
		tests.add(test2);
		tests.add(test3);
		testBase.addTests(tests);

		Student student1 = new Student("Шахматов", "Антон", this, "ShAnton", "1111");
		Student student2 = new Student("Романенко", "Егор", this, "REgor", "1111");

		userBase.addUser(student1);
		userBase.addUser(student2);

		test1.addStudent(student1);
		test1.addStudent(student2);

		test1.addResult(student1, 4);
		test1.addResult(student2, 2);

		test2.addStudent(student1);
		test2.addResult(student1, 5);

		// END DATA FOR TEST

	}

	/** login function.
	 * @param username The user's username.
	 * @param password The user's password.
	 * @return User The authenticated user.
	*/
	public User login(String username, String password) {
		return userBase.getUser(username, password);
	}

	/** Gets tests for student.
	 * @param student The student.
	 * @return List<Test> The list tests.
	*/
	public List<Test> studentGetTests(User student) {
		return testBase.getTestsStudent(student);
	}

	/** Gets student test information.
	 * @param student The student.
	 * @param indexTest The test index.
	 * @return Test The test.
	*/
	public Test studentGetTestInfo(User student, int indexTest) {
		Test test = testBase.getTestIndex(indexTest);
		if (test != null && test.hasStudent(student)) {
			return testBase.getTestIndex(indexTest);
		} else
			return null;
	}

	/** Gets tests for teacher.
	 * @param teacher The teacher.
	 * @return List<Test> The list tests.
	*/
	public List<Test> teacherGetTests(User teacher) {
		return testBase.teacherGetTests(teacher);
	}

	/** Gets students test result.
	 * @param teacher The teacher.
	 * @param indexTest The test index.
	 * @return Test The test.
	*/
	public Test teacherGetTestResult(User teacher, int indexTest) {
		return testBase.teacherGetTests(teacher).get(indexTest);
	}

	/** Gets users.
	 * @return List<User> The list all users.
	*/
	public List<User> adminGetAllUsers() {
		return userBase.getUsers();
	}

	//get user by type 
	private List<User> adminGetUsers(String typeUser) {
		List<User> masUser = userBase.getUsers();
		List<User> masUserResult = new ArrayList<User>();
		for (int i = 0; i < masUser.size(); i++) {
			String className = masUser.get(i).getClass().getSimpleName();
			if (className.equals(typeUser)) {
				masUserResult.add(masUser.get(i));
			}
		}
		return masUserResult;
	}

	/** Gets students.
	 * @return List<User> The list students.
	*/
	public List<User> adminGetStudents() {

		return adminGetUsers("Student");
	}

	/** Gets teachers.
	 * @return List<User> The list teachers.
	*/
	public List<User> adminGetTeachers() {

		return adminGetUsers("Teacher");
	}

	/** Gets administrators.
	 * @return List<User> The list administrators.
	*/
	public List<User> adminGetAdmins() {

		return adminGetUsers("Admin");
	}

}
