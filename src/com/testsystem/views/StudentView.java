package com.testsystem.views;

import java.util.List;

import com.testsystem.models.Model;
import com.testsystem.models.Test;
import com.testsystem.models.User;
import com.testsystem.util.ModScanner;

/**
 * Represents a student.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public final class StudentView extends UserView {

	/**
	 * Creates a student view.
	 * 
	 * @param user the student
	 */
	public StudentView(User user) {
		super(user);
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
			default:
				System.out.println("Неверный ввод! Попытайтесь еще раз.");
				break;
			}

		}
		System.out.println("До свидания!");
	}

	/**
	 * Print a list of student tests from the server and prints.
	 */
	private void printTestsStudent() {
		List<Model> mas = this.getUser().getServer().getTestsForStudent(this.getUser());
		System.out.println("Cписок тестов: ");
		for (int i = 0; i < mas.size(); i++) {
			System.out.println(i + 1 + ") " + ((Test)mas.get(i)).getName());
		}
	}

	/**
	 * Print the number of test questions from the server and prints.
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
		// --numTest index begin from 0;
		int quantityQuestions = this.getUser().getServer().getNumberQuestionsInTest(this.getUser(),
				numTest - 1);
		if (quantityQuestions < 0) {
//				System.out.println("Теста с таким номером не существует!");
		} else {
			String s = String.format("Количество вопросов в тесте %d: %d", numTest, quantityQuestions);
			System.out.println(s);
		}
	}
}
