package ooad.assign.topquiz.services;

import ooad.assign.topquiz.DAO.StudentDAO;
import ooad.assign.topquiz.models.Performance;

import java.util.List;

public class PerformanceService {
    public List<Performance> getAllPerformances(){
        return new StudentDAO().getAllPerformances();
    }
}
