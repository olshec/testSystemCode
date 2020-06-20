package models;

import java.util.List;


public class QuestionModel {
	private String text;
	private List<AnswerModel> answers;
	
	public QuestionModel(String text) {
		setText(text);
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<AnswerModel> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerModel> answers) {
		this.answers = answers;
	}
	
}
