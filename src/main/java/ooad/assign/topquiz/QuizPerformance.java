package ooad.assign.topquiz;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ooad.assign.topquiz.models.Performance;
import ooad.assign.topquiz.models.Student;
import ooad.assign.topquiz.services.PerformanceService;
import ooad.assign.topquiz.services.StudentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuizPerformance {

    @FXML
    Label titleLabel;

    @FXML
    PieChart pieChart;

    @FXML
    BarChart<String,Integer> barChart;

    @FXML
    Label studentName;

    @FXML
    Label totalScore;

    @FXML
    Button reattemptButton;

    @FXML
    Button logoutButton;


    private Student student;

    private Performance performance;

    public QuizPerformance(Student student) {
       this.student = student;
    }


    @FXML
    private void initialize() {

        studentName.setText("Student Name : " + student.getName());

        performance = student.getPerformance();

        totalScore.setText(performance.getScore() + " / " + performance.getMaxScore());


        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Math Score : ", performance.getMathScore()),
                new PieChart.Data("English Score : ", performance.getEnglishScore()),
                new PieChart.Data("Science Score : ", performance.getScienceScore())

                );

        List<Performance> performances = (new PerformanceService()).getAllPerformances();
        int i = 0;

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("All performances");
        for(Performance performance : performances){
            dataSeries1.getData().add(new XYChart.Data("student" + String.valueOf(i + 1), performance.getScore()));
            i++;
        }



//
//        dataSeries1.getData().add(new XYChart.Data("Phone"  , 65));
//        dataSeries1.getData().add(new XYChart.Data("score"  , 23));

        barChart.getData().addAll(dataSeries1);

        pieChart.setData(pieChartData);
        pieChart.setLabelsVisible(true);
        //barChart.setData(barChartData);

        pieChartData.forEach (data -> data.nameProperty().bind(
                Bindings.concat(
                        data.getName(), ":", data.pieValueProperty() )
        )
        );
    //    pieChart.getData().addAll(pieChartData);
        reattemptButton.setOnAction(actionEvent -> {


            try {
                Stage thisStage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
                thisStage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("quiz-view.fxml"));
                fxmlLoader.setController(new QuizController(student));
                Scene scene = new Scene(fxmlLoader.load());
                Stage currStage = new Stage();
                currStage.setScene(scene);
                currStage.show();
            }

            catch (Exception e) {
                e.printStackTrace();
            }


        });

        logoutButton.setOnAction(actionEvent -> {


            try {
                Stage thisStage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
                thisStage.close();

                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("student-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                stage.setTitle("Quiz");
                stage.setScene(scene);
                stage.show();

            }

            catch (Exception e) {
                e.printStackTrace();
            }


        });
    }

}
