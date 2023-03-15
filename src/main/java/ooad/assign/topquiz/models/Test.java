package ooad.assign.topquiz.models;

import ooad.assign.topquiz.DAO.QuestionsDAO;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private ArrayList<Question> questions;

    public void setQuestions(){

    }
    public List<Question> attendTest(){
        QuestionsDAO questionsDAO = new QuestionsDAO();
        return questionsDAO.getQuestions();
    }

    public Score calculateScore(){
        return null;
    }
}
