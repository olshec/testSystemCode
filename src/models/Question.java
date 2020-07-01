package models;

import java.util.List;

/**
 * Represents a question.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Question {
	private String text;
	private List<Answer> answers;
	
	/** Creates a QuestionModel.
	 * @param text The question’s text.
	 */
	public Question(String text) {
		setText(text);
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	
	
	
}
