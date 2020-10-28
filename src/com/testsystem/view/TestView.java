package com.testsystem.view;

import java.util.List;

import com.testsystem.controller.QuestionController;
import com.testsystem.model.User;
import com.testsystem.model.test.Answer;
import com.testsystem.model.test.Question;
import com.testsystem.model.test.Test;
import com.testsystem.util.ModScanner;

public class TestView {

	/**
	 * 
	 */
	public TestView() {
		super();
	}

	/**
	 * Runs test.
	 */
	public void runTest(User student, Test test) {
		greeting();
		List<Question> questions = test.getQuestions();
		ModScanner.getScanner().nextLine();
		for (Question q : questions) {
			System.out.println(q.getText());
			List<Answer> answers = q.getAnswers();
			for (Answer a : answers) {
				System.out.println(a.getText());
			}
			System.out.print("Введите ответ: ");
			String answer = ModScanner.getScanner().nextLine();
			setAnswers(answer, q);
		}
	}

	/*
	 * This method prints the greeting.
	 */
	private void greeting() {
		System.out.println();
		System.out.println("Введите варианты ответов к вопросам. "
				+ "Если правильных ответов несколько, то вводите номера ответов через пробел.");
		System.out.println();
	}

	/*
	 * Set answers for question.
	 */
	private void setAnswers(String answerString, Question question) {
		QuestionController questionController = new QuestionController(question);
		questionController.setCheckAnswers(answerString);
	}

}
