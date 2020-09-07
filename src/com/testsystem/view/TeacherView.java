package com.testsystem.view;

import java.util.List;

import com.testsystem.controller.FrontController;
import com.testsystem.model.StudentTestResult;
import com.testsystem.model.Test;
import com.testsystem.model.User;
import com.testsystem.util.ModScanner;

/**
 * Represents a view for teacher.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public final class TeacherView extends UserView {

	/**
	 * Creates a teacher view.
	 * 
	 * @param user the teacher
	 */
	public TeacherView(User user, FrontController frontController) {
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
			System.out.println("2 - получить результаты теста");
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
				printTests();
				break;
			case 2:
				printTestResult();
				break;
			default:
				System.out.println("Неверный ввод! Попытайтесь еще раз.");
				break;
			}

		}
		System.out.println("До свидания!");
	}

	/**
	 * Print a list of tests from the server and prints.
	 */
	private void printTests() {
		List<Test> mas = getFrontController().getTestsForTeacher(this.getUser());
		System.out.println("Cписок тестов: ");
		for (int i = 0; i < mas.size(); i++) {
			System.out.println(i + 1 + ") " + mas.get(i).getName());
		}
	}

	/**
	 * Print a result of students test from the server and prints.
	 */
	private void printTestResult() {

		int numTest = enterNumberTest();
		if (numTest != -1) {
			int indexTest = numTest - 1;// index begin from 0;
			Test test = getFrontController().getTestResultForTeacher(this.getUser(), indexTest);
			printTestResult(test);
		}
	}
	
	/**
	 * Enter number test.
	 */
	private int enterNumberTest() {
		System.out.print("Введите номер теста: ");
		int numTest = 0;
		try {
			numTest = ModScanner.getScanner().nextInt();
		} catch (java.util.InputMismatchException exception) {
			System.out.println("Номер теста должен быть числом!");
			return -1;
		}
		return numTest;
	}

	/**
	 * Print a result of students test.
	 */
	private void printTestResult(Test test) {
		if (test != null) {
			List<StudentTestResult> studentResult = test.getStudentTestResult();
			if (studentResult.size() > 0) {
				List<StudentTestResult> masStudent = test.getStudentTestResult();
				for (int i = 0; i < masStudent.size(); i++) {
					if(masStudent.get(i).getResult() >= 0) {
						String s = String.format("%d) %s %s: %d", i + 1, 
								masStudent.get(i).getStudent().getLastName(),
								masStudent.get(i).getStudent().getFirstName(), 
								masStudent.get(i).getResult());
						System.out.println(s);
					}
				}
			} else {
				System.out.println("Результаты теста отсутствуют");
			}
		} else {
			System.out.println("Теста с таким номером не существует");
		}
	}

}
