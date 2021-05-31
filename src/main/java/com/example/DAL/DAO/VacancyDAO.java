package com.example.DAL.DAO;

import com.example.DAL.Model.Applicant;
import com.example.DAL.Model.Vacancy;

import java.util.List;

public interface VacancyDAO {
    void add(Vacancy vacancy);

    //read

    Vacancy getById(Long id);

    List<Vacancy> getByPropPosition(String propPosition);

    List<Vacancy> getAll();

    //update
    void update(Vacancy vacancy);

    //delete
    void delete(Vacancy vacancy);
}
