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
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Mark van Drimmelen
 */
@Stateless
@DeclareRoles({"admin", "user"})
public class UserService {

    @Inject
    UserDAO ud;

    @PermitAll
    public List<User> getFollowers(User user) {
        return ud.getFollowers(user);
    }

    @PermitAll
    public List<Tweet> getTweets(User user) {
        return ud.getTweets(user);
    }

    @RolesAllowed("admin")
    public List<User> getAllUsers() {
        return ud.getAllUsers();
    }
}
