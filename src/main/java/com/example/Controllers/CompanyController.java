package com.example.Controllers;

import com.example.DAL.DAO.*;
import com.example.DAL.Model.*;
import com.example.DAL.Repository.*;

import java.sql.Date;
import java.util.List;

public class CompanyController {
    private static CompanyDAO companyRepository = new CompanyRepository();

    public boolean addCompany(String name, String city, String addres, String phoneNumber){
        try{
            Company company = new Company();
            company.setName(name);
            company.setCity(city);
            company.setAddres(addres);
            company.setPhoneNumber(phoneNumber);

            companyRepository.add(company);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Company getByName(String name){
        try{
            return companyRepository.getByName(name);
        }
        catch(Exception e){
            return null;
        }
    }

    public Company getById(Long id){
        try{
            return companyRepository.getById(id);
        }
        catch(Exception e){
            return null;
        }
    }

    public List<Company> getByCity(String city){
        try{
            return companyRepository.getByCity(city);
        }
        catch(Exception e){
            return null;
        }
    }

    public boolean updateCompPhoneNumber(Long Id, String newPhoneNumber){
        try{
            Company company = companyRepository.getById(Id);
            company.setPhoneNumber(newPhoneNumber);

            companyRepository.update(company);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean updateCompAddres(Long Id, String newAddres){
        try{
            Company company = companyRepository.getById(Id);
            company.setPhoneNumber(newAddres);

            companyRepository.update(company);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public List<Company> getAll(){
        return companyRepository.getAll();
    }

    public boolean deleteCompany(Long Id){
        try{
            Company company = companyRepository.getById(Id);

            companyRepository.delete(company);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
