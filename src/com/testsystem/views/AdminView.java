package com.testsystem.views;

import java.util.List;

import com.testsystem.models.Model;
import com.testsystem.models.User;
import com.testsystem.util.ModScanner;

/**
 * Represents an administrator.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class AdminView extends UserView {

	/**
	 * Creates an administrator view.
	 * 
	 * @param user The administrator's model
	 */
	public AdminView(User user) {
		super(user);
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
	 * @param masUser The array of users.
	 * 
	 * @param title String represents a title.
	 */
	private void printListUsers(List<Model> masUser, String title) {
		System.out.println(title + ": ");
		for (int i = 0; i < masUser.size(); i++) {
			User user = (User) masUser.get(i);
			String s = String.format("%d) %s %s  (%s)", i + 1,user.getLastName(),
					user.getFirstName(), user.getNameModel());
			System.out.println(s);
		}
	}

	/*
	 * Print the list users from server.
	 */
	private void getUsers() {
		List<Model> masUser = this.getUser().getServer().getAllUsersForAdmin(this.getUser());
		printListUsers(masUser, "Cписок пользователей");
	}

	/*
	 * Print the list students from server.
	 */
	private void getStudents() {
		List<Model> masUser = this.getUser().getServer().getStudentsForAdmin(this.getUser());
		printListUsers(masUser, "Cписок студентов");
	}

	/*
	 * Print the list teachers from server.
	 */
	private void getTeachers() {
		List<Model> masUser = this.getUser().getServer().getTeachersForAdmin(this.getUser());
		printListUsers(masUser, "Cписок преподавателей");
	}

	/*
	 * Print the list administrators from server.
	 */
	private void getAdministrators() {
		List<Model> masUser = this.getUser().getServer().getAdminsForAdmin(this.getUser());
		printListUsers(masUser, "Cписок администраторов");
	}
}
