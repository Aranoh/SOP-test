/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.Tweet;
import domain.User;
import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import service.UserService;

/**
 *
 * @author Tom
 */
@Stateless
@Path("Kwetter")
public class UserResource {

    @Inject
    UserService us;

    @Context
    UriInfo uriInfo;

    // Kwetter/admin/getallusers
    @GET
    @Path("admin/getallusers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return us.getAllUsers();
    }

    // Kwetter/user/{username}
    @GET
    @Path("user/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByUsername(@PathParam("username") String username) {
        User userByUsername = us.getUserByUsername(username);
        return userByUsername;

    }

    // Kwetter/user/{username}/followers
    @GET
    @Path("user/{username}/followers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getFollowers(@PathParam("username") String username) {
        return us.getFollowers(us.getUserByUsername(username));
    }

    // Kwetter/user/{username}/tweets
    @GET
    @Path("user/{username}/tweets")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tweet> getTweets(@PathParam("username") String username) {
        return us.getTweets(us.getUserByUsername(username));
    }

    // Kwetter/adduser
    @POST
    @Path("adduser")
    public Response addUser(User user) {
        us.save(user);
        URI uri = null;
        if (user != null) {
            uri = uriInfo.getAbsolutePathBuilder().
                    path(user.getId().toString()).
                    build();
        }
        return Response.created(uri).build();
    }

    // Kwetter/addtweet  
    @POST
    @Path("user/{username}/addtweet/{message}")
    public Response addTweet(@PathParam("username") String username, @PathParam("message") String message) {
//        User user = us.getUserByUserID(tweet.getOwnerID());
        User user = us.getUserByUsername(username);
        user.AddTweet(new Tweet(message, user));
        us.save(user);
        URI uri = null;
        if (user != null) {
            uri = uriInfo.getAbsolutePathBuilder().
                    path(user.getId().toString()).
                    build();
        }
        return Response.created(uri).build();
    }
}
