package com.testsystem.controller.test;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.test.ResultQuestion;
import com.testsystem.model.test.ResultQuestion.StateQuestion;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

public class ResultTestController {

	/**
	 * 
	 */
	public ResultTestController() {
		super();
	}

	/**
	 * @param ResultTest the result of test
	 */
	public void saveResultTest(ResultTest ResultTest) {
		ServiceLocator.getDaoProvider().addRecord(ResultTest);
	}

	/**
	 * Returns the result of test by id test.
	 * 
	 * @param student
	 * @param test
	 * @return ResultTest the result of test
	 */
	public List<ResultTest> getResultsOfTest(int idTest) {
		List<ResultTest> records = ServiceLocator.getDaoProvider().getResultTestRecords();
		List<ResultTest> ls = new ArrayList<ResultTest>();
		for(ResultTest result: records) {
			if (result.getTest().getId() == idTest) {
				ls.add(result);
			}
		}
		return ls;
	}
	
	/**
	 * Returns the result of test.
	 * 
	 * @param student
	 * @param test
	 * @return List<ResultTest> the result of test
	 */
	public List<ResultTest> getResultsOfTest(User student, Test test) {
		List<ResultTest> records = ServiceLocator.getDaoProvider().
				getResultTestRecords();
		List<ResultTest> listResult = new ArrayList<ResultTest>();
		for(ResultTest result: records) {
			if (result.getTest().equals(test) && 
					result.getStudent().equals(student)) {
				listResult.add(result);
			}
		}
		return listResult;
	}
	
	/**
	 * Checks test.
	 * 
	 * @param student
	 * @param test
	 */
	public ResultTest checkTest(User student, Test test) {
		List<ResultQuestion> resultQuestion = new ResultQuestionController().checkQuestions(test);
		final double maxPercentTrueQuestion = 100;
		int countQuestion = resultQuestion.size();
		double percentPointOneQuestion = maxPercentTrueQuestion / countQuestion;

		double percentTrueQuestions = 0;
		int numberCorrectQuestion = 0;
		int numberNotCorrectQuestion = 0;
		int numberPartlyQuestion = 0;
		int numberSkippedQuestion = 0;
		for (int i = 0; i < resultQuestion.size(); i++) {
			if(resultQuestion.get(i).getState() == StateQuestion.Skipped) {
				numberSkippedQuestion++;
			} else {
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
		}
		
		ResultTest resultTest = null;
		if (numberNotCorrectQuestion > 0 || numberPartlyQuestion > 0) { //has error in question
			resultTest = new ResultTest(numberCorrectQuestion, numberNotCorrectQuestion, numberPartlyQuestion,
					numberSkippedQuestion, (int)percentTrueQuestions, 
					calculatePoints((int)percentTrueQuestions), student, test, resultQuestion);
		} else if (percentTrueQuestions <= 0) { //the test failed
			resultTest = new ResultTest(0, numberNotCorrectQuestion, 0,
					numberSkippedQuestion, 0, calculatePoints(0), student, test, resultQuestion);
		} else if (numberNotCorrectQuestion == 0 && 
				numberPartlyQuestion == 0 && numberSkippedQuestion == 0) {// the test is 100% complete
			resultTest = new ResultTest(numberCorrectQuestion, 0, 0,
					numberSkippedQuestion, (int)maxPercentTrueQuestion, 
					calculatePoints((int)maxPercentTrueQuestion), student, test, resultQuestion);
		} else {//has skipped question
			resultTest = new ResultTest(numberCorrectQuestion, numberNotCorrectQuestion, numberPartlyQuestion,
					numberSkippedQuestion, (int)percentTrueQuestions, 
					calculatePoints((int)percentTrueQuestions), student, test, resultQuestion);
		}
		return resultTest;
	}

	private int calculatePoints(int percentTrueQuestions) {
		int points = 0;
		if (percentTrueQuestions < 40) {
			points = 2;
		} else if (percentTrueQuestions < 64) {
			points = 3;
		} else if (percentTrueQuestions < 81) {
			points = 4;
		} else if (percentTrueQuestions >= 81 && percentTrueQuestions <= 100){
			points = 5;
		}
		return points;	
	}
}
