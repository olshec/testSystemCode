package lab_2;

import java.util.List;

public class Server {

	UserBase userBase;
	TestBase testBase;
	
	public Server(UserBase userBase, TestBase testBase) {
		this.userBase=userBase;
		this.testBase=testBase;
	}
	
	public User login(String userName, String password) {
		return new Student(this);
	}

	public User startSession(User user) {
		return new Student();
	}
	
	public List<Test> getTestsStudent(Student student)
	{
		return testBase.getTestsStudent(student);
	}
	
	public int getNumberQuestions(Student student, int index)
	{
		return testBase.getNumberQuestions(index);
	}
	
}
