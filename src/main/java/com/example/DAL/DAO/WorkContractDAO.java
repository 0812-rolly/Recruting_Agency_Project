package com.example.DAL.DAO;

import com.example.DAL.Model.WorkContract;

import java.util.Date;
import java.util.List;

public interface WorkContractDAO {
    void add(WorkContract workCont);

    //read

    WorkContract getById(Long id);

    List<WorkContract> getAll();

    List<WorkContract> getByDatePeriod(Date begin, Date end);

    //update
    void update(WorkContract workCont);

    //delete
    void delete(WorkContract workCont);
}
