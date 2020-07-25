package tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import com.testsystem.DAO.Table;
import com.testsystem.controller.TestController;
import com.testsystem.models.Administrator;
import com.testsystem.models.Group;
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
		@SuppressWarnings("unchecked")
		List<com.testsystem.models.Test> listTest = 
				((Table<com.testsystem.models.Test>)serverController.getDaoProvider()
						.getTable(com.testsystem.models.Test.nameModel)).getListRecord();
		
		assertEquals(listTest.size(), 3);
	}

	@Test
	public void testCountUsers() {
		@SuppressWarnings("unchecked")
		List<User> listUser = ((Table<User>)serverController.getDaoProvider()
						.getTable(User.nameModel)).getListRecord();
		
		assertEquals(listUser.size(), 6);
	}

	@Test
	public void testCountGroups() {
		@SuppressWarnings("unchecked")
		List<Group> listGroup = ((Table<Group>)serverController.getDaoProvider()
				.getTable(Group.nameModel)).getListRecord();
		
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
		List<com.testsystem.models.Test> listTest = serverController.getTestsForStudent(student1);
		assertEquals(listTest.size(), 3);
	}

	@Test
	public void testGetTestInfoForStudent() {
		@SuppressWarnings("unchecked")
		com.testsystem.models.Test test1 = ((Table<com.testsystem.models.Test>)serverController.getDaoProvider()
				.getTable(com.testsystem.models.Test.nameModel)).getListRecord().get(0);
		TestController testController = new TestController(test1);
		@SuppressWarnings("unchecked")
		com.testsystem.models.Test test2 = ((Table<com.testsystem.models.Test>)serverController.getDaoProvider()
				.getTable(com.testsystem.models.Test.nameModel)).getListRecord().get(1);
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
		List<User> listUser = ServiceLocator.getAdministratorController(admin1).getAllUsers();

		assertEquals(listUser.size(), 6);
	}

	@Test
	public void testGetStudentsForAdmin() {
		List<User> listUser = ServiceLocator.getAdministratorController(admin1)
				.getUsersByType(Student.nameModel);

		assertEquals(listUser.size(), 4);
	}

	@Test
	public void testGetTeachersForAdmin() {
		List<User> listUser = ServiceLocator.getAdministratorController(admin1)
				.getUsersByType(Teacher.nameModel);

		assertEquals(listUser.size(), 1);
	}

	@Test
	public void testGetAdminsForAdmin() {
		List<User> listUser = ServiceLocator.getAdministratorController(admin1)
				.getUsersByType(Administrator.nameModel);

		assertEquals(listUser.size(), 1);
	}
}
