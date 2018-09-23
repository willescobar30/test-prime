/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Actor;
import com.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sandra granados
 */
public class actorDAO {

    public List<Actor> mostrarActores() {
        List<Actor> actores = new ArrayList<Actor>();
        Transaction txn = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            txn = session.beginTransaction();
            actores = session.createQuery("from Actor").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return actores;

    }

    public void agregarActor(Actor a) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(a);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    public void modificarActor(Actor a) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(a);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    public void eliminarActor(Actor a) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(a);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (session != null) {
                session.close();
            }

        }
    }
    
    public List<Actor>obtenerActorbyID(Actor a){
        
       List<Actor> actores = new ArrayList<Actor>();
        Transaction txn = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            txn = session.beginTransaction();
            actores = session.createQuery("from Actor where actor_id='"+a.getActorId()+"'").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return actores; 
        
    }

}
