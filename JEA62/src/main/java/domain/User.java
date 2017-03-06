/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author HP
 */
@Entity
@NamedQuery(name = "User.getFollowersByUsername", query = "SELECT u FROM Users u WHERE u.following.username = :username")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String username;
    @OneToMany
    private ArrayList<User> following;
    @OneToMany(mappedBy = "owner")
    private ArrayList<Tweet> tweets;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public User(String username) {
        this.username = username;
        this.following = new ArrayList<User>();
        this.tweets = new ArrayList<Tweet>();
    }

    public ArrayList<User> getFollowing() {
        return following;
    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public void CreateTweet(String message) {
        if (message == null || message.isEmpty()) {
            return;
        }

        this.tweets.add(new Tweet(message, this));
    }

    public void FollowUser(User target) {
        if (target == null) {
            return;
        }

        this.following.add(target);
    }
}
