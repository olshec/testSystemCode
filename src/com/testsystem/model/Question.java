package com.testsystem.model;

import java.util.List;

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
	private Integer ID;
	private static Integer idIncrement;

	static {
		idIncrement = 0;
	}

	/**
	 * Creates a QuestionModel.
	 * 
	 * @param text the text of question
	 */
	public Question(String text) {
		this.ID = Question.idIncrement;
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
		return ID;
	}

	/**
	 * Sets ID.
	 * 
	 * @param ID the ID to set
	 */
	public void setID(Integer id) {
		ID = id;
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
