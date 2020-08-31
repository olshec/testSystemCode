package tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import com.testsystem.controller.AdministratorController;
import com.testsystem.controller.TeacherController;
import com.testsystem.controller.TestController;
import com.testsystem.model.Administrator;
import com.testsystem.model.Group;
import com.testsystem.model.Model;
import com.testsystem.model.Student;
import com.testsystem.model.Teacher;
import com.testsystem.model.User;
import com.testsystem.util.ServiceLocator;

import tests.mocks.TestFrontController;

public class TestServer {

	TestFrontController frontController;
	User student1;
	User teacher1;
	User admin1;

	public TestServer() {
		loadData();
	}

	public void loadData() {
		frontController = new TestFrontController();
		student1 = frontController.login("ShAnton", "1111");
		teacher1 = frontController.login("KirovAnton", "12345678");
		admin1 = frontController.login("Admin1", "0000");
	}

	@Test
	public void testCountTests() {
		List<com.testsystem.model.Model> listTest = ServiceLocator.getDaoProvider()
				.getRecords(com.testsystem.model.Test.nameModel);	
		
		assertEquals(listTest.size(), 3);
	}

	@Test
	public void testCountUsers() {
		List<Model> listUserAdmin = ServiceLocator.getDaoProvider()
				.getRecords(Administrator.nameModel);
		List<Model> listUserTeacher = ServiceLocator.getDaoProvider()
				.getRecords(Teacher.nameModel);
		List<Model> listUserStudent = ServiceLocator.getDaoProvider()
				.getRecords(Student.nameModel);
		
		int countUsers = listUserAdmin.size() + listUserTeacher.size() +
				listUserStudent.size();
		assertEquals(countUsers, 7);
	}

	@Test
	public void testCountGroups() {
		List<Model> listGroup = ServiceLocator.getDaoProvider()
				.getRecords(Group.nameModel);
		
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
		List<com.testsystem.model.Model> listTest = frontController.getTestsForStudent(student1);
		assertEquals(listTest.size(), 3);
	}

	@Test
	public void testGetTestInfoForStudent() {

		List<Model> modelsTests = frontController.getDaoProvider()
				.getRecords(com.testsystem.model.Test.nameModel);
		com.testsystem.model.Test test1 = (com.testsystem.model.Test)(modelsTests).get(0);
//		List<Model> listGroup = ServiceLocator.getDaoProvider()
//				.getRecordsTable(Group.nameModel);
		TestController testController = new TestController(test1);

		com.testsystem.model.Test test2 = (com.testsystem.model.Test)(modelsTests).get(1);
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
		int countQuestion = frontController.getNumberQuestionsInTest(student1, 0);
		int countQuestion2 = frontController.getNumberQuestionsInTest(student1, 1);

		assertEquals(countQuestion, 3);
		assertEquals(countQuestion2, 4);
	}

	@Test
	public void testGetTestsForTeacher() {
		List<com.testsystem.model.Test> listTest = (new TeacherController(teacher1)).getTests();

		assertEquals(listTest.size(), 3);
	}

	@Test
	public void testGetAllUsersForAdmin() {
		List<Model> listUser = new AdministratorController(admin1).getAllUsers();

		assertEquals(listUser.size(), 7);
	}

	@Test
	public void testGetStudentsForAdmin() {
		List<Model> listUser = new AdministratorController(admin1)
				.getUsersByType(Student.nameModel);

		assertEquals(listUser.size(), 5);
	}

	@Test
	public void testGetTeachersForAdmin() {
		List<Model> listUser = new AdministratorController(admin1)
				.getUsersByType(Teacher.nameModel);

		assertEquals(listUser.size(), 1);
	}

	@Test
	public void testGetAdminsForAdmin() {
		List<Model> listUser = new AdministratorController(admin1)
				.getUsersByType(Administrator.nameModel);

		assertEquals(listUser.size(), 1);
	}
}
