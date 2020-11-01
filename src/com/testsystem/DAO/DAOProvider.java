package com.testsystem.DAO;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.Group;
import com.testsystem.model.Model;
import com.testsystem.model.Student;
import com.testsystem.model.User;
import com.testsystem.model.test.StudentResultOfTest;
import com.testsystem.model.test.Test;

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
	 * @param tables
	 */
	public DAOProvider(Database database) {
		setDatabase(database);
	}

	/**
	 * Gets database.
	 * 
	 * @return Database the database
	 */
	public Database getDatabase() {
		return database;
	}

	/**
	 * Sets database.
	 * 
	 * @param database the database to set
	 */
	public void setDatabase(Database database) {
		this.database = database;
	}
	
	/**
	 * Sets table.
	 * 
	 * @param name the name of table
	 * @param table the table to set
	 */
	public void setTable(String name, List<Model> listRecord) {
		database.setTable(name, listRecord);
	}
	
	/**
	 * Clears tables in database.
	 */
	public void clear() {
		database.clear();
	}
	
	/**
	 * Adds a new table
	 * 
	 * @param name the name of table
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
	 * Gets all records from table
	 * 
	 * @param nameTable
	 * @return List<Model> the records of table
	 */
	public List<Model> getRecords(String nameTable) {
		return database.getTable(nameTable).getRecords();
	}
	
	/**
	 * Gets all groups from database
	 * 
	 * @param nameTable
	 * @return List<Group> the records of table
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
	 * Gets all tests from database
	 * 
	 * @param nameTable
	 * @return List<Test> the records of table
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
	 * Gets all users from database
	 * 
	 * @param nameTable
	 * @return List<User> the records of table
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
	 * Gets all students from database
	 * 
	 * @param nameTable
	 * @return List<Student> the records of table
	 */
	public List<Student> getStudentsRecords(String nameTable) {
		List<Student> ls = new ArrayList<Student>();
		List<Model> models = database.getTable(nameTable).getRecords();
		for(Model st : models) {
			ls.add((Student)st);
		}
		return ls;
	}
	
//	public List<User> getAdministrators(String nameTable) {
//		List<User> ls = new ArrayList<User>();
//		List<Model> models = database.getTable(nameTable).getRecords();
//		for(Model st : models) {
//			ls.add((User)st);
//		}
//		return ls;
//	}
	
	/**
	 * Gets all tests from database
	 * 
	 * @param nameTable
	 * @return List<Test> the records of table
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
	 * Gets equals test.
	 * 
	 * @param test the Test model.
	 * @return Test 
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
	 * Gets all student result of test from database
	 * 
	 * @param nameTable
	 * @return List<Test> the records of table
	 */
	public List<StudentResultOfTest> getStudentResultOfTestRecords() {
		List<StudentResultOfTest> ls = new ArrayList<StudentResultOfTest>();
		List<Model> models = database.getTable(new StudentResultOfTest().getNameModel()).getRecords();
		for(Model st : models) {
			ls.add((StudentResultOfTest)st);
		}
		return ls;
	}
	
}
