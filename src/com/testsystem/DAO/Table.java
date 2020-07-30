package com.testsystem.DAO;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.models.Model;

public class Table {

	String name;
	List<Model> listRecords;
	
	public Table() {	
		listRecords = new ArrayList<Model>();
	}

	public Table(String name) {
		this.name = name;
		this.listRecords = new ArrayList<Model>();
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
		return listRecords;
	}

	/**
	 * @param listModel the table to set
	 */
	public void setRecords(List<Model> listRecord) {
		this.listRecords = listRecord;
	}
	
	public void addRecord(Model model) {
		listRecords.add(model);
	}
	
	/**
	 * Clears DAOProvider tables.
	 */
	public void clear() {
		listRecords.clear();
	}
}
