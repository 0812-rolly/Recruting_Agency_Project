package com.example.DAL.DAO;

import com.example.DAL.Model.Applicant;

import java.util.List;

public interface ApplicantDAO {
    //create
    void add(Applicant applicant);

    //read
    Applicant getByPasportNumber(String pasportNumber);

    Applicant getById(Long id);

    List<Applicant> getByReqPosition(String reqPosition);

    List<Applicant> getAll();

    //update
    void update(Applicant applicant);

    //delete
    void delete(Applicant applicant);
}
