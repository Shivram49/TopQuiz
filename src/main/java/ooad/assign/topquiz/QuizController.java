package ooad.assign.topquiz;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ooad.assign.topquiz.models.Question;
import ooad.assign.topquiz.models.Score;
import ooad.assign.topquiz.models.Student;
import ooad.assign.topquiz.models.Test;

import java.util.ArrayList;
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
    private Button finishButton;

    @FXML
    private Label studentName;

    private Question currentQuestion;
    private  Student student;
    private Iterator<Question> questionIterator;


    private Score finalScore ;
    private int correctAnswersCount;
    private String originalButtonColor;

    public List<String> resultString;

    public QuizController(Student student) {
        this.student = student;
        List<Question> questions = student.attendTest();
        questionIterator = questions.iterator();
        correctAnswersCount = 0;
        resultString = new ArrayList<>();
    }

    @FXML
    private void initialize() {

        updateQuestion();
//        currentQuestion = questionIterator.next();

         originalButtonColor = button1.getStyle();

//        // Create UI elements
//         questionLabel = new Label(currentQuestion.getQuestion());
//         button1 = new Button(currentQuestion.getAnswer().get(0));
//         button2 = new Button(currentQuestion.getAnswer().get(1));
//         button3 = new Button(currentQuestion.getAnswer().get(2));
//         button4 = new Button(currentQuestion.getAnswer().get(3));
//         nextButton = new Button();

        // Set up the layout


        button1.setOnAction(event -> {
            if (currentQuestion.getCorrectAnswer().equals(button1.getText()))
            {
                correctAnswersCount++;
                resultString.add(currentQuestion.getCorrectAnswer());

            }
            else
                resultString.add("");

            button1.setStyle("-fx-background-color: green;");
        });

        button2.setOnAction(event -> {
            if (currentQuestion.getCorrectAnswer().equals(button2.getText())) {
                correctAnswersCount++;
                resultString.add(button2.getText());

            }
            else
                resultString.add("");
            button2.setStyle("-fx-background-color: green;");

        });

        button3.setOnAction(event -> {
            if (currentQuestion.getCorrectAnswer().equals(button3.getText())) {
                correctAnswersCount++;
                resultString.add(currentQuestion.getCorrectAnswer());

            }
            else
                resultString.add("");
            button3.setStyle("-fx-background-color: green;");

        });

        button4.setOnAction(event -> {
            if (currentQuestion.getCorrectAnswer().equals(button4.getText())) {
                correctAnswersCount++;
                resultString.add(currentQuestion.getCorrectAnswer());

            }
            else
                resultString.add("");

            button4.setStyle("-fx-background-color: green;");
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
            }

        });


        finishButton.setOnAction(actionEvent -> {

            student.submitAnswers(resultString);


            try {
                Stage thisStage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
                thisStage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("studentPermormance-view.fxml"));
                fxmlLoader.setController(new QuizPerformance(student));
                Scene scene = new Scene(fxmlLoader.load());
                Stage currStage = new Stage();
                currStage.setScene(scene);
                currStage.show();
            }

            catch (Exception e) {
                e.printStackTrace();
            }


        });

    }

    private void updateQuestion() {

        studentName.setText("Student Name : " + student.getName());


        currentQuestion = questionIterator.next();
        questionLabel.setText(currentQuestion.getQuestion());
        button1.setText(currentQuestion.getAnswer().get(0));
        button2.setText(currentQuestion.getAnswer().get(1));
        button3.setText(currentQuestion.getAnswer().get(2));
        button4.setText(currentQuestion.getAnswer().get(3));


        //reset colors
        button1.setStyle(originalButtonColor);
        button2.setStyle(originalButtonColor);
        button3.setStyle(originalButtonColor);
        button4.setStyle(originalButtonColor);


    }


}

