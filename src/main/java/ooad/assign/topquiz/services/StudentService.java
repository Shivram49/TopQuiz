package ooad.assign.topquiz.services;

import ooad.assign.topquiz.DAO.StudentDAO;
import ooad.assign.topquiz.models.Student;

public class StudentService {
    public static Student login(String username,String password){
        return (new StudentDAO()).getStudent(username,password);
    }

}
