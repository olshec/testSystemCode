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
	
}
