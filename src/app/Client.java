package app;

import java.util.Scanner;

import controller.ServerController;
import models.UserModel;

/**
 * This class is the entry point to the application.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */

public class Client {

	public static void main(String[] args) {

		String login ="";
		String password ="";
		System.out.print("Введите логин: ");
		Scanner myInput = new Scanner(System.in);
		login = myInput.nextLine();
		System.out.print("Введите пароль: ");
		password = myInput.nextLine();
		
		ServerController server = new ServerController();
		UserModel user = server.login(login, password);
		
		//Student_1 login: "REgor", password: "1111"
		//Student_2 login: "ShAnton", password: "1111"
		
		//Teacher_1 login: "KirovAnton", password: "12345678"
		//SAdmin_1 login: "Admin1", password: "0000"
		if(user!=null)
			user.openMenu();
		else {
			System.out.print("Неправильный логин или пароль.");
			System.out.println("До свидания!");
		}
		
		
	}

}
