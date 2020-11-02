package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.test.StudentResultOfTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

public class StudentResultOfTestController {

	/**
	 * 
	 */
	public StudentResultOfTestController() {
		super();
	}

	/**
	 * @param studentResultOfTest the studentResultOfTest to set
	 */
	public void saveStudentResultOfTest(StudentResultOfTest studentResultOfTest) {
		ServiceLocator.getDaoProvider().addRecord(studentResultOfTest);
	}

	public List<StudentResultOfTest> getResultsOfTest(int idTest) {
		List<StudentResultOfTest> records = ServiceLocator.getDaoProvider().getStudentResultOfTestRecords();
		List<StudentResultOfTest> ls =new ArrayList<StudentResultOfTest>();
		for(StudentResultOfTest result: records) {
			if (result.getTest().getId() == idTest) {
				ls.add(result);
			}
		}
		return ls;
	}
	
	public StudentResultOfTest getResultsOfTest(User student, Test test) {
		List<StudentResultOfTest> records = ServiceLocator.getDaoProvider().
				getStudentResultOfTestRecords();
		for(StudentResultOfTest result: records) {
			if (result.getTest().equals(test) && 
					result.getStudent().equals(student) && 
					result.getResult() != -1) {
				return result;
			}
		}
		return null;
	}

}
