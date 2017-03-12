/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Mark van Drimmelen
 */
@Entity
@Table(name = "JPAGroup")
public class Group {

    @Id
    private String groupName;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private ArrayList<User> users;

    public Group() {
        groupName = "default";
    }

    public Group(String groupname) {
        this.groupName = groupname;
        this.users = new ArrayList<User>();
    }

    public void AddUser(User user) {
        this.users.add(user);
    }
}
