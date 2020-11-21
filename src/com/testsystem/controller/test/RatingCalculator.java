package com.testsystem.controller.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.testsystem.controller.user.GroupController;
import com.testsystem.model.test.RatingStudent;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.Group;
import com.testsystem.model.user.Student;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

/**
 * Represents a RatingCalculator.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class RatingCalculator {

	/**
	 * Gets rating for student. Max_range = 10. Max_point = count_question * 5. Rating
	 * of student = (point*100/(count_question*Max_point))/Max_range =
	 * (point*2/(count_question)).
	 * 
	 * @param student  the student
	 * @param listTest the list of test
	 * @return int the rating of student
	 */
	public RatingStudent getRatingStudent(User student) {
		List<Test> listTest = ServiceLocator.getDaoProvider()
				.getTestsRecords(new Test().getNameModel());
		int point = 0;
		int countTest = 0;
		TestController testController = new TestController();
		for (int i = 0; i < listTest.size(); i++) {
			List<ResultTest> listResultTest = testController.getStudentTestResult(student, listTest.get(i));
			for (ResultTest resultTest : listResultTest) {
				point += resultTest.getPoints();
				countTest++;
			}
		}
		int rating = 0;
		if(countTest>0) {
			rating = point * 2 / countTest;
		}
		
		return new RatingStudent(student, rating, countTest);
	}

	/**
	 * Gets rating for group.
	 * 
	 * @param group  the Group
	 * @return List<ResultTest> the rating of student
	 */
	public List<ResultTest> getRatingGroup(Group group) {
		List<User> listStudent = new GroupController()
		.getStudentsByGroup(group);
		List<ResultTest> groupRating = new ArrayList<ResultTest>();
		for (int i = 0; i < listStudent.size(); i++) {
			User student = listStudent.get(i);
			RatingStudent ratingStudent = this.getRatingStudent(student);
			//int ratingStudent 
			groupRating.add(new ResultTest(student, ratingStudent.getPoints()));
		}
		groupRating = sortByValue(groupRating);
		return groupRating;
	}

	// function to sort arrayList by values
	private static List<ResultTest> sortByValue(List<ResultTest> listStudentResult) {
		Collections.sort(listStudentResult, new Comparator<ResultTest>() {
			@Override
			public int compare(ResultTest result1, ResultTest result2) {
				double pointsResult1 = result1.getPoints();
				double pointsResult2 = result2.getPoints();
				if(pointsResult2>pointsResult1) {
					return 1;
				} else if (pointsResult2==pointsResult1) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		return listStudentResult;
	}
	
	/**
	 * Updates rating student.
	 * 
	 * @param student
	 * @param resultTest
	 */
	public void updateRatingStudent(ResultTest resultTest) {
		ServiceLocator.getDaoProvider().addRecord(resultTest);
		boolean b = false;
		if(resultTest.getStudent().getUserName() == "Anna") {
			b=true;
		}
		RatingStudent ratingStudent = this.getRatingStudent(resultTest.getStudent());
		ServiceLocator.getDaoProvider().updateRatingStudent(ratingStudent);
	}
}
