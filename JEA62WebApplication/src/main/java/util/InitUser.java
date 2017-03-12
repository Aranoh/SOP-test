/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.UserDAO;
import domain.Group;
import domain.User;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author 878550
 */
@Singleton
@Startup
public class InitUser {

    @Inject
    UserDAO ud;

    @PostConstruct
    public void init() {
        Group userGroup = new Group("user");
        Group adminGroup = new Group("admin");
        
        User henk = new User("Henk", "Geheim");
        User piet = new User("Piet", "Geheim");
        User bert = new User("Bert", "Geheim");
        User klaas = new User("Klaas", "Geheim");
        User hans = new User("Hans", "Geheim");
        User sjaak = new User("Sjaak", "Geheim");

        piet.FollowUser(henk);
        bert.FollowUser(henk);
        
        henk.JoinGroup(userGroup);
        piet.JoinGroup(userGroup);
        bert.JoinGroup(userGroup);
        klaas.JoinGroup(userGroup);
        hans.JoinGroup(userGroup);
        sjaak.JoinGroup(userGroup);

        henk.CreateTweet("Hallo - " + henk.getUsername());
        henk.CreateTweet("Hallo2 - " + henk.getUsername());
        piet.CreateTweet("Hallo - " + piet.getUsername());
        bert.CreateTweet("Hallo - " + bert.getUsername());
        klaas.CreateTweet("Hallo - " + klaas.getUsername());
        hans.CreateTweet("Hallo - " + hans.getUsername());
        sjaak.CreateTweet("Hallo - " + sjaak.getUsername());

        ud.save(henk);
        ud.save(piet);
        ud.save(bert);
        ud.save(klaas);
        ud.save(hans);
        ud.save(sjaak);
    }
}
