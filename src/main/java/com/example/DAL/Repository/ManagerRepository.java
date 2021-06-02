package com.example.DAL.Repository;

import com.example.DAL.DAO.ManagerDAO;
import com.example.DAL.Model.*;
import com.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ManagerRepository implements ManagerDAO {
    @Override
    public void add(Manager manager) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(manager);

        transaction.commit();
        session.close();
    }

    @Override
    public Manager getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Manager> query = criteriaBuilder.createQuery(Manager.class);
        Root<Manager> managerRoot = query.from(Manager.class);
        query.where(criteriaBuilder.equal(managerRoot.get(Manager_.id), id));
        query.select(managerRoot);

        Manager manager = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();

        return manager;
    }

    @Override
    public List<Manager> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Manager> query = criteriaBuilder.createQuery(Manager.class);
        Root<Manager> managerRoot = query.from(Manager.class);
        query.select(managerRoot);

        List<Manager> resList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return resList;
    }

    @Override
    public void update(Manager manager) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(manager);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Manager manager) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(manager);

        transaction.commit();
        session.close();
    }
}
