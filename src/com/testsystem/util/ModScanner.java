package com.testsystem.util;

import java.util.Scanner;

public class ModScanner {

	private static Scanner scanner;

	private ModScanner() {}

	public static Scanner getScanner() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
	
	public static void close() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
		scanner.close();
	}
}
