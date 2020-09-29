package com.testsystem.model;

import java.util.ArrayList;
import java.util.List;

public class TestsResult extends Model{
	
	private List<StudentResultOfTest> listResults;
	
	/**
	 * 
	 */
	public TestsResult() {
		super();
		listResults = new ArrayList<StudentResultOfTest>();
	}

	/**
	 * @param listResults
	 */
	public TestsResult(List<StudentResultOfTest> listResults) {
		super();
		this.listResults = listResults;
	}

	/**
	 * @return the listResults
	 */
	public List<StudentResultOfTest> getListResults() {
		return listResults;
	}

	/**
	 * @param listResults the listResults to set
	 */
	public void setListResults(List<StudentResultOfTest> listResults) {
		this.listResults = listResults;
	}
	
	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "TestsResult";
	}
	
}
