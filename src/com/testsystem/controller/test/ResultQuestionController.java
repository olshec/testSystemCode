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

	private ResultQuestion resultQuestion;
	/**
	 * 
	 */
	public ResultQuestionController() {
		super();
	}

	/**
	 * @param resultQuestion
	 */
	public ResultQuestionController(ResultQuestion resultQuestion) {
		super();
		this.resultQuestion = resultQuestion;
	}

	/**
	 * @return the resultQuestion
	 */
	public ResultQuestion getResultQuestion() {
		return resultQuestion;
	}

	/**
	 * @param resultQuestion the resultQuestion to set
	 */
	public void setResultQuestion(ResultQuestion resultQuestion) {
		this.resultQuestion = resultQuestion;
	}
	
	/**
	 * Checks questions.
	 * 
	 * @param student
	 * @param test
	 */
	public ResultTest checkQuestions(User student, Test test) {
		List<ResultQuestion> resultQuestion = checkAnswers(test);
		final double maxPercentTrueQuestion = 100;
		int countQuestion = resultQuestion.size();
		double percentPointOneQuestion = maxPercentTrueQuestion / countQuestion;

		double percentTrueQuestions = 0;
		int numberCorrectQuestion = 0;
		int numberNotCorrectQuestion = 0;
		int numberPartlyQuestion = 0;
		for (int i = 0; i < resultQuestion.size(); i++) {
			double percentCorrectAnswers = resultQuestion.get(i).getPercentCorrectAnswers();
			if(percentCorrectAnswers == 0) {
				numberNotCorrectQuestion++;
			} else if (percentCorrectAnswers < maxPercentTrueQuestion) {
				percentTrueQuestions += percentPointOneQuestion * (percentCorrectAnswers/100);
				numberPartlyQuestion++;
			} else {
				numberCorrectQuestion++;
				percentTrueQuestions += percentPointOneQuestion;
			}
		}
		
		ResultTest resultTest = null;
		if (numberNotCorrectQuestion > 0 || numberPartlyQuestion > 0) {
			resultTest = new ResultTest(numberCorrectQuestion, numberNotCorrectQuestion, numberPartlyQuestion,
					(int)percentTrueQuestions, student, test, resultQuestion);
		} else if (percentTrueQuestions <= 0) {
			resultTest = new ResultTest(0, numberNotCorrectQuestion, 0,
					0, student, test, resultQuestion);
		} else {
			resultTest = new ResultTest(numberCorrectQuestion, 0, 0,
					(int)maxPercentTrueQuestion, student, test, resultQuestion);
		}
		return resultTest;
	}

	//Checks answers
	private List<ResultQuestion> checkAnswers(Test test) {
		List<ResultQuestion> resultQuestions = new ArrayList<>();
		List<Question> userQuestions = test.getQuestions();
		Test sourceTest = ServiceLocator.getDaoProvider()
				.getTest(test);
		List<Question> sourceQuestions = sourceTest.getQuestions();
		for(int i = 0; i < sourceQuestions.size(); i++) {
			Question userQuestion = userQuestions.get(i);
			List<Answer> userAnswers = userQuestion.getAnswers();
			List<Answer> sourceAnswers = sourceQuestions.get(i).getAnswers();
			ResultQuestion resultQuestion = checkAnswers(userAnswers, sourceAnswers);
			resultQuestions.add(resultQuestion);
		}
		return resultQuestions;
	}
	
	/**
	 * Checks answers.
	 * 
	 * @param userQuestion
	 * @param sourceQuestion
	 */
	public ResultQuestion checkAnswers(List<Answer> userAnswers, List<Answer> sourceAnswers) {
		final int maxPercentTrueAnswer = 100;
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
		this.resultQuestion = new ResultQuestion();
		if(!hasChecked) {
			setOptionsCorrectAnswer(resultQuestion, 0, 0, 0, StateQuestion.Skipped);
		} else if (countTrueAnswer == 0) {
			setOptionsCorrectAnswer(resultQuestion, 0, 0, countNotTrueAnswer, StateQuestion.Incorrect);
		} else if (countNotTrueAnswer > 0 && countTrueAnswer > 0) {
			percentTrueAnswers = (percentTrueAnswers < 0? 0 : percentTrueAnswers);
			setOptionsCorrectAnswer(resultQuestion, (int)percentTrueAnswers, countTrueAnswer, countNotTrueAnswer,  StateQuestion.Partly);
		}  else {
			setOptionsCorrectAnswer(resultQuestion, maxPercentTrueAnswer, countTrueAnswer, countNotTrueAnswer, StateQuestion.Correct);
		}
		return resultQuestion;
	}
	
	/*
	 * Sets options for answers.
	 * 
	 * @param resultQuestion        result of answers
	 * @param maxPercentTrueAnswer double
	 * @param countTrueAnswer      int
	 * @param countNotTrueAnswer   int
	 * @param state   StateQuestion
	 */
	private void setOptionsCorrectAnswer(ResultQuestion resultQuestion, int percentTrueAnswer, int countTrueAnswer,
			int countNotTrueAnswer, StateQuestion state) {
		resultQuestion.setPercentCorrectAnswers(percentTrueAnswer);
		resultQuestion.setNumberCorrectAnswers(countTrueAnswer);
		resultQuestion.setNumberNotCorrectAnswer(countNotTrueAnswer);
		resultQuestion.setState(state);
	}
	
}
