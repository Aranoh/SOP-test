/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author HP
 */
public class Tweet {

    private long id;
    private String message;
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

    public Tweet(String message, User owner) {
        this.message = message;
        this.owner = owner;
    }
}
