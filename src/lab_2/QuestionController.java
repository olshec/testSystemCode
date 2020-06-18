package lab_2;

import java.util.List;
import models.QuestionModel;


public class QuestionController {
	QuestionModel questionModel;

	public QuestionController(String text) {
		questionModel=new QuestionModel();
		setText(text);
	}

	public String getText() {
		return questionModel.getText();
	}

	public void setText(String text) {
		questionModel.setText(text);
	}

	public List<Answer> getAnswers() {
		return questionModel.getAnswers();
	}

	public void setAnswers(List<Answer> answers) {
		questionModel.setAnswers(answers);
	}

}
