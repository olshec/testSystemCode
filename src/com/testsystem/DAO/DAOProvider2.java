package com.testsystem.DAO;


import java.util.HashMap;

import com.testsystem.DAO.Tables.TableInterface;

public class DAOProvider2 {

	// @param name
	// @param Table
	HashMap<String, Object> tables;

	public DAOProvider2() {
		tables = new HashMap<String, Object>();
	}

	/**
	 * @param tables
	 */
	public DAOProvider2(HashMap<String, Object> tables) {
		setTables(tables);
	}

	/**
	 * @return the tables
	 */
	public HashMap<String, Object> getTables() {
		return tables;
	}

	/**
	 * @param tables the tables to set
	 */
	public void setTables(HashMap<String, Object> tables) {
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

}
