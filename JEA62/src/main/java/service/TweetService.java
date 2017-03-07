/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TweetDAO;
import domain.User;
import domain.Tweet;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Mark van Drimmelen
 */
@Stateless
public class TweetService {

    @Inject
    TweetDAO td;

//    public List<Tweet> GetTweets(User user) {
//        return td.GetTweets(user);
//    }
}
