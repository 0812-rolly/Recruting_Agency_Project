package com.example.Controllers;

import com.example.DAL.DAO.*;
import com.example.DAL.Model.*;
import com.example.DAL.Repository.*;

import java.sql.Date;
import java.util.List;

public class VacancyController {
    private static VacancyDAO vacancyRepository = new VacancyRepository();
    private static EmployerCompanyDAO employerCompanyRepository = new EmployerCompanyRepository();

    public boolean addVacancy(Long employerCompany, String proposedPosition, Integer proposedSalary,
                              Integer experience, Integer age, String gender, String workShedule, String spesialty){
        try{
            EmployerCompany empComp = employerCompanyRepository.getById(employerCompany);

            Vacancy vacancy = new Vacancy();
            vacancy.setEmployerCompany(empComp);
            vacancy.setProposedPosition(proposedPosition);
            vacancy.setProposedSalary(proposedSalary);
            vacancy.setExperience(experience);
            vacancy.setAge(age);
            vacancy.setGender(gender);
            vacancy.setWorkShedule(workShedule);
            vacancy.setSpesialty(spesialty);

            vacancyRepository.add(vacancy);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Vacancy getById(Long id){
        try{
            return vacancyRepository.getById(id);
        }
        catch(Exception e){
            return null;
        }
    }

    public List<Vacancy> getAll(){
        return vacancyRepository.getAll();
    }


    public List<Vacancy> getByPropPositionVac(String propPosition){
        try{
            return vacancyRepository.getByPropPosition(propPosition);
        }
        catch(Exception e){
            return null;
        }
    }

    public boolean updateVaclPropSalary(Long Id, Integer newPropSalary){
        try{
            Vacancy vacancy = vacancyRepository.getById(Id);
            vacancy.setProposedSalary(newPropSalary);

            vacancyRepository.update(vacancy);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean updateVaclPropPosition(Long Id, String newPropPosition){
        try{
            Vacancy vacancy = vacancyRepository.getById(Id);
            vacancy.setProposedPosition(newPropPosition);

            vacancyRepository.update(vacancy);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public void updateVacancyEmpComp(Long Id, Long newEmployerCompany){
        Vacancy vacancy = vacancyRepository.getById(Id);
        EmployerCompany employerCompany = employerCompanyRepository.getById(newEmployerCompany);
        vacancy.setEmployerCompany(employerCompany);

        vacancyRepository.update(vacancy);
    }

    public boolean deleteVacancy(Long Id){
        try{
            Vacancy vacancy = vacancyRepository.getById(Id);

            vacancyRepository.delete(vacancy);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
