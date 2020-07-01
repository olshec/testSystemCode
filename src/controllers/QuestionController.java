package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Answer;
import models.Question;

/**
 * Represents a question controller.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class QuestionController {
	private List<Question> questionsModel;

	/** Creates a QuestionController.
	 */
	public QuestionController() {
		questionsModel=new ArrayList<Question>();
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
	public List<Answer> getAnswers(int indexQuestion) {
		return questionsModel.get(indexQuestion).getAnswers();
	}

	/**
	 * Set answers
	 * @param answers the answers
	 * @param indexQuestion the index question
	 */
	public void setAnswers(List<Answer> answers,int indexQuestion) {
		questionsModel.get(indexQuestion).setAnswers(answers);
	}
	
	/**
	 * @param questionModel the question to add
	 */
	public void addQuestion(Question questionModel) {
		questionsModel.add(questionModel);
	}

}
