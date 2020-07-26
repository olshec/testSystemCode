package com.testsystem.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.testsystem.models.Model;

public class DAOProvider2 {

	// @param name
	// @param Table
	HashMap<String, List<Model>> tables;
	
	public DAOProvider2() {
		tables = new HashMap<String, List<Model>>();
	}
	
	/**
	 * @param tables
	 */
	public DAOProvider2(HashMap<String, List<Model>> tables) {
		setTables(tables);
	}

	/**
	 * @return the tables
	 */
	public HashMap<String, List<Model>> getTables() {
		return tables;
	}

	/**
	 * @param tables the tables to set
	 */
	public void setTables(HashMap<String, List<Model>> tables) {
		this.tables = tables;
	}
	
	/**
	 * Clears DAOProvider tables.
	 */
	public void clear() {
		tables.forEach((k, v) -> {
			((List<Model>)v).clear();
		});
	}
	
	public void addTable(String name) {
		List<Model> newTable = new ArrayList<Model>();
		tables.put(name, newTable);
	}
	
	public void addRecord(String name, Model record) {
		tables.forEach((k, v) -> {
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
		for (String i : tables.keySet()) {
			return tables.get(i);
		}
		return null;
	}
}
