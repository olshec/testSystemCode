package com.testsystem.controller.test;

import java.util.List;

import com.testsystem.model.test.Answer;

public class AnswerController {

	/**
	 * Returns count of correct answers.
	 * 
	 * @param List<Answer> the list of answers
	 * @return int the count of  correct answers
	 */
	public int getCountCorrectAnswers(List<Answer> sourceAnswers) {
		int count = 0;
		for (Answer a : sourceAnswers) {
			if(a.isCorrect()) {
				count++;
			}
		}
		return count;
	}
	
}
