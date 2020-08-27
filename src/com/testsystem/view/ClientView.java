package com.testsystem.view;

public class ClientView extends UserView {

	public ClientView() {
		
	}

	public void printEnterLogin() {
		System.out.print("Введите логин: ");
	}
	
	public void printEnterPassword() {
		System.out.print("Введите пароль: ");
	}
	
	public void printErrorLoginOrPassword() {
		System.out.print("Неправильный логин или пароль.");
		System.out.println("До свидания!");
	}
	
	public void printUndefinedError() {
		System.out.print("Произошла непредвиденная ошибка!");
		System.out.println("До свидания!");
	}

}
