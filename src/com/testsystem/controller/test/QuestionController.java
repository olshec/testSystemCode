package com.testsystem.controller.test;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.test.Answer;
import com.testsystem.model.test.Question;
import com.testsystem.model.test.ResultAnswers;
import com.testsystem.model.test.ResultQuestion;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

/**
 * Represents a question controller.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class QuestionController {

	private Question question;

	/**
	 * 
	 */
	public QuestionController() {
		super();
	}

	/**
	 * @param question
	 */
	public QuestionController(Question question) {
		super();
		this.question = question;
	}

	/**
	 * Gets new Question.
	 */
	public Question getNewQuestion(String text) {
		return new Question(text);
	}
	
	/**
	 * Gets question text.
	 * 
	 * @return the text question
	 */
	public String getText() {
		return question.getText();
	}

	/**
	 * Set text question.
	 * 
	 * @param text the text question
	 */
	public void setText(String text) {
		question.setText(text);
	}

	/**
	 * Gets answers to a question.
	 * 
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return question.getAnswers();
	}

	/**
	 * Set answers.
	 * 
	 * @param answers the answers
	 */
	public void setAnswers(List<Answer> answers) {
		question.setAnswers(answers);
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
		int countNotCorrectQuestion = 0;
		boolean hasIncorrectQuestion = false;
		for (int i = 0; i < resultQuestion.size(); i++) {
			double percentCorrectAnswers = resultQuestion.get(i).getResultAnswers().getPercentCorrectAnswers();
			if (percentCorrectAnswers!=100) {
				hasIncorrectQuestion = true;
				percentTrueQuestions += percentPointOneQuestion * (percentCorrectAnswers/100);
				countNotCorrectQuestion++;
			} else {
				numberCorrectQuestion++;
				percentTrueQuestions += percentPointOneQuestion;
			}
		}
		int numberPartlyQuestion = 0;
		for(ResultQuestion rq : resultQuestion) {
			double percentCorrectAnswers = rq.getResultAnswers().getPercentCorrectAnswers();
			if(percentCorrectAnswers<100 && percentCorrectAnswers>0) {
				numberPartlyQuestion++;
				countNotCorrectQuestion--;
			}
		}
		ResultTest resultTest = null;
		if (hasIncorrectQuestion) {
			resultTest = new ResultTest(numberCorrectQuestion, countNotCorrectQuestion, numberPartlyQuestion,
					percentTrueQuestions, student, test, resultQuestion);
		} else if (percentTrueQuestions <= 0) {
			resultTest = new ResultTest(0, countNotCorrectQuestion, 0,
					0, student, test, resultQuestion);
		} else {
			resultTest = new ResultTest(numberCorrectQuestion, countNotCorrectQuestion, numberPartlyQuestion,
					percentTrueQuestions, student, test, resultQuestion);
		}
		return resultTest;
	}

	//Checks answers
	private List<ResultQuestion> checkAnswers(Test test) {
		List<ResultQuestion> resultQuestion = new ArrayList<>();
		List<Question> userQuestions = test.getQuestions();
		Test sourceTest = ServiceLocator.getDaoProvider()
				.getTest(test);
		List<Question> sourceQuestions = sourceTest.getQuestions();
		for(int i = 0; i < sourceQuestions.size(); i++) {
			Question userQuestion = userQuestions.get(i);
			List<Answer> userAnswers = userQuestion.getAnswers();
			List<Answer> sourceAnswers = sourceQuestions.get(i).getAnswers();
			ResultAnswers resultAnswers = new AnswerController().
					checkAnswers(userAnswers, sourceAnswers);
			resultQuestion.add(new ResultQuestion(resultAnswers, userQuestion));
		}
		return resultQuestion;
	}
	
}
