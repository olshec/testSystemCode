package lab_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a test.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Test {

	String name;
	User teacher;
	List<Question> questions;
	List<User> students;
	List<Integer> results;

	/**
	 * Creates a test.
	 * @param name  The test's name.
	 * @param teacher The test’s teacher.
	 */
	public Test(String name, User teacher) {
		this.init();
		this.name = name;
		this.teacher = teacher;
	}

	private void init() {
		questions = new ArrayList<Question>();
		students = new ArrayList<User>();
		results = new ArrayList<Integer>();
	}

	/**
	 * Creates a test.
	 * @param name  The test's name.
	 * @return String The name of test.
	 */
	public String getName() {
		return name;
	}

	public void addResult(User student, int points) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == student.getId()) {
				results.set(i, points);
			}
		}
	}

	public boolean hasStudent(User student) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == student.getId()) {
				return true;
			}
		}
		return false;
	}

	public int getNumberQuestions() {
		return questions.size();
	}

	public void addStudent(User user) {
		students.add(user);
		results.add(-1);
	}

	public boolean hasTeacher(User teacher) {
		if (this.teacher.getId() == teacher.getId()) {
			return true;
		}
		return false;
	}

	public List<User> getStudents() {
		return students;
	}

	public List<Integer> getResults() {
		return results;
	}

	public void addQuestion(Question q) {
		questions.add(q);

	}

}
