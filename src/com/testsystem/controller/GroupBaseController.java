package com.testsystem.controller;


import com.testsystem.models.Group;
import com.testsystem.models.GroupBase;

/**
 * Represents a GroupBaseController.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class GroupBaseController {

	private GroupBase groupBase;

	/**
	 * Creates a GroupBaseController.
	 */
//	public GroupBaseController() {
//		groupBase = new GroupBase();
//	}

	/**
	 * Gets new GroupBase.
	 * The database of group.
	 */
	public static GroupBase getNewGroupBase() {
		return new GroupBase();
	}
	
	/**
	 * Creates a GroupBaseController.
	 * 
	 * @param groupBase
	 */
	public GroupBaseController(GroupBase groupBase) {
		setGroupBase(groupBase);
	}

	/**
	 * Gets GroupBase.
	 * 
	 * @return the groupBase
	 */
	public GroupBase getGroupBase() {
		return groupBase;
	}

	/**
	 * Sets GroupBase.
	 * 
	 * @param groupBase the groupBase to set
	 */
	public void setGroupBase(GroupBase groupBase) {
		this.groupBase = groupBase;
	}

	/**
	 * Creates new group and adds it to database.
	 * 
	 * @param String the name of group to create and add
	 */
	public void addGroup(String name) {
		Group group = new Group(name);
		groupBase.getGroups().add(group);
	}

	/**
	 * Adds group.
	 * 
	 * @param group the group to add
	 */
	public void addGroup(Group group) {
		groupBase.getGroups().add(group);
	}

	/**
	 * Gets group by name.
	 * 
	 * @param name the name of group
	 */
	public Group getGroupByName(String name) {
		for (int i = 0; i < groupBase.getGroups().size(); i++) {
			if (groupBase.getGroups().get(i).getName().equals(name)) {
				return groupBase.getGroups().get(i);
			}
		}
		return null;
	}
}
