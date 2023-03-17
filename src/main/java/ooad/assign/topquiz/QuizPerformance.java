package ooad.assign.topquiz;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import ooad.assign.topquiz.models.Performance;
import ooad.assign.topquiz.models.Student;

import java.util.HashMap;

public class QuizPerformance {

    @FXML
    Label titleLabel;

    @FXML
      PieChart pieChart;

    @FXML
    Label studentName;


    private Student student;

    private Performance performance;

    public QuizPerformance(Student student) {
       this.student = student;
    }


    @FXML
    private void initialize() {

        studentName.setText("Student Name : " + student.getName());

        performance = student.getPerformance();


//                HashMap<String,Integer> map = new HashMap<>();
//        map.put("Tree",10);
//        map.put("Car",5);


        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
//                new PieChart.Data("Math Score : ", performance.getMathScore()),
//                new PieChart.Data("English Score : ", performance.getEnglishScore()),
//                new PieChart.Data("Science Score : ", performance.getScienceScore())

                new PieChart.Data("Math Score : ", 10),
                new PieChart.Data("English Score : ", 20),
                new PieChart.Data("Science Score : ", 30)
                );

//        for (String key : map.keySet()) {
//            pieChartData.add(new PieChart.Data(key, map.get(key)));
//        }


        pieChart.setData(pieChartData);
        pieChart.setLabelsVisible(true);

        pieChartData.forEach (data -> data.nameProperty().bind(
                Bindings.concat(
                        data.getName(), "amount: ", data.pieValueProperty() )
        )
        );

    //    pieChart.getData().addAll(pieChartData);

    }

}
