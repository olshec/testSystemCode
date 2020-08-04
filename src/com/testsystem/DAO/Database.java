package com.testsystem.DAO;

import java.util.HashMap;
import java.util.List;
import com.testsystem.models.Model;

/**
 * Represents a database.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Database {

	private HashMap<String, Table> tables;
	
	/**
	 * Creates a database.
	 */
	public Database() {
		tables = new HashMap<String, Table>();
	}

	/**
	 * Creates a database.
	 * 
	 * @param database
	 */
	public Database(HashMap<String, Table> database) {
		setDatabase(database);
	}

	/**
	 * Gets database.
	 * 
	 * @return the database
	 */
	public HashMap<String, Table> getDatabase() {
		return tables;
	}

	/**
	 * Sets database.
	 * 
	 * @param database the database to set
	 */
	public void setDatabase(HashMap<String, Table> database) {
		this.tables = database;
	}

	/**
	 * Gets table.
	 * 
	 * @param name the name of table
	 * @return Table
	 */
	public Table getTable(String name) {
		return tables.get(name);
	}
	
	/**
	 * Clears DAOProvider tables.
	 */
	public void clear() {
		tables.forEach((k, v) -> {
			((Table)v).clear();
		});
	}

	/**
	 * Adds a new table.
	 * 
	 * @param name the table.
	 */
	public void addTable(String name) {
		Table table = new Table(name);
		tables.put(name, table);
	}
	
	/**
	 * Adds a record.
	 * 
	 * @param record the model to add to the database
	 */
	public void addRecord(Model record) {
		tables.forEach((k, v) -> {
			if(k.toString().equals(record.getNameModel()))
			((Table)v).addRecord(record);
		});
	}

	/**
	 * Sets table.
	 * 
	 * @param name of table
	 * @param listRecord the list of model
	 */
	public void setTable(String name, List<Model> listRecord) {
		this.getTable(name).setRecords(listRecord);
		
	}
	
}
