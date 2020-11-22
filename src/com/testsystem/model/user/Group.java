package com.testsystem.model.user;

import com.testsystem.model.Model;

/**
 * Represents a group.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Group extends Model{
	
	private String name;
	
	/**
	 * Creates a Group.
	 */
	public Group() {}
	
	/**
	 * Creates a Group.
	 * 
	 * @param String the name of group.
	 */
	public Group(String name) {
		this.name=name;
	}
	
	/**
	 * Returns the name of group.
	 * 
	 * @return String the name of group
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of group.
	 * 
	 * @param String the name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets name of model Group.
	 * 
	 * @return String return name of model group
	 */
	public String getNameModel() {
		return "Group";
	}
	
	/**
	 * Returns the hash code.
	 * 
	 * @return int the hash code of group
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Сhecks equality of objects.
	 * 
	 * @param Object the group
	 * @return boolean the result of compare objects
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
