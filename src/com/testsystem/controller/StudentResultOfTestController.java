package com.testsystem.controller;

import com.testsystem.model.StudentResultOfTest;
import com.testsystem.util.ServiceLocator;

public class StudentResultOfTestController {

	private StudentResultOfTest studentResultOfTest;

	/**
	 * 
	 */
	public StudentResultOfTestController() {
		super();
	}

	/**
	 * @param studentResultOfTest
	 */
	public StudentResultOfTestController(StudentResultOfTest studentResultOfTest) {
		super();
		this.studentResultOfTest = studentResultOfTest;
	}

	/**
	 * @return the studentResultOfTest
	 */
	public StudentResultOfTest getStudentResultOfTest() {
		return studentResultOfTest;
	}

	/**
	 * @param studentResultOfTest the studentResultOfTest to set
	 */
	public void setStudentResultOfTest(StudentResultOfTest studentResultOfTest) {
		this.studentResultOfTest = studentResultOfTest;
	}
	
	/**
	 * @param studentResultOfTest the studentResultOfTest to set
	 */
	public void saveStudentResultOfTest(StudentResultOfTest studentResultOfTest) {
		ServiceLocator.getDaoProvider().addRecord(studentResultOfTest);
	}
	
}
