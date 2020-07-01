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
 * TeacherController
 * 
 * @author Oleg Shestakov
 * 
 * @author olshec@gmail.com
 * 
 * @version 1.0
 */

public class TeacherController extends UserController {

	/**
	 * Creates a TeacherController.
	 * @param userModel
	 */
	public TeacherController(User userModel) {
		super(userModel);
	}
	
	/**
	 * @return the tests.
	 */
	public List<Test> getTests(TestBase testBaseModel) {
		ArrayList<Test> masTests = new ArrayList<Test>();
		for (int i = 0; i < testBaseModel.getTests().size(); i++) {
			TestController testController=new TestController(testBaseModel.getTests().get(i));
			if (testController.hasTeacher(this.getUserModel())) {
				masTests.add(testController.getTestModel());
			}
		}
		return masTests;
	}
	
	/** 
	 * Gets students test result.
	 * @param teacher The teacher.
	 * @param indexTest The test index.
	 * @return Test The test.
	*/
	public Test getTestResultForTeacher( int indexTest, TestBase testBaseModel) {
		
		if(indexTest>=0 && indexTest<this.getTests(testBaseModel).size() ) {
			return this.getTests(testBaseModel).get(indexTest);
		}
		return null;
	}

}
