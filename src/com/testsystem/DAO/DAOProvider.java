package com.testsystem.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.testsystem.models.Model;

public class DAOProvider {

	// @param name
	// @param List<Model> is Table
	private HashMap<String, List<Model>> database;
	
	public DAOProvider() {
		database = new HashMap<String, List<Model>>();
	}
	
	/**
	 * @param tables
	 */
	public DAOProvider(HashMap<String, List<Model>> tables) {
		setTables(tables);
	}

	/**
	 * @return the tables
	 */
	public HashMap<String, List<Model>> getTables() {
		return database;
	}

	/**
	 * @param tables the tables to set
	 */
	public void setTables(HashMap<String, List<Model>> tables) {
		this.database = tables;
	}
	
	/**
	 * @param table the table to set
	 */
	public void setTable(String name, List<Model> table) {
		database.remove(name);
		database.put(name, table);
	}
	
	/**
	 * Clears DAOProvider tables.
	 */
	public void clear() {
		database.forEach((k, v) -> {
			((List<Model>)v).clear();
		});
	}
	
	public void addTable(String name) {
		List<Model> newTable = new ArrayList<Model>();
		database.put(name, newTable);
	}
	
	public void addRecord(String name, Model record) {
		database.forEach((k, v) -> {
			if(((String)k).equals(name)) {
				((List<Model>)v).add(record);	
			}
		});
	}
	
	/**
	 * Gets all records from table
	 * 
	 * @param nameTable
	 * @return List<Model> the records of table
	 */
	public List<Model> getRecordsTable(String nameTable) {
		for (String i : database.keySet()) {
			return database.get(i);
		}
		return null;
	}
}
