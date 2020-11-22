/*
 * This software is a testing system.
 */
package com.testsystem.view;

import com.testsystem.controller.FrontController;
import com.testsystem.model.user.Administrator;
import com.testsystem.model.user.Student;
import com.testsystem.model.user.Teacher;
import com.testsystem.model.user.User;
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
	 * 
	 * @param String[] the array arguments for application
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

		switch (user.getNameModel()) {
		case Administrator.nameModel:
			userAplication = new AdminView(user, frontController);
			break;
		case Teacher.nameModel:
			userAplication = new TeacherView(user, frontController);
			break;
		case Student.nameModel:
			userAplication = new StudentView(user, frontController);
			break;
		default:
			break;
		}

		if (userAplication != null)
			userAplication.openMenu();
		else {
			System.out.print("Произошла непредвиденная ошибка!");
			System.out.println("До свидания!");
		}
	}
}
