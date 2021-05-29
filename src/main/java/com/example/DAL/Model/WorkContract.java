package com.example.DAL.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class WorkContract {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @OneToOne (cascade = CascadeType.ALL)
        private Applicant applicant;
        @ManyToOne
        @JoinColumn(name="id_manager", nullable=false)
        private Manager manager;
        @OneToOne (cascade = CascadeType.ALL)
        private Vacancy vacancy;

        private Date contractDuration;

        private Date beginningOfWork;

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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public Date getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(Date contractDuration) {
        this.contractDuration = contractDuration;
    }

    public Date getBeginningOfWork() {
        return beginningOfWork;
    }

    public void setBeginningOfWork(Date beginningOfWork) {
        this.beginningOfWork = beginningOfWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkContract that = (WorkContract) o;
        return Objects.equals(id, that.id) && Objects.equals(applicant, that.applicant) && Objects.equals(manager, that.manager) && Objects.equals(vacancy, that.vacancy) && Objects.equals(contractDuration, that.contractDuration) && Objects.equals(beginningOfWork, that.beginningOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applicant, manager, vacancy, contractDuration, beginningOfWork);
    }
}

