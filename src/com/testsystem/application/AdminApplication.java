package com.testsystem.application;

import java.util.List;

import com.testsystem.controller.FrontController;
import com.testsystem.model.Model;
import com.testsystem.model.User;
import com.testsystem.util.ModScanner;
import com.testsystem.view.AdminView;

/**
 * Represents an application for administrator.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class AdminApplication extends UserApplication {

	/**
	 * Creates an administrator view.
	 * 
	 * @param user The administrator's model
	 */
	public AdminApplication(User user, FrontController frontController) {
		super(user, frontController);
	}

	/**
	 * Method for open menu.
	 */
	public void openMenu() {
		int num = -1;
		while (num != 0) {
			new AdminView().printMenu();

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
				new AdminView().printErrorEnter();
				break;
			}
		}
		new AdminView().printExit();
	}

	/*
	 * Print the list users from server.
	 */
	private void getUsers() {
		List<Model> masUser = getFrontController().getAllUsersForAdmin(this.getUser());
		new AdminView().printListUsers(masUser, "Cписок пользователей");
	}

	/*
	 * Print the list students from server.
	 */
	private void getStudents() {
		List<Model> masUser = getFrontController().getStudentsForAdmin(this.getUser());
		new AdminView().printListUsers(masUser, "Cписок студентов");
	}

	/*
	 * Print the list teachers from server.
	 */
	private void getTeachers() {
		List<Model> masUser = getFrontController().getTeachersForAdmin(this.getUser());
		new AdminView().printListUsers(masUser, "Cписок преподавателей");
	}

	/*
	 * Print the list administrators from server.
	 */
	private void getAdministrators() {
		List<Model> masUser = getFrontController().getAdminsForAdmin(this.getUser());
		new AdminView().printListUsers(masUser, "Cписок администраторов");
	}
}
