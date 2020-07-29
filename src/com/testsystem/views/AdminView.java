package com.testsystem.views;

import java.util.List;
import java.util.Scanner;
import com.testsystem.models.User;

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

			Scanner myInput = new Scanner(System.in);
			try {
				num = myInput.nextInt();
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
	private void printListUsers(List<User> masUser, String title) {
		System.out.println(title + ": ");
		for (int i = 0; i < masUser.size(); i++) {
			String s = String.format("%d) %s %s  (%s)", i + 1, masUser.get(i).getLastName(),
					masUser.get(i).getFirstName(), masUser.get(i).getClass().getSimpleName());
			System.out.println(s);
		}
	}

	/*
	 * Print the list users from server.
	 */
	private void getUsers() {
		List<User> masUser = this.getUserModel().getServer().getAllUsersForAdmin(this.getUserModel());
		printListUsers(masUser, "Cписок пользователей");
	}

	/*
	 * Print the list students from server.
	 */
	private void getStudents() {
		List<User> masUser = this.getUserModel().getServer().getStudentsForAdmin(this.getUserModel());
		printListUsers(masUser, "Cписок студентов");
	}

	/*
	 * Print the list teachers from server.
	 */
	private void getTeachers() {
		List<User> masUser = this.getUserModel().getServer().getTeachersForAdmin(this.getUserModel());
		printListUsers(masUser, "Cписок преподавателей");
	}

	/*
	 * Print the list administrators from server.
	 */
	private void getAdministrators() {
		List<User> masUser = this.getUserModel().getServer().getAdminsForAdmin(this.getUserModel());
		printListUsers(masUser, "Cписок администраторов");
	}

}
