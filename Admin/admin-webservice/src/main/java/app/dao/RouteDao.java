package app.dao;

import app.entity.Route;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by Vlad on 10-Dec-17.
 */
public class RouteDao {

    private SessionFactory sessionFactory;

    public RouteDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addRoute(Route route) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(route);
            transaction.commit();
        }catch (HibernateException ex) {
            if(transaction != null)
                transaction.rollback();
        }finally {
            session.close();
        }
    }

}
