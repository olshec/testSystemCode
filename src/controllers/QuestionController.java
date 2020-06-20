package controllers;

import java.util.ArrayList;
import java.util.List;

import models.AnswerModel;
import models.QuestionModel;


public class QuestionController {
	List<QuestionModel> questionsModel;

	public QuestionController() {
		questionsModel=new ArrayList<QuestionModel>();
	}
	

	public String getText(int indexQuestion) {
		return questionsModel.get(indexQuestion).getText();
	}

	public void setText(String text, int indexQuestion) {
		questionsModel.get(indexQuestion).setText(text);
	}

	public List<AnswerModel> getAnswers(int indexQuestion) {
		return questionsModel.get(indexQuestion).getAnswers();
	}

	public void setAnswers(List<AnswerModel> answers,int indexQuestion) {
		questionsModel.get(indexQuestion).setAnswers(answers);
	}
	
	public void addQuestion(QuestionModel qm) {
		questionsModel.add(qm);
	}

}
