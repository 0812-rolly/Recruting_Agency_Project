package com.example.DAL.DAO;

import com.example.DAL.Model.EmployerCompany;

import java.util.List;

public interface EmployerCompanyDAO {
    void add(EmployerCompany empComp);

    //read

    EmployerCompany getByName(String name);

    EmployerCompany getById(Long id);

    List<EmployerCompany> getByCity(String city);

    List<EmployerCompany> getAll();

    //update
    void update(EmployerCompany empComp);

    //delete
    void delete(EmployerCompany empComp);
}
