package com.example.Controllers;

import com.example.DAL.DAO.*;
import com.example.DAL.Model.*;
import com.example.DAL.Repository.*;
import com.example.Util.StringHandler;

import java.sql.Date;
import java.util.List;

public class WorkContractController {

    private static WorkContractDAO workContractRepository = new WorkContractRepository();
    private static VacancyDAO vacancyRepository = new VacancyRepository();
    private static ApplicantDAO applicantRepository = new ApplicantRepository();
    private static ManagerDAO managerRepository = new ManagerRepository();

    public boolean addWorkContract(Long applicant, Long manager, Long vacancy,
                                Date contractDuration, Date beginningOfWork){
        try{
            Vacancy vac = vacancyRepository.getById(vacancy);
            Manager manag = managerRepository.getById(manager);
            Applicant applic = applicantRepository.getById(applicant);

            WorkContract workContract = new WorkContract();
            workContract.setApplicant(applic);
            workContract.setManager(manag);
            workContract.setVacancy(vac);
            workContract.setContractDuration(contractDuration);
            workContract.setBeginningOfWork(beginningOfWork);

            workContractRepository.add(workContract);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public WorkContract getById(Long id){
        try{
            return workContractRepository.getById(id);
        }
        catch(Exception e){
            return null;
        }
    }

    public List<WorkContract> getAll(){
        return workContractRepository.getAll();
    }

    public boolean updateContractDuration(Long Id, int year, int month, int day){
        try{
            WorkContract workContract = workContractRepository.getById(Id);
            String contractDuration = StringHandler.toStringDate(year, month, day);
            workContract.setContractDuration(Date.valueOf(contractDuration));

            workContractRepository.update(workContract);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean deleteWorkContract(Long Id){
        try{
            WorkContract workContract = workContractRepository.getById(Id);

            workContractRepository.delete(workContract);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
