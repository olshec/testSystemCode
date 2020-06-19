package views;

import java.util.Scanner;

import controllers.ServerController;
import models.AdminModel;
import models.UserModel;

/**
 * This class is the entry point to the application.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */

public class ClientView {

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
		UserView userView=null;
		
		switch (user.getClass().getSimpleName()) {
		case "AdminModel":
			userView=new AdminView(user);
			break;
		case "TeacherModel":
			userView=new TeacherView(user);
			break;
		case "StudentModel":
			userView=new StudentView(user);
			break;
		default:
			break;
		}
		
		//Student_1 login: "REgor", password: "1111"
		//Student_2 login: "ShAnton", password: "1111"
		
		//Teacher_1 login: "KirovAnton", password: "12345678"
		//SAdmin_1 login: "Admin1", password: "0000"
		if(userView!=null)
			userView.openMenu();
		else {
			System.out.print("Неправильный логин или пароль.");
			System.out.println("До свидания!");
		}
		
		
	}

}
