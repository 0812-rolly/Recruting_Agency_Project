package com.example.Controllers;

import com.example.DAL.DAO.*;
import com.example.DAL.Model.*;
import com.example.DAL.Repository.*;

import java.sql.Date;
import java.util.List;

public class ApplicantController {
    private static ApplicantDAO applicantRepository = new ApplicantRepository();

    public boolean addApplicant(String surname, String name, String patronymic, String phoneNumber,
                                String gender, Integer age, String city, String addres, String pasportNumber,
                                String inn, String snils, String requiredPosition, Integer requiredSalary,
                                String workShedule, Date applicationDate, String applicationStatus){
        try{
            Applicant artistCheck = applicantRepository.getByPasportNumber(pasportNumber);

            return false;
        }
        catch(Exception e) {
            Applicant applicant = new Applicant();
            applicant.setSurname(surname);
            applicant.setName(name);
            applicant.setPatronymic(patronymic);
            applicant.setPhoneNumber(phoneNumber);
            applicant.setGender(gender);
            applicant.setAge(age);
            applicant.setCity(city);
            applicant.setAddres(addres);
            applicant.setPasportNumber(pasportNumber);
            applicant.setInn(inn);
            applicant.setSnils(snils);
            applicant.setRequiredPosition(requiredPosition);
            applicant.setRequiredSalary(requiredSalary);
            applicant.setWorkShedule(workShedule);
            applicant.setApplicationDate(applicationDate);
            applicant.setApplicationStatus(applicationStatus);

            applicantRepository.add(applicant);
            return true;
        }
    }

    public List<Applicant> getAll(){
        return applicantRepository.getAll();
    }

    public Applicant getById(Long id){
        try{
            return applicantRepository.getById(id);
        }
        catch(Exception e){
            return null;
        }
    }

    public Applicant getByPasportNumber(String pasportNumber){
        try{
            return applicantRepository.getByPasportNumber(pasportNumber);
        }
        catch(Exception e){
            return null;
        }
    }

    public Applicant getByPhoneNumber(String phoneNumber){
        try{
            return applicantRepository.getByPhoneNumber(phoneNumber);
        }
        catch(Exception e){
            return null;
        }
    }

    public List<Applicant> getByReqPosition(String reqPosition){
        try{
            return applicantRepository.getByReqPosition(reqPosition);
        }
        catch(Exception e){
            return null;
        }
    }

    public boolean updateApplPhoneNumber(Long Id, String newPhoneNumber){
        try{
            Applicant applicant = applicantRepository.getById(Id);
            applicant.setPhoneNumber(newPhoneNumber);

            applicantRepository.update(applicant);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean updateApplicationStatus(Long Id, String applicationStatus){
        try{
            Applicant applicant = applicantRepository.getById(Id);
            applicant.setApplicationStatus(applicationStatus);

            applicantRepository.update(applicant);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


    public boolean deleteApplicant(Long Id){
        try{
            Applicant applicant = applicantRepository.getById(Id);

            applicantRepository.delete(applicant);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
