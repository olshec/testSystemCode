package com.testsystem.view;

import java.util.List;
import com.testsystem.model.test.Answer;
import com.testsystem.model.test.Question;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.User;
import com.testsystem.util.ModScanner;

public class TestView {

	/**
	 * Creates a test view.
	 */
	public TestView() {
		super();
	}

	/**
	 * Runs test.
	 * 
	 * @param User	the student
	 * @param Test	the test
	 */
	public Test runTest(User student, Test test) {
		greeting();
		List<Question> questions = test.getQuestions();
		ModScanner.getScanner().nextLine();
		for (Question q : questions) {
			System.out.println(q.getText());
			List<Answer> answers = q.getAnswers();
			for (int i = 0; i < answers.size(); i++) {
				int numTest = i + 1;
				System.out.println(numTest + ") " + answers.get(i));
			}
			System.out.print("Введите ответ: ");
			String answer = ModScanner.getScanner().nextLine();
			if(!answer.isEmpty()) {
				setAnswers(answer, q);
			}
		}
		return test;
	}

	/*
	 * Prints the greeting.
	 */
	private void greeting() {
		System.out.println();
		System.out.println("Введите варианты ответов к вопросам. "
				+ "Если правильных ответов несколько, то вводите номера ответов через пробел.");
		System.out.println();
	}

	/*
	 * Set answers for question.
	 * 
	 * @param String	the string of answer
	 * @param Question 	the question
	 */
	private void setAnswers(String answerString, Question question) {
		answerString = answerString.trim();
		String[] answerOptions = answerString.split(" ");
		List<Answer> answers = question.getAnswers();
		for (int i = 0; i < answerOptions.length; i++) {
			Integer answer = Integer.parseInt(answerOptions[i]);
			answer--; // for index
			answers.get(answer).setChecked(true);
		}
	}

}
