package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.testsystem.controller.test.TestController;
import com.testsystem.controller.user.GroupController;
import com.testsystem.controller.user.StudentController;
import com.testsystem.model.test.Answer;
import com.testsystem.model.test.Question;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.user.Group;
import com.testsystem.model.user.User;


import tests.stubs.TestFrontController;

public class TestResultTest {

	TestFrontController frontController;
	Group g1;
	User student1;
	
	public TestResultTest() {
		loadData();
	}

	public void loadData() {
		frontController = new TestFrontController();
		g1 = new GroupController().getNewGroup("Group 1");
		student1 = new StudentController().getNewStudent("Шахматов", "Антон", "ShAnton", "1111", g1);
	}
	
	@Test
	public void testGetRatingUser() {
		//User student1 = frontController.login("ShAnton", "1111");

		//int percentCorrectQuestion = (int)resultTest.getPercentCorrectQuestions();
		//assertEquals(percentCorrectQuestion, 6);
		
		com.testsystem.model.test.Test test = new TestController().getTest(0);
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
		
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals((int)resultTest.getPercentCorrectQuestions(), 100);
	}
	
}
