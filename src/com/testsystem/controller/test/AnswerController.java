package com.testsystem.controller.test;

import java.util.List;

import com.testsystem.model.test.Answer;
import com.testsystem.model.test.ResultAnswers;
import com.testsystem.model.test.ResultQuestion;

public class AnswerController {

	/**
	 * Checks answers.
	 * 
	 * @param userQuestion
	 * @param sourceQuestion
	 */
	public ResultAnswers checkAnswers(List<Answer> userAnswers, List<Answer> sourceAnswers) {
		final double maxPercentTrueAnswer = 100;
		int countCorrectAnswers = getCountCorrectAnswers(sourceAnswers);
		double percentPointOneAnswer = maxPercentTrueAnswer / countCorrectAnswers;
		double percentTrueAnswers = 0;
		int countTrueAnswer = 0;
		int countNotTrueAnswer = 0;
		ResultAnswers resultAnswers = new ResultAnswers(userAnswers);
		boolean hasIncorrectAnswer = false;
		for (int i = 0; i < sourceAnswers.size(); i++) {
			Answer userAnswer = userAnswers.get(i);
			if(userAnswer.isCorrect() || userAnswer.isChecked()) {
				Answer sourceAnswer = sourceAnswers.get(i);
				boolean result = checkAnswer(userAnswer, sourceAnswer);
				if (result == false) {
					hasIncorrectAnswer = true;
					//percentTrueAnswers -= percentPointOneAnswer;
					countNotTrueAnswer++;
				} else {
					countTrueAnswer++;
					percentTrueAnswers += percentPointOneAnswer;
				}
			}
		}
		if (hasIncorrectAnswer) {
			setOptionsCorrectAnswer(resultAnswers, percentTrueAnswers, countTrueAnswer, countNotTrueAnswer);
		} else if (countTrueAnswer <= 0) {
			setOptionsCorrectAnswer(resultAnswers, 0, 0, countNotTrueAnswer);
		} else {
			setOptionsCorrectAnswer(resultAnswers, maxPercentTrueAnswer, countTrueAnswer, countNotTrueAnswer);
		}
		return resultAnswers;
	}

	/**
	 * Checks answer.
	 * 
	 * @param user   answer
	 * @param source answer
	 */
	private boolean checkAnswer(Answer userAnswer, Answer sourceAnswer) {
		if (sourceAnswer.isCorrect() == true && userAnswer.isChecked() == true) {
			return true;
		} 
		return false;
	}
	
	private int getCountCorrectAnswers(List<Answer> sourceAnswers) {
		int count = 0;
		for (Answer a : sourceAnswers) {
			if(a.isCorrect()) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Sets options for answers.
	 * 
	 * @param resultAnswers        result of answers
	 * @param maxPercentTrueAnswer double
	 * @param countTrueAnswer      int
	 * @param countNotTrueAnswer   int
	 */
	private void setOptionsCorrectAnswer(ResultAnswers resultAnswers, double maxPercentTrueAnswer, int countTrueAnswer,
			int countNotTrueAnswer) {
		resultAnswers.setPercentCorrectAnswers(maxPercentTrueAnswer);
		resultAnswers.setNumberCorrectAnswers(countTrueAnswer);
		resultAnswers.setNumberNotCorrectAnswer(countNotTrueAnswer);
	}

}
