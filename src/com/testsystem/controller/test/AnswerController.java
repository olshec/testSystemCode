package com.testsystem.controller.test;

import java.util.List;

import com.testsystem.model.test.Answer;

public class AnswerController {

	public int getCountCorrectAnswers(List<Answer> sourceAnswers) {
		int count = 0;
		for (Answer a : sourceAnswers) {
			if(a.isCorrect()) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Checks answer.
	 * 
	 * @param user   answer
	 * @param source answer
	 */
	public boolean checkAnswer(Answer userAnswer, Answer sourceAnswer) {
		if (sourceAnswer.isCorrect() == true && userAnswer.isChecked() == true) {
			return true;
		} 
		return false;
	}
	


}
