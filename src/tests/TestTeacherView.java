package tests;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;

import com.testsystem.model.test.ResultTest;
import com.testsystem.model.user.User;
import tests.stubs.TestFrontController;

public class TestTeacherView {

	private TestFrontController frontController;
	private User teacher1;
	private List<com.testsystem.model.test.Test> listTest;

	public TestTeacherView() {
		loadData();
	}

	public void loadData() {
		frontController = new TestFrontController();
		this.teacher1 = frontController.login("KirovAnton", "12345678");
		listTest = frontController.getTestsForTeacher(teacher1);
	}

	// Check number tests in database.
	@Test
	public void testCountTest() {
		assertEquals(listTest.size(), 3);
	}

//	// Check number answers in database.
//	@Test
//	public void testCountAnswers() {
//
//		List<ResultTest> listResult = frontController.getTestResultForTeacher(teacher1, listTest.get(0).getId());
//		assertEquals(listResult.size(), 4);
//
//		listResult = frontController.getTestResultForTeacher(teacher1, listTest.get(1).getId());
//		assertEquals(listResult.size(), 5);
//
//		listResult = frontController.getTestResultForTeacher(teacher1, listTest.get(2).getId());
//		assertEquals(listResult.size(), 5);
//	}

}
