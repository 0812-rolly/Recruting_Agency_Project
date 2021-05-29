package com.example.DAL.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class LaborHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne (cascade = CascadeType.ALL)
    private Applicant applicant;
    @ManyToOne (cascade = CascadeType.ALL)
    private Company company;

    private String position;

    private Integer experience;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaborHistory that = (LaborHistory) o;
        return Objects.equals(id, that.id) && Objects.equals(applicant, that.applicant) && Objects.equals(company, that.company) && Objects.equals(position, that.position) && Objects.equals(experience, that.experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applicant, company, position, experience);
    }
}
