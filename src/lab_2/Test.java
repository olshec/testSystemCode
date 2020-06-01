package lab_2;

import java.util.ArrayList;
import java.util.List;

public class Test {

	String name;
	User teacher;
	List<Question> questions;
	List<User> students;
	List<Integer> results;

	public Test() {
		this.init();
	}

	public Test(String name, User teacher) {
		this.init();
		this.name = name;
		this.teacher = teacher;
	}
	
	private void init() {
		questions=new ArrayList<Question>();
		students=new ArrayList<User>();
		results=new ArrayList<Integer>();
	}

	public String getName() {
		return name;
	}
	
//	public int getResult(int idStudent) {
//
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getId() == idStudent) {
//				return results.get(i);
//			}
//		}
//		return -1;
//	}
	
	public boolean hasStudent(User student) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == student.getId()) {
				return true;
			}
		}
		return false;
	}
	
	
	public int getNumberQuestions()
	{
		return questions.size();
	}
	
	public void addStudent(User user) {
		students.add(user);
	}
	
	
	public boolean hasTeacher(User teacher) {
		if(this.teacher.getId()==teacher.getId()) {
			return true;
		}
		return false;
	}
	
	public List<User> getStudents(){
		return students;
	}
	
	public List<Integer> getResults(){
		return results;
	}


}
