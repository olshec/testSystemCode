package com.testsystem.model.test;

import java.util.ArrayList;
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

	/**
	 * Creates a Question.
	 * 
	 * @param text the text of question
	 */
	public Question(String text) {
		answers = new ArrayList<Answer>();
		this.id = this.getIdIncrement();
		setText(text);
	}

	/**
	 * Returns text of question.
	 * 
	 * @return String the text of question
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets text for question.
	 * 
	 * @param String the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Returns list of answers.
	 * 
	 * @return List<Answer> the list of answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * Sets answers for question.
	 * 
	 * @param List<Answer> the answers to set
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	/**
	 * Returns ID of question.
	 * 
	 * @return int the ID
	 */
	public int getID() {
		return id;
	}

	/**
	 * Sets id.
	 * 
	 * @param int the id to set
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the hash code.
	 * 
	 * @return int the hash code of this object
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
	 * 
	 * @param Object the question
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
		Question other = (Question) obj;
		if (this.id != other.getID()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Clears checked answers.
	 */
	public void clearAnswers() {
		for(Answer a : answers) {
			a.clearChecked();
		}
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
