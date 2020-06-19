package controllers;

import java.util.ArrayList;
import java.util.List;

import models.UserModel;

public class TestBaseController {
	private List<TestController> tests;

	public TestBaseController() {
	}

	public List<TestController> getTestsStudent(UserModel student) {
		List<TestController> testsStudent = new ArrayList<TestController>();
		for (int i = 0; i < tests.size(); i++) {
			if (tests.get(i).hasStudent(student) == true) {
				testsStudent.add(tests.get(i));
			}
		}
		return testsStudent;
	}

	public List<TestController> getAllTests() {
		return tests;
	}

	public void addTests(List<TestController> tests) {
		this.tests = tests;
	}

	public TestController getTestIndex(int index) {
		if (index < tests.size() && index >= 0) {
			return tests.get(index);
		}
		return null;
	}

	/*
	 * get tests result for teacher
	 */
	public List<TestController> teacherGetTests(UserModel teacher) {
		ArrayList<TestController> masTests = new ArrayList<TestController>();
		for (int i = 0; i < tests.size(); i++) {
			if (tests.get(i).hasTeacher(teacher)) {
				masTests.add(tests.get(i));
			}
		}
		return masTests;
	}

}
