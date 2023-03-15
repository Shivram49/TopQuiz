package ooad.assign.topquiz.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ooad.assign.topquiz.HelloApplication;

import java.io.IOException;

public class HelloController {


    @FXML
    private Button takeQuiz;

    @FXML
    private void initialize()
    {
        takeQuiz.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                try {
                    Stage thisStage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
                    thisStage.close();

                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("quiz-view.fxml"));
                    Scene scene = null;
                    scene = new Scene(fxmlLoader.load());
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