package com.testsystem.DAO;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.Model;

/**
 * Represents a table for database.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Table {

	private String name;
	private List<Model> listRecords;
	
	/**
	 * Creates a table.
	 */
	public Table() {	
		listRecords = new ArrayList<Model>();
	}

	/**
	 * Creates a table.
	 * 
	 * @param name the name of table
	 */
	public Table(String name) {
		this.name = name;
		this.listRecords = new ArrayList<Model>();
	}
	
	/**
	 * Creates a table.
	 * 
	 * @param name the name of table
	 * @param table the list of model
	 */
	public Table(String name, List<Model> table) {
		setRecords(table);
	}
	
	/**
	 * Returns name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 * 
	 * @param String the name of table
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns records.
	 * 
	 * @return List<Model> the list of records from table
	 */
	public List<Model> getRecords() {
		return listRecords;
	}

	/**
	 * Sets records.
	 * 
	 * @param List<Model> the list of record to install a table
	 */
	public void setRecords(List<Model> listRecord) {
		this.listRecords = listRecord;
	}
	
	/**
	 * Adds records.
	 * 
	 * @param Model the model to insert in a table
	 */
	public void addRecord(Model model) {
		listRecords.add(model);
	}
	
	/**
	 * Clears all tables.
	 */
	public void clear() {
		listRecords.clear();
	}
}
