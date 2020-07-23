package tests;

import static org.junit.Assert.*;
import java.util.HashMap;
import org.junit.Test;
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
		HashMap<User, Integer> ratingGroup = serverController.getRatingGroup("Group 1"); 
		
		User student1 = serverController.login("ShAnton", "1111");
		int rating1 = ratingGroup.get(student1);
		
		User student2 = serverController.login("REgor", "1111");
		int rating2 = ratingGroup.get(student2);
		
		assertEquals(ratingGroup.values().size(), 2);
		assertEquals(rating1, 6);
		assertEquals(rating2, 8);
	}
	
	@Test
	public void testSortRaiting() {
		HashMap<User, Integer> ratingGroup1 = serverController.getRatingGroup("Group 1"); 
		HashMap<User, Integer> ratingGroup2 = serverController.getRatingGroup("Group 2"); 
		
		String lastNameFirstStudentGroup1 =  ((User)ratingGroup1.keySet().toArray()[0]).getLastName();
		String lastNameSecondStudentGroup1 = ((User)ratingGroup1.keySet().toArray()[1]).getLastName();
		String lastNameFirstStudentGroup2 =  ((User)ratingGroup2.keySet().toArray()[0]).getLastName();
		String lastNameSecondStudentGroup2 = ((User)ratingGroup2.keySet().toArray()[1]).getLastName();
		
		assertEquals(lastNameFirstStudentGroup1, "Романенко");
		assertEquals(lastNameSecondStudentGroup1, "Шахматов");
		assertEquals(lastNameFirstStudentGroup2, "Сазонова");
		assertEquals(lastNameSecondStudentGroup2, "Филонова");
	}
}
