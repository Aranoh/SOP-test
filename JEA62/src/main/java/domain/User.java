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
public class User {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    private void createTweet(String message) {

    }

    private void followUser(User target) {

    }
}
