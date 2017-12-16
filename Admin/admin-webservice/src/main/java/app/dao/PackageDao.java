package app.dao;

import app.entity.Package;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Vlad on 10-Dec-17.
 */
public class PackageDao {

    private SessionFactory sessionFactory;

    public PackageDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addPackage(Package aPackage) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(aPackage);
            transaction.commit();
        }catch (HibernateException ex) {
            if(transaction != null)
                transaction.rollback();
        }finally {
            session.close();
        }
    }

    public Package getPackage(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Package> packages = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Package where id=:id");
            query.setParameter("id",id);
            packages = query.list();
            transaction.commit();
        }catch (HibernateException e) {
            if(transaction != null)
                transaction.rollback();
        }finally {
            session.close();
        }
        return (packages != null && !packages.isEmpty()) ? packages.get(0) : null;
    }

    public void removePackage(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Package aPackage = null;
        try{
            transaction = session.beginTransaction();
            aPackage = getPackage(id);
            session.delete(aPackage);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction != null)
                transaction.rollback();
        }finally {
            session.close();
        }
    }

    public void updatePackage(Package aPackage, int id) {
        Package oldPackage = getPackage(id);
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            aPackage.setId(oldPackage.getId());
            session.update(aPackage);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction != null)
                transaction.rollback();
        }finally {
            session.close();
        }
    }
}
