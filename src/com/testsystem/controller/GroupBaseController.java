package com.testsystem.controller;

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
	public GroupBaseController() {
		groupBase = new GroupBase();
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

}
