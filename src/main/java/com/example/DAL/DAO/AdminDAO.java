package com.example.DAL.DAO;

import com.example.DAL.Model.Admin;

public interface AdminDAO {

    void add(Admin admin);

    Admin getById(Long id);

    void checkLogin(String email, String pass);

    void update(Admin admin);

    void delete(Admin admin);

}
