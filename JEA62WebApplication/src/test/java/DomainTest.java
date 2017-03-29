/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class DomainTest {

    private static User[] users;

    public DomainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        users = new User[10];

        for (int i = 0; i < users.length; i++) {
            users[i] = new User("User" + i);
        }
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void TestCreateTweet() {
        users[2].CreateTweet("Message 1");
        users[3].CreateTweet(null);
        users[3].CreateTweet("");

        assertEquals("Message 1", users[2].getTweets().get(0).getMessage());
        assertEquals(users[2], users[2].getTweets().get(0).getOwner());
        assertTrue(users[3].getTweets().isEmpty());
    }

    @Test
    public void TestFollowUser() {
        users[0].FollowUser(users[1]);
        users[1].FollowUser(null);

        assertTrue(users[0].getFollowing().contains(users[1]));
        assertTrue(users[1].getFollowing().isEmpty());
    }
}
