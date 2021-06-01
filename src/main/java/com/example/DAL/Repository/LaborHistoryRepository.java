package com.example.DAL.Repository;

import com.example.DAL.DAO.LaborHistoryDAO;
import com.example.DAL.Model.*;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class LaborHistoryRepository implements LaborHistoryDAO {
    @Override
    public void add(LaborHistory labHist) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(labHist);

        transaction.commit();
        session.close();
    }

    @Override
    public LaborHistory getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<LaborHistory> query = criteriaBuilder.createQuery(LaborHistory.class);
        Root<LaborHistory> labHistRoot = query.from(LaborHistory.class);
        query.where(criteriaBuilder.equal(labHistRoot.get(LaborHistory_.id), id));
        query.select(labHistRoot);

        LaborHistory labHist = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();

        return labHist;
    }

    @Override
    public List<LaborHistory> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<LaborHistory> query = criteriaBuilder.createQuery(LaborHistory.class);
        Root<LaborHistory> labHistRoot = query.from(LaborHistory.class);
        query.select(labHistRoot);

        List<LaborHistory> resList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return resList;
    }

    @Override
    public void delete(LaborHistory labHist) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(labHist);

        transaction.commit();
        session.close();
    }
}
