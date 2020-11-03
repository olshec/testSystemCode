package com.testsystem.controller.test;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

public class ResultTestController {

	/**
	 * 
	 */
	public ResultTestController() {
		super();
	}

	/**
	 * @param ResultTest the result of test
	 */
	public void saveResultTest(ResultTest ResultTest) {
		ServiceLocator.getDaoProvider().addRecord(ResultTest);
	}

	/**
	 * Returns the result of test by id test.
	 * 
	 * @param student
	 * @param test
	 * @return ResultTest the result of test
	 */
	public List<ResultTest> getResultsOfTest(int idTest) {
		List<ResultTest> records = ServiceLocator.getDaoProvider().getResultTestRecords();
		List<ResultTest> ls =new ArrayList<ResultTest>();
		for(ResultTest result: records) {
			if (result.getTest().getId() == idTest) {
				ls.add(result);
			}
		}
		return ls;
	}
	
	/**
	 * Returns the result of test.
	 * 
	 * @param student
	 * @param test
	 * @return ResultTest the result of test
	 */
	public ResultTest getResultsOfTest(User student, Test test) {
		List<ResultTest> records = ServiceLocator.getDaoProvider().
				getResultTestRecords();
		for(ResultTest result: records) {
			if (result.getTest().equals(test) && 
					result.getStudent().equals(student) && 
					result.isDoneTest()) {
				return result;
			}
		}
		return null;
	}

	public int getPoints(ResultTest result) {
		// TODO Auto-generated method stub
		return 0;
	}

}
