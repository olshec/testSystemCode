package com.testsystem.view;

import java.util.List;

import com.testsystem.model.Model;
import com.testsystem.model.User;

/**
 * View for administrator.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class AdminView extends UserView {

	public AdminView() {
		// TODO Auto-generated constructor stub
	}

	public void printMenu() {
		System.out.println();
		System.out.println("0 - выход");
		System.out.println("1 - получить список всех пользователей");
		System.out.println("2 - получить список студентов");
		System.out.println("3 - получить список преподавателей");
		System.out.println("4 - получить список администраторов");
		System.out.print("?: ");
	}

	/**
	 * Print list users.
	 * 
	 * @param masUser The array of users.
	 * 
	 * @param title   String represents a title.
	 */
	public void printListUsers(List<Model> masUser, String title) {
		System.out.println(title + ": ");
		for (int i = 0; i < masUser.size(); i++) {
			User user = (User) masUser.get(i);
			String s = String.format("%d) %s %s  (%s)", i + 1, user.getLastName(), user.getFirstName(),
					user.getNameModel());
			System.out.println(s);
		}
	}

}
