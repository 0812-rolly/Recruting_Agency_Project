package com.example.DAL.Repository;

import com.example.DAL.DAO.RecrutingAgencyDAO;
import com.example.DAL.Model.*;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RecrutingAgencyRepository implements RecrutingAgencyDAO {
    @Override
    public void add(RecrutingAgency recAg) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(recAg);

        transaction.commit();
        session.close();
    }

    @Override
    public RecrutingAgency getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<RecrutingAgency> query = criteriaBuilder.createQuery(RecrutingAgency.class);
        Root<RecrutingAgency> recAgRoot = query.from(RecrutingAgency.class);
        query.where(criteriaBuilder.equal(recAgRoot.get(RecrutingAgency_.id), id));
        query.select(recAgRoot);

        RecrutingAgency recAg = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();

        return recAg;
    }

    @Override
    public List<RecrutingAgency> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<RecrutingAgency> query = criteriaBuilder.createQuery(RecrutingAgency.class);
        Root<RecrutingAgency> recAgRoot = query.from(RecrutingAgency.class);
        query.select(recAgRoot);

        List<RecrutingAgency> resList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return resList;
    }

    @Override
    public void delete(RecrutingAgency recAg) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(recAg);

        transaction.commit();
        session.close();
    }
}
