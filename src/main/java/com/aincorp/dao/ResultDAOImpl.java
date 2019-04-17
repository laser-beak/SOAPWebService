package com.aincorp.dao;

import com.aincorp.entity.Result;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ResultDAOImpl implements ResultDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Result r) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(r);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Result> list() {
        Session session = this.sessionFactory.openSession();
        List<Result> personList = session.createQuery("from Result").list();
        session.close();
        return personList;
    }

    public Result getLastResult() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Result order by id desc");
        query.setMaxResults(1);
        return (Result) query.uniqueResult();
    }

}
