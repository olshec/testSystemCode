package com.testsystem.model.test;

import java.util.List;

import com.testsystem.model.Model;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

/**
 * Represents a rating of student.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class RatingStudent extends Model {

	private User student;
	private double points;
	private Integer id;
	
	/**
	 * Creates a RatingStudent.
	 */
	public RatingStudent() {
		super();
		this.id = this.getIdIncrement();
	}

	/**
	 * Creates a RatingStudent.
	 * 
	 * @param User 		the student
	 * @param double 	the points
	 */
	public RatingStudent(User student, double points) {
		super();
		this.student = student;
		this.points = points;
		this.id = this.getIdIncrement();
	}

	/**
	 * Returns the student.
	 * 
	 * @return User the student
	 */
	public User getStudent() {
		return student;
	}

	/**
	 * Sets the student.
	 * 
	 * @param User the student
	 */
	public void setStudent(User student) {
		this.student = student;
	}
	
	/**
	 * Returns the points.
	 * 
	 * @return double the points
	 */
	public double getPoints() {
		return points;
	}

	/**
	 * Sets the points.
	 * 
	 * @param double the points
	 */
	public void setPoints(double points) {
		this.points = points;
	}

	/**
	 * Returns the id.
	 * 
	 * @return int the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param int the id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Returns rating for student.
	 * 
	 * @param User the student
	 * @return RatingStudent the rating of student
	 */
	public List<RatingStudent> getRatingTest(User student) {
		List<RatingStudent> ratingStudent = null;
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
	 * @param RatingStudent the rating of student
	 */
	public void saveRating(RatingStudent ratingTest) {
		ServiceLocator.getDaoProvider().addRecord(ratingTest);
	}

	/**
	 * Returns the hash code.
	 * 
	 * @return int the hash code of student
	 */
	@Override
	public int hashCode() {
		final int prime = 34;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Equals objects of RatingStudent.
	 * 
	 * @param Object the student
	 * @return boolean the result of compare
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
	
	/**
	 * Overrides toString() method.
	 * 
	 * @return String the name of model RatingStudent
	 */
	@Override
	public String getNameModel() {
		return "RatingStudent";
	}

	/**
	 * Clones object of RatingStudent.
	 * 
	 * @param RatingStudent the rating of student
	 */
	public void clone(RatingStudent ratingStudent) {
		setPoints(ratingStudent.getPoints());
	}
}
