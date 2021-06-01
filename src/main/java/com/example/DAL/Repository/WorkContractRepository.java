package com.example.DAL.Repository;

import com.example.DAL.DAO.WorkContractDAO;
import com.example.DAL.Model.*;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

public class WorkContractRepository implements WorkContractDAO {
    @Override
    public void add(WorkContract workCont) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(workCont);

        transaction.commit();
        session.close();
    }

    @Override
    public WorkContract getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<WorkContract> query = criteriaBuilder.createQuery(WorkContract.class);
        Root<WorkContract> workContRoot = query.from(WorkContract.class);
        query.where(criteriaBuilder.equal(workContRoot.get(WorkContract_.id), id));
        query.select(workContRoot);

        WorkContract workCont = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();

        return workCont;
    }

    @Override
    public List<WorkContract> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<WorkContract> query = criteriaBuilder.createQuery(WorkContract.class);
        Root<WorkContract> workContRoot = query.from(WorkContract.class);
        query.select(workContRoot);

        List<WorkContract> resList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return resList;
    }

    @Override
    public List<WorkContract> getByDatePeriod(Date begin, Date end) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<WorkContract> query = criteriaBuilder.createQuery(WorkContract.class);
        Root<WorkContract> workContRoot = query.from(WorkContract.class);
        query.where(criteriaBuilder.between(workContRoot.get(WorkContract_.beginningOfWork), begin, end));
        query.select(workContRoot);

        List<WorkContract> workContList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return workContList;
    }

    @Override
    public void update(WorkContract workCont) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(workCont);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(WorkContract workCont) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(workCont);

        transaction.commit();
        session.close();
    }
}
