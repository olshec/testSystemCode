package com.testsystem.controller;

import com.testsystem.models.Group;

/**
 * Represents a GroupBaseController.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class GroupController {

	private Group group;
	
	/**
	 * Creates a GroupController.
	 */
	public GroupController() {
		
	}
	
	/**
	 * Creates a GroupController.
	 * 
	 * @param group the group
	 */
	public GroupController(Group group) {
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
