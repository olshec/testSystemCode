package com.testsystem.model.user;

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
	 * Creates a Student.
	 */
	public Student() {}
	
	/**
	 * Creates a Student.
	 * 
	 * @param String  the user’s last name
	 * @param String  the user’s first name
	 * @param String  the user’s username
	 * @param String  the user’s password
	 * @param Group   the user’s group
	 */
	public Student(String lastName, String firstName,
					String username, String password, Group group) {
		super(lastName, firstName, username, password);
		setGroup(group);
	}

	/**
	 * Returns the name of model student.
	 * 
	 * @return String the name of model
	 */
	public String getNameModel() {
		return nameModel;
	}
	
	/**
	 * Returns the group.
	 * 
	 * @return Group the group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * Sets group.
	 * 
	 * @param Group the group
	 */
	public void setGroup(Group group) {
		this.group = group;
	}
}
