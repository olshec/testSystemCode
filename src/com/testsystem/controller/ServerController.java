package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.models.Administrator;
import com.testsystem.models.Question;
import com.testsystem.models.Student;
import com.testsystem.models.Teacher;
import com.testsystem.models.Test;
import com.testsystem.models.TestBase;
import com.testsystem.models.User;
import com.testsystem.models.UserBase;

/**
 * Represents a server controller.
 * 
 * @author Oleg Shestakov
 * 
 * @author olshec@gmail.com
 * 
 * @version 1.0
 */

public class ServerController {

	private TestBase testBase;
	private UserBase userBase;

	/**
	 * Creates a ServerController.
	 */
	public ServerController() {
		testBase = new TestBase();
		userBase = new UserBase();
		// userBaseController = new UserBaseController(userBaseModel);

		loadTest();
	}

	/**
	 * login function.
	 * @param username The user's username.
	 * @param password The user's password.
	 * @return User The authenticated user.
	 */
	public User login(String username, String password) {
		return new UserBaseController(userBase).getUser(username, password);
	}

	/**
	 * Gets tests for student.
	 * 
	 * @param student The student.
	 * @return List<Test> The list tests.
	 */
	public List<Test> getTestsForStudent(User student) {
		return new StudentController(student).getTests(testBase);
	}

	/**
	 * Gets student test information.
	 * @param student   The student's model.
	 * @param indexTest The test index.
	 * @return The test's model.
	 */
	public Test getTestInfoForStudent(User student, int indexTest) {
		return new StudentController(student).getTestInfo(indexTest, testBase);
	}

	/**
	 * Gets student test number questions.
	 * @param student   The student.
	 * @param indexTest The test index.
	 * @return The test.
	 */
	public int getNumberQuestionsInTest(User student, int indexTest) {
		return new StudentController(student).getNumberQuestionsInTest(indexTest,
				testBase);
	}

	/**
	 * Gets tests for teacher.
	 * 
	 * @param teacher The teacher.
	 * @return List<Test> The list tests.
	 */
	public List<Test> getTestsForTeacher(User teacher) {
		return new TeacherController(teacher).getTests(testBase);
	}

	/**
	 * Gets students test result.
	 * @param teacher   The teacher.
	 * @param indexTest The test index.
	 * @return Test The test.
	 */
	public Test getTestResultForTeacher(User teacher, int indexTest) {
		return new TeacherController(teacher).getTestResult(indexTest, testBase);
	}

	/**
	 * Gets users.
	 * @return List<User> The list all users.
	 */
	public List<User> getAllUsersForAdmin(User adminModel) {
		return new AdministratorController(adminModel)
				.getUsers(new UserBaseController(userBase).getUserBaseModel());
	}

	/**
	 * Gets students.
	 * @return List<User> The list students.
	 */
	public List<User> getStudentsForAdmin(User adminModel) {
		return new AdministratorController(adminModel).getUsersByType(Student.nameModel, userBase);
	}

	/**
	 * Gets teachers.
	 * @return List<User> The list teachers.
	 */
	public List<User> getTeachersForAdmin(User adminModel) {
		return new AdministratorController(adminModel).getUsersByType(Teacher.nameModel, userBase);
	}

	/**
	 * Gets administrators.
	 * @return List<User> The list administrators.
	 */
	public List<User> getAdminsForAdmin(User adminModel) {
		return new AdministratorController(adminModel).getUsersByType(Administrator.nameModel, userBase);
	}

	private void loadTest() {
		// BEGIN DATA FOR TEST
		UserBaseController userBaseController=new UserBaseController(userBase);
		User admin1 = new Administrator("Примарев", "Игорь", this, "Admin1", "0000");
		userBaseController.addUser(admin1);

		User teacher1 = new Teacher("Киров", "Антон", this, "KirovAnton", "12345678");
		userBaseController.addUser(teacher1);

		Test test1 = new Test("Робототехника", teacher1);
		Test test2 = new Test("Сетевые технологии", teacher1);
		Test test3 = new Test("Информатика", teacher1);

		Question q1 = new Question("Основы роботетхники");
		Question q2 = new Question("AI");
		Question q3 = new Question("Микроконтроллеры");

		TestController testController = new TestController(test1);
		testController.addQuestion(q1);
		testController.addQuestion(q2);
		testController.addQuestion(q3);

		Question q4 = new Question("Протокол HTTP");
		Question q5 = new Question("Характеристика OSI");
		Question q6 = new Question("Протокол TCP");

		testController.setTestModel(test2);

		testController.addQuestion(q3);
		testController.addQuestion(q4);
		testController.addQuestion(q5);
		testController.addQuestion(q6);

		List<Test> tests = new ArrayList<Test>();

		tests.add(test1);
		tests.add(test2);
		tests.add(test3);

		//TestBaseController testBaseController=new TestBaseController(testBaseModel);
		new TestBaseController(testBase).addTests(tests);
		//testBaseController.addTests(tests);

		User student1 = new Student("Шахматов", "Антон", this, "ShAnton", "1111");
		User student2 = new Student("Романенко", "Егор", this, "REgor", "1111");

		userBaseController.addUser(student1);
		userBaseController.addUser(student2);

		testController.setTestModel(test1);

		testController.addStudent(student1);
		testController.addStudent(student2);

		testController.addResult(student1, 4);
		testController.addResult(student2, 2);

		testController.setTestModel(test2);

		testController.addStudent(student1);
		testController.addResult(student1, 5);

		// END DATA FOR TEST
	}

}
