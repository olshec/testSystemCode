package com.testsystem.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.testsystem.models.StudentTestResult;
import com.testsystem.models.Test;
import com.testsystem.models.User;
import com.testsystem.util.ModScanner;

/**
 * Represents a teacher.
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
	public TeacherView(User userModel) {
		super(userModel);
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
		List<Test> mas = this.getUser().getServer().getTestsForTeacher(this.getUser());
		System.out.println("Cписок тестов: ");
		for (int i = 0; i < mas.size(); i++) {
			System.out.println(i + 1 + ") " + mas.get(i).getName());
		}
	}

	/**
	 * Print a result of students test from the server and prints.
	 */
	private void printTestResult() {

		System.out.print("Введите номер теста: ");
		int numTest = 0;
		try {
			numTest = ModScanner.getScanner().nextInt();
		} catch (java.util.InputMismatchException exception) {
			System.out.println("Номер теста должен быть числом!");
			return;
		}
		int indexTest = numTest - 1;// index begin from 0;
		Test test = this.getUser().getServer().getTestResultForTeacher(this.getUser(), indexTest);
		if (test != null) {
		List<StudentTestResult> studentResult=test.getStudentResult();
			
			if (studentResult.size() > 0) {
				List<StudentTestResult> masStudent = test.getStudentResult();
				for (int i = 0; i < masStudent.size(); i++) {
					String s = String.format("%d) %s %s: %d", i + 1, masStudent.get(i)
							.getStudent().getLastName(),
							masStudent.get(i).getStudent().getFirstName(), masStudent.get(i).getResult());
					System.out.println(s);
				}
			} else {
				System.out.println("Результаты теста отсутствуют");
			}

		} else {
			System.out.println("Теста с таким номером не существует");
		}

	}
}
