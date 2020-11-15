package com.testsystem.controller.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.testsystem.controller.user.GroupController;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.Group;
import com.testsystem.model.user.User;

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
	public static int getRatingStudent(User student, List<Test> listTest) {
		int point = 0;
		for (int i = 0; i < listTest.size(); i++) {
			Test test = listTest.get(i);
			ResultTest testResult = new TestController(test).getStudentTestResult(student, listTest.get(i));
			point += testResult.getPercentCorrectQuestions();
		}
		int rating = point * 2 / listTest.size();
		return rating;
	}

	/**
	 * Gets rating for group.
	 * 
	 * @param group  the Group
	 * @return List<ResultTest> the rating of student
	 */
	public static List<ResultTest> getRatingGroup(Group group) {
		List<User> listStudent = new GroupController()
		.getStudentsByGroup(group);
		List<ResultTest> groupRating = new ArrayList<ResultTest>();
		for (int i = 0; i < listStudent.size(); i++) {
			User student = listStudent.get(i);
			List<Test> listStudentTests = new TestController().getStudentTests(student);
			int ratingStudent = RatingCalculator.getRatingStudent(student, listStudentTests);
			groupRating.add(new ResultTest(student, listStudentTests.get(i), ratingStudent));
		}
		groupRating = sortByValue(groupRating);
		return groupRating;
	}

	// function to sort arrayList by values
	private static List<ResultTest> sortByValue(List<ResultTest> listStudentResult) {
		Collections.sort(listStudentResult, new Comparator<ResultTest>() {
			@Override
			public int compare(ResultTest result1, ResultTest result2) {
				int pointsResult1 = result1.getPercentCorrectQuestions();
				int pointsResult2 = result2.getPercentCorrectQuestions();
				if(pointsResult2>pointsResult1) {
					return 1;
				} else if (pointsResult2==pointsResult1) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		return listStudentResult;
	}
}
