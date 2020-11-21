package com.testsystem.model.test;

import com.testsystem.model.Model;

/**
 * Represents an answer.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Answer extends Model {
	
	private String text;
	private String information;
	private boolean isCorrect;
	private boolean isChecked;
	
	/**
	 * Creates Answer.
	 */
	public Answer() {
		super();
	}

	/**
	 * Creates Answer.
	 * 
	 * @param String the text of answer
	 * @param String the information of answer
	 * @param boolean the isCorrect checkbox
	 * @param boolean the isChecked checkbox
	 */
	public Answer(String text, String information, boolean isCorrect, boolean isChecked) {
		super();
		setText(text);
		setInformation(information);
		setCorrect(isCorrect);
		setChecked(isChecked);
	}
	
	/**
	 * Constructor with parameters
	 * 
	 * @param String the text of answer
	 * @param String the information of answer
	 * @param boolean the isCorrect checkbox
	 */
	public Answer(String text, String information, boolean isCorrect) {
		super();
		setText(text);
		setInformation(information);
		setCorrect(isCorrect);
		setChecked(false);
	}

	/**
	 * Returns the text of answer.
	 * 
	 * @return String the text of answer
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets text of answer.
	 * 
	 * @param String the text to set answer.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Returns true if the answer is correct, false otherwise.
	 * 
	 * @return boolean the checkbox of isCorrect to set in answer
	 */
	public boolean isCorrect() {
		return isCorrect;
	}

	/**
	 * Sets correct of answer.
	 * 
	 * @param boolean the checkbox of isCorrect to set in answer
	 */
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	/**
	 * Returns additional information.
	 * 
	 * @return String the information of answer
	 */
	public String getInformation() {
		return information;
	}

	/**
	 * Sets additional information.
	 * 
	 * @param String the information to set in answer
	 */
	public void setInformation(String information) {
		this.information = information;
	}

	/**
	 * Returns true if answer is checked, false otherwise.
	 * 
	 * @return boolean the checkbox of isChecked
	 */
	public boolean isChecked() {
		return isChecked;
	}

	/**
	 * Sets answer to checked.
	 * 
	 * @param boolean the checked to set checkbox of isChecked
	 */
	public void setChecked(boolean checked) {
		this.isChecked = checked;
	}

	/**
	 * Overrides toString method.
	 */
	@Override
	public String toString() {
		return text;
	}

	/**
	 * Returns name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "Answer";
	}

	/**
	 * Clears checked.
	 */
	public void clearChecked() {
		isChecked = false;
	}
	
}
