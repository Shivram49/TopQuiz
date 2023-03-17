package ooad.assign.topquiz.models;

import ooad.assign.topquiz.DAO.QuestionsDAO;

import java.util.ArrayList;
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
        int mathScore = 0,scienceScore = 0,englishScore = 0;
        int totalMath = (int)questions.stream().filter(i->i.getTopic().equals("math")).count();
        int totalScience = (int)questions.stream().filter(i->i.getTopic().equals("science")).count();
        int totalEnglish = (int)questions.stream().filter(i->i.getTopic().equals("english")).count();
        int totalScore = 0;
        for(int i = 0;i < questions.size();i++){
            totalScore += (questions.get(i).getCorrectAnswer().equals(answers.get(i))) ? 1 : 0;
            mathScore += (questions.get(i).getTopic().equals("math") && questions.get(i).getCorrectAnswer().equals(answers.get(i))) ? 1 : 0;
            scienceScore += (questions.get(i).getTopic().equals("science") && questions.get(i).getCorrectAnswer().equals(answers.get(i))) ? 1 : 0;
            englishScore += (questions.get(i).getTopic().equals("english") && questions.get(i).getCorrectAnswer().equals(answers.get(i))) ? 1 : 0;
        }
        int totalPerc = (totalScore / questions.size()) * 100;
        int mathPerc =  (mathScore / totalMath) * 100;
        int sciencePerc =  (scienceScore / totalScience) * 100;
        int englishPerc =  (englishScore / totalEnglish) * 100;
        return new Performance(totalPerc,mathPerc,sciencePerc,englishPerc,questions.size());
    }
}
