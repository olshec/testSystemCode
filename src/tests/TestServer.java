package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.testsystem.controller.StudentController;
import com.testsystem.controller.TestController;
import com.testsystem.models.GroupBase;
import com.testsystem.models.Student;
import com.testsystem.models.TestBase;
import com.testsystem.models.User;
import com.testsystem.models.UserBase;

import tests.mocks.ImportTest;
import tests.mocks.Server;

public class TestServer {
//	private com.testsystem.models.Test userTest;

	Server serverController;
	User student1;

	public TestServer() {
		load();
	}

	public void load() {
		serverController = new Server();
		student1 = serverController.login("ShAnton", "1111");
	}

	@Test
	public void testCountTests() {
		TestBase testBase = serverController.getTestBase();
		assertEquals(testBase.getTests().size(), 3);
	}

	@Test
	public void testCountUsers() {
		UserBase userBase = serverController.getUserBase();
		assertEquals(userBase.getUsers().size(), 6);
	}

	@Test
	public void testCountGroups() {
		GroupBase groupBase = serverController.getGroupBase();
		assertEquals(groupBase.getGroups().size(), 2);
	}

	@Test
	public void testLogin() {
		assertEquals(student1.getNameModel(), Student.nameModel);
		assertEquals(student1.getLastName(), "Шахматов");
		assertEquals(student1.getFirstName(), "Антон");
	}

	@Test
	public void testGetTestsForStudent() {
		List<com.testsystem.models.Test> listTest = serverController.getTestsForStudent(student1);
		assertEquals(listTest.size(), 2);
	}

	@Test
	public void testGetTestInfoForStudent() {
		com.testsystem.models.Test test1 = serverController.getTestBase().getTests().get(0);
		com.testsystem.controller.TestController testController = new TestController(test1);
		com.testsystem.models.Test test2 = serverController.getTestBase().getTests().get(1);
		com.testsystem.controller.TestController testController2 = new TestController(test2);
		String lastNameTeacher = testController.getTest().getTeacher().getLastName();
		
		assertEquals(testController.getName(), "Робототехника");
		assertEquals(testController.getNumberQuestions(), 3);
		assertEquals(testController2.getName(), "Сетевые технологии");
		assertEquals(testController2.getNumberQuestions(), 4);
		assertEquals(lastNameTeacher, "Киров");
	}

	@Test
	public void testGetNumberQuestionsInTest() {
		int countQuestion = serverController.getNumberQuestionsInTest(student1, 0);
		int countQuestion2 = serverController.getNumberQuestionsInTest(student1, 1);
		
		assertEquals(countQuestion, 3);
		assertEquals(countQuestion2, 4);
	}

}
