/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
    
    @PersistenceContext
    EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public List<User> getFollowers(User user) {
        Query q = em.createNamedQuery("User.getFollowersByUsername");
        q.setParameter("username", user.getUsername());
        .getResultList();
    }
    
}
