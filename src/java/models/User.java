package models;


import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Chris Wang
 * @version 1.0
 * @date 2022-10-23
 */

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "User.findAll",query = "select u from User u"),
        @NamedQuery(name = "User.findByEmail",query = "select u from User u where u.email = :email"),
        @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE u.active = :active"),
        @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.first_name = :first_name"),
        @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.last_name = :last_name"),
        @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
})
public class User implements Serializable{

    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    @Basic(optional = false)
    private boolean active;
    @Column(name = "first_name")
    @Basic(optional = false)
    private String first_name;
    @Column(name = "last_name")
    @Basic(optional = false)
    private String last_name;
    @Column(name = "password")
    @Basic(optional = false)
    private String password;
    @Column(name = "role")
    private int role;

    public User(String email, boolean active, String first_name, String last_name, String password, int role) {
        this.email = email;
        this.active = active;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
