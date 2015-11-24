package ru.ifmo.database;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import ru.ifmo.database.HibernateUtil;
/**
 * Created by nikolayemrikh on 22.11.15.
 */
public class ObjectsDAO {

    public static Long save(Object obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Long userId = null;
        try {
            tx = session.beginTransaction();
            userId = (Long) session.save(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userId;
    }
    public static void delete(Object obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static Object select(Class cls, Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Object selected = null;
        try {
            tx = session.beginTransaction();
            selected = session.get(cls, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return selected;
    }
    public static User getUserByName(String name) {
        User user = new User();
        user.setUsername(name);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq("username", name));
            user = (User) userCriteria.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
    /*
    //Прост создаем запись с хэшем для нового пользователя в таблице user_verify
    public static void setUserVer() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        User user = new User();
        user.setUsername("jesusets");
        user.setPassword("iamjesus");
        user.setIsAdmin(true);
        user.setIsVerified(false);
        session.persist(user);

        UserVerify userVerify = new UserVerify();
        userVerify.setUserId(user.getUserId());
        userVerify.setHash("hui");

        user.setUserVerify(userVerify);

        session.save(user);
        tx.commit();
        session.close();

    }*/
}
