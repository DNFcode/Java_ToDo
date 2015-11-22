package database;

import org.hibernate.Session;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory.*;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.Configuration;

public class DBClass implements Serializable {
    private static SessionFactory factory;
    public static void main(String args[]) {
        System.out.println("AAAAAdsda");
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        tx.commit();
        session.close();
    }
}