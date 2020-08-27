package com.testsystem.models;

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
	public Student(String lastName, String firstName,
					String username, String password, Group group) {
		super(lastName, firstName, username, password);
		setGroup(group);
	}

	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	public String getNameModel() {
		return nameModel;
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
