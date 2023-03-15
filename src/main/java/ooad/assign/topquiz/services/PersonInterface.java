package ooad.assign.topquiz.services;

import ooad.assign.topquiz.models.Score;

import java.util.List;

public interface PersonInterface {
    public boolean login(String username,String password);
    public boolean logout();
    public Score viewPerformance(List<String> answers);

}
