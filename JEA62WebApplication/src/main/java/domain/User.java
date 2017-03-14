/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import security.Group;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity(name = "JPAUser")
@NamedQueries({
    @NamedQuery(name = "User.getFollowersByUser", query = "SELECT u FROM JPAUser as u WHERE u.following = :user"),
    @NamedQuery(name = "User.getTweetsByUser", query = "SELECT t FROM Tweet as t WHERE t.owner = :user"),
    @NamedQuery(name = "User.getAllUsers", query = "SELECT u FROM JPAUser u")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<User> following;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private List<Tweet> tweets;
    @ManyToMany(mappedBy = "users", cascade = CascadeType.PERSIST)
    private List<Group> groups;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<User> getFollowing() {
        return following;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public User() {
        username = "default";
    }

    public User(String username) {
        this.username = username;
        this.following = new ArrayList<User>();
        this.tweets = new ArrayList<Tweet>();
        this.groups = new ArrayList<Group>();
    }

    public User(String username, String password) {
        this(username);
        this.password = password;
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

    public void JoinGroup(Group group) {
        group.AddUser((this));
        this.groups.add(group);
    }
}
