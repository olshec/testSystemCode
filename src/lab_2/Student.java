package lab_2;

import java.util.List;
import java.util.Scanner;

public final class Student extends User {

	public Student() {

	}

	public Student(Server server) {
		super(server);
	}

	public void openMenu() {
		int num = -1;
		while (num != 0) {
			System.out.println("0 - выход");
			System.out.println("1 - получить список тестов");
			System.out.println("2 - получить количество вопросов в тесте");
			System.out.print("?: ");

			Scanner myInput = new Scanner(System.in);
			num = myInput.nextInt();

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

	private void getTestsStudent() {
		List<Test> mas =  this.getServer().getTestsStudent(this);
		for(int i=0;i<mas.size();i++) {
			System.out.println(i+1+") "+mas.get(i).getName());
		}
	}
	
	private void getNumberQuestions() {

		System.out.print("Введите номер теста: ");

		Scanner myInput = new Scanner(System.in);
		int numTest = myInput.nextInt();
		numTest-=1;
		int quantityQuestions = this.getServer().getNumberQuestions(this, numTest);
		String s = String.format("Количество вопросов в тесте %d: %d", numTest, quantityQuestions);
		System.out.println(s);
	}

}
