package lab_2;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		String login ="";
		String password ="";
		System.out.print("Введите логин: ");
		Scanner myInput = new Scanner(System.in);
		login = myInput.nextLine();
		System.out.print("Введите пароль: ");
		password = myInput.nextLine();
		//myInput.close();
		
		Server server = new Server();
		//User user = server.login("REgor", "1111");
		//"ShAnton","1111"
		User user = server.login(login, password);
		
		//User user = server.login("KirovAnton", "12345678");
		//User user = server.login( "Admin1", "0000");
		
		user.openMenu();
		
		
	}

}
