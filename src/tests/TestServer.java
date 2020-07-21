package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import com.testsystem.models.User;

import tests.mocks.ImportTest;
import tests.mocks.Server;


public class TestServer {
//	private com.testsystem.models.Test userTest;
	
	Server serverController;

	public TestServer() {
		load();
	}
	
	public void load() {
		serverController = new Server();
		//serverController.
	}

	@Test
	public void testLogin() {
		User user1;
		user1=serverController.login("ShAnton", "1111");
		assertEquals(user1.getLastName(), "Шахматов");
		assertEquals(user1.getFirstName(), "Антон");
	}
	
	@Test
	public void testGetTestsForStudent() {
		User user1;
		user1=serverController.login("ShAnton", "1111");
		List<com.testsystem.models.Test> listTest = serverController.getTestsForStudent(user1);
		assertEquals(listTest.size(), 2);
	}

}
