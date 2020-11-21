/**
 * 
 */
package com.testsystem.controller.user;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.controller.test.TestController;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.Group;
import com.testsystem.model.user.Student;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

/**
 * Student Controller.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class StudentController extends UserController {

	/**
	 * Creates a StudentController.
	 */
	public StudentController() {}
	
	/**
	 * Creates a StudentController.
	 * 
	 * @param user 
	 */
	public StudentController(User user) {
		super(user);
	}

	/**
	 * Returns new student.
	 * 
	 * @param String the lastName
	 * @param String the firstName
	 * @param String the username
	 * @param String the password
	 * @param Group the group
	 * @return Student the student
	 */
	public Student getNewStudent(String lastName, String firstName, 
			 String username, String password, Group group) {
		return new Student(lastName, firstName, username, password, group);
	}

	/**
	 * Returns test
	 * 
	 * @return the all tests of student
	 */
	public List<Test> getTests() {
		List<Test> listTest = ServiceLocator.getDaoProvider()
				.getTestsRecords(new Test().getNameModel());
		List<Test> testsStudent = new ArrayList<Test>();
		for (int i = 0; i < listTest.size(); i++) {
			TestController testController = new TestController();
			if (testController.hasStudentThisTest(this.getUser(), listTest.get(i)) == true) {
				testsStudent.add(listTest.get(i));
			}
		}
		return testsStudent;
	}
	
	/**
	 * Returns test for student.
	 * 
	 * @param idTest   	the model of student
	 * @return 			the test
	 */
	public Test getTest(int idTest) {
		List<Test> listTest = ServiceLocator.getDaoProvider()
				.getTestsRecords(new Test().getNameModel());
		Test test = listTest.get(idTest);
		TestController testController = new TestController(test);
		if (test != null && testController.hasStudentThisTest(this.getUser(), test)) {
			test.clearChecked();
			return test;
		} else
			return null;
	}

	/**
	 * Returns number questions in the test.
	 * 
	 * @param idTest   	the test id.
	 * @return 			the number of tests.
	 */
	public int getNumberQuestionsInTest(int idTest) {
		List<Test> listTest = ServiceLocator.getDaoProvider()
				.getTestsRecords(new Test().getNameModel());
		if (idTest >= listTest.size() || idTest < 0) {
			return -1;
		}
		Test test = listTest.get(idTest);
		TestController testController = new TestController(test);
		if (test != null && testController.hasStudentThisTest(this.getUser(), test)) {
			Test t = listTest.get(idTest);
			return t.getQuestions().size();
		}
		return -1;
	}
	
	/**
	 * Returns group of student.
	 */
	public Group getGroup() {
		return ((Student)this.getUser()).getGroup();
	}
}
