package com.example.DAL.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Manager extends Person{

    @ManyToOne (cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RecrutingAgency recrutingAgency;

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
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(recrutingAgency, manager.recrutingAgency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recrutingAgency);
    }
}
