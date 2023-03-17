package ooad.assign.topquiz.DAO;

import ooad.assign.topquiz.models.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionsDAO {
    private JDBCTemplate jdbcTemplate;

    public QuestionsDAO() {
        jdbcTemplate = new JDBCTemplate();
    }

    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        ArrayList<String> cols = new ArrayList<>();
        cols.add("id");
        cols.add("topic");
        cols.add("question");
        cols.add("answer1");
        cols.add("answer2");
        cols.add("answer3");
        cols.add("answer4");
        cols.add("correct_answer1");

        List<List<String>> res = jdbcTemplate.getAll("select * from questions",cols);
        for(List<String> row : res){
            List<String> answers = new ArrayList<>();
            int startIndex = 3;
            int endIndex = 6;
            answers = row.stream().skip(startIndex).limit(endIndex - startIndex + 1).collect(Collectors.toList());
            questions.add(new Question(row.get(0), row.get(1), row.get(2), answers, row.get(row.size() - 1)));

        }
        return questions;
    }
}

