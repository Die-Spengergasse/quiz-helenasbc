package at.spengergasse;

import at.spengergasse.entities.Answer;
import at.spengergasse.entities.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private Scanner scanner = new Scanner(System.in);

    private int correctAnswer;
    private int totalQuestions;

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    public void startQuiz() {
        for (Question question : questions) {
            totalQuestions++;
            boolean correct = showQuestionAndCheckAnswer(question);
            if (correct) {
                correctAnswer++;
            }
        }
        showFinalScore();
    }


    public boolean showQuestionAndCheckAnswer(Question question) {
        System.out.println("\n" + question.getText());
        List<Answer> answers = question.getAnswersList();
        for (int i = 0; i < answers.size(); i++) {
            Answer a = answers.get(i);
            System.out.println((i + 1) + ")" + a.getText());
        }
        System.out.print("type your answers: ");
        int userChoice = Integer.parseInt(scanner.nextLine());

        if (userChoice > 0 && userChoice <= answers.size()) {
            Answer selectedAnswer = answers.get(userChoice - 1);
            if (selectedAnswer.isCorrect()) {
                System.out.println("true!");
                return true;
            } else {
                System.out.println("false! The right answer is : " + getCorrectAnswerText(question));
            }
        } else {
            System.out.println("Error!");
        }

        return false;
    }

    private String getCorrectAnswerText(Question question) {
        for (Answer answer : question.getAnswersList()) {
            if (answer.isCorrect()) {
                return answer.getText();
            }
        }
        return "";
    }

    private void showFinalScore() {
        double percentage = ((double) correctAnswer / totalQuestions) * 100;
        System.out.println("\nQuiz is finished!");
        System.out.println("You have " + correctAnswer + " out of " + totalQuestions + " Answer is true.");
    }

}




