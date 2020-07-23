package com.testsystem.DAO.Tables;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.models.Group;

/**
 * Represents a table of group.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class GroupTable {

	private List<Group> groups;
	
	/**
	 * Creates a GroupTable.
	 */
	public GroupTable() {
		groups=new ArrayList<Group>();
	}

	/**
	 * Creates a GroupTable.
	 * 
	 * @param groups the list of groups
	 */
	public GroupTable(List<Group> groups) {
		setGroups(groups);
	}
	
	/**
	 * Gets groups.
	 * 
	 * @return the groups
	 */
	public List<Group> getGroups() {
		return groups;
	}

	/**
	 * Sets groups.
	 * 
	 * @param groups the groups to set
	 */
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
}
