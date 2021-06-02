package com.example.DAL.Model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne (cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EmployerCompany employerCompany;

    private String proposedPosition;

    private Integer proposedSalary;

    private Integer experience;

    private Integer age;

    private String gender;

    private String workShedule;

    private String spesialty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployerCompany getEmployerCompany() {
        return employerCompany;
    }

    public void setEmployerCompany(EmployerCompany employerCompany) {
        this.employerCompany = employerCompany;
    }

    public String getProposedPosition() {
        return proposedPosition;
    }

    public void setProposedPosition(String proposedPosition) {
        this.proposedPosition = proposedPosition;
    }

    public Integer getProposedSalary() {
        return proposedSalary;
    }

    public void setProposedSalary(Integer proposedSalary) {
        this.proposedSalary = proposedSalary;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWorkShedule() {
        return workShedule;
    }

    public void setWorkShedule(String workShedule) {
        this.workShedule = workShedule;
    }

    public String getSpesialty() {
        return spesialty;
    }

    public void setSpesialty(String spesialty) {
        this.spesialty = spesialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(id, vacancy.id) && Objects.equals(employerCompany, vacancy.employerCompany) && Objects.equals(proposedPosition, vacancy.proposedPosition) && Objects.equals(proposedSalary, vacancy.proposedSalary) && Objects.equals(experience, vacancy.experience) && Objects.equals(age, vacancy.age) && Objects.equals(gender, vacancy.gender) && Objects.equals(workShedule, vacancy.workShedule) && Objects.equals(spesialty, vacancy.spesialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employerCompany, proposedPosition, proposedSalary, experience, age, gender, workShedule, spesialty);
    }
}
