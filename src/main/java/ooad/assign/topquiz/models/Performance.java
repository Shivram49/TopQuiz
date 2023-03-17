package ooad.assign.topquiz.models;

import java.util.HashMap;
//score needs addition
public class Performance {
    private int score;
    private int mathScore;
    private int scienceScore;
    private int englishScore;
    private int maxScore;

    public Performance(int score, int mathScore, int scienceScore, int englishScore, int maxScore) {
        this.score = score;
        this.mathScore = mathScore;
        this.scienceScore = scienceScore;
        this.englishScore = englishScore;
        this.maxScore = maxScore;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "score=" + score +
                ", mathScore=" + mathScore +
                ", scienceScore=" + scienceScore +
                ", englishScore=" + englishScore +
                ", maxScore=" + maxScore +
                '}';
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int pointsToAdd){
        this.score += pointsToAdd;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getScienceScore() {
        return scienceScore;
    }

    public void setScienceScore(int scienceScore) {
        this.scienceScore = scienceScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }


}
