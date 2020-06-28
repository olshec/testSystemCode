package controllers;

import java.util.ArrayList;
import java.util.List;

import models.AdministratorModel;
import models.QuestionModel;
import models.StudentModel;
import models.TeacherModel;
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

	//private UserBaseModel userBaseModel;
	
	private TestBaseController testBaseController;
	private UserBaseController userBaseController;
	
	/** Creates a ServerController.
	 */
	public ServerController() {
		testBaseController = new TestBaseController();
		UserBaseModel userBaseModel = new UserBaseModel();
		userBaseController = new UserBaseController(userBaseModel);
		
		loadTest();
	}

	/** login function.
	 * @param username The user's username.
	 * @param password The user's password.
	 * @return User The authenticated user.
	*/
	public UserModel login(String username, String password) {
		return userBaseController.getUser(username, password);
	}

	/** Gets tests for student.
	 * @param student The student.
	 * @return List<Test> The list tests.
	*/
	public List<TestModel> getTestsForStudent(UserModel student) {
		return testBaseController.getTestsStudent(student);
	}

	/** Gets student test information.
	 * @param student The student's model.
	 * @param  indexTest The test index.
	 * @return The test's model.
	*/
	public TestModel getTestInfoForStudent(UserModel student, int indexTest) {
		return testBaseController.getTestInfoForStudent(student, indexTest);
	}

	
	/** Gets student test number questions.
	 * @param student The student.
	 * @param indexTest The test index.
	 * @return The test.
	 * @throws Exception 
	*/
	public int getNumberQuestionsInTest(UserModel student, int indexTest) {
		return testBaseController.getNumberQuestionsInTest(student, indexTest);
	}
	
	/** Gets tests for teacher.
	 * @param teacher The teacher.
	 * @return List<Test> The list tests.
	*/
	public List<TestModel> getTestsForTeacher(UserModel teacher) {
		return testBaseController.getTests(teacher);
	}

	/** Gets students test result.
	 * @param teacher The teacher.
	 * @param indexTest The test index.
	 * @return Test The test.
	*/
	public TestModel getTestResultForTeacher(UserModel teacher, int indexTest) {
		if(indexTest<testBaseController.getTests(teacher).size()) {
			return testBaseController.getTests(teacher).get(indexTest);
		}
		return null;
	}

	/** Gets users.
	 * @return List<User> The list all users.
	*/
	public List<UserModel> getAllUsersForAdmin() {
		return userBaseController.getUserBaseModel().getUsers();
	}

	/** Gets students.
	 * @return List<User> The list students.
	*/
	public List<UserModel> getStudentsForAdmin() {
		return userBaseController.getUsersByType(StudentModel.nameModel);
	}

	/** Gets teachers.
	 * @return List<User> The list teachers.
	*/
	public List<UserModel> getTeachersForAdmin() {
		return userBaseController.getUsersByType(TeacherModel.nameModel);
	}

	/** Gets administrators.
	 * @return List<User> The list administrators.
	*/
	public List<UserModel> getAdminsForAdmin() {
		return userBaseController.getUsersByType(AdministratorModel.nameModel);
	}
	
	

	private void loadTest() {
		// BEGIN DATA FOR TEST

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

				TestController testController=new TestController(test1);
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
				
				testBaseController.addTests(tests);

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
