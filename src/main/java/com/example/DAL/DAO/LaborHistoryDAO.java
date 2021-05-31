package com.example.DAL.DAO;

import com.example.DAL.Model.LaborHistory;

import java.util.List;

public interface LaborHistoryDAO {
    void add(LaborHistory labHist);

    //read

    LaborHistory getById(Long id);

    List<LaborHistory> getAll();

    //delete
    void delete(LaborHistory labHist);
}
