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
		boolean hasIncorrectQuestion = false;
		for (int i = 0; i < resultQuestion.size(); i++) {
			double percentCorrectAnswers = resultQuestion.get(i).getPercentCorrectAnswers();
			if(percentCorrectAnswers<=0) {
				numberNotCorrectQuestion++;
			}
			if (percentCorrectAnswers<100) {
				hasIncorrectQuestion = true;
				percentTrueQuestions += percentPointOneQuestion * (percentCorrectAnswers/100);
				numberPartlyQuestion++;
			} else {
				numberCorrectQuestion++;
				percentTrueQuestions += percentPointOneQuestion;
			}
		}
		
		ResultTest resultTest = null;
		if (hasIncorrectQuestion) {
			resultTest = new ResultTest(numberCorrectQuestion, numberNotCorrectQuestion, numberPartlyQuestion,
					percentTrueQuestions, student, test, resultQuestion);
		} else if (percentTrueQuestions <= 0) {
			resultTest = new ResultTest(0, numberNotCorrectQuestion, 0,
					0, student, test, resultQuestion);
		} else {
			resultTest = new ResultTest(numberCorrectQuestion, 0, 0,
					maxPercentTrueQuestion, student, test, resultQuestion);
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
		final double maxPercentTrueAnswer = 100;
		int countCorrectAnswers = new AnswerController().getCountCorrectAnswers(sourceAnswers);
		double percentPointOneAnswer = maxPercentTrueAnswer / countCorrectAnswers;
		double percentTrueAnswers = 0;
		int countTrueAnswer = 0;
		int countNotTrueAnswer = 0;
		boolean hasIncorrectAnswer = false;
		boolean hasChecked = false;
		for (int i = 0; i < sourceAnswers.size(); i++) {
			Answer userAnswer = userAnswers.get(i);
			if (userAnswer.isChecked()) {
				hasChecked = true;
				Answer sourceAnswer = sourceAnswers.get(i);
				if (sourceAnswer.isCorrect()) {
					countTrueAnswer++;
					percentTrueAnswers += percentPointOneAnswer;

				} else {
					hasIncorrectAnswer = true;
					percentTrueAnswers -= percentPointOneAnswer;
					countNotTrueAnswer++;
				}
			}
		}
		this.resultQuestion = new ResultQuestion();
		if(!hasChecked) {
			setOptionsCorrectAnswer(resultQuestion, 0, 					countTrueAnswer, countNotTrueAnswer, StateQuestion.Skipped);
		} else if (hasIncorrectAnswer) {
			percentTrueAnswers = (percentTrueAnswers < 0? 0 : percentTrueAnswers);
			setOptionsCorrectAnswer(resultQuestion, percentTrueAnswers, countTrueAnswer, countNotTrueAnswer,  StateQuestion.Partly);
		} else if (countTrueAnswer <= 0) {
			setOptionsCorrectAnswer(resultQuestion, 0, 					countTrueAnswer, countNotTrueAnswer, StateQuestion.Incorrect);
		} else {
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
	private void setOptionsCorrectAnswer(ResultQuestion resultQuestion, double maxPercentTrueAnswer, int countTrueAnswer,
			int countNotTrueAnswer, StateQuestion state) {
		resultQuestion.setPercentCorrectAnswers(maxPercentTrueAnswer);
		resultQuestion.setNumberCorrectAnswers(countTrueAnswer);
		resultQuestion.setNumberNotCorrectAnswer(countNotTrueAnswer);
		resultQuestion.setState(state);
	}
	
}
