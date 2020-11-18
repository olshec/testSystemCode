package com.testsystem.util;

import java.util.ArrayList;
import java.util.List;
import com.testsystem.controller.test.QuestionController;
import com.testsystem.controller.test.TestController;
import com.testsystem.controller.user.AdministratorController;
import com.testsystem.controller.user.GroupController;
import com.testsystem.controller.user.StudentController;
import com.testsystem.controller.user.TeacherController;
import com.testsystem.controller.user.UserController;
import com.testsystem.model.test.Answer;
import com.testsystem.model.test.Question;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.Group;
import com.testsystem.model.user.User;

public class LoaderDataToApplication {
	
	public void loadData() {
		UserController userController = new UserController();
		User admin1 = new AdministratorController().getNewAdministrator("Примарев", 
				"Игорь", "Admin1", "0000");
		userController.saveUserInDatabase(admin1);

		User teacher1 = new TeacherController().getNewTeacher("Киров", 
				"Антон", "KirovAnton", "12345678");
		userController.saveUserInDatabase(teacher1);

		Test test1 = new TestController().getNewTest("Космология", teacher1);
		Test test2 = new TestController().getNewTest("Сетевые технологии", teacher1);
		Test test3 = new TestController().getNewTest("Информатика", teacher1);

		
		TestController testController = new TestController(test1);
		addTest1(teacher1, test1);
		
		Question q5 = new QuestionController().getNewQuestion("Протокол HTTP");
		Question q6 = new QuestionController().getNewQuestion("Характеристика OSI");
		Question q7 = new QuestionController().getNewQuestion("Протокол TCP");

		testController.setTest(test2);
		testController.addQuestion(q5);
		testController.addQuestion(q6);
		testController.addQuestion(q7);
		
		
		TestController.saveTest(test2);
		TestController.saveTest(test3);

		Group g1 = new GroupController().getNewGroup("Group 1");
		new GroupController().saveGroupInDatabase(g1);
		User student1 	= 	new StudentController().getNewStudent("Шахматов", "Антон", "ShAnton", "1111", g1);
		User student2 	= 	new StudentController().getNewStudent("Романенко", "Егор", "REgor", "1111", g1);
		User student5 	= 	new StudentController().getNewStudent("Федоренко", "Игнат", "FeIgnat", "1111", g1);
		
		Group g2 = new GroupController().getNewGroup("Group 2");
		new GroupController().saveGroupInDatabase(g2);
		User student3 = new StudentController().getNewStudent("Сазонова", "Екатерина", "Kat", "1111", g2);
		User student4 = new StudentController().getNewStudent("Фролова", "Анна", "Anna", "1111", g2);

		//add users to database
		userController.saveUserInDatabase(student1);
		userController.saveUserInDatabase(student2);
		userController.saveUserInDatabase(student3);
		userController.saveUserInDatabase(student4);
		userController.saveUserInDatabase(student5);

		//add test1 and result to students
		testController.setTest(test1);
		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addStudent(student5);
		testController.saveResultInDatabase(student1, test1, 4);
		testController.saveResultInDatabase(student2, test1, 5);
		testController.saveResultInDatabase(student5, test1, 3);

		//add test2 and result to students
		testController.setTest(test2);
		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addStudent(student3);
		testController.addStudent(student4);
		testController.saveResultInDatabase(student1, test2, 3);
		testController.saveResultInDatabase(student2, test2, 4);
		testController.saveResultInDatabase(student3, test2, 4);
		testController.saveResultInDatabase(student4, test2, 5);
		testController.saveResultInDatabase(student5, test2, 3);
//		
		//add test3 and result to students
		testController.setTest(test3);
		testController.addStudent(student1);
		testController.addStudent(student2);
		testController.addStudent(student3);
		testController.addStudent(student4);
		testController.saveResultInDatabase(student1, test3, 3);
		testController.saveResultInDatabase(student2, test3, 4);
		testController.saveResultInDatabase(student3, test3, 5);
		testController.saveResultInDatabase(student4, test3, 5);
		testController.saveResultInDatabase(student5, test3, 2);
		
		loadTestData();
	}
	
	private void loadTestData() {
		Test test = new TestController().getTest(0);
		List<Question> listQuestion = test.getQuestions();
		//get question 1
		List<Answer> listAnswer = listQuestion.get(0).getAnswers();
		listAnswer.get(0).setChecked(true);
		listAnswer.get(1).setChecked(true);
		//get question 2
		listAnswer = listQuestion.get(1).getAnswers();
		listAnswer.get(1).setChecked(true);
		//get question 3
		listAnswer = listQuestion.get(2).getAnswers();
		listAnswer.get(3).setChecked(true);
		//get question 4
		listAnswer = listQuestion.get(3).getAnswers();
		listAnswer.get(2).setChecked(true);
		
//		Group g1 = new GroupController().getNewGroup("Group 1");
//		User student1 	= 	new StudentController().getNewStudent("Шахматов", "Антон", "ShAnton", "1111", g1);
//		ResultTest resultTest = new TestController().checkTest(student1, test);
//		System.out.println(resultTest.toString());
	}
	
