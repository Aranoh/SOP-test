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
public class TweetDAO {
    
    @PersistenceContext
    EntityManager em;

    public void save(Tweet tweet) {
        em.persist(tweet);
    }

    public List<Tweet> allTweetsFromOwner(User owner) {
        Query q = em.createNamedQuery("Tweet.FindByUsername");
        q.setParameter("username", owner.getUsername());
        return q.getResultList();
    }
    
}
