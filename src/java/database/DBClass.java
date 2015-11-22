package java.database;

import org.hibernate.Session;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.*;

public class DBClass implements Serializable {
    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }
    public void save() throws Exception {
        setUp();
        Session session = sessionFactory.openSession();
    }

    public void delete(){

    }

    public void update() {

    }
}