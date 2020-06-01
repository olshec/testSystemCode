package lab_2;

import java.util.List;
import java.util.Scanner;

public final class Student extends User {

//	public Student() {
//
//	}

//	public Student(Server server) {
//		super(server);
//	}

	public Student(String lastName, String firstName, Server server, String username, String password) {
		super(lastName, firstName, server, username, password);
	}
	
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
			}
			catch(java.util.InputMismatchException exception) {
				num=-1;
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

	private void getTestsStudent() {
		List<Test> mas =  this.getServer().studentGetTests(this);
		System.out.println("Cписок тестов: ");
		for(int i=0;i<mas.size();i++) {
			System.out.println(i+1+") "+mas.get(i).getName());
		}
	}
	
	private void getNumberQuestions() {

		System.out.print("Введите номер теста: ");

		Scanner myInput = new Scanner(System.in);
		
		int numTest = 0;
		Boolean errorInput=false;
		try {
			numTest = myInput.nextInt();
		}
		catch(java.util.InputMismatchException exception) {
			System.out.println("Теста с таким номером не существует");
			return;
		}

		int indexTest=numTest-1;//index begin from 0;
		Test test = this.getServer().
				studentGetTestInfo(this, indexTest);
		if(test!=null) {
			int quantityQuestions =	test.getNumberQuestions();
			String s = String.format("Количество вопросов в тесте %d: %d", numTest, quantityQuestions);
			System.out.println(s);
		}
		else {
			System.out.println("Теста с таким номером не существует");
		}
		
		
	}

}
