package com.example.DAL.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany (mappedBy = "manager")
    private Set<WorkContract> workContracts;
    @ManyToOne (cascade = CascadeType.ALL)
    private RecrutingAgency recrutingAgency;

    private String surname;

    private String name;

    private String patronymic;

    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RecrutingAgency getRecrutingAgency() {
        return recrutingAgency;
    }

    public void setRecrutingAgency(RecrutingAgency recrutingAgency) {
        this.recrutingAgency = recrutingAgency;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<WorkContract> getWorkContracts() {
        return workContracts;
    }

    public void setWorkContracts(Set<WorkContract> workContracts) {
        this.workContracts = workContracts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(id, manager.id) && Objects.equals(workContracts, manager.workContracts) && Objects.equals(recrutingAgency, manager.recrutingAgency) && Objects.equals(surname, manager.surname) && Objects.equals(name, manager.name) && Objects.equals(patronymic, manager.patronymic) && Objects.equals(phoneNumber, manager.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workContracts, recrutingAgency, surname, name, patronymic, phoneNumber);
    }
}
