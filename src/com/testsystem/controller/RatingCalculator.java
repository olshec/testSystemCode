package com.testsystem.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.testsystem.models.Group;
import com.testsystem.models.Model;
import com.testsystem.models.StudentTestResult;
import com.testsystem.models.Test;
import com.testsystem.models.User;
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
	public static int getRatingStudent(User student, List<Model> listTest) {
		int point = 0;
		for (int i = 0; i < listTest.size(); i++) {
			Test test = (Test)listTest.get(i);
			point += ServiceLocator.getTestController(test).getStudentResult(student).getResult();
		}
		int rating = point * 2 / listTest.size();
		return rating;
	}

	/**
	 * Gets rating for group.
	 * 
	 * @param student  the student
	 * @param testBase the database of test
	 * @return HashMap<User, Integer> the rating of student
	 */
	public static List<StudentTestResult> getRatingGroup(Group group, 
			List<User> listStudent) {
		
		List<StudentTestResult> groupRating = new ArrayList<StudentTestResult>();
		for (int i = 0; i < listStudent.size(); i++) {
			User student = listStudent.get(i);
			List<Model> listStudentTests = TestController.getStudentTests(student);
			int ratingStudent = RatingCalculator.getRatingStudent(student, listStudentTests);
			groupRating.add(new StudentTestResult(student, ratingStudent));
		}
		groupRating = sortByValue(groupRating);
		return groupRating;
	}

	// function to sort arrayList by values
	private static List<StudentTestResult> sortByValue(List<StudentTestResult> listStudentResult) {
		Collections.sort(listStudentResult, new Comparator<StudentTestResult>() {
			@Override
			public int compare(StudentTestResult o1, StudentTestResult o2) {
				return (o2.getResult().compareTo(o1.getResult()));
			}
		});

		return listStudentResult;
	}
}
