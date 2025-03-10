package at.spengergasse;

import at.spengergasse.entities.Answer;
import at.spengergasse.entities.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private Scanner scanner = new Scanner(System.in);

    public boolean ShowQuestionandAnswer(Question question) {
    List<Answer> answers = question.getAnswersList();
    for(int i = 0; i < answers.size(); i++) {

        Answer a = answers.get(i);
        System.out.println((i+1) + ")" +a.getText());
    }


    }
}


