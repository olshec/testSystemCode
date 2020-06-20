package controllers;

import java.util.ArrayList;
import java.util.List;

import models.TestModel;
import models.UserModel;

public class TestBaseController {
	private List<TestModel> tests;
	
	public TestBaseController() {;}

	/**
	 * @return the tests student
	 */
	public List<TestModel> getTestsStudent(UserModel student) {
		List<TestModel> testsStudent = new ArrayList<TestModel>();
		for (int i = 0; i < tests.size(); i++) {
			TestController testController=new TestController(tests.get(i));
			if (testController.hasStudent(student) == true) {
				testsStudent.add(tests.get(i));
			}
		}
		return testsStudent;
	}

	/**
	 * @return the all tests 
	 */
	public List<TestModel> getAllTests() {
		return tests;
	}

	/**
	 * @param tests the tests to add
	 */
	public void addTests(List<TestModel> tests) {
		this.tests = tests;
	}
	
	/**
	 * @return the TestModel
	 */
	public TestModel getTest(int index) {
		if (index < tests.size() && index >= 0) {
			return tests.get(index);
		}
		return null;
	}

	/**
	 * @return the tests
	 */
	public List<TestModel> getTests(UserModel teacher) {
		ArrayList<TestModel> masTests = new ArrayList<TestModel>();
		for (int i = 0; i < tests.size(); i++) {
			TestController testController=new TestController(tests.get(i));
			if (testController.hasTeacher(teacher)) {
				masTests.add(testController.getTestModel());
			}
		}
		return masTests;
	}
	
	/**
	 * get number questions in test
	 */
	public int getNumberQuestionsInTest(int indexTest) {
		TestController testController=new TestController(tests.get(indexTest));
		return  testController.getNumberQuestions();
	}

}
