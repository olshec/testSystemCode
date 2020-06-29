/**
 * 
 */
package controllers;

import java.util.ArrayList;
import java.util.List;

import models.TestBaseModel;
import models.TestModel;
import models.UserModel;

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
	public StudentController(UserModel userModel) {
		super(userModel);
	}
	
	/**
	 * @return the all tests student.
	 */
	public List<TestModel> getTests(TestBaseModel testBaseModel) {
		List<TestModel> testsStudent = new ArrayList<TestModel>();
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
	public TestModel getTestInfo(int indexTest, TestBaseModel testBaseModel) {
		TestModel test = testBaseModel.getTests().get(indexTest);
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
	public int getNumberQuestionsInTest(int indexTest, TestBaseModel testBaseModel)  {
		if(indexTest>=testBaseModel.getTests().size() || indexTest<0) {
			return -1;
		}
		TestModel test = testBaseModel.getTests().get(indexTest);
		TestController testController =new TestController(test);
		if (test != null && testController.hasStudent(this.getUserModel())) {
			return testBaseModel.getTests().get(indexTest).getQuestions().size();
		} 
		return -1;
	}

}
