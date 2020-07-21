package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.testsystem.models.GroupBase;
import com.testsystem.models.Student;
import com.testsystem.models.TestBase;
import com.testsystem.models.User;
import com.testsystem.models.UserBase;

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
		student1=serverController.login("ShAnton", "1111");
	}
	
	@Test
	public void testCountTests() {
		TestBase testBase =serverController.getTestBase();
		assertEquals(testBase.getTests().size(), 3);
	}
	
	@Test
	public void testCountUsers() {
		UserBase userBase =serverController.getUserBase();
		assertEquals(userBase.getUsers().size(), 6);
	}
	
	@Test
	public void testCountGroups() {
		GroupBase groupBase =serverController.getGroupBase();
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
	public void testGetNumberQuestionsInTest() {
		int countQuestion = serverController.getNumberQuestionsInTest(student1, 0);
		int countQuestion2 = serverController.getNumberQuestionsInTest(student1, 1);
		assertEquals(countQuestion, 3);
		assertEquals(countQuestion2, 4);
	}

}
