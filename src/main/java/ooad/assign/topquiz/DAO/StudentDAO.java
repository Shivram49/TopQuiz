package ooad.assign.topquiz.DAO;


import ooad.assign.topquiz.models.Performance;
import ooad.assign.topquiz.models.Question;
import ooad.assign.topquiz.models.Student;
import ooad.assign.topquiz.models.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDAO {
    private static JDBCTemplate jdbcTemplate;

    public StudentDAO() {
        jdbcTemplate = new JDBCTemplate();
    }

    public Student getStudent(String username, String password) {
        ArrayList<String> cols = new ArrayList<>();
        cols.add("id");

        List<String> res = jdbcTemplate.getByValue("select * from student where username = ? and password = ?",cols,Arrays.asList(username,password));
        return new Student(new Test(),res.get(0),username);
    }

    public void setPerformance(Performance performance,String id){
        List<String> cols = Arrays.asList("total_score","math_score","science_score","english_score","student_id");
        List<String> values = Arrays.asList(String.valueOf(performance.getScore()),String.valueOf(performance.getMathScore()),String.valueOf(performance.getScienceScore()),String.valueOf(performance.getEnglishScore()),id);
        jdbcTemplate.save("performance", cols,values);
    }

    public Performance getPerformance(String id){
        List<String> cols = Arrays.asList("total_score","math_score","science_score","english_score");
        List<String> valueCheck = Arrays.asList("student_id");
        List<String> values = Arrays.asList(id);
        String sqlStatement = jdbcTemplate.createSelectStatementWithWhereAnd("performance",cols,valueCheck) ;
        List<String> res = jdbcTemplate.getByIntValue(sqlStatement, cols,values);
        if(res.size() != 0)
            return  new Performance(Integer.parseInt(res.get(0)),Integer.parseInt(res.get(1)),Integer.parseInt(res.get(2)),Integer.parseInt(res.get(3)),9);
        return null;
    }
    public List<Performance> getAllPerformances(){
        List<Performance> performances = new ArrayList<>();
        ArrayList<String> cols = new ArrayList<>();
        cols.add("total_score");
        cols.add("math_score");
        cols.add("science_score");
        cols.add("english_score");
        List<List<String>> res = jdbcTemplate.getAll("select * from performance",cols);
        for(List<String> row : res){
            performances.add(new Performance(Integer.parseInt(row.get(0)),Integer.parseInt(row.get(1)),Integer.parseInt(row.get(2)),Integer.parseInt(row.get(3)),9));
        }
        return performances;
    }

}
