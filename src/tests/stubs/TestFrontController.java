package tests.stubs;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.controller.AdministratorController;
import com.testsystem.controller.GroupController;
import com.testsystem.controller.QuestionController;
import com.testsystem.controller.FrontController;
import com.testsystem.controller.StudentController;
import com.testsystem.controller.TeacherController;
import com.testsystem.controller.TestController;
import com.testsystem.controller.UserController;
import com.testsystem.model.Group;
import com.testsystem.model.Model;
import com.testsystem.model.Question;
import com.testsystem.model.Test;
import com.testsystem.model.User;

public class TestFrontController extends FrontController {

	public TestFrontController() {
		super();
		//getDaoProvider().clear();
		//loadTest();
	}

	private void loadTest() {
//		UserController userController = new UserController();
//		User admin1 = new AdministratorController().getNewAdministrator("Примарев", 
//				"Игорь", "Admin1", "0000");
//		userController.saveUserInDatabase(admin1);
//
//		User teacher1 = new TeacherController().getNewTeacher("Киров", 
//				"Антон", "KirovAnton", "12345678");
//		userController.saveUserInDatabase(teacher1);
//
//		Test test1 = new TestController().getNewTest("Робототехника", teacher1);
//		Test test2 = new TestController().getNewTest("Сетевые технологии", teacher1);
//		Test test3 = new TestController().getNewTest("Информатика", teacher1);
//
//		Question q1 = new QuestionController().getNewQuestion("Основы роботетхники");
//		Question q2 = new QuestionController().getNewQuestion("AI");
//		Question q3 = new QuestionController().getNewQuestion("Микроконтроллеры");
//
//		TestController testController = new TestController(test1);
//		testController.addQuestion(q1);
//		testController.addQuestion(q2);
//		testController.addQuestion(q3);
//
//		Question q4 = new QuestionController().getNewQuestion("Протокол HTTP");
//		Question q5 = new QuestionController().getNewQuestion("Характеристика OSI");
//		Question q6 = new QuestionController().getNewQuestion("Протокол TCP");
//
//		testController.setTest(test2);
//
//		testController.addQuestion(q3);
//		testController.addQuestion(q4);
//		testController.addQuestion(q5);
//		testController.addQuestion(q6);
//
//		List<Model> tests = new ArrayList<Model>();
//
//		tests.add(test1);
//		tests.add(test2);
//		tests.add(test3);
//
//		new TestController().setTests(tests);
//
//		Group g1 = new GroupController().getNewGroup("Group 1");
//		new GroupController().saveGroupInDatabase(g1);
//		User student1 	= 	new StudentController().getNewStudent("Шахматов", "Антон", "ShAnton", "1111", g1);
//		User student2 	= 	new StudentController().getNewStudent("Романенко", "Егор", "REgor", "1111", g1);
//		User student01 	= 	new StudentController().getNewStudent("Федоренко", "Игнат", "FeIgnat", "1111", g1);
//		
//		Group g2 = new GroupController().getNewGroup("Group 2");
//		new GroupController().saveGroupInDatabase(g2);
//		User student3 = new StudentController().getNewStudent("Сазонова", "Екатерина", "Kat", "1111", g2);
//		User student4 = new StudentController().getNewStudent("Фролова", "Анна", "Anna", "1111", g2);
//
//		//add users to database
//		userController.saveUserInDatabase(student1);
//		userController.saveUserInDatabase(student2);
//		userController.saveUserInDatabase(student3);
//		userController.saveUserInDatabase(student4);
//		userController.saveUserInDatabase(student01);
//
//		//add test1 and result to students
//		testController.setTest(test1);
//		testController.addStudent(student1);
//		testController.addStudent(student2);
//		testController.addStudent(student01);
//		testController.addResult(student1, 4);
//		testController.addResult(student2, 5);
//		testController.addResult(student01, 3);
//
//		//add test2 and result to students
//		testController.setTest(test2);
//		testController.addStudent(student1);
//		testController.addStudent(student2);
//		testController.addStudent(student3);
//		testController.addStudent(student4);
//		testController.addResult(student1, 3);
//		testController.addResult(student2, 4);
//		testController.addResult(student3, 4);
//		testController.addResult(student4, 5);
//		testController.addResult(student01, 3);
//		
//		//add test3 and result to students
//		testController.setTest(test3);
//		testController.addStudent(student1);
//		testController.addStudent(student2);
//		testController.addStudent(student3);
//		testController.addStudent(student4);
//		testController.addResult(student1, 3);
//		testController.addResult(student2, 4);
//		testController.addResult(student3, 5);
//		testController.addResult(student4, 3);
//		testController.addResult(student01, 2);
	}
}
