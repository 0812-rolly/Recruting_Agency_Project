package com.example.DAL.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Manager extends Person{

    @JsonBackReference
    @OneToMany (mappedBy = "manager")
    private Set<WorkContract> workContracts;

    @ManyToOne (cascade = CascadeType.ALL)
    private RecrutingAgency recrutingAgency;


    public Set<WorkContract> getWorkContracts() {
        return workContracts;
    }

    public void setWorkContracts(Set<WorkContract> workContracts) {
        this.workContracts = workContracts;
    }

    public RecrutingAgency getRecrutingAgency() {
        return recrutingAgency;
    }

    public void setRecrutingAgency(RecrutingAgency recrutingAgency) {
        this.recrutingAgency = recrutingAgency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(workContracts, manager.workContracts) && Objects.equals(recrutingAgency, manager.recrutingAgency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workContracts, recrutingAgency);
    }
}
