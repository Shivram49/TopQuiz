package ooad.assign.topquiz.models;

import ooad.assign.topquiz.DAO.StudentDAO;

import java.util.Arrays;
import java.util.List;

public class Student{
    private Test test;
    private String id;
    private String name;
    private Performance performance;
    StudentDAO studentDAO;

    public Student(Test test, String id, String name) {
        this.test = test;
        this.id = id;
        this.name = name;
        studentDAO = new StudentDAO();
    }

    public List<Question> attendTest(){
        return test.attendTest();
    }

    public void submitAnswers(List<String> answers){
        this.performance = test.submitAnswers(answers);
        //use existing services to push this into database.
        studentDAO.setPerformance(this.performance,this.id);
    }

    public Performance getPerformance(){
        if(this.performance == null){
            return this.performance = studentDAO.getPerformance(this.id);
        }
        return this.performance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "test=" + test +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", performance=" + performance +
                '}';
    }
}
