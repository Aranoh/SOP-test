/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.User;
import dao.UserDAO;
import util.DatabaseCleaner;
import domain.Tweet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mark van Drimmelen
 */
public class DAOTest_ {

    private static UserDAO ud;
    private static User[] users;

    public DAOTest_() {
    }

    @BeforeClass
    public static void setUpClass() throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JEA62PU_unitTests");
        EntityManager em = emf.createEntityManager();
        DatabaseCleaner dbc = new DatabaseCleaner(em);
        dbc.clean();

        ud = new UserDAO();
        users = new User[10];

        for (int i = 0; i < users.length; i++) {
            users[i] = new User("User" + i);
        }

        users[1].FollowUser(users[2]);
        users[1].FollowUser(users[3]);
        users[1].FollowUser(users[4]);
        users[1].FollowUser(users[5]);

        users[2].FollowUser(users[2]);
        users[2].FollowUser(users[3]);
        users[2].FollowUser(users[4]);
        users[2].FollowUser(users[5]);
        users[2].FollowUser(users[6]);
        users[2].FollowUser(users[7]);
        users[2].FollowUser(users[8]);

        users[3].CreateTweet("Message 1");
        users[3].CreateTweet("Message 2");
        users[3].CreateTweet("Message 3");

        users[4].CreateTweet("Message 4");
        users[4].CreateTweet("Message 5");
        users[4].CreateTweet("Message 6");

        em.getTransaction().begin();
        for (int i = 0; i < users.length; i++) {
            em.persist((users[i]));
            em.getTransaction().commit();

        }

        em.close();
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
    public void TestSaveUsersToDatabase() {
        for (int i = 0; i < users.length; i++) {
            ud.save(users[i]);
        }
    }

    @Test
    public void TestGetUserByName() {
        List<User> user1 = ud.GetUserByName("User1");
        assertEquals(users[1], user1.get(0));

        List<User> user2 = ud.GetUserByName("User2");
        assertEquals(users[2], user1.get(1));

        List<User> user3 = ud.GetUserByName("User3");
        assertEquals(users[3], user1.get(2));
    }

    @Test
    public void TestGetFollwers() {
        List<User> usersListUser1 = ud.GetFollowers(users[1]);
        assertEquals(4, usersListUser1.size());

        assertTrue(usersListUser1.contains(users[2]));
        assertTrue(usersListUser1.contains(users[3]));
        assertTrue(usersListUser1.contains(users[4]));
        assertTrue(usersListUser1.contains(users[5]));

        List<User> usersListUser2 = ud.GetFollowers(users[1]);
        assertEquals(7, usersListUser2.size());

        assertTrue(usersListUser2.contains(users[2]));
        assertTrue(usersListUser2.contains(users[3]));
        assertTrue(usersListUser2.contains(users[4]));
        assertTrue(usersListUser2.contains(users[5]));
        assertTrue(usersListUser2.contains(users[6]));
        assertTrue(usersListUser2.contains(users[7]));
        assertTrue(usersListUser2.contains(users[8]));

    }

    @Test
    public void GetTweetsFromUser() {
        List<Tweet> tweetsUser3 = ud.GetTweets(users[3]);
        List<Tweet> tweetsUser4 = ud.GetTweets(users[4]);

        assertEquals(tweetsUser3, users[3].getTweets());
        assertEquals(tweetsUser4, users[4].getTweets());
    }

}
