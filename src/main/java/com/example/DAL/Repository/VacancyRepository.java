package com.example.DAL.Repository;

import com.example.DAL.DAO.VacancyDAO;
import com.example.DAL.Model.*;
import com.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class VacancyRepository implements VacancyDAO {
    @Override
    public void add(Vacancy vacancy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(vacancy);

        transaction.commit();
        session.close();
    }

    @Override
    public Vacancy getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Vacancy> query = criteriaBuilder.createQuery(Vacancy.class);
        Root<Vacancy> vacancyRoot = query.from(Vacancy.class);
        query.where(criteriaBuilder.equal(vacancyRoot.get(Vacancy_.id), id));
        query.select(vacancyRoot);

        Vacancy vacancy = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();

        return vacancy;
    }

    @Override
    public List<Vacancy> getByPropPosition(String propPosition) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Vacancy> query = criteriaBuilder.createQuery(Vacancy.class);
        Root<Vacancy> vacancyRoot = query.from(Vacancy.class);
        query.where(criteriaBuilder.equal(vacancyRoot.get(Vacancy_.proposedPosition), propPosition));
        query.select(vacancyRoot);

        List<Vacancy> vacancyList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return vacancyList;
    }

    @Override
    public List<Vacancy> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Vacancy> query = criteriaBuilder.createQuery(Vacancy.class);
        Root<Vacancy> vacancyRoot = query.from(Vacancy.class);
        query.select(vacancyRoot);

        List<Vacancy> resList = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return resList;
    }

    @Override
    public void update(Vacancy vacancy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(vacancy);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Vacancy vacancy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(vacancy);

        transaction.commit();
        session.close();
    }
}
