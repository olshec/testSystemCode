package com.testsystem.model.test;

import com.testsystem.model.Model;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

public class RatingStudent extends Model {

	private User student;
	private int points;
	private Integer id;
	private static Integer idIncrement;
	
	static {
		idIncrement = 0;
	}
	
	/**
	 * Creates a RatingStudent
	 */
	public RatingStudent() {
		super();
	}

	/**
	 * Creates a RatingStudent
	 * 
	 * @param student
	 * @param points
	 */
	public RatingStudent(User student, int points) {
		super();
		this.student = student;
		this.points = points;
		this.id = RatingStudent.idIncrement;
		RatingStudent.idIncrement++;
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
	 * Gets rating for student
	 * 
	 * @param student
	 * @return RatingStudent
	 */
	public RatingStudent getRatingTest(User student) {
		RatingStudent ratingStudent = null;
		try {
			ratingStudent = ServiceLocator.getDaoProvider().getRatingStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ratingStudent;
	}
	
	/**
	 * Adds rating of test.
	 * 
	 * @param ratingTest the rating of student
	 */
	public void saveRating(RatingStudent ratingTest) {
		ServiceLocator.getDaoProvider().addRecord(ratingTest);
	}

	/**
	 * Returns the hash code.
	 */
	@Override
	public int hashCode() {
		final int prime = 34;
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
		RatingStudent other = (RatingStudent) obj;
		if (this.id != other.getId()) {
			return false;
		}
		return true;
	}
	
	@Override
	public String getNameModel() {
		return "RatingStudent";
	}
}
