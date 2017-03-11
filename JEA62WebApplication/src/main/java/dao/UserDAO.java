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
    }

    public List<User> GetFollowers(User user) {
        Query q = em.createNamedQuery("User.getFollowersByUser");
        q.setParameter("user", user);
        return q.getResultList();
    }
    
    public List<Tweet> GetTweets(User user) {
        Query q = em.createNamedQuery("User.getTweetsByUser");
        q.setParameter("user", user);
        return q.getResultList();
    }
    
    public List<User> getAllUsers(){
        Query q = em.createNamedQuery("User.getUsers");
        return q.getResultList();
    }
    
}
