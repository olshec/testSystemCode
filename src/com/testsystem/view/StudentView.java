package com.testsystem.view;

import java.util.List;

import com.testsystem.model.Model;
import com.testsystem.model.Test;

/**
 * View for student.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class StudentView extends UserView {

	public StudentView() {

	}

	public void printMenu() {
		System.out.println();
		System.out.println("0 - выход");
		System.out.println("1 - получить список тестов");
		System.out.println("2 - получить количество вопросов в тесте");
		System.out.print("?: ");
	}

	/**
	 * Print a list of student tests from the server and prints.
	 */
	public void printTestsStudent(List<Model> mas) {
		System.out.println("Cписок тестов: ");
		for (int i = 0; i < mas.size(); i++) {
			System.out.println(i + 1 + ") " + ((Test) mas.get(i)).getName());
		}
	}

	public void EnterNumberTest() {
		System.out.print("Введите номер теста: ");
	}

	public void PrintCountQuestionsInTest(int numTest, int quantityQuestions) {
		if (quantityQuestions < 0) {
			System.out.println("Теста с таким номером не существует!");
		} else {
			String s = String.format("Количество вопросов в тесте %d: %d", numTest, quantityQuestions);
			System.out.println(s);
		}

	}

}
