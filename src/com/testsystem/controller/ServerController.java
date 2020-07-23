package com.testsystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.testsystem.DAO.DAOProvider;
import com.testsystem.models.Administrator;
import com.testsystem.models.Group;
import com.testsystem.models.Question;
import com.testsystem.models.Student;
import com.testsystem.models.Teacher;
import com.testsystem.models.Test;
import com.testsystem.models.User;

/**
 * Represents a server controller.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class ServerController {

	DAOProvider daoProvider;

	/**
	 * Creates a ServerController.
	 */
	public ServerController() {
		daoProvider = new DAOProvider();
		loadTest();
	}

	/**
	 * Gets DAOProvider.
	 * @return the daoProvider
	 */
	public DAOProvider getDaoProvider() {
		return daoProvider;
	}

	/**
	 * Sets DAOProvider.
	 * @param daoProvider the daoProvider to set
	 */
	public void setDaoProvider(DAOProvider daoProvider) {
		this.daoProvider = daoProvider;
	}


	/**
	 * Method for login.
	 * 
	 * @param username 	the user's username
	 * @param password 	the user's password
	 * @return User 	the authenticated user
	 */
	public User login(String username, String password) {
		return new UserController(daoProvider).getUser(username, password);
	}

	/**
	 * Gets tests for student.
	 * 
	 * @param student 		the student
	 * @return List<Test> 	the list tests
	 */
	public List<Test> getTestsForStudent(User student) {
		return new StudentController(student).getTests(daoProvider.getTestTable());
	}

	/**
	 * Gets student test information.
	 * 
	 * @param student   the model of student
	 * @param idTest the test index
	 * @return 			the model of test
	 */
	public Test getTestInfoForStudent(User student, int idTest) {
		return new StudentController(student).getTestInfo(idTest, daoProvider.getTestTable());
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
				daoProvider.getTestTable());
	}

	/**
	 * Gets tests for teacher.
	 * 
	 * @param teacher		the teacher
	 * @return List<Test> 	the list tests
	 */
	public List<Test> getTestsForTeacher(User teacher) {
		return new TeacherController(teacher).getTests(daoProvider.getTestTable());
	}

	/**
	 * Gets students test result.
	 * 
	 * @param teacher   the teacher
	 * @param indexTest the test id
	 * @return Test 	the test
	 */
	public Test getTestResultForTeacher(User teacher, int idTest) {
		return new TeacherController(teacher).getTestResult(idTest, daoProvider.getTestTable());
	}

	/**
	 * Gets all users.
	 * 
	 * @param 				the administrator
	 * @return List<User> 	the list all administrators
	 */
	public List<User> getAllUsersForAdmin(User admin) {
		return new UserController(admin, daoProvider).getAllUsers();
	}

	/**
	 * Gets students.
	 * 
	 * @param 				the administrator
	 * @return List<User> 	the list students
	 */
	public List<User> getStudentsForAdmin(User admin) {
		return new AdministratorController(admin, daoProvider).getUsersByType(Student.nameModel);
	}

	/**
	 * Gets teachers.
	 * 
	 * @param 				the administrator
	 * @return List<User> 	the list of teachers
	 */
	public List<User> getTeachersForAdmin(User admin) {
		return new AdministratorController(admin, daoProvider).getUsersByType(Teacher.nameModel);
	}

	/**
	 * Gets administrators.
	 * 
	 * @param 				the administrator
	 * @return List<User> 	the list of administrators
	 */
	public List<User> getAdminsForAdmin(User admin) {
		return new AdministratorController(admin, daoProvider).getUsersByType(Administrator.nameModel);
	}
	
	public int getRatingUser(User student) {
		return RatingCalculator.getRatingStudent(student, daoProvider.getTestTable());
	}
	
	public HashMap<User, Integer> getRatingGroup(String nameGroup){
		Group group = GroupController.getGroupByName(nameGroup, daoProvider.getGroupTable());
		return RatingCalculator.getRatingGroup(group, daoProvider);
	}

	private void loadTest() {
		UserController userController = new UserController(daoProvider);
		User admin1 = AdministratorController.getNewAdministrator("Примарев", 
				"Игорь", this, "Admin1", "0000");
		userController.addUser(admin1);

		User teacher1 = TeacherController.getNewTeacher("Киров", 
				"Антон", this, "KirovAnton", "12345678");
		userController.addUser(teacher1);

		Test test1 = TestController.getNewTest("Робототехника", teacher1);
		Test test2 = TestController.getNewTest("Сетевые технологии", teacher1);
		Test test3 = TestController.getNewTest("Информатика", teacher1);

		Question q1 = QuestionController.getNewQuestion("Основы роботетхники");
		Question q2 = QuestionController.getNewQuestion("AI");
		Question q3 = QuestionController.getNewQuestion("Микроконтроллеры");

		TestController testController = new TestController(test1);
		testController.addQuestion(q1);
		testController.addQuestion(q2);
		testController.addQuestion(q3);

		Question q4 = QuestionController.getNewQuestion("Протокол HTTP");
		Question q5 = QuestionController.getNewQuestion("Характеристика OSI");
		Question q6 = QuestionController.getNewQuestion("Протокол TCP");

		testController.setTest(test2);

		testController.addQuestion(q3);
		testController.addQuestion(q4);
		testController.addQuestion(q5);
		testController.addQuestion(q6);

		List<Test> tests = new ArrayList<Test>();

		tests.add(test1);
		tests.add(test2);
		tests.add(test3);

		new TestController(getDaoProvider()).addTests(tests);

		Group g1 = GroupController.getNewGroup("Group 1");
		GroupController.addGroup(g1,daoProvider.getGroupTable());
		User student1 = StudentController.getNewStudent("Шахматов", "Антон", this, "ShAnton", "1111", g1);
		User student2 = StudentController.getNewStudent("Романенко", "Егор", this, "REgor", "1111", g1);
		
		Group g2 = GroupController.getNewGroup("Group 2");
		GroupController.addGroup(g2,daoProvider.getGroupTable());
		User student3 = StudentController.getNewStudent("Сазонова", "Екатерина", this, "Kat", "1111", g2);
		User student4 = StudentController.getNewStudent("Филонова", "Анна", this, "Anna", "1111", g2);

		//add users to database
		userController.addUser(student1);
		userController.addUser(student2);
		userController.addUser(student3);
		userController.addUser(student4);

		//add test1 and result to students
		testController.setTest(test1);
		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addResult(student1, 4);
		testController.addResult(student2, 5);

		//add test2 and result to students
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
		testController.addResult(student4, 3);
	}
}
