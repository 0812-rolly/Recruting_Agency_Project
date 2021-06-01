package com.example.Controllers;

import com.example.DAL.DAO.*;
import com.example.DAL.Model.*;
import com.example.DAL.Repository.*;

import java.sql.Date;
import java.util.List;

public class EducationController {
    private static EducationDAO educationRepository = new EducationRepository();
    private static EducationInstitutionDAO edInstRepository = new EducationInstitutionReposytory();
    private static ApplicantDAO applicantRepository = new ApplicantRepository();

    public boolean addEducation(Long educationInstitution, Long applicant, String faculty,
                                String specialty, String typeOfDocument, Integer startDate, Integer endDate){
        try{
            EducationInstitution edInst = edInstRepository.getById(educationInstitution);
            Applicant applic = applicantRepository.getById(applicant);

            Education education = new Education();
            education.setEducationInstitution(edInst);
            education.setApplicant(applic);
            education.setFaculty(faculty);
            education.setSpecialty(specialty);
            education.setTypeOfDocument(typeOfDocument);
            education.setStartDate(startDate);
            education.setEndDate(endDate);

            educationRepository.add(education);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Education getById(Long id){
        try{
            return educationRepository.getById(id);
        }
        catch(Exception e){
            return null;
        }
    }

    public List<Education> getAll(){
        return educationRepository.getAll();
    }


    public boolean deleteEducation(Long Id){
        try{
            Education education = educationRepository.getById(Id);

            educationRepository.delete(education);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
