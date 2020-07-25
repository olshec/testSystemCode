package com.testsystem.DAO;


import java.util.HashMap;

import com.testsystem.DAO.Tables.TableInterface;

public class DAOProvider2 {

	// @param name
	// @param Table
	HashMap<String, TableInterface> tables;

	public DAOProvider2() {
		tables = new HashMap<String, TableInterface>();
	}

	/**
	 * @param tables
	 */
	public DAOProvider2(HashMap<String, TableInterface> tables) {
		setTables(tables);
	}

	/**
	 * @return the tables
	 */
	public HashMap<String, TableInterface> getTables() {
		return tables;
	}

	/**
	 * @param tables the tables to set
	 */
	public void setTables(HashMap<String, TableInterface> tables) {
		this.tables = tables;
	}

	/**
	 * Clears DAOProvider tables.
	 */
	public void clear() {
		tables.forEach((k, v) -> {
			((TableInterface)v).clear();
		});
	}
	
	public void addTable(String name, TableInterface ti) {
		tables.put(name, ti);
	}

	public TableInterface getTable(String name) {
		return tables.get(name);
	}
}
