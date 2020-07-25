package com.testsystem.DAO.Tables;

import java.util.ArrayList;
import java.util.List;

public class Table<T extends TableInterface> {

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
		setList(list);
	}

	/**
	 * @return the list
	 */
	public List<T> getList() {
		return listRecord;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<T> list) {
		this.listRecord = list;
	}

	public void clear() {
		listRecord.clear();
	}
}
