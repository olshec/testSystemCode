package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.models.Model;
import com.testsystem.models.Question;
import com.testsystem.models.StudentTestResult;
import com.testsystem.models.Test;
import com.testsystem.models.User;
import com.testsystem.util.ServiceLocator;

/**
 * Represents a test controller.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TestController {

	private Test test;

	/**
	 * Creates a TestController.
	 * 
	 * @param the test
	 */
	public TestController(Test test) {
		setTest(test);
	}

	public TestController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets model of test.
	 * 
	 * @return the test
	 */
	public Test getTest() {
		return test;
	}

	/**
	 * Sets the model of test.
	 * 
	 * @param test the test
	 */
	public void setTest(Test test) {
		this.test = test;
	}

	/**
	 * Gets new Test.
	 */
	public static Test getNewTest() {
		return new Test();
	}

	/**
	 * Gets all tests.
	 * 
	 * @return the all tests
	 */
	public List<Model> getAllTests() {
		List<Model> listTest = ServiceLocator.getDaoProvider().getRecordsTable(Test.nameModel);
		return listTest;
	}

	/**
	 * Adds list of test.
	 * 
	 * @param tests the tests to add
	 */
	public void setTests(List<Model> tests) {
		ServiceLocator.getDaoProvider().setTable(Test.nameModel, tests);
	}
	

	/**
	 * Gets test.
	 * 
	 * @param the test id.
	 * @return the TestModel.
	 */
	public Test getTest(int idTest) {
		List<Model> listTest = ServiceLocator.getDaoProvider().getRecordsTable(Test.nameModel);
		if (idTest < listTest.size() && idTest >= 0) {
			return (Test)listTest.get(idTest);
		}
		return null;
	}

	/**
	 * Gets new Test.
	 */
	public static Test getNewTest(String name, User teacher) {
		return new Test(name, teacher);
	}

	/**
	 * Gets name
	 * 
	 * @return the name of test
	 */
	public String getName() {
		return test.getName();
	}

	/**
	 * Sets name of test.
	 * 
	 * @param name the name to set.
	 */
	public void setName(String name) {
		this.test.setName(name);
	}

	/**
	 * Adds result of test.
	 * 
	 * @param student the student for grading
	 * @param points  the student point
	 */
	public void addResult(User student, int points) {
		test.getStudentResult().add(new StudentTestResult(student, points));
	}

	/**
	 * Gets result: does the student have a test.
	 * 
	 * @param the student.
	 * @return the true if test student has this test. Otherwise returns false.
	 */
	public boolean hasStudent(User student) {
		for (StudentTestResult st : test.getStudentResult()) {
			if (st.getStudent().equals(student)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets tests for student.
	 * 
	 * @param 	the student.
	 * @return 	the true if test student has this test. Otherwise returns false.
	 */
	public List<Model> getStudentTests(User student) {
		List<Model> listTest = ServiceLocator.getDaoProvider()
				.getRecordsTable(Test.nameModel);
		List<Model> listTestReturn = new ArrayList<Model>();
		for (Model test : listTest) {
			Test t = (Test)test;
			for(int i=0; i < t.getStudentResult().size(); i++) {
				if(t.getStudentResult().get(i).getStudent().equals(student)) {
					listTestReturn.add(t);
				}
			}
		}
		return listTestReturn;
	}

	/**
	 * Gets number of question.
	 * 
	 * @return the number of questions
	 */
	public int getNumberQuestions() {
		return test.getQuestions().size();
	}

	/**
	 * Adds new student.
	 * 
	 * @param user the user for add to test
	 */
	public void addStudent(User user) {
		test.getStudentResult().add(new StudentTestResult(user, -1));
	}

	/**
	 * Gets result: does the teacher have a test.
	 * 
	 * @param the model of teacher
	 * @return the true if test teacher has this test. Otherwise returns false
	 */
	public boolean hasTeacher(User teacher) {
		if (test.getTeacher().getId() == teacher.getId()) {
			return true;
		}
		return false;
	}

	/**
	 * Gets students.
	 * 
	 * @return students the list of students
	 */
	public List<User> getStudents() {
		List<User> listStudent = new ArrayList<User>();
		List<StudentTestResult> listStudentTestResult = test.getStudentResult();
		for (StudentTestResult studentTestResult : listStudentTestResult) {
			listStudent.add(studentTestResult.getStudent());
		}
		return listStudent;
	}

	/**
	 * Adds new question.
	 * 
	 * @param question the question to add
	 */
	public void addQuestion(Question question) {
		test.getQuestions().add(question);
	}
	
	/**
	 * Gets students and their results.
	 * 
	 * @return the result of student
	 */
	public StudentTestResult getStudentResult(User student) {
		for (StudentTestResult st : test.getStudentResult()) {
			if(st.getStudent().equals((User)student) && st.getResult() != -1) {
				return st;
			}
		}
		return null;
	}
}
