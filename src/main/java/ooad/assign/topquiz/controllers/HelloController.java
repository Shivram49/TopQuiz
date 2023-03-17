package ooad.assign.topquiz.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ooad.assign.topquiz.HelloApplication;
import ooad.assign.topquiz.QuizController;
import ooad.assign.topquiz.models.Student;
import ooad.assign.topquiz.services.StudentService;

import java.io.IOException;

public class HelloController {


    @FXML
    private Button takeQuiz;
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;



    private Student student;

    @FXML
    private void initialize()
    {
        takeQuiz.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                try {

                    student = StudentService.login(username.getText(), password.getText());

                    Stage thisStage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
                    thisStage.close();

                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("quiz-view.fxml"));

                 //   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("quiz-view.fxml"));
                    fxmlLoader.setController(new QuizController(student));


                 //   Scene scene = new Scene(fxmlLoader.load());
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage currStage = new Stage();
                    currStage.setScene(scene);
                    currStage.show();
                }

                catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });


    }

}