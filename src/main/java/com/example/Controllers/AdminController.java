package com.example.Controllers;

import com.example.DAL.DAO.*;
import com.example.DAL.Model.*;
import com.example.DAL.Repository.*;
import com.example.util.StringHandler;

public class AdminController {
    private static AdminDAO adminRepository = new AdminRepository();

    public void addAdmin(String email, String password){
        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(StringHandler.encryptString(password));

        adminRepository.add(admin);
    }

    public boolean checkLogin(String email, String password){
        try{
            adminRepository.checkLogin(email, StringHandler.encryptString(password));
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public void deleteAdmin(Long adminId){
        Admin admin = adminRepository.getById(adminId);

        adminRepository.delete(admin);
    }
}
