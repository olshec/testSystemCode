package tests;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;

import com.testsystem.model.test.StudentResultOfTest;
import com.testsystem.model.user.User;

import tests.stubs.TestFrontController;

public class TestRaitingCalculator {

	TestFrontController frontController;
	
	public TestRaitingCalculator() {
		loadData();
	}

	public void loadData() {
		frontController = new TestFrontController();
	}
	
	@Test
	public void testGetRatingUser() {
		User student1 = frontController.login("ShAnton", "1111");
		int rating1 = frontController.getRatingUser(student1);

		assertEquals(rating1, 6);
	}

	@Test
	public void testGetRatingGroup() {
		List<StudentResultOfTest> ratingGroup = frontController.getRatingGroup("Group 1"); 
		
		int rating1 = ratingGroup.get(0).getResult(); //"Романенко", "Егор"
		int rating2 = ratingGroup.get(1).getResult();//"Шахматов", "Антон"
		int rating3 = ratingGroup.get(2).getResult();//"Федоренко"
		
		assertEquals(ratingGroup.size(), 3);
		assertEquals(rating1, 8);
		assertEquals(rating2, 6);
		assertEquals(rating3, 5);
		assertEquals(ratingGroup.get(0).getStudent().getLastName(), "Романенко");
		assertEquals(ratingGroup.get(1).getStudent().getLastName(), "Шахматов");
		assertEquals(ratingGroup.get(2).getStudent().getLastName(), "Федоренко");
	}
	
	@Test
	public void testSortRaiting() {
		List<StudentResultOfTest> ratingGroup1 = frontController.getRatingGroup("Group 1"); 
		List<StudentResultOfTest> ratingGroup2 = frontController.getRatingGroup("Group 2"); 
		
		String lastNameFirstStudentGroup1 =  ratingGroup1.get(0).getStudent().getLastName();
		String lastNameSecondStudentGroup1 = ratingGroup1.get(1).getStudent().getLastName();
		String lastNameFirstStudentGroup2 =  ratingGroup2.get(0).getStudent().getLastName();
		String lastNameSecondStudentGroup2 = ratingGroup2.get(1).getStudent().getLastName();
		
		assertEquals(lastNameFirstStudentGroup1, "Романенко");
		assertEquals(lastNameSecondStudentGroup1, "Шахматов");
		assertEquals(lastNameFirstStudentGroup2, "Сазонова");
		assertEquals(lastNameSecondStudentGroup2, "Фролова");
	}
}
