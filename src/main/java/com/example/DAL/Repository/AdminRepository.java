package com.example.DAL.Repository;

import com.example.DAL.DAO.AdminDAO;
import com.example.DAL.Model.Admin;
import com.example.DAL.Model.Admin_;
import com.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = criteriaBuilder.createQuery(Admin.class);
        Root<Admin> adminRoot = query.from(Admin.class);
        query.where(criteriaBuilder.equal(adminRoot.get(Admin_.id), id));
        query.select(adminRoot);

        Admin admin = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return admin;
    }

    @Override
    public void checkLogin(String email, String pass) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Admin> query = criteriaBuilder.createQuery(Admin.class);
            Root<Admin> adminRoot = query.from(Admin.class);
            Predicate emailPredicate = criteriaBuilder.equal(adminRoot.get(Admin_.email), email);
            Predicate passPredicate = criteriaBuilder.equal(adminRoot.get(Admin_.password), pass);
            Predicate finalPredicate = criteriaBuilder.and(emailPredicate, passPredicate);
            query.where(finalPredicate);
            query.select(adminRoot);

            Admin admin = session.createQuery(query).getSingleResult();

        } catch (NoResultException e) {
            throw new NoResultException();
        } finally {
            transaction.commit();
            session.close();
        }

    }

    @Override
    public void delete(Admin admin) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(admin);

        transaction.commit();
        session.close();
    }
}
