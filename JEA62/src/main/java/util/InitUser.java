/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.TweetDAO;
import dao.UserDAO;
import domain.Tweet;
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

    @Inject
    TweetDAO td;

    @PostConstruct
    public void init() {
        User henk = new User("Henk");
        User piet = new User("Piet");
        piet.FollowUser(henk);
        User bert = new User("Bert");
        bert.FollowUser(henk);
        User klaas = new User("Klaas");
        User hans = new User("Hans");
        User sjaak = new User("Sjaak");

        ud.save(henk);
        ud.save(piet);
        ud.save(bert);
        ud.save(klaas);
        ud.save(hans);
        ud.save(sjaak);

        Tweet hallo = new Tweet("Hallo - " + henk.getUsername(), henk);
        Tweet hallo1 = new Tweet("Hallo - " + piet.getUsername(), piet);
        Tweet hallo2 = new Tweet("Hallo - " + bert.getUsername(), bert);
        Tweet hallo3 = new Tweet("Hallo - " + klaas.getUsername(), klaas);
        Tweet hallo4 = new Tweet("Hallo - " + hans.getUsername(), hans);
        Tweet hallo5 = new Tweet("Hallo - " + sjaak.getUsername(), sjaak);

        td.save(hallo);
        td.save(hallo1);
        td.save(hallo2);
        td.save(hallo3);
        td.save(hallo4);
        td.save(hallo5);
    }

}