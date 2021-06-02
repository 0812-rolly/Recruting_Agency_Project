package com.example.DAL.Repository;

import com.example.DAL.DAO.CompanyDAO;
import com.example.DAL.Model.*;
import com.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CompanyRepository implements CompanyDAO {
    @Override
    public void add(Company company) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(company);

        transaction.commit();
        session.close();
    }

    @Override
    public Company getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Company> query = criteriaBuilder.createQuery(Company.class);
        Root<Company> companyRoot = query.from(Company.class);
        query.where(criteriaBuilder.equal(companyRoot.get(Company_.name), name));
        query.select(companyRoot);

        Company company = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return company;
    }

    @Override
    public Company getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Company> query = criteriaBuilder.createQuery(Company.class);
        Root<Company> companyRoot = query.from(Company.class);
        query.where(criteriaBuilder.equal(companyRoot.get(Company_.id), id));
        query.select(companyRoot);

        Company company = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();

        return company;
    }

    @Override
    public List<Company> getByCity(String city) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Company> query = criteriaBuilder.createQuery(Company.class);
        Root<Company> companyRoot = query.from(Company.class);
        query.where(criteriaBuilder.equal(companyRoot.get(Company_.city), city));
        query.select(companyRoot);

        List<Company> companyList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return companyList;
    }

    @Override
    public List<Company> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Company> query = criteriaBuilder.createQuery(Company.class);
        Root<Company> companyRoot = query.from(Company.class);
        query.select(companyRoot);

        List<Company> resList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return resList;
    }

    @Override
    public void update(Company company) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(company);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Company company) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(company);

        transaction.commit();
        session.close();
    }
}
