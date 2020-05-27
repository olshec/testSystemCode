package lab_2;

import java.util.ArrayList;
import java.util.List;

public class TestBase {
	private List<Test> tests;

	private Test getTest(String nameTest) {
		for (int i = 0; i < tests.size(); i++) {
			if (tests.get(i).name == nameTest) {
				return tests.get(i);
			}
		}
		return null;
	}

	public TestBase() {
		
	}

	public List<Test> getTestsStudent(Student student) {
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

	public int getResult(int idStudent, String nameTest) {

		Test test = getTest(nameTest);
		if (test != null) {
			return test.getResult(idStudent);
		} else
			return -1;
	}

	public int getNumberQuestions(int index) {
		return tests.get(index).getNumberQuestions();
	}
	
	public void addArrayTest(List<Test> tests) {
		this.tests=tests;
	}
	
	public Test getTestIndex(int index) {
		return tests.get(index);
	}

}
