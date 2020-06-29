package controllers;

import java.util.ArrayList;
import java.util.List;

import models.AdministratorModel;
import models.QuestionModel;
import models.StudentModel;
import models.TeacherModel;
import models.TestBaseModel;
import models.TestModel;
import models.UserBaseModel;
import models.UserModel;

/**
 * Represents a server controller.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class ServerController {

	// private UserBaseModel userBaseModel;

	private TestBaseModel testBaseModel;
	private UserBaseModel userBaseModel;

	/**
	 * Creates a ServerController.
	 */
	public ServerController() {
		testBaseModel = new TestBaseModel();
		userBaseModel = new UserBaseModel();
		// userBaseController = new UserBaseController(userBaseModel);

		loadTest();
	}

	/**
	 * login function.
	 * 
	 * @param username The user's username.
	 * @param password The user's password.
	 * @return User The authenticated user.
	 */
	public UserModel login(String username, String password) {
		return new UserBaseController(userBaseModel).getUser(username, password);
	}

	/**
	 * Gets tests for student.
	 * 
	 * @param student The student.
	 * @return List<Test> The list tests.
	 */
	public List<TestModel> getTestsForStudent(UserModel student) {
		return new StudentController(student).getTests(testBaseModel);
	}

	/**
	 * Gets student test information.
	 * 
	 * @param student   The student's model.
	 * @param indexTest The test index.
	 * @return The test's model.
	 */
	public TestModel getTestInfoForStudent(UserModel student, int indexTest) {
		return new StudentController(student).getTestInfo(indexTest, testBaseModel);
	}

	/**
	 * Gets student test number questions.
	 * 
	 * @param student   The student.
	 * @param indexTest The test index.
	 * @return The test.
	 */
	public int getNumberQuestionsInTest(UserModel student, int indexTest) {
		return new StudentController(student).getNumberQuestionsInTest(indexTest,
				testBaseModel);
	}

	/**
	 * Gets tests for teacher.
	 * 
	 * @param teacher The teacher.
	 * @return List<Test> The list tests.
	 */
	public List<TestModel> getTestsForTeacher(UserModel teacher) {
		return new TeacherController(teacher).getTests(testBaseModel);
	}

	/**
	 * Gets students test result.
	 * 
	 * @param teacher   The teacher.
	 * @param indexTest The test index.
	 * @return Test The test.
	 */
	public TestModel getTestResultForTeacher(UserModel teacher, int indexTest) {
		return new TeacherController(teacher).getTestResultForTeacher(indexTest, testBaseModel);
	}

	/**
	 * Gets users.
	 * 
	 * @return List<User> The list all users.
	 */
	public List<UserModel> getAllUsersForAdmin(UserModel adminModel) {
		return new AdministratorController(adminModel)
				.getUsers(new UserBaseController(userBaseModel).getUserBaseModel());
	}

	/**
	 * Gets students.
	 * 
	 * @return List<User> The list students.
	 */
	public List<UserModel> getStudentsForAdmin(UserModel adminModel) {
		return new AdministratorController(adminModel).getUsersByType(StudentModel.nameModel, userBaseModel);
	}

	/**
	 * Gets teachers.
	 * 
	 * @return List<User> The list teachers.
	 */
	public List<UserModel> getTeachersForAdmin(UserModel adminModel) {
		return new AdministratorController(adminModel).getUsersByType(TeacherModel.nameModel, userBaseModel);
	}

	/**
	 * Gets administrators.
	 * 
	 * @return List<User> The list administrators.
	 */
	public List<UserModel> getAdminsForAdmin(UserModel adminModel) {
		return new AdministratorController(adminModel).getUsersByType(AdministratorModel.nameModel, userBaseModel);
	}

	private void loadTest() {
		// BEGIN DATA FOR TEST
		UserBaseController userBaseController=new UserBaseController(userBaseModel);
		UserModel admin1 = new AdministratorModel("Примарев", "Игорь", this, "Admin1", "0000");
		userBaseController.addUser(admin1);

		UserModel teacher1 = new TeacherModel("Киров", "Антон", this, "KirovAnton", "12345678");
		userBaseController.addUser(teacher1);

		TestModel test1 = new TestModel("Робототехника", teacher1);
		TestModel test2 = new TestModel("Сетевые технологии", teacher1);
		TestModel test3 = new TestModel("Информатика", teacher1);

		QuestionModel q1 = new QuestionModel("Основы роботетхники");
		QuestionModel q2 = new QuestionModel("AI");
		QuestionModel q3 = new QuestionModel("Микроконтроллеры");

		TestController testController = new TestController(test1);
		testController.addQuestion(q1);
		testController.addQuestion(q2);
		testController.addQuestion(q3);

		QuestionModel q4 = new QuestionModel("Протокол HTTP");
		QuestionModel q5 = new QuestionModel("Характеристика OSI");
		QuestionModel q6 = new QuestionModel("Протокол TCP");

		testController.setTestModel(test2);

		testController.addQuestion(q3);
		testController.addQuestion(q4);
		testController.addQuestion(q5);
		testController.addQuestion(q6);

		List<TestModel> tests = new ArrayList<TestModel>();

		tests.add(test1);
		tests.add(test2);
		tests.add(test3);

		//TestBaseController testBaseController=new TestBaseController(testBaseModel);
		new TestBaseController(testBaseModel).addTests(tests);
		//testBaseController.addTests(tests);

		UserModel student1 = new StudentModel("Шахматов", "Антон", this, "ShAnton", "1111");
		UserModel student2 = new StudentModel("Романенко", "Егор", this, "REgor", "1111");

		userBaseController.addUser(student1);
		userBaseController.addUser(student2);

		testController.setTestModel(test1);

		testController.addStudent(student1);
		testController.addStudent(student2);

		testController.addResult(student1, 4);
		testController.addResult(student2, 2);

		testController.setTestModel(test2);

		testController.addStudent(student1);
		testController.addResult(student1, 5);

		// END DATA FOR TEST
	}

}
