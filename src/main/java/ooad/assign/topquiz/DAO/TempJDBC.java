package ooad.assign.topquiz.DAO;

import ooad.assign.topquiz.models.Question;
import ooad.assign.topquiz.models.Student;
import ooad.assign.topquiz.models.Test;
import ooad.assign.topquiz.services.StudentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class TempJDBC {
    public TempJDBC() {
    }

    public static void main(String[] args) {
        Student currStudent = StudentService.login("Alice","password123");
        currStudent.attendTest();
//        List<String> answers = new ArrayList<>(Arrays.asList("4", "5", "42", "Skin", "Bio", "100°C", "Cold", "Went", "Children","9"));
//        currStudent.submitAnswers(answers);
//        System.out.println(currStudent);
        System.out.println(currStudent.getPerformance());

    }
}
