package com.example.Controllers;

import com.example.DAL.DAO.*;
import com.example.DAL.Model.*;
import com.example.DAL.Repository.*;

import java.sql.Date;
import java.util.List;

public class EmployerCompanyController {
    private static EmployerCompanyDAO employerCompanyRepository = new EmployerCompanyRepository();

    public boolean addEmpComp(String name, String city, String addres, String phoneNumber){
        try{
            EmployerCompany empComp = new EmployerCompany();
            empComp.setName(name);
            empComp.setCity(city);
            empComp.setAddres(addres);
            empComp.setPhoneNumber(phoneNumber);

            employerCompanyRepository.add(empComp);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public EmployerCompany getByName(String name){
        try{
            return employerCompanyRepository.getByName(name);
        }
        catch(Exception e){
            return null;
        }
    }

    public EmployerCompany getById(Long id){
        try{
            return employerCompanyRepository.getById(id);
        }
        catch(Exception e){
            return null;
        }
    }

    public List<EmployerCompany> getByCity(String city){
        try{
            return employerCompanyRepository.getByCity(city);
        }
        catch(Exception e){
            return null;
        }
    }

    public List<EmployerCompany> getAll(){
        return employerCompanyRepository.getAll();
    }

    public boolean updateEmpCompPhoneNumber(Long Id, String newPhoneNumber){
        try{
            EmployerCompany empComp = employerCompanyRepository.getById(Id);
            empComp.setPhoneNumber(newPhoneNumber);

            employerCompanyRepository.update(empComp);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean updateEmpCompAddres(Long Id, String newAddres){
        try{
            EmployerCompany empComp = employerCompanyRepository.getById(Id);
            empComp.setPhoneNumber(newAddres);

            employerCompanyRepository.update(empComp);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean deleteCompany(Long Id){
        try{
            EmployerCompany empComp = employerCompanyRepository.getById(Id);

            employerCompanyRepository.delete(empComp);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
