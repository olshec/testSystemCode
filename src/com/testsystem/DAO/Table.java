package com.testsystem.DAO;

import java.util.ArrayList;
import java.util.List;

public class Table<T> implements TableInterface {

	private List<T> listRecord;

	/**
	 * Creates a Table.
	 */
	public Table() {
		listRecord = new ArrayList<T>();
	}

	/**
	 * Creates a Table.
	 * 
	 * @param groups the list of groups
	 */
	public Table(List<T> list) {
		setListRecord(list);
	}

	/**
	 * @return the list
	 */
	public List<T> getListRecord() {
		return listRecord;
	}

	/**
	 * @param listRecord the list to set
	 */
	public void setListRecord(List<T> listRecord) {
		this.listRecord = listRecord;
	}

	@Override
	public void clear() {
		listRecord.clear();
	}
}
