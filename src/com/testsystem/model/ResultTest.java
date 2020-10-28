package com.testsystem.model;

import java.util.List;

public class ResultTest {
	
	private int numberQuestions;
	private int numberCorrectQuestions;
	private int percentCorrectQuesionts;
	
	private StudentResultOfTest studentResultOfTest;
	private List<ResultQuestion> resultQuestions;
	
	/**
	 * 
	 */
	public ResultTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param numberQuestions
	 * @param numberCorrectQuestions
	 * @param percentCorrectQuesionts
	 */
	public ResultTest(int numberQuestions, int numberCorrectQuestions, int percentCorrectQuesionts) {
		super();
		setNumberQuestions(numberQuestions);
		setNumberCorrectQuestions(numberCorrectQuestions);
		setPercentCorrectQuesionts(percentCorrectQuesionts);
	}
	
	/**
	 * @return the numberQuestions
	 */
	public int getNumberQuestions() {
		return numberQuestions;
	}
	/**
	 * @param numberQuestions the numberQuestions to set
	 */
	public void setNumberQuestions(int numberQuestions) {
		this.numberQuestions = numberQuestions;
	}
	/**
	 * @return the numberCorrectQuestions
	 */
	public int getNumberCorrectQuestions() {
		return numberCorrectQuestions;
	}
	/**
	 * @param numberCorrectQuestions the numberCorrectQuestions to set
	 */
	public void setNumberCorrectQuestions(int numberCorrectQuestions) {
		this.numberCorrectQuestions = numberCorrectQuestions;
	}
	/**
	 * @return the percentCorrectQuesionts
	 */
	public int getPercentCorrectQuesionts() {
		return percentCorrectQuesionts;
	}
	/**
	 * @param percentCorrectQuesionts the percentCorrectQuesionts to set
	 */
	public void setPercentCorrectQuesionts(int percentCorrectQuesionts) {
		this.percentCorrectQuesionts = percentCorrectQuesionts;
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
	 * @return the resultQuestions
	 */
	public List<ResultQuestion> getResultQuestions() {
		return resultQuestions;
	}

	/**
	 * @param resultQuestions the resultQuestions to set
	 */
	public void setResultQuestions(List<ResultQuestion> resultQuestions) {
		this.resultQuestions = resultQuestions;
	}
	
	
}
