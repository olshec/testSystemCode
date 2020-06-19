package controllers;

import java.util.ArrayList;
import java.util.List;

import models.TestModel;
import models.UserModel;

public class TestBaseController {
	private List<TestModel> tests;
	
	public TestBaseController() {;}

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

	public List<TestModel> getAllTests() {
		return tests;
	}

	public void addTests(List<TestModel> tests) {
		this.tests = tests;
	}

	public TestModel getTestIndex(int index) {
		if (index < tests.size() && index >= 0) {
			return tests.get(index);
		}
		return null;
	}

	/**
	 * get tests
	 */
	public List<TestController> getTests(UserModel teacher) {
		ArrayList<TestController> masTests = new ArrayList<TestController>();
		for (int i = 0; i < tests.size(); i++) {
			TestController testController=new TestController(tests.get(i));
			if (testController.hasTeacher(teacher)) {
				masTests.add(testController);
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
