package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.testsystem.model.test.ResultTest;
import com.testsystem.model.user.User;


import tests.stubs.TestFrontController;

public class TestResultTest {

	TestFrontController frontController;
	
	public TestResultTest() {
		loadData();
	}

	public void loadData() {
		frontController = new TestFrontController();
	}
	
	@Test
	public void testGetRatingUser() {
		User student1 = frontController.login("ShAnton", "1111");
		com.testsystem.model.test.Test test = new com.testsystem.model.test.Test();
		ResultTest resultTest = frontController.checkTest(student1, test);
		int percentCorrectQuestion = (int)resultTest.getPercentCorrectQuestions();
		assertEquals(percentCorrectQuestion, 6);
	}
	
}
