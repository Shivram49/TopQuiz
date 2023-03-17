package ooad.assign.topquiz.DAO;

import ooad.assign.topquiz.models.Question;
import ooad.assign.topquiz.models.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TempJDBC {
    public TempJDBC() {
    }

    public static void main(String[] args) {
        System.out.println((new StudentDAO()).getStudent("Alice","password123"));
    }
}
