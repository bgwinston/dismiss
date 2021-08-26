
package org.launchcode.dismissal1.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity //Database creation//
public class User { //Database fields//
    //computer generated id
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 20)
    private String username;

    @NotNull
    @Size(min = 3, max = 20)
    private String password;

    @NotNull
    @Size(min = 3, max = 20)
    private String verify_password;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Student> students=new ArrayList<>();


    public User(String username, String password, String email, String verify_password) {
        this.username = username;
        this.password = password;
        this.verify_password=verify_password;
    }

    public User() {
    }

    public int getId() {
        return id;
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

    public String getVerify_password(){return verify_password;}

    public void setVerify_password(String verify_password) {this.verify_password=verify_password;}


}