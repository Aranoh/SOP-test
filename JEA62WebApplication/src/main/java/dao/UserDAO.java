/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Tweet;
import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author HP
 */
@Stateless
public class UserDAO {

    @PersistenceContext(name = "JEA62PU")
    public EntityManager em;

    public void save(User user) {
        em.persist(user);
        em.flush();
    }

    public User getUserByUsername(String username) {
        Query q = em.createNamedQuery("User.getUserByUsername");
        q.setParameter("username", username);
        return (User) q.getSingleResult();
    }

    public List<User> getFollowers(User user) {
        Query q = em.createNamedQuery("User.getFollowersByUser");
        q.setParameter("user", user);
        return q.getResultList();
    }

    public List<Tweet> getTweets(User user) {
        Query q = em.createNamedQuery("User.getTweetsByUser");
        q.setParameter("user", user);
        return q.getResultList();
    }

    public List<User> getAllUsers() {
        Query q = em.createNamedQuery("User.getAllUsers");
        return q.getResultList();
    }

    public User getUserByUserID(Long userID) {
        Query q = em.createNamedQuery("User.getUserByUserID");
        q.setParameter("ID", userID);
        return (User) q.getSingleResult();
    }

}
