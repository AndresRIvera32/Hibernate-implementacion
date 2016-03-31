/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.test.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author jriverac
 */
public class UsuarioDao {

    public SessionFactory factory;

    public UsuarioDao() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        factory = configuration.buildSessionFactory(serviceRegistry);

    }

    public void guardarUser(Usuario us) {
        Session sess = factory.openSession();
        try {
            sess.beginTransaction();
            sess.persist(us);
            sess.getTransaction().commit();
        } catch (Exception e) {
            if (sess.getTransaction() != null) {
                sess.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            sess.close();
        }
    }

    public Usuario mostrarUser(int x) {
        Session sess = factory.openSession();
        Transaction tx = null;
        Usuario us = null;
        try {
            tx = sess.beginTransaction();
            us = (Usuario) sess.get(Usuario.class, x);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return us;
    }

}
