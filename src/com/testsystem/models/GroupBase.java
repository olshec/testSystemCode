package com.testsystem.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a database of group.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class GroupBase {

	private List<Group> groups;
	
	/**
	 * Creates a GroupBase.
	 * Default constructor.
	 */
	public GroupBase() {
		groups=new ArrayList<Group>();
	}

	/**
	 * Creates a GroupBase.
	 * 
	 * @param groups The list of groups.
	 */
	public GroupBase(List<Group> groups) {
		setGroups(groups);
	}
	
	/**
	 * Gets groups.
	 * 
	 * @return the groups.
	 */
	public List<Group> getGroups() {
		return groups;
	}

	/**
	 * Sets groups.
	 * 
	 * @param groups The groups to set.
	 */
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
}
