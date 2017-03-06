/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author HP
 */
@Entity
//@NamedQuery(name = "Tweet.findByUsername", query = "SELECT t FROM Tweet t WHERE t.Owner.username = :username")

public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;
    @OneToOne(cascade = CascadeType.PERSIST)
    private User owner;

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public User GetOwner() {
        return this.owner;
    }

    public Tweet() {
        message = "default";
    }

    public Tweet(String message, User owner) {
        this.message = message;
        this.owner = owner;
    }
}
