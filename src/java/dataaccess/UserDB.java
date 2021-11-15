
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.User;
import models.Role;


public class UserDB {
    
    // Modified with JPA / JPQL
    public List<User> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Role role = em.find(Role.class, role);
            return role.getUserList();
        }
        finally {
            em.close();
        }
    }

    // Modified get method with the EntityManager class
    public User get(String email) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, email);
            System.out.println("Email: " + user.getEmail()); // retrieve the email
            return user;
        }
        finally {
            em.close();
        }
    }

    // Modify using transaction for updating
    public void insert(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            Role role = role.getRoleName();
            user.getUserList().add(user);
            trans.begin();
            em.persist(user);
            em.merge(user);
            trans.commit();
        }
        catch (Exception ex) {
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    // Modified
    public void update(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        }
        catch (Exception ex) {
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    // Modified
    public void delete(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            Email email = user.getEmail();
            email.getUserList().remove(email);
            trans.begin();
            em.remove(em.merge(email));
            em.merge(user);
            trans.commit();
        }
        catch (Exception ex) {
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
}