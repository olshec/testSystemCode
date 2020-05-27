package lab_2;

import java.util.ArrayList;
import java.util.List;

public class TestSystem {

	public static void main(String[] args) {

		TestBase testBase = new TestBase();
		UserBase userBase=new UserBase();
		
		Server server = new Server(userBase, testBase);				
		
		Teacher teacher = new Teacher("Киров", "Антон", server, "KirovAnton", "12345678");
		Test test1 = new Test("Робототехника", teacher);
		Test test2 = new Test("Сетевые технологии", teacher);
		
		
		List<Test> tests=new ArrayList<Test>();
		tests.add(test1);
		tests.add(test2);
		
		testBase.addArrayTest(tests);
		
		User user = server.login("name", "pass");
		
		test2.addStudent(user);
		test1.addStudent(user);
		
		user.openMenu();
		
		
	}

}
