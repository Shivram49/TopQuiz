package ooad.assign.topquiz.models;

import java.util.List;

public class Question {
    private String id;
    private String topic;
    private String question;
    private List<String> answer;
    private String correctAnswer;

    public Question(String id, String topic, String question,List<String> answer, String correctAnswer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.topic = topic;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", topic='" + topic + '\'' +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
