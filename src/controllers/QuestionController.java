package controllers;

import java.util.ArrayList;
import java.util.List;

import models.AnswerModel;
import models.QuestionModel;

/**
 * Represents a question controller.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class QuestionController {
	private List<QuestionModel> questionsModel;

	/** Creates a QuestionController.
	 */
	public QuestionController() {
		questionsModel=new ArrayList<QuestionModel>();
	}
	
	/**
	 * @param indexQuestion the index question
	 * @return the text question
	 */
	public String getText(int indexQuestion) {
		return questionsModel.get(indexQuestion).getText();
	}
	
	/**
	 * Set text question
	 * @param text the text question
	 * @param indexQuestion the index question
	 */
	public void setText(String text, int indexQuestion) {
		questionsModel.get(indexQuestion).setText(text);
	}

	/**
	 * @param indexQuestion the index question
	 * @return the answers
	 */
	public List<AnswerModel> getAnswers(int indexQuestion) {
		return questionsModel.get(indexQuestion).getAnswers();
	}

	/**
	 * Set answers
	 * @param answers the answers
	 * @param indexQuestion the index question
	 */
	public void setAnswers(List<AnswerModel> answers,int indexQuestion) {
		questionsModel.get(indexQuestion).setAnswers(answers);
	}
	
	/**
	 * @param questionModel the question to add
	 */
	public void addQuestion(QuestionModel questionModel) {
		questionsModel.add(questionModel);
	}

}
