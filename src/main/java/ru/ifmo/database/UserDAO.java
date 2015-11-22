package ru.ifmo.database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.ifmo.database.HibernateUtil;
/**
 * Created by nikolayemrikh on 22.11.15.
 */
public class UserDAO {

    public Long saveUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Long userId = null;
        try {
            tx = session.beginTransaction();
            userId = (Long) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userId;
    }
}
