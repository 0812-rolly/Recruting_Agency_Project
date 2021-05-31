package com.example.DAL.DAO;

import com.example.DAL.Model.Education;

import java.util.List;

public interface EducationDAO {
    void add(Education education);

    //read

    Education getById(Long id);

    List<Education> getAll();

    //delete
    void delete(Education education);
}
