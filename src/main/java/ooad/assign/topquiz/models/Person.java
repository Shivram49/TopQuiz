package ooad.assign.topquiz.models;

import ooad.assign.topquiz.services.PersonInterface;

import java.util.List;

public class Person implements PersonInterface {
    private int name;

    public Person() {
    }

    public Person(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public boolean login(String username, String password) {
        //username password should be validated with database
        return true;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public Score viewPerformance(List<String> answers) {
        return null;
    }
}
