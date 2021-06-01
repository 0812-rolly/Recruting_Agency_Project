package com.example.Controllers;

import com.example.DAL.DAO.*;
import com.example.DAL.Model.*;
import com.example.DAL.Repository.*;

import java.sql.Date;
import java.util.List;

public class EducationInstitutionController {
    private static EducationInstitutionDAO educationInstitutionRepository = new EducationInstitutionReposytory();

    public boolean addEdInst(String name, String city, String addres, String phoneNumber){
        try{
            EducationInstitution edInst = new EducationInstitution();
            edInst.setName(name);
            edInst.setCity(city);
            edInst.setAddres(addres);
            edInst.setPhoneNumber(phoneNumber);

            educationInstitutionRepository.add(edInst);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public EducationInstitution getById(Long id){
        try{
            return educationInstitutionRepository.getById(id);
        }
        catch(Exception e){
            return null;
        }
    }

    public List<EducationInstitution> getByCity(String city){
        try{
            return educationInstitutionRepository.getByCity(city);
        }
        catch(Exception e){
            return null;
        }
    }

    public boolean updateEdInstPhoneNumber(Long Id, String newPhoneNumber){
        try{
            EducationInstitution edInst = educationInstitutionRepository.getById(Id);
            edInst.setPhoneNumber(newPhoneNumber);

            educationInstitutionRepository.update(edInst);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public List<EducationInstitution> getAll(){
        return educationInstitutionRepository.getAll();
    }

    public boolean deleteEdInst(Long Id){
        try{
            EducationInstitution edInst = educationInstitutionRepository.getById(Id);

            educationInstitutionRepository.delete(edInst);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
