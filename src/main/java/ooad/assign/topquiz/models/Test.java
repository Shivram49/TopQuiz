package ooad.assign.topquiz.models;

import ooad.assign.topquiz.DAO.QuestionsDAO;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private List<Question> questions;

    public void setQuestions(){

    }
    public List<Question> attendTest(){
        QuestionsDAO questionsDAO = new QuestionsDAO();
        questions = questionsDAO.getQuestions();
        return questions;
    }

    public Score calculateScore(List<String> answers){

        return null;
    }
}
