package com.testsystem.util;

import java.util.Scanner;

/**
 * This class а singleton for resource java.util.Scanner.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class ModScanner {

	private static Scanner scanner;

	/**
	 * Private constructor.
	 */
	private ModScanner() {}

	/**
	 * Gets scanner.
	 */
	public static Scanner getScanner() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
	
	/**
	 * Closes scanner.
	 */
	public static void close() {
		if (scanner != null) {
			scanner.close();
		}
	}
}
