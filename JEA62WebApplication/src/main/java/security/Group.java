/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @JoinTable(
            name="JPAUSER_JPAGROUP",
            joinColumns = @JoinColumn(
                    name = "groupName",
                    referencedColumnName = "groupName"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "userName",
                    referencedColumnName = "userName"
            )
    )

    private List<User> users;

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

    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    //</editor-fold>
    
}
