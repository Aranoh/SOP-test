/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Tweet;
import domain.User;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import service.UserService;

/**
 *
 * @author Tom
 */
@Named
@SessionScoped

public class UserBean implements Serializable {

    private User gebruiker;

    @Inject
    private UserService us;

    public List<User> getFollowers() {
        return us.getFollowers(gebruiker);
    }

    public List<Tweet> getTweets() {
        return us.getTweets(gebruiker);
    }

    public List<User> getAllUsers() {
        return us.getAllUsers();
    }
}
