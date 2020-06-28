package views;

import java.util.List;
import java.util.Scanner;
import models.TestModel;
import models.UserModel;

/**
 * Represents a student.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public final class StudentView extends UserView {

	/** Creates a student view.
	 * @param userModel The student’s model.
	*/
	public StudentView(UserModel userModel) {
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
	 */
	private void getTestsStudent() {
		List<TestModel> mas = this.getUserModel().getServer().getTestsForStudent(this.getUserModel());
		System.out.println("Cписок тестов: ");
		for (int i = 0; i < mas.size(); i++) {
			System.out.println(i + 1 + ") " + mas.get(i).getName());
		}
	}

	/**
	 * Gets the number of test questions from the server and prints.
	 */
	private void getNumberQuestions() {

		System.out.print("Введите номер теста: ");

		Scanner myInput = new Scanner(System.in);

		int numTest = 0;
		try {
			numTest = myInput.nextInt();
		} catch (java.util.InputMismatchException exception) {
			System.out.println("Ошибка ввода! Номер теста должен быть числом!");
			return;
		}

		// --numTest index begin from 0;
			int quantityQuestions = this.getUserModel().getServer().getNumberQuestionsInTest(this.getUserModel(), numTest-1);
			if(quantityQuestions<0) {
				System.out.println("Теста с таким номером не существует!");
			}
			else {
				String s = String.format("Количество вопросов в тесте %d: %d", numTest, quantityQuestions);
				System.out.println(s);
			}
			

	}

}
