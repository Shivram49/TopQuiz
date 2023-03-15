package ooad.assign.topquiz.models;

import java.util.List;

public class Student extends Person{
    private Test test;
    public Student(int name) {
        super(name);
        test = new Test();
    }
    public List<Question> attendTest(){
        return test.attendTest();
    }

    @Override
    public Score viewPerformance(List<String>  answers){
        return test.calculateScore(answers);
    }
}
