/*
 * This software is a testing system.
 */
package com.testsystem.application;

import com.testsystem.controller.FrontController;
import com.testsystem.models.Administrator;
import com.testsystem.models.Student;
import com.testsystem.models.Teacher;
import com.testsystem.models.User;
import com.testsystem.util.ModScanner;
import com.testsystem.view.ClientView;

/**
 * This class is the entry point to the application.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class ClientApplication extends UserApplication {

	/**
	 * The main function. The entry point to the application.
	 */
	public static void main(String[] args) {
		new ClientApplication().openMenu();
		ModScanner.close();
	}

	/**
	 * Method for open menu.
	 */
	public void openMenu() {
		String login = "";
		String password = "";
		new ClientView().printEnterLogin();
		login = ModScanner.getScanner().nextLine();
		new ClientView().printEnterPassword();
		password = ModScanner.getScanner().nextLine();

		FrontController frontController = new FrontController();
		User user = frontController.login(login, password);

		if (user == null) {
			new ClientView().printErrorLoginOrPassword();
			return;
		}

		UserApplication userAplication = null;
		//System.out.print(user.getClass().getSimpleName());

		switch (user.getClass().getSimpleName()) {
		case Administrator.nameModel:
			userAplication = new AdminApplication(user, frontController);
			break;
		case Teacher.nameModel:
			userAplication = new TeacherApplication(user, frontController);
			break;
		case Student.nameModel:
			userAplication = new StudentApplication(user, frontController);
			break;
		default:
			break;
		}

		// Student_1 login: "REgor", password: "1111"
		// Student_2 login: "ShAnton", password: "1111"

		// Teacher_1 login: "KirovAnton", password: "12345678"
		// SAdmin_1 login: "Admin1", password: "0000"
		if (userAplication != null)
			userAplication.openMenu();
		else {
			new ClientView().printUndefinedError();
		}
	}
}
