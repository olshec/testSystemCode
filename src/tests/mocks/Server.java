package tests.mocks;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.controller.GroupBaseController;
import com.testsystem.controller.ServerController;
import com.testsystem.controller.TestBaseController;
import com.testsystem.controller.TestController;
import com.testsystem.controller.UserBaseController;
import com.testsystem.models.Administrator;
import com.testsystem.models.Group;
import com.testsystem.models.Question;
import com.testsystem.models.Student;
import com.testsystem.models.Teacher;
import com.testsystem.models.Test;
import com.testsystem.models.User;

public class Server extends ServerController {

	public Server()  {
		//super();
		loadTest();
	}

	private void loadTest() {
		// BEGIN DATA FOR TEST
		UserBaseController userBaseController=new UserBaseController(getUserBase());
		User admin1 = new Administrator("Примарев", "Игорь", this, "Admin1", "0000");
		userBaseController.addUser(admin1);

		User teacher1 = new Teacher("Киров", "Антон", this, "KirovAnton", "12345678");
		userBaseController.addUser(teacher1);

		Test test1 = new Test("Робототехника", teacher1);
		Test test2 = new Test("Сетевые технологии", teacher1);
		Test test3 = new Test("Информатика", teacher1);

		Question q1 = new Question("Основы роботетхники");
		Question q2 = new Question("AI");
		Question q3 = new Question("Микроконтроллеры");

		TestController testController = new TestController(test1);
		testController.addQuestion(q1);
		testController.addQuestion(q2);
		testController.addQuestion(q3);

		Question q4 = new Question("Протокол HTTP");
		Question q5 = new Question("Характеристика OSI");
		Question q6 = new Question("Протокол TCP");

		testController.setTest(test2);

		testController.addQuestion(q3);
		testController.addQuestion(q4);
		testController.addQuestion(q5);
		testController.addQuestion(q6);

		List<Test> tests = new ArrayList<Test>();

		tests.add(test1);
		tests.add(test2);
		tests.add(test3);

		//TestBaseController testBaseController=new TestBaseController(testBaseModel);
		new TestBaseController(getTestBase()).addTests(tests);
		//testBaseController.addTests(tests);

		Group g1=new Group("Group 1");
		new GroupBaseController(getGroupBase()).addGroup(g1);
		User student1 = new Student("Шахматов", "Антон", this, "ShAnton", "1111", g1);
		User student2 = new Student("Романенко", "Егор", this, "REgor", "1111", g1);
		
		Group g2=new Group("Group 2");
		new GroupBaseController(getGroupBase()).addGroup(g2);
		User student3 = new Student("Сазонова", "Екатерина", this, "Kat", "1111", g2);
		User student4 = new Student("Филонова", "Анна", this, "Anna", "1111", g2);

		userBaseController.addUser(student1);
		userBaseController.addUser(student2);
		userBaseController.addUser(student3);
		userBaseController.addUser(student4);

		testController.setTest(test1);

		testController.addStudent(student1);
		testController.addStudent(student2);

		testController.addResult(student1, 4);
		testController.addResult(student2, 2);

		testController.setTest(test2);

		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addStudent(student3);
		testController.addStudent(student4);
		
		testController.addResult(student1, 3);
		testController.addResult(student2, 4);
		testController.addResult(student3, 5);
		testController.addResult(student4, 4);

		// END DATA FOR TEST
	}
}
