/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    
    @GET
    @Path("allusers")
    public List<User> allUsers()
    {
        return us.GetAllUsers();
    }
    
}
