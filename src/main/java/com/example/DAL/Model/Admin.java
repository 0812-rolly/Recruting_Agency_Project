package com.example.DAL.Model;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) && Objects.equals(email, admin.email) && Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }
}
