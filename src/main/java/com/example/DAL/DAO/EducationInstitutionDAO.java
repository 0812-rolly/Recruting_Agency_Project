package com.example.DAL.DAO;

import com.example.DAL.Model.EducationInstitution;

import java.util.List;

public interface EducationInstitutionDAO {
    void add(EducationInstitution edInst);

    //read

    EducationInstitution getById(Long id);

    List<EducationInstitution> getAll();

    List<EducationInstitution> getByCity(String city);

    //update
    void update(EducationInstitution edInst);

    //delete
    void delete(EducationInstitution edInst);
}
