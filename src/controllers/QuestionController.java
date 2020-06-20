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
	
	/**
	 * @return the text question
	 */
	public String getText(int indexQuestion) {
		return questionsModel.get(indexQuestion).getText();
	}
	
	/**
	 * Set text question
	 * @param text the text
	 * @param indexQuestion the indexQuestion
	 */
	public void setText(String text, int indexQuestion) {
		questionsModel.get(indexQuestion).setText(text);
	}

	/**
	 * @return the answers
	 * @param indexQuestion the indexQuestion
	 */
	public List<AnswerModel> getAnswers(int indexQuestion) {
		return questionsModel.get(indexQuestion).getAnswers();
	}

	/**
	 * Set answers
	 * @param answers the answers
	 * @param indexQuestion the indexQuestion
	 */
	public void setAnswers(List<AnswerModel> answers,int indexQuestion) {
		questionsModel.get(indexQuestion).setAnswers(answers);
	}
	
	/**
	 * @param questionModel the questionModel to add
	 */
	public void addQuestion(QuestionModel questionModel) {
		questionsModel.add(questionModel);
	}

}
