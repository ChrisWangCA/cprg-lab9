package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.User;
import dataaccess.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 * @author Chris Wang
 * @version 1.0
 * @date 2022-10-23
 */
public class UserDB {

    public List<User> getAll() throws Exception{
        EntityManager em = dataaccess.DBUtil.getEmFactory().createEntityManager();
        try {
            Query query = em.createNamedQuery("User.findAll");
            return query.getResultList();
        }finally {
            em.close();
        }
    }
    public User get(String email) throws Exception{
        EntityManager em = dataaccess.DBUtil.getEmFactory().createEntityManager();
        try{
            User user = em.find(User.class,email);
            return user;
        }finally {
            em.close();
        }
    }

    public void insert(User user) throws Exception{
        EntityManager em = dataaccess.DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();

        try{
            et.begin();
            em.persist(user);
            em.merge(user);
            et.commit();
        }catch (Exception e){
            et.rollback();
        }finally {
            em.close();
        }
    }

    public void update(User user) throws Exception{
        EntityManager em = dataaccess.DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(user);
            et.commit();
        }catch (Exception e){
            et.rollback();
        }finally {
            em.close();
        }
    }

    public void delete(User user) throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.remove(em.merge(user));
            et.commit();
        }catch (Exception e){
            et.rollback();
        }finally {
            em.close();
        }
    }
}
