package app.dao;

import app.entity.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by Vlad on 10-Dec-17.
 */
public class ClientDao {

    private SessionFactory sessionFactory;

    public ClientDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addClient(Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }catch (HibernateException ex) {
            if(transaction != null)
                transaction.rollback();
        }finally {
            session.close();
        }
    }

}
