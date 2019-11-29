
package org.launchcode.dismissal1.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class dismiss {
    //computer generated id
    @Id
    @GeneratedValue
    private int id;
    //table columns

    //@NotNull
    @Size(min = 3, max = 15)
    private String username;

    //@NotNull
    @Size(min = 3, max = 15)
    private String password;

    //@NotNull
    @Size(min = 3, max = 15)
    private String studentname;

    //@NotNull
    @Size(min = 1, message= "Select a teacher.")
    private String teachername;


    public dismiss(String username, String password, String studentname, String teachername) {
        this.username = username;
        this.password = password;
        this.studentname = studentname;
        this.teachername=teachername;
    }

    public dismiss() {
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

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getTeachername() {
    return teachername;
    }

    public void setTeachername(String teachername) {
    this.teachername = teachername;
    }


}