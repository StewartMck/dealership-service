package ca.smckinlay.dealership.service.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Iterator;
import java.util.Set;

/*
    MANY-TO-MANY:
    Include Collection in both classes which contains elements of the others.
 */

@Entity
@Table(name="USERS")
public class User {

    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

    /*
        @JoinTable name = name of join table
        Foreign keys from @JoinColumn
        @JoinColumn = connect to owner side of relationship
        @InverseJoinColumn = connect to other side
     */

    @ManyToMany
    @JoinTable(
            name="USER_ROLE",
            joinColumns = @JoinColumn(name="USER_ID"),
            inverseJoinColumns = @JoinColumn(name="ROLE_ID"))
    private Set<Role> roles;

    public User() {
    }

    public User(Long id, String username, String password, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set roles) {
        this.roles = roles;
    }

    public boolean hasRole(String roleName) {
        Iterator<Role> iterator = this.roles.iterator();
        while(iterator.hasNext()) {
            Role role = iterator.next();
            if(role.getName().equals(roleName)) {
                return true;
            }
        }
        return false;
    }
}
