package com.example.DAL.Repository;

import com.example.DAL.DAO.EducationDAO;
import com.example.DAL.Model.*;
import com.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EducationRepository implements EducationDAO {
    @Override
    public void add(Education education) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(education);

        transaction.commit();
        session.close();
    }

    @Override
    public Education getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Education> query = criteriaBuilder.createQuery(Education.class);
        Root<Education> educationRoot = query.from(Education.class);
        query.where(criteriaBuilder.equal(educationRoot.get(Education_.id), id));
        query.select(educationRoot);

        Education education = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();

        return education;
    }

    @Override
    public List<Education> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Education> query = criteriaBuilder.createQuery(Education.class);
        Root<Education> educationRoot = query.from(Education.class);
        query.select(educationRoot);

        List<Education> resList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return resList;
    }

    @Override
    public void delete(Education education) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(education);

        transaction.commit();
        session.close();
    }
}
