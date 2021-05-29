package com.example.DAL.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne (cascade = CascadeType.ALL)
    private EducationInstitution educationInstitution;
    @ManyToOne (cascade = CascadeType.ALL)
    private Applicant applicant;

    private String faculty;

    private String specialty;

    private String typeOfDocument;

    private Date startDate;

    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EducationInstitution getEducationInstitution() {
        return educationInstitution;
    }

    public void setEducationInstitution(EducationInstitution educationInstitution) {
        this.educationInstitution = educationInstitution;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getTypeOfDocument() {
        return typeOfDocument;
    }

    public void setTypeOfDocument(String typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return Objects.equals(id, education.id) && Objects.equals(educationInstitution, education.educationInstitution) && Objects.equals(applicant, education.applicant) && Objects.equals(faculty, education.faculty) && Objects.equals(specialty, education.specialty) && Objects.equals(typeOfDocument, education.typeOfDocument) && Objects.equals(startDate, education.startDate) && Objects.equals(endDate, education.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, educationInstitution, applicant, faculty, specialty, typeOfDocument, startDate, endDate);
    }
}
