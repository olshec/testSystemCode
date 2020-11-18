package com.testsystem.model.test;

import com.testsystem.model.Model;
import com.testsystem.model.user.Group;
import com.testsystem.model.user.User;

public class RatingGroup extends Model {
	private Group group;
	private User student;
	private int points;
	private Integer id;
	private static Integer idIncrement;
		
	static {
		idIncrement = 0;
	}
	
	/**
	 * Creates a RatingGroup
	 * 
	 * @param group
	 * @param points
	 */
	public RatingGroup(Group group, User student, int points) {
		super();
		this.group = group;
		this.points = points;
		this.student = student;
		this.id = RatingGroup.idIncrement;
		RatingGroup.idIncrement++;
	}
	
	/**
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Group group) {
		this.group = group;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the student
	 */
	public User getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(User student) {
		this.student = student;
	}

	/**
	 * Returns the hash code.
	 */
	@Override
	public int hashCode() {
		final int prime = 35;
		int result = 1;
		result = prime * result + id;
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
		RatingGroup other = (RatingGroup) obj;
		if (this.id != other.getId()) {
			return false;
		}
		return true;
	}

	@Override
	public String getNameModel() {
		return "RatingGroup";
	}
	
}
