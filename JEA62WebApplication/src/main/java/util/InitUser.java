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
        User henk = new User("Henk", "geheim");
        User piet = new User("Piet", "geheim");
        User bert = new User("Bert", "geheim");
        User klas = new User("Klas", "geheim");
        User hans = new User("Hans", "geheim");
        User sjak = new User("Sjak", "geheim");

        piet.FollowUser(henk);
        bert.FollowUser(henk);
        
        henk.JoinGroup("user");
//        bert.JoinGroup("user");
//        klas.JoinGroup("user");
//        hans.JoinGroup("user");
//        sjak.JoinGroup("user");
//        piet.JoinGroup("admin");

        henk.CreateTweet("Hallo - " + henk.getUsername());
        
        piet.CreateTweet("Hallo - " + piet.getUsername());
        bert.CreateTweet("Hallo - " + bert.getUsername());
        klas.CreateTweet("Hallo - " + klas.getUsername());
        hans.CreateTweet("Hallo - " + hans.getUsername());
        sjak.CreateTweet("Hallo - " + sjak.getUsername());
        
        henk.CreateTweet("Hallo2 - " + henk.getUsername());
        
        ud.save(henk);
        ud.save(piet);
        ud.save(bert);
        ud.save(klas);
        ud.save(hans);
        ud.save(sjak);
    }
}
