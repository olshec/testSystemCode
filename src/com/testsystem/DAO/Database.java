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
	
	public Database() {
		tables = new HashMap<String, Table>();
	}

	/**
	 * @param database
	 */
	public Database(HashMap<String, Table> database) {
		setDatabase(database);
	}

	/**
	 * @return the database
	 */
	public HashMap<String, Table> getDatabase() {
		return tables;
	}

	/**
	 * @param database the database to set
	 */
	public void setDatabase(HashMap<String, Table> database) {
		this.tables = database;
	}

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

	public void addTable(String name) {
		Table table = new Table(name);
		tables.put(name, table);
	}
	
	public void addRecord(Model record) {
		tables.forEach((k, v) -> {
			if(k.toString().equals(record.getNameModel()))
			((Table)v).addRecord(record);
		});
	}

	public void setTable(String name, List<Model> listRecord) {
		this.getTable(name).setRecords(listRecord);
		
	}
	
}
