package tests;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;

import com.testsystem.models.StudentTestResult;
import com.testsystem.models.User;
import tests.mocks.Server;

public class TestRaitingCalculator {

	Server serverController;
	
	public TestRaitingCalculator() {
		loadData();
	}

	public void loadData() {
		serverController = new Server();
	}
	
	@Test
	public void testGetRatingUser() {
		User student1 = serverController.login("ShAnton", "1111");
		int rating1 = serverController.getRatingUser(student1);

		assertEquals(rating1, 6);
	}

	@Test
	public void testGetRatingGroup() {
		List<StudentTestResult> ratingGroup = serverController.getRatingGroup("Group 1"); 
		
		int rating1 = ratingGroup.get(0).getResult();
		int rating2 = ratingGroup.get(1).getResult();
		
		assertEquals(ratingGroup.size(), 2);
		assertEquals(rating1, 8);
		assertEquals(rating2, 6);
	}
	
	@Test
	public void testSortRaiting() {
		List<StudentTestResult> ratingGroup1 = serverController.getRatingGroup("Group 1"); 
		List<StudentTestResult> ratingGroup2 = serverController.getRatingGroup("Group 2"); 
		
		String lastNameFirstStudentGroup1 =  ratingGroup1.get(0).getStudent().getLastName();
		String lastNameSecondStudentGroup1 = ratingGroup1.get(1).getStudent().getLastName();
		String lastNameFirstStudentGroup2 =  ratingGroup2.get(0).getStudent().getLastName();
		String lastNameSecondStudentGroup2 = ratingGroup2.get(1).getStudent().getLastName();
		
		assertEquals(lastNameFirstStudentGroup1, "Романенко");
		assertEquals(lastNameSecondStudentGroup1, "Шахматов");
		assertEquals(lastNameFirstStudentGroup2, "Сазонова");
		assertEquals(lastNameSecondStudentGroup2, "Филонова");
	}
}
