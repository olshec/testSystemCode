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
public class ServerController {

	private UserBaseController userBase;
	private TestBase testBase;

	public ServerController() {

		testBase = new TestBase();
		userBase = new UserBaseController();

		// BEGIN DATA FOR TEST

		Admin admin1 = new Admin("Примарев", "Игорь", this, "Admin1", "0000");
		userBase.addUser(admin1);

		Teacher teacher1 = new Teacher("Киров", "Антон", this, "KirovAnton", "12345678");
		userBase.addUser(teacher1);
		TestController test1 = new TestController("Робототехника", teacher1);
		TestController test2 = new TestController("Сетевые технологии", teacher1);
		TestController test3 = new TestController("Информатика", teacher1);

		QuestionController q1 = new QuestionController("Основы роботетхники");
		QuestionController q2 = new QuestionController("AI");
		QuestionController q3 = new QuestionController("Микроконтроллеры");
		test1.addQuestion(q1);
		test1.addQuestion(q2);
		test1.addQuestion(q3);

		QuestionController q4 = new QuestionController("Протокол HTTP");
		QuestionController q5 = new QuestionController("Характеристика OSI");
		QuestionController q6 = new QuestionController("Протокол TCP");
		test2.addQuestion(q3);
		test2.addQuestion(q4);
		test2.addQuestion(q5);
		test2.addQuestion(q6);

		List<TestController> tests = new ArrayList<TestController>();
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
	public List<TestController> getTestsForStudent(User student) {
		return testBase.getTestsStudent(student);
	}

	/** Gets student test information.
	 * @param student The student.
	 * @param indexTest The test index.
	 * @return Test The test.
	*/
	public TestController getTestInfoForStudent(User student, int indexTest) {
		TestController test = testBase.getTestIndex(indexTest);
		if (test != null && test.hasStudent(student)) {
			return testBase.getTestIndex(indexTest);
		} else
			return null;
	}

	/** Gets tests for teacher.
	 * @param teacher The teacher.
	 * @return List<Test> The list tests.
	*/
	public List<TestController> teacherGetTests(User teacher) {
		return testBase.teacherGetTests(teacher);
	}

	/** Gets students test result.
	 * @param teacher The teacher.
	 * @param indexTest The test index.
	 * @return Test The test.
	*/
	public TestController teacherGetTestResult(User teacher, int indexTest) {
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
