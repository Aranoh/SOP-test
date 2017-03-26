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
import javax.ws.rs.core.Context;
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
    public List<User> getAllUsers() {
        return us.getAllUsers();
    }

    // Kwetter/user/{username}
    @GET
    @Path("user/{username}")
    public User getUserByUsername(@PathParam("username") String username) {
        return us.getUserByUsername(username);
    }

    // Kwetter/user/{username}/followers
    @GET
    @Path("user/{username}/followers")
    public List<User> getFollowers(@PathParam("username") String username) {
        return us.getFollowers(us.getUserByUsername(username));
    }

    // Kwetter/user/{username}/tweets
    @GET
    @Path("user/{username}/tweets")
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
    @Path("addtweet")
    public Response addTweet(Tweet tweet) {
        tweet.GetOwner().AddTweet(tweet);
        us.save(tweet.GetOwner());
        URI uri = null;
        if (tweet.GetOwner() != null) {
            uri = uriInfo.getAbsolutePathBuilder().
                    path(tweet.GetOwner().getId().toString()).
                    build();
        }
        return Response.created(uri).build();
    }
}
