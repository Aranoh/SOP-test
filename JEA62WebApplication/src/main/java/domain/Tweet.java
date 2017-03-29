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
import javax.persistence.OneToOne;

/**
 *
 * @author HP
 */
@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;
    @OneToOne(cascade = CascadeType.PERSIST)
    private User owner;

    public Tweet() {
        message = "default";
    }

    public Tweet(String message, User owner) {
        this.message = message;
        this.owner = owner;
    }

    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
        
    public User getOwner()
    {
        return this.owner;
    }
    
    public void setOwner(User owner)
    {
        this.owner = owner;
    }
    //</editor-fold>

}
