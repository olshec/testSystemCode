package com.testsystem.controller;

import java.util.List;
import com.testsystem.DAO.DAOProvider;
import com.testsystem.controller.test.RatingCalculator;
import com.testsystem.controller.test.TestController;
import com.testsystem.controller.user.AdministratorController;
import com.testsystem.controller.user.GroupController;
import com.testsystem.controller.user.StudentController;
import com.testsystem.controller.user.TeacherController;
import com.testsystem.controller.user.UserController;
import com.testsystem.model.test.RatingStudent;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.Administrator;
import com.testsystem.model.user.Group;
import com.testsystem.model.user.Student;
import com.testsystem.model.user.Teacher;
import com.testsystem.model.user.User;
import com.testsystem.util.LoaderDataToApplication;
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
		daoProvider.addTable(new RatingStudent().getNameModel());
		
		LoaderDataToApplication loader = new LoaderDataToApplication();
		loader.loadData(this);
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
		return new StudentController().getNumberQuestionsInTest(idTest);
	}
	
	/**
	 * Gets rating of student.
	 * 
	 * @param user   the student
	 * @return 		 RatingStudent
	 */
	public List<RatingStudent> getRatingForStudent(User student) {
		return new RatingStudent().getRatingTest(student);
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
	
//	/**
//	 * Gets students.
//	 * 
//	 * @param student		the student
//	 * @return List<User> 	the list students
//	 */
//	public List<Student> getStudentsForTeacher(Teacher teacher) {
//		return new TeacherController().getStudents(teacher);
//	}

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
	 * @param  student 			the student
	 * @return RatingStudent 	the rating
	 */
	public RatingStudent getRatingUser(User student) {
		return new RatingCalculator().getRatingStudent(student);
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



}
