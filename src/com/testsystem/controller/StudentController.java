/**
 * 
 */
package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;
import com.testsystem.models.Test;
import com.testsystem.models.TestBase;
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
	 * @param userModel
	 */
	public StudentController(User userModel) {
		super(userModel);
	}
	
	/**
	 * Gets test
	 * 
	 * @param testBase The tests' database.
	 * @return The all tests of student.
	 */
	public List<Test> getTests(TestBase testBase) {
		List<Test> testsStudent = new ArrayList<Test>();
		for (int i = 0; i <testBase.getTests().size(); i++) {
			TestController testController=new TestController(testBase.getTests().get(i));
			if (testController.hasStudent(this.getUserModel()) == true) {
				testsStudent.add(testBase.getTests().get(i));
			}
		}
		return testsStudent;
	}
	
	/** 
	 * Gets student test information.
	 * 
	 * @param idTest The student's model.
	 * @param  testBase The tests' database.
	 * @return The test's model.
	*/
	public Test getTestInfo(int idTest, TestBase testBase) {
		Test test = testBase.getTests().get(idTest);
		TestController testController =new TestController(test);
		if (test != null && testController.hasStudent(this.getUserModel())) {
			return testBase.getTests().get(idTest);
		} else
			return null;
	}
	
	/** 
	 * Gets student test number questions.
	 * 
	 * @param idTest The test id.
	 * @param testBase The tests' database.
	 * @return The number of tests.
	*/
	public int getNumberQuestionsInTest(int idTest, TestBase testBase)  {
		if(idTest>=testBase.getTests().size() || idTest<0) {
			return -1;
		}
		Test test = testBase.getTests().get(idTest);
		TestController testController =new TestController(test);
		if (test != null && testController.hasStudent(this.getUserModel())) {
			return testBase.getTests().get(idTest).getQuestions().size();
		} 
		return -1;
	}

}
