package com.example.Controllers;

import com.example.DAL.DAO.*;
import com.example.DAL.Model.*;
import com.example.DAL.Repository.*;

import java.sql.Date;
import java.util.List;

public class RecrutingAgencyController {
    private static RecrutingAgencyDAO recrutingAgencyRepository = new RecrutingAgencyRepository();

    public boolean addRecAg(String name){
        try{
            RecrutingAgency recAg = new RecrutingAgency();
            recAg.setName(name);

            recrutingAgencyRepository.add(recAg);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public RecrutingAgency getById(Long id){
        try{
            return recrutingAgencyRepository.getById(id);
        }
        catch(Exception e){
            return null;
        }
    }

    public List<RecrutingAgency> getAll(){
        return recrutingAgencyRepository.getAll();
    }

    public boolean deleteRecAg(Long Id){
        try{
            RecrutingAgency recAg = recrutingAgencyRepository.getById(Id);

            recrutingAgencyRepository.delete(recAg);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
