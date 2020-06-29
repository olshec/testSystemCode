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
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TeacherController extends UserController {

	/**Creates a TeacherController.
	 * @param userModel
	 */
	public TeacherController(UserModel userModel) {
		super(userModel);
	}
	
	/**
	 * @return the tests.
	 */
	public List<TestModel> getTests(TestBaseModel testBaseModel) {
		ArrayList<TestModel> masTests = new ArrayList<TestModel>();
		for (int i = 0; i < testBaseModel.getTests().size(); i++) {
			TestController testController=new TestController(testBaseModel.getTests().get(i));
			if (testController.hasTeacher(this.getUserModel())) {
				masTests.add(testController.getTestModel());
			}
		}
		return masTests;
	}
	
	/** Gets students test result.
	 * @param teacher The teacher.
	 * @param indexTest The test index.
	 * @return Test The test.
	*/
	public TestModel getTestResultForTeacher( int indexTest, TestBaseModel testBaseModel) {
		
		if(indexTest<this.getTests(testBaseModel).size()) {
			return this.getTests(testBaseModel).get(indexTest);
		}
		return null;
	}
	
	

}
