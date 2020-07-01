package views;

import java.util.List;
import java.util.Scanner;
import models.Test;
import models.User;
/**
 * Represents a teacher.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */

public final class TeacherView extends UserView {

	/**
	 * Creates a teacher view.
	 * 
	 * @param userModel  The teacher’s model.
	 */
	public TeacherView(User userModel) {
		super(userModel);
	}

	/** Menu.
	*/
	public void openMenu() {
		int num = -1;
		while (num != 0) {
			System.out.println();
			System.out.println("0 - выход");
			System.out.println("1 - получить список тестов");
			System.out.println("2 - получить результаты теста");
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
				getTests();
				break;
			case 2:
				getTestResult();
				break;
			default:
				System.out.println("Неверный ввод! Попытайтесь еще раз.");
				break;
			}

		}
		System.out.println("До свидания!");
	}

	/**
	 * Gets a list of tests from the server and prints.
	 */
	private void getTests() {
		List<Test> mas = this.getUserModel().getServer().getTestsForTeacher(this.getUserModel());
		System.out.println("Cписок тестов: ");
		for (int i = 0; i < mas.size(); i++) {
			System.out.println(i + 1 + ") " + mas.get(i).getName());
		}
	}

	/**
	 * Gets a result of students test from the server and prints.
	 */
	private void getTestResult() {

		System.out.print("Введите номер теста: ");

		Scanner myInput = new Scanner(System.in);

		int numTest = 0;
		try {
			numTest = myInput.nextInt();
		} catch (java.util.InputMismatchException exception) {
			System.out.println("Номер теста должен быть числом!");
			return;
		}

		int indexTest = numTest - 1;// index begin from 0;
		Test test = this.getUserModel().getServer().getTestResultForTeacher(this.getUserModel(), indexTest);
		if (test != null) {
			List<User> masStudent = test.getStudents();
			List<Integer> masResult = test.getResults();
			if (masResult.size() > 0) {
				for (int i = 0; i < masResult.size(); i++) {
					String s = String.format("%d) %s %s: %d", i + 1, masStudent.get(i).getLastName(),
							masStudent.get(i).getFirstName(), masResult.get(i));
					System.out.println(s);
				}
			} else {
				System.out.println("Результаты теста отсутствуют");
			}

		} else {
			System.out.println("Теста с таким номером не существует");
		}

	}

}
