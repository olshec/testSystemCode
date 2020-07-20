package com.testsystem.models;

/**
 * Represents a group.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Group {
	
	private String name;
	
	/**
	 * Creates a Group.
	 * 
	 * Default constructor
	 */
	public Group() {
	}
	
	/**
	 * Creates a Group.
	 * 
	 * @param name  the name of group.
	 */
	public Group(String name) {
		this.name=name;
	}
	
	/**
	 * Gets name of group.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 * 
	 * @param name the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

}
