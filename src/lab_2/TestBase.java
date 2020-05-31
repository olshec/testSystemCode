package lab_2;

import java.util.ArrayList;
import java.util.List;

public class TestBase {
	private List<Test> tests;

//	private Test getTest(String nameTest) {
//		for (int i = 0; i < tests.size(); i++) {
//			if (tests.get(i).name == nameTest) {
//				return tests.get(i);
//			}
//		}
//		return null;
//	}

	public TestBase() {
		
	}

	public List<Test> getTestsStudent(User student) {
		List<Test> testsStudent=new ArrayList<Test>();
		for (int i = 0; i < tests.size(); i++) {
			if (tests.get(i).hasStudent(student) == true) {
				testsStudent.add(tests.get(i));
			}
		}
		return testsStudent;
	}
	
	public List<Test> getAllTests() {
		return tests;
	}

//	public int getResult(int idStudent, String nameTest) {
//
//		Test test = getTest(nameTest);
//		if (test != null) {
//			return test.getResult(idStudent);
//		} else
//			return -1;
//	}

	public int getNumberQuestions(int index) {
		return tests.get(index).getNumberQuestions();
	}
	
	public void addArrayTest(List<Test> tests) {
		this.tests=tests;
	}
	
	public Test getTestIndex(int index) {
		if(index<tests.size() && index>=0) {
			return tests.get(index);
		}
		return null;
	}

	/*
	 * get tests result for teacher
	 */
	public List<Test> getTests(User user) {
		ArrayList<Test> masTests=new ArrayList<Test>();
		for(int i=0;i<tests.size();i++) {
			if(tests.get(i).hasTeacher(user)) {
				masTests.add(tests.get(i));
			}
		}
		return masTests;
	}
	
}
