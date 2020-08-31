package com.testsystem.view;

import java.util.List;

import com.testsystem.model.StudentTestResult;
import com.testsystem.model.Test;
import com.testsystem.util.ModScanner;

/**
 * View for teacher.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TeacherView extends UserView {

	public TeacherView() {
		// TODO Auto-generated constructor stub
	}

	public void printMenu() {
		System.out.println();
		System.out.println("0 - выход");
		System.out.println("1 - получить список тестов");
		System.out.println("2 - получить результаты теста");
		System.out.print("?: ");
	}

	/**
	 * Print a list of tests.
	 */
	public void printTests(List<Test> mas) {
		System.out.println("Cписок тестов: ");
		for (int i = 0; i < mas.size(); i++) {
			System.out.println(i + 1 + ") " + mas.get(i).getName());
		}
	}

	/**
	 * Enter number test.
	 */
	public int enterNumberTest() {
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
	public void printTestResult(Test test) {
		if (test != null) {
			List<StudentTestResult> studentResult = test.getStudentResult();
			if (studentResult.size() > 0) {
				List<StudentTestResult> masStudent = test.getStudentResult();
				for (int i = 0; i < masStudent.size(); i++) {
					String s = String.format("%d) %s %s: %d", i + 1, masStudent.get(i).getStudent().getLastName(),
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
