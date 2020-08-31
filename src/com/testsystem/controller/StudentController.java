/**
 * 
 */
package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.Group;
import com.testsystem.model.Model;
import com.testsystem.model.Student;
import com.testsystem.model.Test;
import com.testsystem.model.User;
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
	 * Creates a UserController.
	 * 
	 * @param user 
	 * @param daoProvider
	 */
	public StudentController(User user) {
		super(user);
	}
	
	/**
	 * Gets new student.
	 */
	public static Student getNewStudent(String lastName, String firstName, 
			 String username, String password, Group group) {
		return new Student(lastName, firstName, username, password, group);
	}

	/**
	 * Gets test
	 * 
	 * @return 			the all tests of student
	 */
	public List<Model> getTests() {
		List<Model> listTest = ServiceLocator.getDaoProvider()
				.getRecords(Test.nameModel);
		List<Model> testsStudent = new ArrayList<Model>();
		for (int i = 0; i < listTest.size(); i++) {
			TestController testController = new TestController((Test)listTest.get(i));
			if (testController.hasStudent(this.getUser()) == true) {
				testsStudent.add(listTest.get(i));
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
	public Test getTestInfo(int idTest) {
		List<Model> listTest = ServiceLocator.getDaoProvider()
				.getRecords(Test.nameModel);
		Test test = (Test)listTest.get(idTest);
		TestController testController = new TestController(test);
		if (test != null && testController.hasStudent(this.getUser())) {
			return (Test)listTest.get(idTest);
		} else
			return null;
	}

	/**
	 * Gets student test number questions.
	 * 
	 * @param idTest   	the test id.
	 * @param testTable the table of test.
	 * @return 			the number of tests.
	 */
	public int getNumberQuestionsInTest(int idTest) {
		List<Model> listTest = ServiceLocator.getDaoProvider()
				.getRecords(Test.nameModel);
		if (idTest >= listTest.size() || idTest < 0) {
			return -1;
		}
		Test test = (Test)listTest.get(idTest);
		TestController testController = new TestController(test);
		if (test != null && testController.hasStudent(this.getUser())) {
			Test t = (Test)listTest.get(idTest);
			return t.getQuestions().size();
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
