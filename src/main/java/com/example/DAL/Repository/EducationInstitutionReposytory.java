package com.example.DAL.Repository;

import com.example.DAL.DAO.EducationInstitutionDAO;
import com.example.DAL.Model.*;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EducationInstitutionReposytory implements EducationInstitutionDAO {
    @Override
    public void add(EducationInstitution edInst) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(edInst);

        transaction.commit();
        session.close();
    }

    @Override
    public EducationInstitution getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<EducationInstitution> query = criteriaBuilder.createQuery(EducationInstitution.class);
        Root<EducationInstitution> edInstRoot = query.from(EducationInstitution.class);
        query.where(criteriaBuilder.equal(edInstRoot.get(EducationInstitution_.id), id));
        query.select(edInstRoot);

        EducationInstitution edInst = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();

        return edInst;
    }

    @Override
    public List<EducationInstitution> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<EducationInstitution> query = criteriaBuilder.createQuery(EducationInstitution.class);
        Root<EducationInstitution> edInstRoot = query.from(EducationInstitution.class);
        query.select(edInstRoot);

        List<EducationInstitution> resList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return resList;
    }

    @Override
    public List<EducationInstitution> getByCity(String city) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<EducationInstitution> query = criteriaBuilder.createQuery(EducationInstitution.class);
        Root<EducationInstitution> edInstRoot = query.from(EducationInstitution.class);
        query.where(criteriaBuilder.equal(edInstRoot.get(EducationInstitution_.city), city));
        query.select(edInstRoot);

        List<EducationInstitution> edInstList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return edInstList;
    }

    @Override
    public void update(EducationInstitution edInst) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(edInst);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(EducationInstitution edInst) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(edInst);

        transaction.commit();
        session.close();
    }
}
