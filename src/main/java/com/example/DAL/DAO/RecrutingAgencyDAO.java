package com.example.DAL.DAO;

import com.example.DAL.Model.RecrutingAgency;

import java.util.List;

public interface RecrutingAgencyDAO {
    void add(RecrutingAgency recAg);

    //read

    RecrutingAgency getById(Long id);

    List<RecrutingAgency> getAll();

    //delete
    void delete(RecrutingAgency recAg);
}
