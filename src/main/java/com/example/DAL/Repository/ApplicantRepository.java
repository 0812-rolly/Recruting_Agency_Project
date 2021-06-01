package com.example.DAL.Repository;

import com.example.DAL.DAO.ApplicantDAO;
import com.example.DAL.Model.*;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class ApplicantRepository implements ApplicantDAO {
    @Override
    public void add(Applicant applicant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(applicant);

        transaction.commit();
        session.close();
    }

    @Override
    public Applicant getByPasportNumber(String pasportNumber) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Applicant> query = criteriaBuilder.createQuery(Applicant.class);
        Root<Applicant> applicantRoot = query.from(Applicant.class);
        query.where(criteriaBuilder.equal(applicantRoot.get(Applicant_.pasportNumber), pasportNumber));
        query.select(applicantRoot);

        Applicant applicant = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return applicant;
    }

    @Override
    public Applicant getByPhoneNumber(String phoneNumber) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Applicant> query = criteriaBuilder.createQuery(Applicant.class);
        Root<Applicant> applicantRoot = query.from(Applicant.class);
        query.where(criteriaBuilder.equal(applicantRoot.get(Applicant_.phoneNumber), phoneNumber));
        query.select(applicantRoot);

        Applicant applicant = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return applicant;
    }

    @Override
    public Applicant getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Applicant> query = criteriaBuilder.createQuery(Applicant.class);
        Root<Applicant> applicantRoot = query.from(Applicant.class);
        query.where(criteriaBuilder.equal(applicantRoot.get(Applicant_.id), id));
        query.select(applicantRoot);

        Applicant applicant = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();

        return applicant;
    }

    @Override
    public List<Applicant> getByReqPosition(String reqPosition) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Applicant> query = criteriaBuilder.createQuery(Applicant.class);
        Root<Applicant> applicantRoot = query.from(Applicant.class);
        query.where(criteriaBuilder.equal(applicantRoot.get(Applicant_.requiredPosition), reqPosition));
        query.select(applicantRoot);

        List<Applicant> applicantList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return applicantList;
    }

    @Override
    public List<Applicant> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Applicant> query = criteriaBuilder.createQuery(Applicant.class);
        Root<Applicant> applicantRoot = query.from(Applicant.class);
        query.select(applicantRoot);

        List<Applicant> resList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return resList;
    }

    @Override
    public void update(Applicant applicant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(applicant);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Applicant applicant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(applicant);

        transaction.commit();
        session.close();
    }
}
