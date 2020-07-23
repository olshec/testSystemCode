package com.testsystem.DAO.Providers;

import com.testsystem.DAO.Tables.GroupTable;
import com.testsystem.models.Group;

/**
 * Represents a provider to the database containing groups.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class GroupTableProvider {

	private GroupTable groupTable;
	
	/**
	 * Creates a GroupTableProvider.
	 * 
	 * @param groupTable
	 */
	public GroupTableProvider(GroupTable groupTable) {
		setGroupTable(groupTable);
	}

	/**
	 * Gets new GroupTable.
	 * The table of group.
	 */
	public static GroupTable getNewGroupTable() {
		return new GroupTable();
	}

	/**
	 * Gets GroupTable.
	 * 
	 * @return the groupTable
	 */
	public GroupTable getGroupTable() {
		return groupTable;
	}

	/**
	 * Sets GroupTable.
	 * 
	 * @param groupTable the table of group to set
	 */
	public void setGroupTable(GroupTable groupTable) {
		this.groupTable = groupTable;
	}

	/**
	 * Creates new group and adds it to database.
	 * 
	 * @param String the name of group to create and add
	 */
	public void addGroup(String name) {
		Group group = new Group(name);
		groupTable.getGroups().add(group);
	}

	/**
	 * Adds group.
	 * 
	 * @param group the group to add
	 */
	public void addGroup(Group group) {
		groupTable.getGroups().add(group);
	}

	/**
	 * Gets group by name.
	 * 
	 * @param name the name of group
	 */
	public Group getGroupByName(String name) {
		for (int i = 0; i < groupTable.getGroups().size(); i++) {
			if (groupTable.getGroups().get(i).getName().equals(name)) {
				return groupTable.getGroups().get(i);
			}
		}
		return null;
	}
}
