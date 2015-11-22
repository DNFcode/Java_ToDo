package ru.ifmo.database;

import org.hibernate.Session;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory.*;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.Configuration;

public class DBClass implements Serializable {

    public static void main(String args[]) {
        /*
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        tx.commit();
        session.close();*/
        UserDAO userDao = new UserDAO();
        User user = new User();
        user.setDateCreate(System.currentTimeMillis());
        user.setEmail("redishko@gmail.com");
        user.setIsAdmin(true);
        user.setIsVerified(true);
        user.setUsername("redishko");
        user.setPassword("password");
        userDao.saveUser(user);
    }
}