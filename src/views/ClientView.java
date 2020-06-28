package views;

import java.util.Scanner;

import controllers.ServerController;
import models.AdministratorModel;
import models.StudentModel;
import models.TeacherModel;
import models.UserModel;

/**
 * This class is the entry point to the application.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */

public class ClientView extends UserView {

	/**main.
	 * Entry point to the application.
	 */
	public static void main(String[] args) {
		new ClientView().openMenu();
	}
	
	/** Menu.
	*/
	public void openMenu() {
		String login ="";
		String password ="";
		System.out.print("Введите логин: ");
		Scanner myInput = new Scanner(System.in);
		login = myInput.nextLine();
		System.out.print("Введите пароль: ");
		password = myInput.nextLine();
		
		ServerController server = new ServerController();
		UserModel user = server.login(login, password);

		if(user==null) {
			System.out.print("Неправильный логин или пароль.");
			System.out.println("До свидания!");
			return;
		}
		
		UserView userView=null;
		switch (user.getClass().getSimpleName()) {
		case AdministratorModel.nameModel:
			userView=new AdminView(user);
			break;
		case TeacherModel.nameModel:
			userView=new TeacherView(user);
			break;
		case StudentModel.nameModel:
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
			System.out.print("Произошла непредвиденная ошибка!");
			System.out.println("До свидания!");
		}
	}
	

}
