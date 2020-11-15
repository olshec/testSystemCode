package com.testsystem.controller.test;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.test.Answer;
import com.testsystem.model.test.Question;
import com.testsystem.model.test.ResultQuestion;
import com.testsystem.model.test.ResultQuestion.StateQuestion;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

public class ResultQuestionController {

	/**
	 * 
	 */
	public ResultQuestionController() {
		super();
	}
	
	/**
	 * Checks questions
	 * 
	 * @param test
	 * @return List<ResultQuestion>
	 */
	public List<ResultQuestion> checkQuestions(Test test) {
		List<ResultQuestion> resultQuestions = new ArrayList<>();
		List<Question> userQuestions = test.getQuestions();
		Test sourceTest = ServiceLocator.getDaoProvider()
				.getTest(test);
		List<Question> sourceQuestions = sourceTest.getQuestions();
		for(int i = 0; i < sourceQuestions.size(); i++) {
			ResultQuestion resultQuestion = checkAnswers(userQuestions.get(i), sourceQuestions.get(i));
			resultQuestions.add(resultQuestion);
		}
		return resultQuestions;
	}
	
	/*
	 * Checks answers.
	 * 
	 * @param userQuestion
	 * @param sourceQuestion
	 * @return ResultQuestion
	 */
	private ResultQuestion checkAnswers(Question questionUser, Question questionSource) {
		final int maxPercentTrueAnswer = 100;
		List<Answer> userAnswers = questionUser.getAnswers();
		List<Answer> sourceAnswers = questionSource.getAnswers();
		int countCorrectAnswers = new AnswerController().getCountCorrectAnswers(sourceAnswers);
		double percentPointOneAnswer = maxPercentTrueAnswer / countCorrectAnswers;
		double percentTrueAnswers = 100;
		int countTrueAnswer = 0;
		int countNotTrueAnswer = 0;
		//boolean hasIncorrectAnswer = false;
		boolean hasChecked = false;
		for (int i = 0; i < sourceAnswers.size(); i++) {
			Answer userAnswer = userAnswers.get(i);
			Answer sourceAnswer = sourceAnswers.get(i);
			if (userAnswer.isChecked() && sourceAnswer.isCorrect()) {
				hasChecked = true;		
				countTrueAnswer++;
			} else if(!userAnswer.isChecked() && sourceAnswer.isCorrect()) {
				percentTrueAnswers -= percentPointOneAnswer;
				countNotTrueAnswer++;
			} else if (userAnswer.isChecked() && !sourceAnswer.isCorrect()) {
				hasChecked = true;
				percentTrueAnswers -= percentPointOneAnswer;
				countNotTrueAnswer++;
			}
		}
		
		ResultQuestion resultQuestion = null;
		if(!hasChecked) {
			resultQuestion = new ResultQuestion(0, 0, 0, questionUser, StateQuestion.Skipped);
		} else if (countTrueAnswer == 0) {
			resultQuestion = new ResultQuestion(0, 0, countNotTrueAnswer, questionUser,StateQuestion.Incorrect);
		} else if (countNotTrueAnswer > 0 && countTrueAnswer > 0) {
			percentTrueAnswers = (percentTrueAnswers < 0? 0 : percentTrueAnswers);
			resultQuestion = new ResultQuestion((int)percentTrueAnswers, countTrueAnswer, countNotTrueAnswer, questionUser, StateQuestion.Partly);
		}  else {
			resultQuestion = new ResultQuestion((int)maxPercentTrueAnswer, countTrueAnswer, countNotTrueAnswer, questionUser, StateQuestion.Correct);
		}
		return resultQuestion;
	}
	
}
