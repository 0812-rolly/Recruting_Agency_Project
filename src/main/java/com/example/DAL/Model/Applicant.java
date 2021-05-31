package com.example.DAL.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Applicant extends Person{

    private String gender;

    private Integer age;

    private String city;

    private String addres;

    private String pasportNumber;

    private String inn;

    private String snils;

    private String requiredPosition;

    private Integer requiredSalary;

    private String workShedule;

    private Date applicationDate;

    private String applicationStatus;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getPasportNumber() {
        return pasportNumber;
    }

    public void setPasportNumber(String pasportNumber) {
        this.pasportNumber = pasportNumber;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getRequiredPosition() {
        return requiredPosition;
    }

    public void setRequiredPosition(String requiredPosition) {
        this.requiredPosition = requiredPosition;
    }

    public Integer getRequiredSalary() {
        return requiredSalary;
    }

    public void setRequiredSalary(Integer requiredSalary) {
        this.requiredSalary = requiredSalary;
    }

    public String getWorkShedule() {
        return workShedule;
    }

    public void setWorkShedule(String workShedule) {
        this.workShedule = workShedule;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicant applicant = (Applicant) o;
        return Objects.equals(gender, applicant.gender) && Objects.equals(age, applicant.age) && Objects.equals(city, applicant.city) && Objects.equals(addres, applicant.addres) && Objects.equals(pasportNumber, applicant.pasportNumber) && Objects.equals(inn, applicant.inn) && Objects.equals(snils, applicant.snils) && Objects.equals(requiredPosition, applicant.requiredPosition) && Objects.equals(requiredSalary, applicant.requiredSalary) && Objects.equals(workShedule, applicant.workShedule) && Objects.equals(applicationDate, applicant.applicationDate) && Objects.equals(applicationStatus, applicant.applicationStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, age, city, addres, pasportNumber, inn, snils, requiredPosition, requiredSalary, workShedule, applicationDate, applicationStatus);
    }
}
