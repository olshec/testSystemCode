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
	com.testsystem.model.test.Test test;
	
	public TestResultTest() {
		loadData();
	}

	public void loadData() {
		frontController = new TestFrontController();
		g1 = new GroupController().getNewGroup("Group 1");
		student1 = new StudentController().getNewStudent("Шахматов", "Антон", "ShAnton", "1111", g1);
		test = new TestController().getTest(0);
	}
	
	private void loadTestData() {
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
	}
	
	//All questions corrects.
	@Test
	public void testResultTest1() {
		loadTestData();
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals(resultTest.getPercentCorrectQuestions(), 100);
		assertEquals(resultTest.getNumberCorrectQuestions(), 4);
		assertEquals(resultTest.getNumberNotCorrectQuestions(), 0);
		assertEquals(resultTest.getNumberPartlyQuestion(), 0);
	}
	
	//Question 4 is not correct
	@Test
	public void testResultTest2() {
		loadTestData();
		
		List<Question> listQuestion = test.getQuestions();
		List<Answer> listAnswer = listQuestion.get(0).getAnswers();
		
		//get question 4
		listAnswer = listQuestion.get(3).getAnswers();
		listAnswer.get(0).setChecked(true);
		
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals(resultTest.getPercentCorrectQuestions(), 75);
		assertEquals(resultTest.getNumberCorrectQuestions(), 3);
		assertEquals(resultTest.getNumberNotCorrectQuestions(), 1);
		assertEquals(resultTest.getNumberPartlyQuestion(), 0);
	}
	
	//Question 4 is not correct. It's check all answer in question 4.
	@Test
	public void testResultTest3() {
		loadTestData();

		List<Question> listQuestion = test.getQuestions();
		List<Answer> listAnswer = listQuestion.get(0).getAnswers();
		
		//get question 4
		listAnswer = listQuestion.get(3).getAnswers();
		listAnswer.get(0).setChecked(true);
		listAnswer.get(1).setChecked(true);
		listAnswer.get(2).setChecked(true);
		listAnswer.get(3).setChecked(true);
		
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals(resultTest.getPercentCorrectQuestions(), 75);
		assertEquals(resultTest.getNumberCorrectQuestions(), 3);
		assertEquals(resultTest.getNumberNotCorrectQuestions(), 1);
		assertEquals(resultTest.getNumberPartlyQuestion(), 0);
	}
	
	//Question 1 is partly
	@Test
	public void testResultTest4() {
		loadTestData();

		List<Question> listQuestion = test.getQuestions();
		//get question 1
		List<Answer> listAnswer = listQuestion.get(0).getAnswers();
		listAnswer.get(0).setChecked(true);
		//set answer to error
		listAnswer.get(1).setChecked(false);
		
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals(resultTest.getPercentCorrectQuestions(), 87);
		assertEquals(resultTest.getNumberCorrectQuestions(), 3);
		assertEquals(resultTest.getNumberNotCorrectQuestions(), 0);
		assertEquals(resultTest.getNumberPartlyQuestion(), 1);
	}
	
	//Question 1 is partly correct and question 4 is not correct
	@Test
	public void testResultTest5() {
		loadTestData();

		List<Question> listQuestion = test.getQuestions();
		//get question 1
		List<Answer> listAnswer = listQuestion.get(0).getAnswers();
		listAnswer.get(0).setChecked(true);
		//set answer to error
		listAnswer.get(1).setChecked(false);
		
		//get question 4
		listAnswer = listQuestion.get(3).getAnswers();
		//set answer to error
		listAnswer.get(0).setChecked(true);
		
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals(resultTest.getPercentCorrectQuestions(), 62);
		assertEquals(resultTest.getNumberCorrectQuestions(), 2);
		assertEquals(resultTest.getNumberNotCorrectQuestions(), 1);
		assertEquals(resultTest.getNumberPartlyQuestion(), 1);
	}
	
	//Question 1 is partly correct and question 4 is not correct. It's check all answer in question 4.
	@Test
	public void testResultTest6() {
		loadTestData();

		List<Question> listQuestion = test.getQuestions();
		//get question 1
		List<Answer> listAnswer = listQuestion.get(0).getAnswers();
		listAnswer.get(0).setChecked(true);
		//set answer to error
		listAnswer.get(1).setChecked(false);
		
		//get question 4
		listAnswer = listQuestion.get(3).getAnswers();
		//set answer to error
		listAnswer.get(0).setChecked(true);
		listAnswer.get(1).setChecked(true);
		listAnswer.get(2).setChecked(true);
		listAnswer.get(3).setChecked(true);
		
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals(resultTest.getPercentCorrectQuestions(), 62);
		assertEquals(resultTest.getNumberCorrectQuestions(), 2);
		assertEquals(resultTest.getNumberNotCorrectQuestions(), 1);
		assertEquals(resultTest.getNumberPartlyQuestion(), 1);
	}
	
	//Question 1 skipped.
	@Test
	public void testResultTestSkipped1() {
		loadTestData();

		List<Question> listQuestion = test.getQuestions();
		//get question 1
		List<Answer> listAnswer = listQuestion.get(0).getAnswers();
		listAnswer.get(0).setChecked(false);
		listAnswer.get(1).setChecked(false);
		
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals(resultTest.getPercentCorrectQuestions(), 75);
		assertEquals(resultTest.getNumberCorrectQuestions(), 3);
		assertEquals(resultTest.getNumberNotCorrectQuestions(), 0);
		assertEquals(resultTest.getNumberSkippedQuestion(), 1);
		assertEquals(resultTest.getNumberPartlyQuestion(), 0);
	}
	
	//Question 1 skipped and question 4 is not correct.
	@Test
	public void testResultTestSkipped2() {
		loadTestData();

		List<Question> listQuestion = test.getQuestions();
		//get question 1
		List<Answer> listAnswer = listQuestion.get(0).getAnswers();
		//set answer to error
		listAnswer.get(0).setChecked(false);
		listAnswer.get(1).setChecked(false);
		
		//get question 4
		listAnswer = listQuestion.get(3).getAnswers();
		//set answer to error
		listAnswer.get(0).setChecked(true);
		
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals(resultTest.getPercentCorrectQuestions(), 50);
		assertEquals(resultTest.getNumberCorrectQuestions(), 2);
		assertEquals(resultTest.getNumberNotCorrectQuestions(), 1);
		assertEquals(resultTest.getNumberSkippedQuestion(), 1);
		assertEquals(resultTest.getNumberPartlyQuestion(), 0);
	}
	

}
