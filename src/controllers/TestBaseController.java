package controllers;

import java.util.ArrayList;
import java.util.List;

import models.TestBase;
import models.Test;
import models.User;

/**
 * Represents a controller to the database containing tests.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TestBaseController {
	private TestBase testBaseModel;
	
	
	/** Creates a TestBaseController.
	 */
	public TestBaseController() {
		setTestBaseModel(new TestBase());
		}

	/** Creates a TestBaseController.
	 *  @param testBaseModel the database containing tests.
	 */
	public TestBaseController(TestBase testBaseModel) {
		setTestBaseModel(testBaseModel);
		}

	/**
	 * @return the all tests.
	 */
	public List<Test> getAllTests() {
		return testBaseModel.getTests();
	}

	/**
	 * @param tests the tests to add.
	 */
	public void addTests(List<Test> tests) {
		this.testBaseModel.setTests(tests);
	}
	
	/**
	 * @return the TestModel.
	 */
	public Test getTest(int index) {
		if (index < testBaseModel.getTests().size() && index >= 0) {
			return testBaseModel.getTests().get(index);
		}
		return null;
	}


	

	/**
	 * @return the testBaseModel
	 */
	public TestBase getTestBaseModel() {
		return testBaseModel;
	}

	/**
	 * @param testBaseModel the testBaseModel to set
	 */
	public void setTestBaseModel(TestBase testBaseModel) {
		this.testBaseModel = testBaseModel;
	}



	
	

	
}
