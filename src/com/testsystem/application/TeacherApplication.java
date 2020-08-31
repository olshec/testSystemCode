package com.testsystem.application;

import java.util.List;

import com.testsystem.controller.FrontController;
import com.testsystem.model.Test;
import com.testsystem.model.User;
import com.testsystem.util.ModScanner;
import com.testsystem.view.TeacherView;

/**
 * Represents an application for teacher.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public final class TeacherApplication extends UserApplication {

	/**
	 * Creates a teacher view.
	 * 
	 * @param user the teacher
	 */
	public TeacherApplication(User user, FrontController frontController) {
		super(user, frontController);
	}

	/**
	 * Method for open menu.
	 */
	public void openMenu() {
		int num = -1;
		while (num != 0) {
			new TeacherView().printMenu();

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
				new TeacherView().printErrorEnter();
				break;
			}

		}
		new TeacherView().printExit();
	}

	/**
	 * Print a list of tests from the server and prints.
	 */
	private void printTests() {
		List<Test> mas = getFrontController().getTestsForTeacher(this.getUser());
		new TeacherView().printTests(mas);
	}

	/**
	 * Print a result of students test from the server and prints.
	 */
	private void printTestResult() {

		int numTest = new TeacherView().enterNumberTest();
		if (numTest != -1) {
			int indexTest = numTest - 1;// index begin from 0;
			Test test = getFrontController().getTestResultForTeacher(this.getUser(), indexTest);
			new TeacherView().printTestResult(test);
		}
	}

}
