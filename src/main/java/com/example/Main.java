package com.example;

import com.example.DAL.Model.RecrutingAgency;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

//        Session session = sessionFactory.openSession();
//        final Transaction transaction = session.beginTransaction();
//        RecrutingAgency ra1 = new RecrutingAgency();
//        ra1.setName("hffjf");
//        session.save(ra1);
//        transaction.commit();
//        session.close();

        HibernateUtil.shutdown();
    }
}
