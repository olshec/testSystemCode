package com.testsystem.controller;

import com.testsystem.models.GroupBase;

public class GroupBaseController {

	private GroupBase groupBase;

	public GroupBaseController() {
		groupBase = new GroupBase();
	}

	
	/**
	 * @param groupBase
	 */
	public GroupBaseController(GroupBase groupBase) {
		setGroupBase(groupBase);
	}

	/**
	 * @return the groupBase
	 */
	public GroupBase getGroupBase() {
		return groupBase;
	}

	/**
	 * @param groupBase the groupBase to set
	 */
	public void setGroupBase(GroupBase groupBase) {
		this.groupBase = groupBase;
	}

}
