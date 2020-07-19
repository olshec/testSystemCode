package com.testsystem.controller;

import java.util.List;

import com.testsystem.models.StudentTest;

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

	public static int getRating(StudentTest studentTest) {
		if (studentTest == null) {
			return 0;
		} if (studentTest.getListAnswers()==null) {
			return 0;
		} else {
			List<List<Integer>> listAnswers=studentTest.getListAnswers();
			
		}
		
			
		
		return 0;
	}

}
