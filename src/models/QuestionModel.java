package models;

import java.util.List;


public class QuestionModel {
	private String text;
	private List<AnswerModel> answers;
	
	public QuestionModel(String text) {
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
	public List<AnswerModel> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(List<AnswerModel> answers) {
		this.answers = answers;
	}
	
	
	
}
