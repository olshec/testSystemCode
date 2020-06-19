package view;

import java.util.List;
import java.util.Scanner;

import controller.ServerController;
import models.UserModel;

/**
 * Represents an administrator.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class AdminView extends UserModel {

	/**
	 * Creates an administrator.
	 * 
	 * @param lastName  The administrator’s last name.
	 * @param firstName The administrator’s first name.
	 * @param server    The administrator’s server.
	 * @param username  The administrator’s username.
	 * @param password  The administrator’s password.
	 */
	public AdminView(String lastName, String firstName, ServerController server, String username, String password) {
		super(lastName, firstName, server, username, password);
	}

	/**
	 * Function for opening menu.
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

	/**
	 * Print list users.
	 * 
	 * @param masUser The array of users.
	 * @param title String represents a title.
	 */
	private void printListUsers(List<UserModel> masUser, String title) {
		System.out.println(title + ": ");
		for (int i = 0; i < masUser.size(); i++) {
			String s = String.format("%d) %s %s  (%s)", i + 1, masUser.get(i).getLastName(),
					masUser.get(i).getFirstName(), masUser.get(i).getClass().getSimpleName());
			System.out.println(s);
		}
	}

	/**
	 * Gets the list users from server.
	 * 
	 */
	private void getUsers() {
		List<UserModel> masUser = this.getServer().getAllUsersForAdmin();
		printListUsers(masUser, "Cписок пользователей");
	}

	/**
	 * Gets the list students from server.
	 * 
	 */
	private void getStudents() {
		List<UserModel> masUser = this.getServer().getStudentsForAdmin();
		printListUsers(masUser, "Cписок студентов");
	}

	/**
	 * Gets the list teachers from server.
	 * 
	 */
	private void getTeachers() {
		List<UserModel> masUser = this.getServer().getTeachersForAdmin();
		printListUsers(masUser, "Cписок преподавателей");
	}

	/**
	 * Gets the list administrators from server.
	 * 
	 */
	private void getAdministrators() {
		List<UserModel> masUser = this.getServer().getAdminForAdmin();
		printListUsers(masUser, "Cписок администраторов");
	}

}
