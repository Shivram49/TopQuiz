package ooad.assign.topquiz.models;

import ooad.assign.topquiz.DAO.QuestionsDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Test {
    private List<Question> questions;

    public void setQuestions(){

    }
    public List<Question> attendTest(){
        QuestionsDAO questionsDAO = new QuestionsDAO();
        questions = questionsDAO.getQuestions();
        return questions;
    }

    public Performance submitAnswers(List<String> answers){
        if(answers == null || answers.size() != questions.size()){
            return new Performance(0,0,0,0,questions.size());
        }
        int mathScore = 0,scienceScore = 0,englishScore = 0;
//        int totalMath = (int)questions.stream().filter(i->i.getTopic().equals("math")).count();
//        int totalScience = (int)questions.stream().filter(i->i.getTopic().equals("science")).count();
//        int totalEnglish = (int)questions.stream().filter(i->i.getTopic().equals("english")).count();
        int totalScore = 0;
        for(int i = 0;i < questions.size();i++){
            totalScore += (questions.get(i).getCorrectAnswer().equals(answers.get(i))) ? 1 : 0;
            mathScore += (questions.get(i).getTopic().equals("math") && questions.get(i).getCorrectAnswer().equals(answers.get(i))) ? 1 : 0;
            scienceScore += (questions.get(i).getTopic().equals("science") && questions.get(i).getCorrectAnswer().equals(answers.get(i))) ? 1 : 0;
            englishScore += (questions.get(i).getTopic().equals("english") && questions.get(i).getCorrectAnswer().equals(answers.get(i))) ? 1 : 0;
        }
        return new Performance(totalScore,mathScore,scienceScore,englishScore,questions.size());
    }
}
