package com.testsystem.controller.test;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.exception.FindTestException;
import com.testsystem.model.test.Answer;
import com.testsystem.model.test.Question;
import com.testsystem.model.test.ResultQuestion;
import com.testsystem.model.test.ResultQuestion.StateQuestion;
import com.testsystem.model.test.Test;
import com.testsystem.util.ServiceLocator;

public class ResultQuestionController {

	/**
	 * Creates ResultQuestionController.
	 */
	public ResultQuestionController() {
		super();
	}
	
	/**
	 * Checks questions
	 * 
	 * @param test
	 * @return List<ResultQuestion>
	 * @throws FindTestException 
	 */
	public List<ResultQuestion> checkQuestions(Test test) throws FindTestException {
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
	 * The max percent point of correct question = 100; (maxPercentCorrectQuestion)
	 * numberCorrectAnswers - the number of correct answers in the question.
	 * The percent point of one answer = maxPercentCorrectQuestion / countCorrectAnswers;
	 * 
	 * @param questionUser
	 * @param questionSource
	 * @return ResultQuestion
	 */
	private ResultQuestion checkAnswers(Question questionUser, Question questionSource) {
		final int maxPercentCorrectQuestion = 100;
		List<Answer> userAnswers = questionUser.getAnswers();
		List<Answer> sourceAnswers = questionSource.getAnswers();
		int numberCorrectAnswers = new AnswerController().getCountCorrectAnswers(sourceAnswers);
		double percentPointOneAnswer = maxPercentCorrectQuestion / numberCorrectAnswers;
		double percentTrueAnswers = 100;
		int countTrueAnswer = 0;
		int countNotTrueAnswer = 0;
		boolean hasChecked = false;
		for (int i = 0; i < sourceAnswers.size(); i++) {
			Answer userAnswer = userAnswers.get(i);
			Answer sourceAnswer = sourceAnswers.get(i);
			if (userAnswer.isChecked() && sourceAnswer.isCorrect()) {
				hasChecked = true;
				countTrueAnswer++;
			} else if (!userAnswer.isChecked() && sourceAnswer.isCorrect()) {
				percentTrueAnswers -= percentPointOneAnswer;
				countNotTrueAnswer++;
			} else if (userAnswer.isChecked() && !sourceAnswer.isCorrect()) {
				hasChecked = true;
				percentTrueAnswers -= percentPointOneAnswer;
				countNotTrueAnswer++;
			}
		}

		ResultQuestion resultQuestion = null;
		if (!hasChecked) { // Question is skipped
			resultQuestion = new ResultQuestion(0, 0, 0, questionUser, StateQuestion.Skipped);
		} else if (countTrueAnswer == 0) {// Question not correct
			resultQuestion = new ResultQuestion(0, 0, countNotTrueAnswer, questionUser, StateQuestion.Incorrect);
		} else if (countNotTrueAnswer > 0 && countTrueAnswer > 0) {// Question is partly
			percentTrueAnswers = (percentTrueAnswers < 0 ? 0 : percentTrueAnswers);
			resultQuestion = new ResultQuestion((int) percentTrueAnswers, countTrueAnswer, countNotTrueAnswer,
					questionUser, StateQuestion.Partly);
		} else {// Question is 100% correct
			resultQuestion = new ResultQuestion((int) maxPercentCorrectQuestion, countTrueAnswer, countNotTrueAnswer,
					questionUser, StateQuestion.Correct);
		}
		return resultQuestion;
	}
	
}
