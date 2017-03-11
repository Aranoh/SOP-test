/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDAO;
import domain.Tweet;
import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Mark van Drimmelen
 */
@Stateless
public class UserService {
    
    @Inject
    UserDAO ud;
    
    public List<User> GetFollowers(User user){
        return ud.GetFollowers(user);
    }
    
    public List<Tweet> GetTweets(User user) {
        return ud.GetTweets(user);
    }
    
    public List<User> GetAllUsers(){
        return ud.getAllUsers();
    }
}
