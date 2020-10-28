package com.testsystem.model.test;

import java.util.List;

import com.testsystem.model.Model;

/**
 * Represents a question.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Question extends Model {
	
	private String text;
	private List<Answer> answers;
	private Integer id;
	private static Integer idIncrement;

	static {
		idIncrement = 0;
	}

	/**
	 * Creates a Question.
	 * 
	 * @param text the text of question
	 */
	public Question(String text) {
		this.id = Question.idIncrement;
		Question.idIncrement++;
		setText(text);
	}

	/**
	 * Gets text of question.
	 * 
	 * @return the text of question
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets text for question.
	 * 
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets list of answers.
	 * 
	 * @return the list of answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * Sets answers for question.
	 * 
	 * @param answers the answers to set
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	/**
	 * Gets ID of question.
	 * 
	 * @return the ID
	 */
	public Integer getID() {
		return id;
	}

	/**
	 * Sets ID.
	 * 
	 * @param id the ID to set
	 */
	public void setID(Integer id) {
		this.id = id;
	}
	
	/**
	 * Returns the hash code.
	 */
	@Override
	public int hashCode() {
		final int prime = 33;
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
		Question other = (Question) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}
	
	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "Question";
	}
}
