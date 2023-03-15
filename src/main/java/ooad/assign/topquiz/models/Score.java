package ooad.assign.topquiz.models;

import java.util.HashMap;
//score needs addition
public class Score {
    private Question question;
    private Student student;
    private int points;
    HashMap<String,Integer> topicWiseScore;

    public Score(Question question, Student student) {
        this.question = question;
        this.student = student;
    }

    public int getScore() {
        return points;
    }

    public void setScore(int points) {
        this.points = points;
    }

    public void addScore(int pointsToAdd){
        this.points += pointsToAdd;
    }

    public void addTopicScore(String topic,int points){
        topicWiseScore.put(topic,topicWiseScore.getOrDefault(topic,0) + 1);
    }
    public int getTopicScore(String topic){
        return topicWiseScore.get(topic);
    }
}
