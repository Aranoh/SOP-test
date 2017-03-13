/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.UserDAO;
import security.Group;
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
        
        User henk = new User("Henk", "d768ccc827c5d0aab5a460185dfbce2fb4f144f60edaa3cb66af9c086b03d87e");
        User piet = new User("Piet", "d768ccc827c5d0aab5a460185dfbce2fb4f144f60edaa3cb66af9c086b03d87e");
        User bert = new User("Bert", "d768ccc827c5d0aab5a460185dfbce2fb4f144f60edaa3cb66af9c086b03d87e");
        User klas = new User("Klas", "d768ccc827c5d0aab5a460185dfbce2fb4f144f60edaa3cb66af9c086b03d87e");
        User hans = new User("Hans", "d768ccc827c5d0aab5a460185dfbce2fb4f144f60edaa3cb66af9c086b03d87e");
        User sjak = new User("Sjak", "d768ccc827c5d0aab5a460185dfbce2fb4f144f60edaa3cb66af9c086b03d87e");

        piet.FollowUser(henk);
        bert.FollowUser(henk);
        
        henk.JoinGroup(userGroup);
        piet.JoinGroup(userGroup);
        bert.JoinGroup(userGroup);
        klas.JoinGroup(userGroup);
        hans.JoinGroup(adminGroup);
        sjak.JoinGroup(adminGroup);
        
        

        henk.CreateTweet("Hallo - " + henk.getUsername());
        piet.CreateTweet("Hallo - " + piet.getUsername());
        bert.CreateTweet("Hallo - " + bert.getUsername());
        klas.CreateTweet("Hallo - " + klas.getUsername());
        hans.CreateTweet("Hallo - " + hans.getUsername());
        sjak.CreateTweet("Hallo - " + sjak.getUsername());
        
        henk.CreateTweet("Hallo2 - " + henk.getUsername());
        piet.CreateTweet("Hallo2 - " + piet.getUsername());
        bert.CreateTweet("Hallo2 - " + bert.getUsername());

        ud.save(henk);
        ud.save(piet);
        ud.save(bert);
        ud.save(klas);
        ud.save(hans);
        ud.save(sjak);
    }
}
