package view;

import java.util.List;
import java.util.Scanner;

import controller.ServerController;
import controller.TestController;
import models.UserModel;

/**
 * Represents a student.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public final class StudentView extends UserModel {

	/** Creates a student.
	 * @param lastName The student’s last name.
	 * @param firstName The student’s first name.
	 * @param server The student’s server.
	 * @param username The student’s username.
	 * @param password The student’s password.
	*/
	public StudentView(String lastName, String firstName, ServerController server, String username, String password) {
		super(lastName, firstName, server, username, password);
	}

	/** Function for opening menu.
	*/
	public void openMenu() {
		int num = -1;
		while (num != 0) {
			System.out.println();
			System.out.println("0 - выход");
			System.out.println("1 - получить список тестов");
			System.out.println("2 - получить количество вопросов в тесте");
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
				getTestsStudent();
				break;
			case 2:
				getNumberQuestions();
				break;
			default:
				System.out.println("Неверный ввод! Попытайтесь еще раз.");
				break;
			}

		}
		System.out.println("До свидания!");
	}

	/**
	 * Gets a list of student tests from the server and prints.
	 * 
	 */
	private void getTestsStudent() {
		List<TestController> mas = this.getServer().getTestsForStudent(this);
		System.out.println("Cписок тестов: ");
		for (int i = 0; i < mas.size(); i++) {
			System.out.println(i + 1 + ") " + mas.get(i).getName());
		}
	}

	/**
	 * Gets the number of test questions from the server and prints.
	 * 
	 */
	private void getNumberQuestions() {

		System.out.print("Введите номер теста: ");

		Scanner myInput = new Scanner(System.in);

		int numTest = 0;
		try {
			numTest = myInput.nextInt();
		} catch (java.util.InputMismatchException exception) {
			System.out.println("Теста с таким номером не существует");
			return;
		}

		int indexTest = numTest - 1;// index begin from 0;
		TestController test = this.getServer().getTestInfoForStudent(this, indexTest);
		if (test != null) {
			int quantityQuestions = test.getNumberQuestions();
			String s = String.format("Количество вопросов в тесте %d: %d", numTest, quantityQuestions);
			System.out.println(s);
		} else {
			System.out.println("Теста с таким номером не существует");
		}

	}

}