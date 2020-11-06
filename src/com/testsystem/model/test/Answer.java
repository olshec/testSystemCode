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
	private boolean correct;
	private boolean checked;
	
	
	
	/**
	 * Constructor
	 */
	public Answer() {
		super();
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param text
	 * @param information
	 * @param correct
	 * @param checked
	 */
	public Answer(String text, String information, boolean correct, boolean checked) {
		super();
		setText(text);
		setInformation(information);
		setCorrect(correct);
		setChecked(checked);
	}
	
	/**
	 * Constructor with parameters
	 * 
	 * @param text
	 * @param information
	 * @param correct
	 */
	public Answer(String text, String information, boolean correct) {
		super();
		setText(text);
		setInformation(information);
		setCorrect(correct);
		setChecked(false);
	}

	/**
	 * Get text of answer.
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets text of answer.
	 * 
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Returns true if the answer is correct, false otherwise.
	 * 
	 * @return the correct
	 */
	public boolean isCorrect() {
		return correct;
	}

	/**
	 * Sets correct of answer.
	 * 
	 * @param correct the correct to set
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	/**
	 * Returns additional information.
	 * 
	 * @return the information
	 */
	public String getInformation() {
		return information;
	}

	/**
	 * Sets additional information.
	 * 
	 * @param information the information to set
	 */
	public void setInformation(String information) {
		this.information = information;
	}

	/**
	 * Returns true if answer is checked, false otherwise.
	 * 
	 * @return the checked
	 */
	public Boolean isChecked() {
		return checked;
	}

	/**
	 * Sets answer to checked.
	 * 
	 * @param checked the checked to set
	 */
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return text;
	}

	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "Answer";
	}
}
