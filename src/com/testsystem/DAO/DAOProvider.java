package com.testsystem.DAO;

import java.util.List;
import com.testsystem.models.Model;

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
	public List<Model> getRecordsTable(String nameTable) {
		return database.getTable(nameTable).getRecords();
	}
}
