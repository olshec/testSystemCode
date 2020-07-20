package com.testsystem.controller;

import java.util.HashMap;
import java.util.List;

import com.testsystem.models.Group;
import com.testsystem.models.Student;
import com.testsystem.models.TestBase;
import com.testsystem.models.User;
import com.testsystem.models.UserBase;

/**
 * Represents a RatingCalculator.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class RatingCalculator {

	/**
	 * Creates a RatingCalculator.
	 */
	private RatingCalculator() {
	}

	/**
	 * Gets rating for student. 
	 * Rating of student = (count*100/(count question*5))/10.
	 * 
	 * @param student 	the student
	 * @param testBase 	the database of test
	 * @return int 		the rating of student
	 */
	public static int getRatingStudent(User student, TestBase testBase) {
		int count = 0;
		for (int i = 0; i < testBase.getTests().size(); i++) {
			count += testBase.getTests().get(i).getStudentResult(student);
		}
		int rating = count * 2 / testBase.getTests().size();
		return rating;
	}
	
	/**
	 * Gets rating for group. 
	 * Rating of student = (count*100/(count question*5))/10.
	 * 
	 * @param student	the student
	 * @param testBase 	the database of test
	 * @return int 		the rating of student
	 */
	public static HashMap<User, Integer> getRatingGroup(Group group, TestBase testBase, UserBase userBase) {
		UserBaseController userBaseController=new UserBaseController(userBase);
		List<User> listUser = userBaseController.getUsersByType(Student.nameModel);
		HashMap<User, Integer> groupRating=new HashMap<User, Integer>();
		for(int i=0;i<listUser.size();i++) {
			User user=listUser.get(i);
			StudentController studentController=new StudentController(user);
		    if(group == studentController.getGroup()) {
		    	
		    }
		    	
		}
		
		
//		int count = 0;
//		for (int i = 0; i < testBase.getTests().size(); i++) {
//			//count += testBase.getTests().get(i).getStudentResult(student);
//		}
//		int rating = count * 2 / testBase.getTests().size();
		return new HashMap<User, Integer>();
	}
}
