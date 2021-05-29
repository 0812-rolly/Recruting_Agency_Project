package com.example.DAL.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;

    private String name;

    private String patronymic;

    private String gender;

    private Integer age;

    private String city;

    private String addres;

    private String phoneNumber;

    private String pasportNumber;

    private String inn;

    private String snils;

    private String requiredPosition;

    private Integer requiredSalary;

    private String workShedule;

    private Date applicationDate;

    private String applicationStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return Objects.equals(id, applicant.id) && Objects.equals(surname, applicant.surname) && Objects.equals(name, applicant.name) && Objects.equals(patronymic, applicant.patronymic) && Objects.equals(gender, applicant.gender) && Objects.equals(age, applicant.age) && Objects.equals(city, applicant.city) && Objects.equals(addres, applicant.addres) && Objects.equals(phoneNumber, applicant.phoneNumber) && Objects.equals(pasportNumber, applicant.pasportNumber) && Objects.equals(inn, applicant.inn) && Objects.equals(snils, applicant.snils) && Objects.equals(requiredPosition, applicant.requiredPosition) && Objects.equals(requiredSalary, applicant.requiredSalary) && Objects.equals(workShedule, applicant.workShedule) && Objects.equals(applicationDate, applicant.applicationDate) && Objects.equals(applicationStatus, applicant.applicationStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, gender, age, city, addres, phoneNumber, pasportNumber, inn, snils, requiredPosition, requiredSalary, workShedule, applicationDate, applicationStatus);
    }
}
