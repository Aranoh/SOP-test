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

    @GET
    @Path("getAllUsers")
    public List<User> getAllUsers() {
        return us.getAllUsers();
    }

    @GET
    @Path("{getUser}")
    public User getUserByUsername(@PathParam("username") String username) {
        return us.getUserByUsername(username);
    }

    @GET
    @Path("{getFollowers}")
    public List<User> getFollowers(@PathParam("user") User user) {
        return us.getFollowers(user);
    }

    @GET
    @Path("{getTweets}")
    public List<Tweet> getTweets(@PathParam("user") User user) {
        return us.getTweets(user);
    }

    @POST
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

    @POST
    public Response addTweet(User user, String message) {
        user.CreateTweet(message);
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
