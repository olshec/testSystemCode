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
		
		//get question 1
		listAnswer = listQuestion.get(4).getAnswers();
		listAnswer.get(0).setChecked(true);
		listAnswer.get(1).setChecked(true);
		//get question 2
		listAnswer = listQuestion.get(5).getAnswers();
		listAnswer.get(1).setChecked(true);
		//get question 3
		listAnswer = listQuestion.get(6).getAnswers();
		listAnswer.get(3).setChecked(true);
		//get question 4
		listAnswer = listQuestion.get(7).getAnswers();
		listAnswer.get(2).setChecked(true);
		
		//get question 1
		listAnswer = listQuestion.get(8).getAnswers();
		listAnswer.get(0).setChecked(true);
		listAnswer.get(1).setChecked(true);
		//get question 2
		listAnswer = listQuestion.get(9).getAnswers();
		listAnswer.get(1).setChecked(true);
		//get question 3
		listAnswer = listQuestion.get(10).getAnswers();
		listAnswer.get(3).setChecked(true);
		//get question 4
		listAnswer = listQuestion.get(11).getAnswers();
		listAnswer.get(2).setChecked(true);
	}
	
	//All questions corrects.
	@Test
	public void testResultTest1() {
		loadTestData();
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals(resultTest.getPercentCorrectQuestions(), 100);
		assertEquals(resultTest.getNumberCorrectQuestions(), 12);
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
		assertEquals(resultTest.getPercentCorrectQuestions(), 91);
		assertEquals(resultTest.getNumberCorrectQuestions(), 11);
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
		assertEquals(resultTest.getPercentCorrectQuestions(), 91);
		assertEquals(resultTest.getNumberCorrectQuestions(), 11);
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
		assertEquals(resultTest.getPercentCorrectQuestions(), 95);
		assertEquals(resultTest.getNumberCorrectQuestions(), 11);
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
		assertEquals(resultTest.getPercentCorrectQuestions(), 87);
		assertEquals(resultTest.getNumberCorrectQuestions(), 10);
		assertEquals(resultTest.getNumberNotCorrectQuestions(), 1);
		assertEquals(resultTest.getNumberPartlyQuestion(), 1);
	}
	
	//Question 5 is partly correct and question 4 is not correct. It's check all answer in question 4.
	@Test
	public void testResultTest6() {
		loadTestData();

		List<Question> listQuestion = test.getQuestions();
		//get question 1
		List<Answer> listAnswer = listQuestion.get(4).getAnswers();
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
		assertEquals(resultTest.getPercentCorrectQuestions(), 87);
		assertEquals(resultTest.getNumberCorrectQuestions(), 10);
		assertEquals(resultTest.getNumberNotCorrectQuestions(), 1);
		assertEquals(resultTest.getNumberPartlyQuestion(), 1);
	}
	
	//Question 10 skipped.
	@Test
	public void testResultTestSkipped1() {
		loadTestData();

		List<Question> listQuestion = test.getQuestions();
		//get question 1
		List<Answer> listAnswer = listQuestion.get(9).getAnswers();
		listAnswer.get(0).setChecked(false);
		listAnswer.get(1).setChecked(false);
		
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals(resultTest.getPercentCorrectQuestions(), 91);
		assertEquals(resultTest.getNumberCorrectQuestions(), 11);
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
		//set answers to error
		listAnswer.get(0).setChecked(false);
		listAnswer.get(1).setChecked(false);
		
		//get question 4
		listAnswer = listQuestion.get(3).getAnswers();
		//set answer to error
		listAnswer.get(0).setChecked(true);
		
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals(resultTest.getPercentCorrectQuestions(), 83);
		assertEquals(resultTest.getNumberCorrectQuestions(), 10);
		assertEquals(resultTest.getNumberNotCorrectQuestions(), 1);
		assertEquals(resultTest.getNumberSkippedQuestion(), 1);
		assertEquals(resultTest.getNumberPartlyQuestion(), 0);
	}
	
	//question 1 is parly, questions 2 and 4 are skipped.
	@Test
	public void testResultTestSkipped3() {
		loadTestData();

		List<Question> listQuestion = test.getQuestions();
		//get question 1
		List<Answer> listAnswer = listQuestion.get(0).getAnswers();
		//set answer to error
		listAnswer.get(0).setChecked(false);
		
		//get question 2
		listAnswer = listQuestion.get(1).getAnswers();
		//set answer to skipped
		listAnswer.get(1).setChecked(false);		
		
		//get question 4
		listAnswer = listQuestion.get(3).getAnswers();
		//set answer to skipped
		listAnswer.get(2).setChecked(false);
		
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals(resultTest.getPercentCorrectQuestions(), 79);
		assertEquals(resultTest.getNumberCorrectQuestions(), 9);
		assertEquals(resultTest.getNumberNotCorrectQuestions(), 0);
		assertEquals(resultTest.getNumberSkippedQuestion(), 2);
		assertEquals(resultTest.getNumberPartlyQuestion(), 1);
	}
	
	//All Question are skipped.
	@Test
	public void testResultTestSkipped4() {
		loadTestData();

		List<Question> listQuestion = test.getQuestions();
		for(Question q: listQuestion) {
			List<Answer> listAnswer = q.getAnswers();
			for(Answer a: listAnswer) {
				a.setChecked(false);
			}
		}
		
		ResultTest resultTest = new TestController().checkTest(student1, test);
		assertEquals(resultTest.getPercentCorrectQuestions(), 0);
		assertEquals(resultTest.getNumberCorrectQuestions(), 0);
		assertEquals(resultTest.getNumberNotCorrectQuestions(), 0);
		assertEquals(resultTest.getNumberSkippedQuestion(), 12);
		assertEquals(resultTest.getNumberPartlyQuestion(), 0);
	}

}
