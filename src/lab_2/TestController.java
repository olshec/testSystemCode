package lab_2;

import java.util.ArrayList;
import java.util.List;
import models.TestModel;

/**
 * Represents a test.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TestController {

	TestModel testModel;

	/**
	 * Creates a test.
	 * @param name  The test's name.
	 * @param teacher The test’s teacher.
	 */
	public TestController(String name, User teacher) {
		this.init();
		testModel.setName(name);
		testModel.setTeacher(teacher);
	}

	private void init() {
		testModel=new TestModel();
		testModel.setQuestions(new ArrayList<QuestionController>());
		testModel.setStudents(new ArrayList<User>());
		testModel.setResults(new ArrayList<Integer>()); 
	}

	/**
	 * Creates a test.
	 * @return String The name of test.
	 */
	public String getName() {
		return testModel.getName();
	}

	public void addResult(User student, int points) {
		for (int i = 0; i <testModel.getStudents().size(); i++) {
			if (testModel.getStudents().get(i).getId() == student.getId()) {
				testModel.getResults().set(i, points);
			}
		}
	}

	public boolean hasStudent(User student) {
		for (int i = 0; i < testModel.getStudents().size(); i++) {
			if (testModel.getStudents().get(i).getId() == student.getId()) {
				return true;
			}
		}
		return false;
	}

	public int getNumberQuestions() {
		return testModel.getQuestions().size();
	}

	public void addStudent(User user) {
		testModel.getStudents().add(user);
		testModel.getResults().add(-1);
	}

	public boolean hasTeacher(User teacher) {
		if (testModel.getTeacher().getId() == teacher.getId()) {
			return true;
		}
		return false;
	}

	public List<User> getStudents() {
		return testModel.getStudents();
	}

	public List<Integer> getResults() {
		return testModel.getResults();
	}

	public void addQuestion(QuestionController q) {
		testModel.getQuestions().add(q);
	}

}
