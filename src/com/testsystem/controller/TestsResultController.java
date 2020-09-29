package com.testsystem.controller;

import com.testsystem.model.StudentResultOfTest;
import com.testsystem.model.TestsResult;

public class TestsResultController {

	private TestsResult testsResult;

	/**
	 * 
	 */
	public TestsResultController() {}
	
	/**
	 * @param testsResult
	 */
	public TestsResultController(TestsResult testsResult) {
		this.testsResult = testsResult;
	}

	/**
	 * @return the testsResult
	 */
	public TestsResult getTestsResult() {
		return testsResult;
	}

	/**
	 * @param testsResult the testsResult to set
	 */
	public void setTestsResult(TestsResult testsResult) {
		this.testsResult = testsResult;
	}

	/**
	 * Adds the new test result.
	 */
	public void addTestResult(StudentResultOfTest srt) {
		testsResult.getListResults().add(srt);
	}
	
}
