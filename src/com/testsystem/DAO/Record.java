package com.testsystem.DAO;

import com.testsystem.models.Model;

public class Record {

	private Model record;
	
	public Record(Model record) {
		setRecord(record);
	}

	/**
	 * @return the records
	 */
	public Model getRecord() {
		return record;
	}

	/**
	 * @param record the record to set
	 */
	public void setRecord(Model record) {
		this.record = record;
	}
}
