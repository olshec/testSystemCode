package com.testsystem.view;

import java.util.List;

import com.testsystem.controller.FrontController;
import com.testsystem.model.user.User;
import com.testsystem.util.ModScanner;

/**
 * Represents a view for administrator.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class AdminView extends UserView {

	/**
	 * Creates an AdminView.
	 * 
	 * @param User the user
	 * @param FrontController the front controller
	 */
	public AdminView(User user, FrontController frontController) {
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
			System.out.println("1 - получить список всех пользователей");
			System.out.println("2 - получить список студентов");
			System.out.println("3 - получить список преподавателей");
			System.out.println("4 - получить список администраторов");
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
				getUsers();
				break;
			case 2:
				getStudents();
				break;
			case 3:
				getTeachers();
				break;
			case 4:
				getAdministrators();
				break;
			default:
				System.out.println("Неверный ввод! Попытайтесь еще раз.");
				break;
			}
		}
		System.out.println("До свидания!");
	}

	/*
	 * Print list users.
	 * 
	 * @param List<User> the list of users.
	 * @param String   	 the title of message.
	 */
	private void printListUsers(List<User> masUser, String title) {
		System.out.println(title + ": ");
		for (int i = 0; i < masUser.size(); i++) {
			User user = masUser.get(i);
			String s = String.format("%d) %s %s  (%s)", i + 1, user.getLastName(), user.getFirstName(),
					user.getNameModel());
			System.out.println(s);
		}
	}
	
	/*
	 * Prints the list users from server.
	 */
	private void getUsers() {
		List<User> masUser = getFrontController().getAllUsersForAdmin(this.getUser());
		printListUsers(masUser, "Cписок пользователей");
	}

	/*
	 * Prints the list students from server.
	 */
	private void getStudents() {
		List<User> masUser = getFrontController().getStudentsForAdmin(this.getUser());
		printListUsers(masUser, "Cписок студентов");
	}

	/*
	 * Prints the list teachers from server.
	 */
	private void getTeachers() {
		List<User> masUser = getFrontController().getTeachersForAdmin(this.getUser());
		printListUsers(masUser, "Cписок преподавателей");
	}

	/*
	 * Prints the list administrators from server.
	 */
	private void getAdministrators() {
		List<User> masUser = getFrontController().getAdminsForAdmin(this.getUser());
		printListUsers(masUser, "Cписок администраторов");
	}

}
