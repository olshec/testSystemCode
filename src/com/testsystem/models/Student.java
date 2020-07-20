package com.testsystem.models;

import com.testsystem.controller.ServerController;

/**
 * Represents a student.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Student extends User {

	public static final String nameModel = "Student";
	private Group group;

	/**
	 * Creates a StudentModel.
	 * 
	 * @param lastName  the user’s last name
	 * @param firstName the user’s first name
	 * @param server    the user’s server
	 * @param username  the user’s username
	 * @param password  the user’s password
	 */
	public Student(String lastName, String firstName, ServerController server, 
					String username, String password, Group group) {
		super(lastName, firstName, server, username, password);
		setGroup(group);
	}

	/**
	 * Gets group.
	 * 
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * Sets group.
	 * 
	 * @param group the group to set
	 */
	public void setGroup(Group group) {
		this.group = group;
	}
}
