package com.testsystem.view;

import java.text.NumberFormat;
import java.util.List;

import com.testsystem.controller.FrontController;
import com.testsystem.exception.FindTestException;
import com.testsystem.model.test.RatingStudent;
import com.testsystem.model.test.ResultQuestion;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.User;
import com.testsystem.util.ModScanner;

/**
 * Represents a view for student.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public final class StudentView extends UserView {

	/**
	 * Creates a view for student.
	 * 
	 * @param User            the student
	 * @param FrontController the FrontController
	 */
	public StudentView(User user, FrontController frontController) {
		super(user, frontController);
	}

	/**
	 * Method for open menu.
	 */
	public void openMenu() {
		int num = -1;
		while (num != 0) {

			System.out.println();
			System.out.println("0 - выход");
			System.out.println("1 - получить список тестов");
			System.out.println("2 - получить количество вопросов в тесте");
			System.out.println("3 - пройти тест");
			System.out.println("4 - посмотреть рейтинг");
			System.out.print("?: ");

			try {
				num = ModScanner.getScanner().nextInt();
			} catch (java.util.InputMismatchException exception) {
				num = -1;
			}

			switch (num) {
			case 0:
				break;
			case 1:
				printTestsStudent();
				break;
			case 2:
				printNumberQuestions();
				break;
			case 3:
				runTest();
				break;
			case 4:
				printRating();
				break;
			default:
				System.out.println("Неверный ввод! Попытайтесь еще раз.");
				break;
			}

		}
		System.out.println("До свидания!");
	}

	/**
	 * Printa a list of tests.
	 * 
	 * @param List<Test> the list of students
	 */
	private void printTestsStudent(List<Test> listStudents) {
		System.out.println("Cписок тестов: ");
		for (int i = 0; i < listStudents.size(); i++) {
			System.out.println(i + 1 + ") " + (listStudents.get(i)).getName());
		}
	}

	/**
	 * Prints a list of student tests from the server and prints.
	 */
	private void printTestsStudent() {
		List<Test> mas = getFrontController().getTestsForStudent(this.getUser());
		printTestsStudent(mas);
	}

	/**
	 * Prints the number of test questions from the server and prints.
	 */
	private void printNumberQuestions() {

		System.out.print("Введите номер теста: ");

		int numTest = 0;
		try {
			numTest = ModScanner.getScanner().nextInt();
		} catch (java.util.InputMismatchException exception) {
//			System.out.println("Ошибка при вводе! Номер теста должен быть числом!");
			return;
		}
		// numTest index begin from 0;
		int quantityQuestions = getFrontController().getNumberQuestionsInTest(this.getUser(), --numTest);
		if (quantityQuestions < 0) {
			System.out.println("Теста с таким номером не существует!");
		} else {
			String s = String.format("Количество вопросов в тесте %d: %d", ++numTest, quantityQuestions);
			System.out.println(s);
		}
	}

	/**
	 * Runs test.
	 */
	private void runTest() {
		System.out.print("Введите номер теста: ");

		int numTest = 0;
		try {
			numTest = ModScanner.getScanner().nextInt();
		} catch (java.util.InputMismatchException exception) {
			System.out.println("Ошибка при вводе! Номер теста должен быть числом!");
			return;
		}
		// numTest index begin from 0;
		numTest--;
		Test test = getFrontController().getTestForStudent(this.getUser(), numTest);
		if (test == null) {
			System.out.println("Теста с таким номером не существует!");
		} else {
			TestView testView = new TestView();
			Test testSender = testView.runTest(this.getUser(), test);
			ResultTest resultTest = null;
			try {
				resultTest = getFrontController().checkTest(this.getUser(), testSender);
			} catch (FindTestException e) {
				System.out.println(e.getMessage());
			}
			printTestResult(resultTest);
		}
	}

	/**
	 * Prints result of test.
	 * 
	 * @param ResultTest the result of test
	 */
	private void printTestResult(ResultTest resultTest) {
		System.out.println();
		System.out.println("Результаты теста: ");
		System.out.println(resultTest.toString());
		
		System.out.println("Результат проверки вопросов: ");
		List<ResultQuestion> resultQuestion = resultTest.getResultQuestions();
		for (int i = 0; i < resultQuestion.size(); i++) {
			System.out.print("Вопрос " + (i + 1) + ": ");
			System.out.println(resultQuestion.get(i).toString());
		}
	}
	
	/*
	 * Prints rating of student.
	 */
	private void printRating() {
		List<RatingStudent> ratingStudent = getFrontController().getRatingForStudent(this.getUser());
		double ratingpoint = ratingStudent.get(0).getPoints();
		NumberFormat nf = NumberFormat.getInstance(); 
		nf.setMaximumFractionDigits(2); 
		System.out.println();
		System.out.print("Rating: ");
		System.out.println(nf.format(ratingpoint));
	}

}
