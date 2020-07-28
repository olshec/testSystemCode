package com.testsystem.DAO;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.models.Model;

public class Table {

	String name;
	List<Model> listRecord;
	
	public Table() {	
		listRecord = new ArrayList<Model>();
	}

	public Table(String name) {
		this.name = name;
		this.listRecord = new ArrayList<Model>();
	}
	
	/**
	 * @param table
	 */
	public Table(String name, List<Model> table) {
		setRecords(table);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the table
	 */
	public List<Model> getRecords() {
		return listRecord;
	}

	/**
	 * @param listModel the table to set
	 */
	public void setRecords(List<Model> listRecord) {
		this.listRecord = listRecord;
	}
	
	public void addRecord(Model model) {
		listRecord.add(model);
	}
	
	/**
	 * Clears DAOProvider tables.
	 */
	public void clear() {
		listRecord.clear();
	}
}
