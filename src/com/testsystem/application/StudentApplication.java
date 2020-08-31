package com.testsystem.application;

import java.util.List;

import com.testsystem.controller.FrontController;
import com.testsystem.model.Model;
import com.testsystem.model.Test;
import com.testsystem.model.User;
import com.testsystem.util.ModScanner;
import com.testsystem.view.StudentView;

/**
 * Represents a student.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public final class StudentApplication extends UserApplication {

	/**
	 * Creates an application for student.
	 * 
	 * @param user the student
	 */
	public StudentApplication(User user, FrontController frontController) {
		super(user, frontController);
	}

	/**
	 * Method for open menu.
	 */
	public void openMenu() {
		int num = -1;
		while (num != 0) {
			
			new StudentView().printMenu();
			
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
				new StudentView().printErrorEnter();
				break;
			}

		}
		new StudentView().printExit();
	}

	/**
	 * Print a list of student tests from the server and prints.
	 */
	private void printTestsStudent() {
		List<Model> mas = getFrontController().getTestsForStudent(this.getUser());
		new StudentView().printTestsStudent(mas);
	}

	/**
	 * Print the number of test questions from the server and prints.
	 */
	private void printNumberQuestions() {
		new StudentView().EnterNumberTest();

		int numTest = 0;
		try {
			numTest = ModScanner.getScanner().nextInt();
		} catch (java.util.InputMismatchException exception) {
//			System.out.println("Ошибка при вводе! Номер теста должен быть числом!");
			return;
		}
		// --numTest index begin from 0;
		int quantityQuestions = getFrontController().getNumberQuestionsInTest(this.getUser(),
				numTest - 1);
		new StudentView().PrintCountQuestionsInTest(numTest, quantityQuestions);
	}
}
