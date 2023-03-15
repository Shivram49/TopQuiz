package ooad.assign.topquiz.services;

import ooad.assign.topquiz.models.Score;

public interface PersonInterface {
    public boolean login(String username,String password);
    public boolean logout();
    public Score displayPerformance();
}
