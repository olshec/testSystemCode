package com.testsystem.DAO;

import java.util.List;

import com.testsystem.models.Model;

public class DAOProvider {

	private Database database;
	
	public DAOProvider() {
		database = new Database();
	}
	
	/**
	 * @param tables
	 */
	public DAOProvider(Database database) {
		setDatabase(database);
	}

	/**
	 * @return the tables
	 */
	public Database getDatabase() {
		return database;
	}

	/**
	 * @param database the tables to set
	 */
	public void setDatabase(Database database) {
		this.database = database;
	}
	
	/**
	 * @param table the table to set
	 */
	public void setTable(String name, List<Model> listRecord) {
		database.setTable(name, listRecord);
	}
	
	/**
	 * Clears DAOProvider tables.
	 */
	public void clear() {
		database.clear();
	}
	
	public void addTable(String name) {
		database.addTable(name);
	}
	
	public void addRecord(Model record) {
		database.addRecord(record);
	}
	
	/**
	 * Gets all records from table
	 * 
	 * @param nameTable
	 * @return List<Model> the records of table
	 */
	public List<Model> getRecordsTable(String nameTable) {
		return database.getTable(nameTable).getRecords();
	}
}
