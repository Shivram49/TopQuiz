package ooad.assign.topquiz;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ooad.assign.topquiz.models.Question;
import ooad.assign.topquiz.models.Student;

import java.util.Iterator;
import java.util.List;

public class QuizController  {


    @FXML
    private Label questionLabel;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button nextButton;

    @FXML
    private Label Finalscore;
    private Question currentQuestion;
    private  Student student;
    private Iterator<Question> questionIterator;
    private int correctAnswersCount;

    public QuizController() {
        student = new Student(1);
        List<Question> questions = student.attendTest();
        questionIterator = questions.iterator();
        correctAnswersCount = 0;
    }

    @FXML
    private void initialize() {

        updateQuestion();
//        currentQuestion = questionIterator.next();


//        // Create UI elements
//         questionLabel = new Label(currentQuestion.getQuestion());
//         button1 = new Button(currentQuestion.getAnswer().get(0));
//         button2 = new Button(currentQuestion.getAnswer().get(1));
//         button3 = new Button(currentQuestion.getAnswer().get(2));
//         button4 = new Button(currentQuestion.getAnswer().get(3));
//         nextButton = new Button();

        // Set up the layout


        button1.setOnAction(event -> {
            if (currentQuestion.getCorrectAnswer().equals(button1.getText())) {
                correctAnswersCount++;
            }
        });

        button2.setOnAction(event -> {
            if (currentQuestion.getCorrectAnswer().equals(button2.getText())) {
                correctAnswersCount++;
            }
        });

        button3.setOnAction(event -> {
            if (currentQuestion.getCorrectAnswer().equals(button3.getText())) {
                correctAnswersCount++;
            }
        });

        button4.setOnAction(event -> {
            if (currentQuestion.getCorrectAnswer().equals(button4.getText())) {
                correctAnswersCount++;
            }
        });
        // Set up the next button behavior
        nextButton.setOnAction(event -> {
            if(questionIterator.hasNext())
            {
                updateQuestion();
            }
            else
            {
                nextButton.setDisable(true);
                Finalscore.setText("Final Score " + String.valueOf(correctAnswersCount));
            }

        });

    }

    private void updateQuestion() {
        currentQuestion = questionIterator.next();
        questionLabel.setText(currentQuestion.getQuestion());
        button1.setText(currentQuestion.getAnswer().get(0));
        button2.setText(currentQuestion.getAnswer().get(1));
        button3.setText(currentQuestion.getAnswer().get(2));
        button4.setText(currentQuestion.getAnswer().get(3));
    }


}

