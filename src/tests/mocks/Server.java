package tests.mocks;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.controller.AdministratorController;
import com.testsystem.controller.GroupController;
import com.testsystem.controller.QuestionController;
import com.testsystem.controller.ServerController;
import com.testsystem.controller.StudentController;
import com.testsystem.controller.TeacherController;
import com.testsystem.controller.TestController;
import com.testsystem.controller.UserController;
import com.testsystem.models.Group;
import com.testsystem.models.Model;
import com.testsystem.models.Question;
import com.testsystem.models.Test;
import com.testsystem.models.User;
import com.testsystem.util.ServiceLocator;

public class Server extends ServerController {

	public Server() {
		super();
		//getDaoProvider().clear();
		//loadTest();
	}

	private void loadTest() {
		UserController userController = ServiceLocator.getUserController();
		User admin1 = AdministratorController.getNewAdministrator("Примарев", 
				"Игорь", this, "Admin1", "0000");
		userController.addUser(admin1);

		User teacher1 = TeacherController.getNewTeacher("Киров", 
				"Антон", this, "KirovAnton", "12345678");
		userController.addUser(teacher1);

		Test test1 = TestController.getNewTest("Робототехника", teacher1);
		Test test2 = TestController.getNewTest("Сетевые технологии", teacher1);
		Test test3 = TestController.getNewTest("Информатика", teacher1);

		Question q1 = QuestionController.getNewQuestion("Основы роботетхники");
		Question q2 = QuestionController.getNewQuestion("AI");
		Question q3 = QuestionController.getNewQuestion("Микроконтроллеры");

		TestController testController = new TestController(test1);
		testController.addQuestion(q1);
		testController.addQuestion(q2);
		testController.addQuestion(q3);

		Question q4 = QuestionController.getNewQuestion("Протокол HTTP");
		Question q5 = QuestionController.getNewQuestion("Характеристика OSI");
		Question q6 = QuestionController.getNewQuestion("Протокол TCP");

		testController.setTest(test2);

		testController.addQuestion(q3);
		testController.addQuestion(q4);
		testController.addQuestion(q5);
		testController.addQuestion(q6);

		List<Model> tests = new ArrayList<Model>();

		tests.add(test1);
		tests.add(test2);
		tests.add(test3);

		ServiceLocator.getTestController().setTests(tests);

		Group g1 = GroupController.getNewGroup("Group 1");
		ServiceLocator.getGroupController().addGroup(g1);
		User student1 = StudentController.getNewStudent("Шахматов", "Антон", this, "ShAnton", "1111", g1);
		User student2 = StudentController.getNewStudent("Романенко", "Егор", this, "REgor", "1111", g1);
		
		Group g2 = GroupController.getNewGroup("Group 2");
		ServiceLocator.getGroupController().addGroup(g2);
		User student3 = StudentController.getNewStudent("Сазонова", "Екатерина", this, "Kat", "1111", g2);
		User student4 = StudentController.getNewStudent("Филонова", "Анна", this, "Anna", "1111", g2);

		//add users to database
		userController.addUser(student1);
		userController.addUser(student2);
		userController.addUser(student3);
		userController.addUser(student4);

		//add test1 and result to students
		testController.setTest(test1);
		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addResult(student1, 4);
		testController.addResult(student2, 5);

		//add test2 and result to students
		testController.setTest(test2);
		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addStudent(student3);
		testController.addStudent(student4);
		testController.addResult(student1, 3);
		testController.addResult(student2, 4);
		testController.addResult(student3, 4);
		testController.addResult(student4, 5);
		
		//add test3 and result to students
		testController.setTest(test3);
		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addStudent(student3);
		testController.addStudent(student4);
		testController.addResult(student1, 3);
		testController.addResult(student2, 4);
		testController.addResult(student3, 5);
		testController.addResult(student4, 3);
	}
}
