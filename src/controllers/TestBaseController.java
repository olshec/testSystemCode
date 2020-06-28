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
	 * @return the tests student.
	 */
	public List<TestModel> getTestsStudent(UserModel student) {
		List<TestModel> testsStudent = new ArrayList<TestModel>();
		for (int i = 0; i <testBaseModel.getTests().size(); i++) {
			TestController testController=new TestController(testBaseModel.getTests().get(i));
			if (testController.hasStudent(student) == true) {
				testsStudent.add(testBaseModel.getTests().get(i));
			}
		}
		return testsStudent;
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
	public List<TestModel> getTests(UserModel teacher) {
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
	 * get number questions in test.
	 */
//	public int getNumberQuestionsInTest(int indexTest) {
//		TestController testController=new TestController(testBaseModel.getTests().get(indexTest));
//		return  testController.getNumberQuestions();
//	}

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


	/** Gets student test information.
	 * @param student The student's model.
	 * @param  indexTest The test index.
	 * @return The test's model.
	*/
	public TestModel getTestInfoForStudent(UserModel student, int indexTest) {
		TestModel test = testBaseModel.getTests().get(indexTest);
		TestController testController =new TestController(test);
		if (test != null && testController.hasStudent(student)) {
			return testBaseModel.getTests().get(indexTest);
		} else
			return null;
	}
	
	/** Gets student test number questions.
	 * @param student The student.
	 * @param indexTest The test index.
	 * @return The test.
	*/
	public int getNumberQuestionsInTest(UserModel student, int indexTest)  {
		if(indexTest>=testBaseModel.getTests().size() || indexTest<0) {
			return -1;
		}
		TestModel test = testBaseModel.getTests().get(indexTest);
		TestController testController =new TestController(test);
		if (test != null && testController.hasStudent(student)) {
			return testBaseModel.getTests().get(indexTest).getQuestions().size();
		} 
		return -1;
	}
	
	
	/** Gets students test result.
	 * @param teacher The teacher.
	 * @param indexTest The test index.
	 * @return Test The test.
	*/
	public TestModel getTestResultForTeacher(UserModel teacher, int indexTest) {
		
		if(indexTest<this.getTests(teacher).size()) {
			return this.getTests(teacher).get(indexTest);
		}
		return null;
	}
	
}
