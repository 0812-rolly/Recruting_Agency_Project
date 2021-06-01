package com.example.Controllers;

import com.example.DAL.DAO.*;
import com.example.DAL.Model.*;
import com.example.DAL.Repository.*;

import java.sql.Date;
import java.util.List;

public class ManagerController {
    private static ManagerDAO managerRepository = new ManagerRepository();
    private static RecrutingAgencyDAO recrutingAgencyRepository = new RecrutingAgencyRepository();

    public boolean addManager(Long recrutingAgency, String surname, String name,
                              String patronymic, String phoneNumber){
        try{
            RecrutingAgency recAg = recrutingAgencyRepository.getById(recrutingAgency);

            Manager manager = new Manager();
            manager.setRecrutingAgency(recAg);
            manager.setSurname(surname);
            manager.setName(name);
            manager.setPatronymic(patronymic);
            manager.setPhoneNumber(phoneNumber);

            managerRepository.add(manager);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Manager getById(Long id){
        try{
            return managerRepository.getById(id);
        }
        catch(Exception e){
            return null;
        }
    }

    public List<Manager> getAll(){
        return managerRepository.getAll();
    }

    public void updateManagerRecAg(Long Id, Long newRecrutingAgency){
        Manager manager = managerRepository.getById(Id);
        RecrutingAgency recrutingAgency = recrutingAgencyRepository.getById(newRecrutingAgency);
        manager.setRecrutingAgency(recrutingAgency);

        managerRepository.update(manager);
    }

    public boolean updateManagerPhoneNumber(Long Id, String newPhoneNumber){
        try{
            Manager manager = managerRepository.getById(Id);
            manager.setPhoneNumber(newPhoneNumber);

            managerRepository.update(manager);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean deleteManager(Long Id){
        try{
            Manager manager = managerRepository.getById(Id);

            managerRepository.delete(manager);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
