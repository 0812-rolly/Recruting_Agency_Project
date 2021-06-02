package com.example.DAL.Repository;

import com.example.DAL.DAO.EmployerCompanyDAO;
import com.example.DAL.Model.*;
import com.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployerCompanyRepository implements EmployerCompanyDAO {
    @Override
    public void add(EmployerCompany empComp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(empComp);

        transaction.commit();
        session.close();
    }

    @Override
    public EmployerCompany getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<EmployerCompany> query = criteriaBuilder.createQuery(EmployerCompany.class);
        Root<EmployerCompany> empCompRoot = query.from(EmployerCompany.class);
        query.where(criteriaBuilder.equal(empCompRoot.get(EmployerCompany_.name), name));
        query.select(empCompRoot);

        EmployerCompany empComp = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return empComp;
    }

    @Override
    public EmployerCompany getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<EmployerCompany> query = criteriaBuilder.createQuery(EmployerCompany.class);
        Root<EmployerCompany> empCompRoot = query.from(EmployerCompany.class);
        query.where(criteriaBuilder.equal(empCompRoot.get(EmployerCompany_.id), id));
        query.select(empCompRoot);

        EmployerCompany empComp = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();

        return empComp;
    }

    @Override
    public List<EmployerCompany> getByCity(String city) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<EmployerCompany> query = criteriaBuilder.createQuery(EmployerCompany.class);
        Root<EmployerCompany> empCompRoot = query.from(EmployerCompany.class);
        query.where(criteriaBuilder.equal(empCompRoot.get(EmployerCompany_.city), city));
        query.select(empCompRoot);

        List<EmployerCompany> empCompList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return empCompList;
    }

    @Override
    public List<EmployerCompany> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<EmployerCompany> query = criteriaBuilder.createQuery(EmployerCompany.class);
        Root<EmployerCompany> empCompRoot = query.from(EmployerCompany.class);
        query.select(empCompRoot);

        List<EmployerCompany> resList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return resList;
    }

    @Override
    public void update(EmployerCompany empComp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(empComp);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(EmployerCompany empComp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(empComp);

        transaction.commit();
        session.close();
    }
}
