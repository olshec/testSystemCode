package com.testsystem.model;

/**
 * Represents a model.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public abstract class Model {

	private static Integer idIncrement;
	
	static {
		idIncrement = 0;
	}
	
	/**
	 * Returns the name of model.
	 * 
	 * @return String the name of model
	 */
	public abstract String getNameModel();

	protected int getIdIncrement() {
		Model.idIncrement++;
		return Model.idIncrement;
	}

}
