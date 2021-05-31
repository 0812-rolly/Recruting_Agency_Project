package com.example.DAL.DAO;

import com.example.DAL.Model.Manager;

import java.util.List;

public interface ManagerDAO {
    void add(Manager manager);

    //read

    Manager getById(Long id);

    List<Manager> getAll();

    //update
    void update(Manager manager);

    //delete
    void delete(Manager manager);
}
