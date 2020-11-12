package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;
import com.testsystem.DAO.DAOProvider;
import com.testsystem.controller.test.QuestionController;
import com.testsystem.controller.test.RatingCalculator;
import com.testsystem.controller.test.TestController;
import com.testsystem.controller.user.AdministratorController;
import com.testsystem.controller.user.GroupController;
import com.testsystem.controller.user.StudentController;
import com.testsystem.controller.user.TeacherController;
import com.testsystem.controller.user.UserController;
import com.testsystem.model.test.Answer;
import com.testsystem.model.test.Question;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.Administrator;
import com.testsystem.model.user.Group;
import com.testsystem.model.user.Student;
import com.testsystem.model.user.Teacher;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

/**
 * Represents a server controller.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class FrontController {

	DAOProvider daoProvider;

	/**
	 * Creates a ServerController.
	 */
	public FrontController() {
		daoProvider = new DAOProvider();
		ServiceLocator.setDaoProvider(daoProvider);
		daoProvider.addTable(new Group().getNameModel());
		daoProvider.addTable(new Test().getNameModel());
		daoProvider.addTable(new Teacher().getNameModel());
		daoProvider.addTable(new Student().getNameModel());
		daoProvider.addTable(new Administrator().getNameModel());
		daoProvider.addTable(new ResultTest().getNameModel());
		loadTest();
	}

	/**
	 * Gets DAOProvider.
	 * 
	 * @return the daoProvider
	 */
	public DAOProvider getDaoProvider() {
		return daoProvider;
	}

	/**
	 * Sets DAOProvider.
	 * 
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
		return new UserController().getUser(username, password);
	}

	/**
	 * Gets tests for student.
	 * 
	 * @param student 		the student
	 * @return List<Test> 	the list tests
	 */
	public List<Test> getTestsForStudent(User student) {
		return new StudentController(student).getTests();
	}

	/**
	 * Gets student test information.
	 * 
	 * @param student   the student
	 * @param idTest 	the test index
	 * @return 			the model of test
	 */
	public Test getTestInfoForStudent(User student, int idTest) {
		return new StudentController(student).getTestInfo(idTest);
	}
	
	/**
	 * Gets test for student.
	 * 
	 * @param student   the student
	 * @param idTest 	the test index
	 * @return 			the model of test
	 */
	public Test getTestForStudent(User student, int idTest) {
		return new StudentController(student).getTest(idTest);
	}

	/**
	 * Gets result of test for student.
	 * 
	 * @param student   the student
	 * @param idTest 	the test index
	 * @return 			the model of test
	 */
	public ResultTest getResultTestForStudent(User student, int idTest) {
		return new StudentController(student).getResultTest(idTest);
	}
	
	/**
	 * This method checks student test.
	 *
	 *@param test the test
	 */
	public ResultTest checkTest(User student, Test test) {
		ResultTest result = new TestController().checkTest(student, test);
		return result;
	}
	
	/**
	 * Gets student test number questions.
	 * 
	 * @param student   the student
	 * @param idTest 	the test index
	 * @return 			the test
	 */
	public int getNumberQuestionsInTest(User student, int idTest) {
		return new StudentController(student).getNumberQuestionsInTest(idTest);
	}

	/**
	 * Gets tests for teacher.
	 * 
	 * @param  teacher		the teacher
	 * @return List<Test> 	the list tests
	 */
	public List<Test> getTestsForTeacher(User teacher) {
		return new TeacherController(teacher).getTests();
	}

	/**
	 * Gets students test result.
	 * 
	 * @param  teacher   the teacher
	 * @param  indexTest the test id
	 * @return Test 	 the test
	 */
	public List<ResultTest> getTestResultForTeacher(User teacher, int idTest) {
		return new TeacherController(teacher).getTestResult(idTest);
	}

	/**
	 * Gets all users.
	 * 
	 * @param admin			the administrator
	 * @return List<User> 	the list all administrators
	 */
	public List<User> getAllUsersForAdmin(User admin) {
		return new AdministratorController(admin).getAllUsers();
	}

	/**
	 * Gets students.
	 * 
	 * @param admin			the administrator
	 * @return List<User> 	the list students
	 */
	public List<User> getStudentsForAdmin(User admin) {
		return new AdministratorController(admin).getUsers(new Student().getNameModel());
	}

	/**
	 * Gets teachers.
	 * 
	 * @param  admin 		the administrator
	 * @return List<User> 	the list of teachers
	 */
	public List<User> getTeachersForAdmin(User admin) {
		return new AdministratorController(admin).getUsers(new Teacher().getNameModel());
	}

	/**
	 * Gets administrators.
	 * 
	 * @param  admin		the administrator
	 * @return List<User> 	the list of administrators
	 */
	public List<User> getAdminsForAdmin(User admin) {
		return new AdministratorController(admin).getUsers(new Administrator().getNameModel());
	}
	
	/**
	 * Gets rating for student.
	 * 
	 * @param  student the student
	 * @return int 	   the rating
	 */
	public int getRatingUser(User student) {
		List<Test> listTest = ServiceLocator.getDaoProvider()
				.getTestsRecords(new Test().getNameModel());
		return RatingCalculator.getRatingStudent(student, listTest);
	}
	
	
	/**
	 * Gets rating for group.
	 * 
	 * @param  nameGroup 				the name of group 		
	 * @return List<StudentTestResult>	the students results 
	 */
	public List<ResultTest> getRatingGroup(String nameGroup){
		List<ResultTest> ratingGroup = new GroupController().getRatingGroup(nameGroup);
		return ratingGroup;
	}

	private void loadTest() {
		UserController userController = new UserController();
		User admin1 = new AdministratorController().getNewAdministrator("Примарев", 
				"Игорь", "Admin1", "0000");
		userController.saveUserInDatabase(admin1);

		User teacher1 = new TeacherController().getNewTeacher("Киров", 
				"Антон", "KirovAnton", "12345678");
		userController.saveUserInDatabase(teacher1);

		Test test1 = new TestController().getNewTest("Космология", teacher1);
		Test test2 = new TestController().getNewTest("Сетевые технологии", teacher1);
		Test test3 = new TestController().getNewTest("Информатика", teacher1);

		Question q1 = new QuestionController().getNewQuestion("Какие планеты солнечной системы вращаются в направлении, противоположном Земле?");
		List<Answer> answersForQuestion1 = new ArrayList<Answer>();
		answersForQuestion1.add(new Answer("Венера", "", true));
		answersForQuestion1.add(new Answer("Уран", "", true));
		answersForQuestion1.add(new Answer("Плутон", "", false));
		answersForQuestion1.add(new Answer("Юпитер", "", false));
		q1.setAnswers(answersForQuestion1);
		
		Question q2 = new QuestionController().getNewQuestion("Какой ученый является изобретателем космической ракеты?");
		List<Answer> answersForQuestion2 = new ArrayList<Answer>();
		answersForQuestion2.add(new Answer("Нил Армстронг", "", false));
		answersForQuestion2.add(new Answer("Циолковский", "", true));
		answersForQuestion2.add(new Answer("Сергей Павлович Королев", "", false));
		answersForQuestion2.add(new Answer("Вернер фон Браун", "", false));
		q2.setAnswers(answersForQuestion2);
		
		Question q3 = new QuestionController().getNewQuestion("Как звали человека, который первым высадился на Луну?");
		List<Answer> answersForQuestion3 = new ArrayList<Answer>();
		answersForQuestion3.add(new Answer("Даниил Армстронг", "", false));
		answersForQuestion3.add(new Answer("Джек Армстронг", "", false));
		answersForQuestion3.add(new Answer("Арнольд Армстронг", "", false));
		answersForQuestion3.add(new Answer("Нил Армстронг", "", true));
		q3.setAnswers(answersForQuestion3);
		
		Question q3_2 = new QuestionController().getNewQuestion("Как называется ближайшая к Солнцу планета?");
		List<Answer> answersForQuestion3_2  = new ArrayList<Answer>();
		answersForQuestion3_2 .add(new Answer("Марс", "", false));
		answersForQuestion3_2 .add(new Answer("Плутон", "", false));
		answersForQuestion3_2 .add(new Answer("Меркурий", "", true));
		answersForQuestion3_2 .add(new Answer("Юпитер", "", false));
		q3_2.setAnswers(answersForQuestion3_2 );
		
		TestController testController = new TestController(test1);
		
		testController.addQuestion(q1);
		testController.addQuestion(q2);
		testController.addQuestion(q3);
		testController.addQuestion(q3_2);

		Question q4 = new QuestionController().getNewQuestion("Протокол HTTP");
		Question q5 = new QuestionController().getNewQuestion("Характеристика OSI");
		Question q6 = new QuestionController().getNewQuestion("Протокол TCP");

		testController.setTest(test2);
		//testController.addQuestion(q3);
		testController.addQuestion(q4);
		testController.addQuestion(q5);
		testController.addQuestion(q6);
		
		TestController.saveTest(test1);
		TestController.saveTest(test2);
		TestController.saveTest(test3);

		Group g1 = new GroupController().getNewGroup("Group 1");
		new GroupController().saveGroupInDatabase(g1);
		User student1 	= 	new StudentController().getNewStudent("Шахматов", "Антон", "ShAnton", "1111", g1);
		User student2 	= 	new StudentController().getNewStudent("Романенко", "Егор", "REgor", "1111", g1);
		User student01 	= 	new StudentController().getNewStudent("Федоренко", "Игнат", "FeIgnat", "1111", g1);
		
		Group g2 = new GroupController().getNewGroup("Group 2");
		new GroupController().saveGroupInDatabase(g2);
		User student3 = new StudentController().getNewStudent("Сазонова", "Екатерина", "Kat", "1111", g2);
		User student4 = new StudentController().getNewStudent("Фролова", "Анна", "Anna", "1111", g2);

		//add users to database
		userController.saveUserInDatabase(student1);
		userController.saveUserInDatabase(student2);
		userController.saveUserInDatabase(student3);
		userController.saveUserInDatabase(student4);
		userController.saveUserInDatabase(student01);

		//add test1 and result to students
		testController.setTest(test1);
		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addStudent(student01);
		testController.saveResultInDatabase(student1, test1, 4);
		testController.saveResultInDatabase(student2, test1, 5);
		testController.saveResultInDatabase(student01, test1, 3);

		//add test2 and result to students
		testController.setTest(test2);
		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addStudent(student3);
		testController.addStudent(student4);
		testController.saveResultInDatabase(student1, test2, 3);
		testController.saveResultInDatabase(student2, test2, 4);
		testController.saveResultInDatabase(student3, test2, 4);
		testController.saveResultInDatabase(student4, test2, 5);
		testController.saveResultInDatabase(student01, test2, 3);
		
		//add test3 and result to students
		testController.setTest(test3);
		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addStudent(student3);
		testController.addStudent(student4);
		testController.saveResultInDatabase(student1, test3, 3);
		testController.saveResultInDatabase(student2, test3, 4);
		testController.saveResultInDatabase(student3, test3, 5);
		testController.saveResultInDatabase(student4, test3, 3);
		testController.saveResultInDatabase(student01, test3, 2);
		
	}
}
