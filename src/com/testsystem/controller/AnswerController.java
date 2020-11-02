package com.testsystem.controller;

import java.util.List;

import com.testsystem.model.test.Answer;
import com.testsystem.model.test.ResultQuestion;

public class AnswerController{

	/**
	 * Checks answers.
	 * 
	 * @param userQuestion
	 * @param sourceQuestion
	 */
	public void checkAnswers(List<Answer> userAnswers, List<Answer> sourceAnswers) {
		int countAnswer = sourceAnswers.size();
		double maxPointAnswer = 100;
		double pointOneAnswer = maxPointAnswer / countAnswer;
		double points = 0;
		ResultQuestion resultQuestion = new ResultQuestion();
		boolean hasInCorrectAnswer = false;
		for(int i = 0; i< sourceAnswers.size(); i++) {
			Answer userAnswer = userAnswers.get(i);
			Answer sourceAnswer = sourceAnswers.get(i);
			boolean result = checkAnswer(userAnswer, sourceAnswer);
			if(result==false) {
				hasInCorrectAnswer = true;
				points-=pointOneAnswer;
			}
			else {
				points+=pointOneAnswer;
			}
		}
		if(hasInCorrectAnswer) {
			points = maxPointAnswer;
			resultQuestion.setPercentCorrectAnswers(100);
			resultQuestion.setNumberCorrectAnswers(countAnswer);
		}
		else {
			
		}
	}
	
	/**
	 * Checks answer.
	 * 
	 * @param user answer
	 * @param source answer
	 */
	private boolean checkAnswer(Answer userAnswer, Answer sourceAnswer) {
		if(sourceAnswer.isCorrect() == true && userAnswer.getChecked() == true) {
			return true;
		}
		else if(sourceAnswer.isCorrect() == false && userAnswer.getChecked() == false) {
			return true;
		}
		return false;
	}
	
}
