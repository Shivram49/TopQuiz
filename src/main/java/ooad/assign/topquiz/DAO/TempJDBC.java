package ooad.assign.topquiz.DAO;

import ooad.assign.topquiz.models.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TempJDBC {
    public TempJDBC() {
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "apple");
        props.setProperty("ssl", "false");
        String sql = "SELECT question,answer1 from questions";
        List<Question> questions = new ArrayList<Question>();
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            try {
                ResultSet rs = stmt.executeQuery("select * from questions");
                while (rs.next()) {
                    String name = rs.getString("question");
                    questions.add(new Question(rs.getString("id"),rs.getString("topic"),rs.getString("question"),new ArrayList<String>(),rs.getString("correct_answer1")));
                }
            } catch (SQLException e ) {
                throw new Error("Problem", e);
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
        questions.stream().forEach(System.out::println);
    }
}
