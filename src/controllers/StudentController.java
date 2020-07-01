/**
 * 
 */
package controllers;

import java.util.ArrayList;
import java.util.List;

import models.TestBase;
import models.Test;
import models.User;

/** 
 * Student Controller.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class StudentController extends UserController {

	/**Creates a UserController.
	 * @param userModel
	 */
	public StudentController(User userModel) {
		super(userModel);
	}
	
	/**
	 * @return the all tests student.
	 */
	public List<Test> getTests(TestBase testBaseModel) {
		List<Test> testsStudent = new ArrayList<Test>();
		for (int i = 0; i <testBaseModel.getTests().size(); i++) {
			TestController testController=new TestController(testBaseModel.getTests().get(i));
			if (testController.hasStudent(this.getUserModel()) == true) {
				testsStudent.add(testBaseModel.getTests().get(i));
			}
		}
		return testsStudent;
	}
	
	/** Gets student test information.
	 * @param student The student's model.
	 * @param  indexTest The test index.
	 * @return The test's model.
	*/
	public Test getTestInfo(int indexTest, TestBase testBaseModel) {
		Test test = testBaseModel.getTests().get(indexTest);
		TestController testController =new TestController(test);
		if (test != null && testController.hasStudent(this.getUserModel())) {
			return testBaseModel.getTests().get(indexTest);
		} else
			return null;
	}
	
	/** Gets student test number questions.
	 * @param student The student.
	 * @param indexTest The test index.
	 * @return The number of tests.
	*/
	public int getNumberQuestionsInTest(int indexTest, TestBase testBaseModel)  {
		if(indexTest>=testBaseModel.getTests().size() || indexTest<0) {
			return -1;
		}
		Test test = testBaseModel.getTests().get(indexTest);
		TestController testController =new TestController(test);
		if (test != null && testController.hasStudent(this.getUserModel())) {
			return testBaseModel.getTests().get(indexTest).getQuestions().size();
		} 
		return -1;
	}

}
