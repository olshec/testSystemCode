package com.testsystem.controller.test;

import java.util.List;

import com.testsystem.model.test.Answer;

public class AnswerController {

	public int getCountCorrectAnswers(List<Answer> sourceAnswers) {
		int count = 0;
		for (Answer a : sourceAnswers) {
			if(a.isCorrect()) {
				count++;
			}
		}
		return count;
	}
	
	public boolean checked(Answer answer) {
		if(answer.isCorrect() == true && answer.isChecked()==true) {
			return true;
		} else if(answer.isCorrect() == false && answer.isChecked() == false) {
			return true;
		}
			return false;
	}
	
}
