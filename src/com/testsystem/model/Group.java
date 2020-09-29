package com.testsystem.model;

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
	 * @param name  the name of group.
	 */
	public Group(String name) {
		this.name=name;
	}
	
	/**
	 * Gets name of group.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 * 
	 * @param name the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	public String getNameModel() {
		return "Group";
	}
	
	/**
	 * Returns the hash code.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Equals check.
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
