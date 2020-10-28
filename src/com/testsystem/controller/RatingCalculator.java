package com.testsystem.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.testsystem.model.Group;
import com.testsystem.model.User;
import com.testsystem.model.test.StudentResultOfTest;
import com.testsystem.model.test.Test;

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
			point += new TestController(test).getStudentTestResult(student, listTest.get(i)).getResult();
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
	public static List<StudentResultOfTest> getRatingGroup(Group group, 
			List<User> listStudent) {
		List<StudentResultOfTest> groupRating = new ArrayList<StudentResultOfTest>();
		for (int i = 0; i < listStudent.size(); i++) {
			User student = listStudent.get(i);
			List<Test> listStudentTests = new TestController().getStudentTests(student);
			int ratingStudent = RatingCalculator.getRatingStudent(student, listStudentTests);
			groupRating.add(new StudentResultOfTest(student, listStudentTests.get(i), ratingStudent));
		}
		groupRating = sortByValue(groupRating);
		return groupRating;
	}

	// function to sort arrayList by values
	private static List<StudentResultOfTest> sortByValue(List<StudentResultOfTest> listStudentResult) {
		Collections.sort(listStudentResult, new Comparator<StudentResultOfTest>() {
			@Override
			public int compare(StudentResultOfTest o1, StudentResultOfTest o2) {
				return (o2.getResult().compareTo(o1.getResult()));
			}
		});

		return listStudentResult;
	}
}
