/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Tweet;
import domain.User;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import service.UserService;

/**
 *
 * @author Tom
 */

@ManagedBean(name = "userBean")
@SessionScoped
@DeclareRoles({"admin","user"})
public class UserBean {
    @Inject
    UserService us;
    
    User gebruiker;
    
    @PermitAll
    public List<User> GetFollowers()
    {
        return us.GetFollowers(gebruiker);
    }
    
    @PermitAll
    public List<Tweet> GetTweets()
    {
        return us.GetTweets(gebruiker);
    }
    
    @RolesAllowed("admin")
    public List<User> GetAllUsers()
    {
        return us.GetAllUsers();
    }
}
