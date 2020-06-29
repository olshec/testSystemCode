package controllers;

import java.util.ArrayList;
import java.util.List;

import models.TestBaseModel;
import models.TestModel;
import models.UserModel;

/**
 * Represents a controller to the database containing tests.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TestBaseController {
	private TestBaseModel testBaseModel;
	
	
	/** Creates a TestBaseController.
	 */
	public TestBaseController() {
		setTestBaseModel(new TestBaseModel());
		}

	/** Creates a TestBaseController.
	 *  @param testBaseModel the database containing tests.
	 */
	public TestBaseController(TestBaseModel testBaseModel) {
		setTestBaseModel(testBaseModel);
		}
	


	/**
	 * @return the all tests.
	 */
	public List<TestModel> getAllTests() {
		return testBaseModel.getTests();
	}

	/**
	 * @param tests the tests to add.
	 */
	public void addTests(List<TestModel> tests) {
		this.testBaseModel.setTests(tests);
	}
	
	/**
	 * @return the TestModel.
	 */
	public TestModel getTest(int index) {
		if (index < testBaseModel.getTests().size() && index >= 0) {
			return testBaseModel.getTests().get(index);
		}
		return null;
	}

	/**
	 * @return the tests.
	 */
	public List<TestModel> getTestsForTeacher(UserModel teacher) {
		ArrayList<TestModel> masTests = new ArrayList<TestModel>();
		for (int i = 0; i < testBaseModel.getTests().size(); i++) {
			TestController testController=new TestController(testBaseModel.getTests().get(i));
			if (testController.hasTeacher(teacher)) {
				masTests.add(testController.getTestModel());
			}
		}
		return masTests;
	}
	

	/**
	 * @return the testBaseModel
	 */
	public TestBaseModel getTestBaseModel() {
		return testBaseModel;
	}

	/**
	 * @param testBaseModel the testBaseModel to set
	 */
	public void setTestBaseModel(TestBaseModel testBaseModel) {
		this.testBaseModel = testBaseModel;
	}



	
	
	/** Gets students test result.
	 * @param teacher The teacher.
	 * @param indexTest The test index.
	 * @return Test The test.
	*/
	public TestModel getTestResultForTeacher(UserModel teacher, int indexTest) {
		
		if(indexTest<this.getTestsForTeacher(teacher).size()) {
			return this.getTestsForTeacher(teacher).get(indexTest);
		}
		return null;
	}
	
}
