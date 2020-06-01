package lab_2;

import java.util.List;
import java.util.Scanner;

public final class Teacher extends User {


	public Teacher(String lastName, String firstName, Server server, String username, String password) {
		super(lastName,  firstName,  server,  username,  password);
	}
	

	
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
			}
			catch(java.util.InputMismatchException exception) {
				num=-1;
			}
			
			switch (num) {
			case 0:
				break;
			case 1:
				getTests();
				break;
			case 2:
				getResult();
				break;
			default:
				System.out.println("Неверный ввод! Попытайтесь еще раз.");
				break;
			}

		}
		System.out.println("До свидания!");
	}

	private void getTests() {
		List<Test> mas =  this.getServer().teacherGetTests(this);
		System.out.println("Cписок тестов: ");
		for(int i=0;i<mas.size();i++) {
			System.out.println(i+1+") "+mas.get(i).getName());
		}
	}
	
	private void getResult() {

		System.out.print("Введите номер теста: ");

		Scanner myInput = new Scanner(System.in);
		
		int numTest = 0;
		try {
			numTest = myInput.nextInt();
		}
		catch(java.util.InputMismatchException exception) {
			System.out.println("Теста с таким номером не существует");
			return;
		}

		int indexTest=numTest-1;//index begin from 0;
		Test test = this.getServer().
				teacherGetTestResult(this, indexTest);
		if(test!=null) {
			List<User> masStudent = test.getStudents();
			List<Integer> masResult = test.getResults();
			if(masResult.size()>0)
			{
				for(int i=0;i<masResult.size();i++) {
					String s = String.format("%d) %s %s: %d", i+1,masStudent.get(i).getLastName(), 
							masStudent.get(i).getFirstName(),masResult.get(i));
					System.out.println(s);
				}
			}
			else {
				System.out.println("Результаты теста отсутствуют");
			}
			
		}
		else {
			System.out.println("Теста с таким номером не существует");
		}
		
		
	}

}
