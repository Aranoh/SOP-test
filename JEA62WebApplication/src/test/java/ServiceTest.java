/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.UserDAO;
import domain.Tweet;
import domain.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import service.UserService;

/**
 *
 * @author Mark van Drimmelen
 */
public class ServiceTest {

    private static UserService us;
    private static List<User> users;
    private static List<User> followers;

    public ServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        us = Mockito.mock(UserService.class);
        users = new ArrayList<User>();
        followers = new ArrayList<User>();

        for (int i = 0; i < 10; i++) {
            users.add(new User("User" + i));
        }

        users.get(1).FollowUser(users.get(2));
        followers.add(users.get(1));
        users.get(1).FollowUser(users.get(3));
        users.get(1).FollowUser(users.get(4));
        users.get(1).FollowUser(users.get(5));

        users.get(2).FollowUser(users.get(2));
        followers.add(users.get(2));
        users.get(2).FollowUser(users.get(3));
        users.get(2).FollowUser(users.get(4));
        users.get(2).FollowUser(users.get(5));
        users.get(2).FollowUser(users.get(6));
        users.get(2).FollowUser(users.get(7));
        users.get(2).FollowUser(users.get(8));

        users.get(3).CreateTweet("Message 1");
        users.get(3).CreateTweet("Message 2");
        users.get(3).CreateTweet("Message 3");

        users.get(4).CreateTweet("Message 4");
        users.get(4).CreateTweet("Message 5");
        users.get(4).CreateTweet("Message 6");

        when(us.GetAllUsers()).thenReturn(users);
        when(us.GetFollowers(users.get(2))).thenReturn(followers);
        when(us.GetTweets(users.get(3))).thenReturn(users.get(3).getTweets());
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
    public void TestGetAllFollowers() {
        assertTrue(us.GetFollowers(users.get(9)).isEmpty());
        assertEquals(followers, us.GetFollowers(users.get(2)));
    }

    @Test
    public void TestGetTweets() {
        assertTrue(us.GetTweets(users.get(1)).isEmpty());
        assertEquals(users.get(3).getTweets(), us.GetTweets(users.get(3)));
    }

    @Test
    public void GetAllUsers() {
        assertEquals(us.GetAllUsers(), users);
    }

    @Test
    public void TestVerify() {
        UserService verifyUs = Mockito.mock(UserService.class);
        when(verifyUs.GetAllUsers()).thenReturn(users);

        verifyUs.GetAllUsers();
        verifyUs.GetAllUsers();
        verifyUs.GetAllUsers();
        verifyUs.GetAllUsers();
        verifyUs.GetAllUsers();

        verify(verifyUs, times(5)).GetAllUsers();
        verify(verifyUs, never()).GetTweets(users.get(0));
    }
}
