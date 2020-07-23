/**
 * 
 */
package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.DAO.Tables.TestTable;
import com.testsystem.models.Group;
import com.testsystem.models.Student;
import com.testsystem.models.Test;
import com.testsystem.models.User;

/**
 * Student Controller.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class StudentController extends UserController {

	/**
	 * Creates a UserController.
	 * 
	 * @param user
	 */
	public StudentController(User user) {
		super(user);
	}
	
	/**
	 * Gets new student.
	 */
	public static Student getNewStudent(String lastName, String firstName, 
			ServerController server, String username, String password, Group group) {
		return new Student(lastName, firstName, server, username, password, group);
	}

	/**
	 * Gets test
	 * 
	 * @param testTable 	the database of test
	 * @return 			the all tests of student
	 */
	public List<Test> getTests(TestTable testTable) {
		List<Test> testsStudent = new ArrayList<Test>();
		for (int i = 0; i < testTable.getTests().size(); i++) {
			TestController testController = new TestController(testTable.getTests().get(i));
			if (testController.hasStudent(this.getUser()) == true) {
				testsStudent.add(testTable.getTests().get(i));
			}
		}
		return testsStudent;
	}

	/**
	 * Gets student test information.
	 * 
	 * @param idTest   	the model of student
	 * @param testTable 	the database of student
	 * @return 			the model of test
	 */
	public Test getTestInfo(int idTest, TestTable testTable) {
		Test test = testTable.getTests().get(idTest);
		TestController testController = new TestController(test);
		if (test != null && testController.hasStudent(this.getUser())) {
			return testTable.getTests().get(idTest);
		} else
			return null;
	}

	/**
	 * Gets student test number questions.
	 * 
	 * @param idTest   	the test id.
	 * @param testBase 	the tests' database.
	 * @return 			the number of tests.
	 */
	public int getNumberQuestionsInTest(int idTest, TestTable testBase) {
		if (idTest >= testBase.getTests().size() || idTest < 0) {
			return -1;
		}
		Test test = testBase.getTests().get(idTest);
		TestController testController = new TestController(test);
		if (test != null && testController.hasStudent(this.getUser())) {
			return testBase.getTests().get(idTest).getQuestions().size();
		}
		return -1;
	}
	
	/**
	 * Gets group of student.
	 */
	public Group getGroup() {
		return ((Student)getUser()).getGroup();
	}
}
