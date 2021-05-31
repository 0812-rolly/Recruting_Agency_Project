package com.example.DAL.DAO;

import com.example.DAL.Model.Company;

import java.util.List;

public interface CompanyDAO {

    void add(Company company);

    //read
    Company getByName(String name);

    Company getById(Long id);

    List<Company> getByCity(String city);

    List<Company> getAll();

    //update
    void update(Company company);

    //delete
    void delete(Company company);

}
