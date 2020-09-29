/*
 * This software is a testing system.
 */
package com.testsystem.view;

import com.testsystem.controller.FrontController;
import com.testsystem.model.Administrator;
import com.testsystem.model.Student;
import com.testsystem.model.Teacher;
import com.testsystem.model.User;
import com.testsystem.util.ModScanner;

/**
 * This class is the entry point to the application.
 * Represents a view for unauthorized users.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class ClientView extends UserView {

	/**
	 * The main function. The entry point to the application.
	 */
	public static void main(String[] args) {
		new ClientView().openMenu();
		ModScanner.close();
	}

	/**
	 * Method for open menu.
	 */
	public void openMenu() {
		String login = "";
		String password = "";
		System.out.print("Введите логин: ");
		login = ModScanner.getScanner().nextLine();
		System.out.print("Введите пароль: ");
		password = ModScanner.getScanner().nextLine();

		FrontController frontController = new FrontController();
		User user = frontController.login(login, password);

		if (user == null) {
			System.out.print("Неправильный логин или пароль.");
			System.out.println("До свидания!");
			return;
		}

		UserView userAplication = null;
		//System.out.print(user.getClass().getSimpleName());

		switch (user.getNameModel()) {
		case "Administrator":
			userAplication = new AdminView(user, frontController);
			break;
		case "Teacher":
			userAplication = new TeacherView(user, frontController);
			break;
		case "Student":
			userAplication = new StudentView(user, frontController);
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
			System.out.print("Произошла непредвиденная ошибка!");
			System.out.println("До свидания!");
		}
	}
}
