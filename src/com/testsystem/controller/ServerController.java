package com.testsystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.testsystem.models.Administrator;
import com.testsystem.models.Group;
import com.testsystem.models.GroupBase;
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
 * @author olshec@gmail.com
 * @version 1.0
 */
public class ServerController {

	private TestBase testBase;
	private UserBase userBase;
	private GroupBase groupBase;

	/**
	 * Creates a ServerController.
	 */
	public ServerController() {
		testBase = new TestBase();
		userBase = new UserBase();
		groupBase = new GroupBase();
		// userBaseController = new UserBaseController(userBaseModel);

		loadTest();
	}

	/**
	 * Gets database of tests.
	 * 
	 * @return the database of tests
	 */
	public TestBase getTestBase() {
		return testBase;
	}

	/**
	 * Sets database of tests.
	 * 
	 * @param testBase the database of tests
	 */
	public void setTestBase(TestBase testBase) {
		this.testBase = testBase;
	}

	/**
	 * Gets database of users.
	 * 
	 * @return the database of users
	 */
	public UserBase getUserBase() {
		return userBase;
	}

	/**
	 * Sets database of users.
	 * 
	 * @param userBase the database of users
	 */
	public void setUserBase(UserBase userBase) {
		this.userBase = userBase;
	}

	/**
	 * Gets database of groups.
	 * 
	 * @return the groupBase
	 */
	public GroupBase getGroupBase() {
		return groupBase;
	}

	/**
	 * Sets database of groups.
	 * 
	 * @param groupBase the groupBase to set
	 */
	public void setGroupBase(GroupBase groupBase) {
		this.groupBase = groupBase;
	}

	/**
	 * Method for login.
	 * 
	 * @param username 	the user's username
	 * @param password 	the user's password
	 * @return User 	the authenticated user
	 */
	public User login(String username, String password) {
		return new UserBaseController(userBase).getUser(username, password);
	}

	/**
	 * Gets tests for student.
	 * 
	 * @param student 		the student
	 * @return List<Test> 	the list tests
	 */
	public List<Test> getTestsForStudent(User student) {
		return new StudentController(student).getTests(testBase);
	}

	/**
	 * Gets student test information.
	 * 
	 * @param student   the model of student
	 * @param idTest the test index
	 * @return 			the model of test
	 */
	public Test getTestInfoForStudent(User student, int idTest) {
		return new StudentController(student).getTestInfo(idTest, testBase);
	}

	/**
	 * Gets student test number questions.
	 * 
	 * @param student   the student
	 * @param idTest the test index
	 * @return 			the test
	 */
	public int getNumberQuestionsInTest(User student, int idTest) {
		return new StudentController(student).getNumberQuestionsInTest(idTest,
				testBase);
	}

	/**
	 * Gets tests for teacher.
	 * 
	 * @param teacher		the teacher
	 * @return List<Test> 	the list tests
	 */
	public List<Test> getTestsForTeacher(User teacher) {
		return new TeacherController(teacher).getTests(testBase);
	}

	/**
	 * Gets students test result.
	 * 
	 * @param teacher   the teacher
	 * @param indexTest the test id
	 * @return Test 	the test
	 */
	public Test getTestResultForTeacher(User teacher, int idTest) {
		return new TeacherController(teacher).getTestResult(idTest, testBase);
	}

	/**
	 * Gets all users.
	 * 
	 * @param 				the administrator
	 * @return List<User> 	the list all administrators
	 */
	public List<User> getAllUsersForAdmin(User admin) {
		return new AdministratorController(admin)
				.getAllUsers(new UserBaseController(userBase).getUserBase());
	}

	/**
	 * Gets students.
	 * 
	 * @param 				the administrator
	 * @return List<User> 	the list students
	 */
	public List<User> getStudentsForAdmin(User admin) {
		return new AdministratorController(admin).getUsersByType(Student.nameModel, userBase);
	}

	/**
	 * Gets teachers.
	 * 
	 * @param 				the administrator
	 * @return List<User> 	the list of teachers
	 */
	public List<User> getTeachersForAdmin(User admin) {
		return new AdministratorController(admin).getUsersByType(Teacher.nameModel, userBase);
	}

	/**
	 * Gets administrators.
	 * 
	 * @param 				the administrator
	 * @return List<User> 	the list of administrators
	 */
	public List<User> getAdminsForAdmin(User admin) {
		return new AdministratorController(admin).getUsersByType(Administrator.nameModel, userBase);
	}
	
	public int getRatingUser(User student) {
		return RatingCalculator.getRatingStudent(student, testBase);
	}
	
	public HashMap<User, Integer> getRatingGroup(String nameGroup){
		Group group = new GroupBaseController(groupBase).getGroupByName(nameGroup);
		return RatingCalculator.getRatingGroup(group, testBase, userBase);
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

		testController.setTest(test2);

		testController.addQuestion(q3);
		testController.addQuestion(q4);
		testController.addQuestion(q5);
		testController.addQuestion(q6);

		List<Test> tests = new ArrayList<Test>();

		tests.add(test1);
		tests.add(test2);
		tests.add(test3);

		new TestBaseController(testBase).addTests(tests);

		GroupBaseController groupBaseController = new GroupBaseController(groupBase);
		Group g1=new Group("Group 1");
		groupBaseController.addGroup(g1);
		User student1 = new Student("Шахматов", "Антон", this, "ShAnton", "1111", g1);
		User student2 = new Student("Романенко", "Егор", this, "REgor", "1111", g1);
		
		Group g2=new Group("Group 2");
		groupBaseController.addGroup(g2);
		User student3 = new Student("Сазонова", "Екатерина", this, "Kat", "1111", g2);
		User student4 = new Student("Филонова", "Анна", this, "Anna", "1111", g2);

		//add users to database
		userBaseController.addUser(student1);
		userBaseController.addUser(student2);
		userBaseController.addUser(student3);
		userBaseController.addUser(student4);

		//add test3 and result to students
		testController.setTest(test1);
		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addResult(student1, 4);
		testController.addResult(student2, 5);

		//add test3 and result to students
		testController.setTest(test2);
		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addStudent(student3);
		testController.addStudent(student4);
		testController.addResult(student1, 3);
		testController.addResult(student2, 4);
		testController.addResult(student3, 4);
		testController.addResult(student4, 5);
		
		//add test3 and result to students
		testController.setTest(test3);
		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addStudent(student3);
		testController.addStudent(student4);
		testController.addResult(student1, 3);
		testController.addResult(student2, 4);
		testController.addResult(student3, 5);
		testController.addResult(student4, 5);
	}
}
