package com.example.Controllers;

import com.example.DAL.DAO.*;
import com.example.DAL.Model.*;
import com.example.DAL.Repository.*;

import java.sql.Date;
import java.util.List;

public class LaborHistoryController {
    private static LaborHistoryDAO laborHistoryRepository = new LaborHistoryRepository();
    private static CompanyDAO companyRepository = new CompanyRepository();
    private static ApplicantDAO applicantRepository = new ApplicantRepository();

    public boolean addLaborHistory(Long applicant, Long company, String position, Integer experience){
        try{
            Company comp = companyRepository.getById(company);
            Applicant applic = applicantRepository.getById(applicant);

            LaborHistory labHist = new LaborHistory();
            labHist.setApplicant(applic);
            labHist.setCompany(comp);
            labHist.setPosition(position);
            labHist.setExperience(experience);

            laborHistoryRepository.add(labHist);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public LaborHistory getById(Long id){
        try{
            return laborHistoryRepository.getById(id);
        }
        catch(Exception e){
            return null;
        }
    }

    public List<LaborHistory> getAll(){
        return laborHistoryRepository.getAll();
    }

    public boolean deleteLaborHistory(Long Id){
        try{
            LaborHistory labHist = laborHistoryRepository.getById(Id);

            laborHistoryRepository.delete(labHist);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
