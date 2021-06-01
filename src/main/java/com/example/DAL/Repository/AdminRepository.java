package com.example.DAL.Repository;

import com.example.DAL.DAO.AdminDAO;
import com.example.DAL.Model.*;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;

public class AdminRepository implements AdminDAO {
    @Override
    public void add(Admin admin) throws NoResultException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(admin);

        transaction.commit();
        session.close();
    }

    @Override
    public Admin getById(Long id) throws NoResultException {
        return null;
    }

    @Override
    public void checkLogin(String email, String pass) throws NoResultException {

    }

    @Override
    public void update(Admin admin) throws NoResultException {

    }

    @Override
    public void delete(Admin admin) {

    }
}