	private void addTest1(User teacher, Test test) {
				
		Question q1 = new QuestionController().getNewQuestion("Какие планеты солнечной системы вращаются в направлении, противоположном Земле?");
		QuestionController questionController = new QuestionController(q1);
		questionController.addAnswer(new Answer("Венера", "", true));
		questionController.addAnswer(new Answer("Уран", "", true));
		questionController.addAnswer(new Answer("Плутон", "", false));
		questionController.addAnswer(new Answer("Юпитер", "", false));
		
		Question q2 = new QuestionController().getNewQuestion("Какой ученый является изобретателем космической ракеты?");
		questionController = new QuestionController(q2);
		questionController.addAnswer(new Answer("Нил Армстронг", "", false));
		questionController.addAnswer(new Answer("Циолковский", "", true));
		questionController.addAnswer(new Answer("Сергей Павлович Королев", "", false));
		questionController.addAnswer(new Answer("Вернер фон Браун", "", false));
		
		Question q3 = new QuestionController().getNewQuestion("Как звали человека, который первым высадился на Луну?");
		questionController = new QuestionController(q3);
		questionController.addAnswer(new Answer("Даниил Армстронг", "", false));
		questionController.addAnswer(new Answer("Джек Армстронг", "", false));
		questionController.addAnswer(new Answer("Арнольд Армстронг", "", false));
		questionController.addAnswer(new Answer("Нил Армстронг", "", true));
		
		Question q4 = new QuestionController().getNewQuestion("Как называется ближайшая к Солнцу планета?");
		questionController = new QuestionController(q4);
		questionController.addAnswer(new Answer("Марс", "", false));
		questionController.addAnswer(new Answer("Плутон", "", false));
		questionController.addAnswer(new Answer("Меркурий", "", true));
		questionController.addAnswer(new Answer("Юпитер", "", false));
		
		Question q5 = new QuestionController().getNewQuestion("Какие планеты солнечной системы вращаются в направлении, противоположном Земле?");
		questionController = new QuestionController(q5);
		questionController.addAnswer(new Answer("Венера", "", true));
		questionController.addAnswer(new Answer("Уран", "", true));
		questionController.addAnswer(new Answer("Плутон", "", false));
		questionController.addAnswer(new Answer("Юпитер", "", false));
		
		Question q6 = new QuestionController().getNewQuestion("Какой ученый является изобретателем космической ракеты?");
		questionController = new QuestionController(q6);
		questionController.addAnswer(new Answer("Нил Армстронг", "", false));
		questionController.addAnswer(new Answer("Циолковский", "", true));
		questionController.addAnswer(new Answer("Сергей Павлович Королев", "", false));
		questionController.addAnswer(new Answer("Вернер фон Браун", "", false));
		
		Question q7 = new QuestionController().getNewQuestion("Как звали человека, который первым высадился на Луну?");
		questionController = new QuestionController(q7);
		questionController.addAnswer(new Answer("Даниил Армстронг", "", false));
		questionController.addAnswer(new Answer("Джек Армстронг", "", false));
		questionController.addAnswer(new Answer("Арнольд Армстронг", "", false));
		questionController.addAnswer(new Answer("Нил Армстронг", "", true));
		
		Question q8 = new QuestionController().getNewQuestion("Как называется ближайшая к Солнцу планета?");
		questionController = new QuestionController(q8);
		questionController.addAnswer(new Answer("Марс", "", false));
		questionController.addAnswer(new Answer("Плутон", "", false));
		questionController.addAnswer(new Answer("Меркурий", "", true));
		questionController.addAnswer(new Answer("Юпитер", "", false));
		
		Question q9 = new QuestionController().getNewQuestion("Какие планеты солнечной системы вращаются в направлении, противоположном Земле?");
		questionController = new QuestionController(q9);
		questionController.addAnswer(new Answer("Венера", "", true));
		questionController.addAnswer(new Answer("Уран", "", true));
		questionController.addAnswer(new Answer("Плутон", "", false));
		questionController.addAnswer(new Answer("Юпитер", "", false));
		
		Question q10 = new QuestionController().getNewQuestion("Какой ученый является изобретателем космической ракеты?");
		questionController = new QuestionController(q10);
		questionController.addAnswer(new Answer("Нил Армстронг", "", false));
		questionController.addAnswer(new Answer("Циолковский", "", true));
		questionController.addAnswer(new Answer("Сергей Павлович Королев", "", false));
		questionController.addAnswer(new Answer("Вернер фон Браун", "", false));

		
		Question q11 = new QuestionController().getNewQuestion("Как звали человека, который первым высадился на Луну?");
		questionController = new QuestionController(q11);
		questionController.addAnswer(new Answer("Даниил Армстронг", "", false));
		questionController.addAnswer(new Answer("Джек Армстронг", "", false));
		questionController.addAnswer(new Answer("Арнольд Армстронг", "", false));
		questionController.addAnswer(new Answer("Нил Армстронг", "", true));
		
		Question q12 = new QuestionController().getNewQuestion("Как называется ближайшая к Солнцу планета?");
		questionController = new QuestionController(q12);
		questionController.addAnswer(new Answer("Марс", "", false));
		questionController.addAnswer(new Answer("Плутон", "", false));
		questionController.addAnswer(new Answer("Меркурий", "", true));
		questionController.addAnswer(new Answer("Юпитер", "", false));
		
		TestController testController = new TestController(test);
		testController.addQuestion(q1);
		testController.addQuestion(q2);
		testController.addQuestion(q3);
		testController.addQuestion(q4);
		testController.addQuestion(q5);
		testController.addQuestion(q6);
		testController.addQuestion(q7);
		testController.addQuestion(q8);
		testController.addQuestion(q9);
		testController.addQuestion(q10);
		testController.addQuestion(q11);
		testController.addQuestion(q12);
		
		TestController.saveTest(test);
	}

	
}
