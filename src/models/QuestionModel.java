package models;

import java.util.List;

import controllers.AnswerController;

public class QuestionModel {
	private String text;
	private List<AnswerController> answers;
	
	public QuestionModel(String text) {
		setText(text);
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<AnswerController> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerController> answers) {
		this.answers = answers;
	}
	
}
