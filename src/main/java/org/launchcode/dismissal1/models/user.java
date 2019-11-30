
package org.launchcode.dismissal1.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class user {
    //computer generated id
    @Id
    @GeneratedValue
    private int id;
    //table columns

    @NotNull
    @Size(min = 3, max = 15)
    private String username;

    @NotNull
    @Size(min = 3, max = 15)
    private String password;

    @OneToMany
    @JoinColumn (name = "user_id")
    private List<student>students=new ArrayList<>();


    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public user() {
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


}