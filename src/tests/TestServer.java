package tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import com.testsystem.controller.TestController;
import com.testsystem.models.Administrator;
import com.testsystem.models.Group;
import com.testsystem.models.Model;
import com.testsystem.models.Student;
import com.testsystem.models.Teacher;
import com.testsystem.models.User;
import com.testsystem.util.ServiceLocator;

import tests.mocks.Server;

public class TestServer {

	Server serverController;
	User student1;
	User teacher1;
	User admin1;

	public TestServer() {
		loadData();
	}

	public void loadData() {
		serverController = new Server();
		student1 = serverController.login("ShAnton", "1111");
		teacher1 = serverController.login("KirovAnton", "12345678");
		admin1 = serverController.login("Admin1", "0000");
	}

	@Test
	public void testCountTests() {
		List<com.testsystem.models.Model> listTest = ServiceLocator.getDaoProvider()
				.getRecordsTable(com.testsystem.models.Test.nameModel);	
		
		assertEquals(listTest.size(), 3);
	}

	@Test
	public void testCountUsers() {
		List<Model> listUser = ServiceLocator.getDaoProvider()
				.getRecordsTable(User.nameModel);
		
		assertEquals(listUser.size(), 6);
	}

	@Test
	public void testCountGroups() {
		List<Model> listGroup = ServiceLocator.getDaoProvider()
				.getRecordsTable(Group.nameModel);
		
		assertEquals(listGroup.size(), 2);
	}

	@Test
	public void testLogin() {
		assertEquals(student1.getNameModel(), Student.nameModel);
		assertEquals(student1.getLastName(), "Шахматов");
		assertEquals(student1.getFirstName(), "Антон");
	}

	@Test
	public void testGetTestsForStudent() {
		List<com.testsystem.models.Model> listTest = serverController.getTestsForStudent(student1);
		assertEquals(listTest.size(), 3);
	}

	@Test
	public void testGetTestInfoForStudent() {

		List<Model> modelsTests = serverController.getDaoProvider()
				.getRecordsTable(com.testsystem.models.Test.nameModel);
		com.testsystem.models.Test test1 = (com.testsystem.models.Test)(modelsTests).get(0);
//		List<Model> listGroup = ServiceLocator.getDaoProvider()
//				.getRecordsTable(Group.nameModel);
		TestController testController = new TestController(test1);

		com.testsystem.models.Test test2 = (com.testsystem.models.Test)(modelsTests).get(1);
		TestController testController2 = new TestController(test2);
		
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

	@Test
	public void testGetTestsForTeacher() {
		List<com.testsystem.models.Test> listTest = ServiceLocator.getTeacherController(teacher1).getTests();

		assertEquals(listTest.size(), 3);
	}

	@Test
	public void testGetAllUsersForAdmin() {
		List<Model> listUser = ServiceLocator.getAdministratorController(admin1).getAllUsers();

		assertEquals(listUser.size(), 6);
	}

	@Test
	public void testGetStudentsForAdmin() {
		List<Model> listUser = ServiceLocator.getAdministratorController(admin1)
				.getUsersByType(Student.nameModel);

		assertEquals(listUser.size(), 4);
	}

	@Test
	public void testGetTeachersForAdmin() {
		List<Model> listUser = ServiceLocator.getAdministratorController(admin1)
				.getUsersByType(Teacher.nameModel);

		assertEquals(listUser.size(), 1);
	}

	@Test
	public void testGetAdminsForAdmin() {
		List<Model> listUser = ServiceLocator.getAdministratorController(admin1)
				.getUsersByType(Administrator.nameModel);

		assertEquals(listUser.size(), 1);
	}
}
