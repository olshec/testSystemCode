package com.testsystem.view;

import java.util.List;

import com.testsystem.controller.FrontController;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.User;
import com.testsystem.util.ModScanner;

/**
 * Represents a view for teacher.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public final class TeacherView extends UserView {

	private List<Test> listTest;
	
	/**
	 * Creates a teacher view.
	 * 
	 * @param User the teacher
	 * @param FrontController the FrontController
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
//			System.out.println("3 - получить список студентов");
//			System.out.println("4 - получить рейтинг студента");
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
				getListTests();
				break;
			case 2:
				getResultsTest();
				break;
//			case 3:
//				getListStudents();
//				break;
			default:
				System.out.println("Неверный ввод! Попытайтесь еще раз.");
				break;
			}

		}
		System.out.println("До свидания!");
	}

	/**
	 * Prints a list of tests from the server and prints.
	 */
	private void getListTests() {
		listTest = getFrontController().getTestsForTeacher(this.getUser());
		System.out.println("Cписок тестов: ");
		for (int i = 0; i < listTest.size(); i++) {
			System.out.println(i + 1 + ") " + listTest.get(i).getName());
		}
	}

	/**
	 * Prints a result of students test from the server and prints.
	 */
	private void getResultsTest() {
		int numTest = enterNumberTest();
		if (numTest != -1) {
			int indexTest = numTest - 1;// index begin from 0;
			//If listTest empty, load data from server
			if(listTest == null) {
				listTest = getFrontController().getTestsForTeacher(this.getUser());
			}
			int idTest = listTest.get(indexTest).getId();
			List<ResultTest> ls = getFrontController().getTestResultForTeacher(this.getUser(), idTest);
			printTestResult(ls);
		}
	}
	
	/**
	 * Method for enter number of test.
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
	 * Prints a result of students test.
	 */
	private void printTestResult(List<ResultTest> resultsTest) {
		if (resultsTest != null) {
			if (resultsTest.size() > 0) {
				for (int i = 0; i < resultsTest.size(); i++) {
					ResultTest resTest = resultsTest.get(i);
					User student = resTest.getStudent();
					System.out.println("Студент: " + student.getLastName() + " " + student.getFirstName());	
					System.out.println(resTest.toString());
					System.out.println();
				}
			} else {
				System.out.println("Результаты теста отсутствуют");
			}
		} else {
			System.out.println("Теста с таким номером не существует");
		}
	}

	
//	/*
//	 * Print the list students from server.
//	 */
//	private void getListStudents() {
//		List<Student> masUser = getFrontController().getStudentsForTeacher(this.getUser());
//		printListUsers(masUser, "Cписок студентов");
//	}
//	
//	/*
//	 * Print list users.
//	 * 
//	 * @param masUser The array of users.
//	 * @param title   String represents a title.
//	 */
//	private void printListUsers(List<Student > masUser, String title) {
//		System.out.println(title + ": ");
//		for (int i = 0; i < masUser.size(); i++) {
//			User user = masUser.get(i);
//			String s = String.format("%d) %s %s  (%s)", i + 1, user.getLastName(), user.getFirstName(),
//					user.getNameModel());
//			System.out.println(s);
//		}
//	}
	
}
