package com.testsystem.DAO;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.Model;
import com.testsystem.model.test.RatingStudent;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.Group;
import com.testsystem.model.user.Student;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

/**
 * Represents a provider for database.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class DAOProvider {

	private Database database;
	
	/**
	 * Creates a provider.
	 */
	public DAOProvider() {
		database = new Database();
	}
	
	/**
	 * Creates a provider.
	 * 
	 * @param Database the database
	 */
	public DAOProvider(Database database) {
		setDatabase(database);
	}

	/**
	 * Returns the database.
	 * 
	 * @return Database the database
	 */
	public Database getDatabase() {
		return database;
	}

	/**
	 * Sets database.
	 * 
	 * @param Database the database to set
	 */
	public void setDatabase(Database database) {
		this.database = database;
	}
	
	/**
	 * Sets table.
	 * 
	 * @param String 		the name of table
	 * @param List<Model> 	the list of record for install table
	 */
	public void setTable(String name, List<Model> listRecord) {
		database.setTable(name, listRecord);
	}
	
	/**
	 * Clears all tables in database.
	 */
	public void clearDatabase() {
		database.clear();
	}
	
	/**
	 * Adds a new table
	 * 
	 * @param String the name of table
	 */
	public void addTable(String name) {
		database.addTable(name);
	}
	
	/**
	 * Adds a new record
	 * 
	 * @param record the model to add
	 */
	public void addRecord(Model record) {
		database.addRecord(record);
	}
	
	/**
	 * Returns all records from table
	 * 
	 * @param String the name of table
	 * @return List<Model> the all records of table from the database
	 */
	public List<Model> getRecords(String nameTable) {
		return database.getTable(nameTable).getRecords();
	}
	
	/**
	 * Returns all groups from database
	 * 
	 * @param String the name of table
	 * @return List<Group> the all records of group from the database
	 */
	public List<Group> getGroupsRecords(String nameTable) {
		List<Group> ls = new ArrayList<Group>();
		List<Model> models = database.getTable(nameTable).getRecords();
		for(Model st : models) {
			ls.add((Group)st);
		}
		return ls;
	}

	/**
	 * Returns all tests from database
	 * 
	 * @param String the name of table
	 * @return List<Test> the all records of tests from the database
	 */
	public List<Test> getTestsRecords(String nameTable) {
		List<Test> ls = new ArrayList<Test>();
		List<Model> models = database.getTable(nameTable).getRecords();
		for(Model st : models) {
			ls.add((Test)st);
		}
		return ls;
	}

	/**
	 * Returns all users from database
	 * 
	 * @param String the name of table
	 * @return List<User> the all records of users from the database
	 */
	public List<User> getUsersRecords(String nameTable) {
		List<User> ls = new ArrayList<User>();
		List<Model> models = database.getTable(nameTable).getRecords();
		for(Model st : models) {
			ls.add((User)st);
		}
		return ls;
	}

	/**
	 * Returns all students from database
	 * 
	 * @param String the name of table
	 * @return List<Student> the all records about students from the database
	 */
	public List<Student> getStudentsRecords(String nameTable) {
		List<Student> ls = new ArrayList<Student>();
		List<Model> models = database.getTable(nameTable).getRecords();
		for(Model st : models) {
			ls.add((Student)st);
		}
		return ls;
	}
	
	/**
	 * Returns all tests from database
	 * 
	 * @return List<Test> the all records about tests from the database
	 */
	public List<Test> getTestsRecords() {
		List<Test> ls = new ArrayList<Test>();
		List<Model> models = database.getTable(new Test().getNameModel()).getRecords();
		for(Model st : models) {
			ls.add((Test)st);
		}
		return ls;
	}
	
	/**
	 * Returns equals test. 
	 * This method use for get source test by test came from student.
	 * 
	 * @param Test the test.
	 * @return Test the test
	 */
	public Test getTest(Test test) {
		Test testReturns = null;
		List<Model> models = database.getTable(new Test().getNameModel()).getRecords();
		for(Model st : models) {
			Test t = (Test)st;
			if(t.equals(test)) {
				testReturns = t;
			}
		}
		return testReturns;
	}
	
	/**
	 * Returns all student result of test from database
	 * 
	 * @param String the name of table
	 * @return List<ResultTest> the all records about results of tests
	 */
	public List<ResultTest> getResultTestRecords() {
		List<ResultTest> ls = new ArrayList<ResultTest>();
		List<Model> models = database.getTable(new ResultTest().getNameModel()).getRecords();
		for(Model st : models) {
			ls.add((ResultTest)st);
		}
		return ls;
	}
	
	/**
	 * Returns rating for student from database
	 * 
	 * @param User the student
	 * @return List<RatingStudent> the records of student rating 
	 */
	public List<RatingStudent> getRatingStudent(User student) {
		List<RatingStudent> ls = new ArrayList<RatingStudent>();
		List<RatingStudent> listRatingStudents = new ArrayList<RatingStudent>();
		List<Model> models = database.getTable(new RatingStudent().getNameModel()).getRecords();
		for(Model st : models) {
			ls.add((RatingStudent)st);
		}
		for(RatingStudent rating: ls) {
			if(rating.getStudent().equals(student)) {
				listRatingStudents.add(rating);
			}
		}
		return listRatingStudents;
	}

	/**
	 * Updates rating for student
	 * 
	 * @param RatingStudent the rating of student
	 */
	public void updateRatingStudent(RatingStudent ratingStudent) {
		List<RatingStudent> listRatingStudents = this.getRatingStudent(ratingStudent.getStudent());
		if (listRatingStudents.size() == 0) {
			//save first record about rating of student
			this.addRecord(ratingStudent);
		} else {
			listRatingStudents.get(0).clone(ratingStudent);
		}
	}
	
}
