package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.models.Group;
import com.testsystem.models.GroupBase;
import com.testsystem.models.User;
import com.testsystem.models.UserBase;

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
		Group group=new Group(name);
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
	 * Gets student by group.
	 * 
	 * @param userBase the database of user
	 */
	public List<User> getStudentByGroup(UserBase userBase, Group group){
		List<User> listUser = new ArrayList<User>();
		for (int i=0; i < userBase.getUsers().size(); i++) {
			listUser.add(userBase.getUsers().get(i));
		}
		return listUser;
	}
}
